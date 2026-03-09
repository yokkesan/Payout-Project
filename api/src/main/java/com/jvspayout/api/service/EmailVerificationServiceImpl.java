package com.jvspayout.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jvspayout.api.entity.EmailVerification;
import com.jvspayout.api.repository.EmailVerificationRepository;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private static final Logger log = LoggerFactory.getLogger(EmailVerificationServiceImpl.class);

    private final EmailVerificationRepository repository;

    @Value("${mail.driver}")
    private String mailDriver;

    public EmailVerificationServiceImpl(EmailVerificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void sendVerificationCode(String email) {

        Optional<EmailVerification> last = repository.findTopByEmailOrderByCreatedAtDesc(email);

        if (last.isPresent()) {
            LocalDateTime lastTime = last.get().getCreatedAt();

            if (lastTime.plusMinutes(1).isAfter(LocalDateTime.now())) {
                throw new RuntimeException("Too many requests");
            }
        }

        String code = String.format("%06d", new java.util.Random().nextInt(1000000));

        EmailVerification entity = new EmailVerification();

        entity.setId(UUID.randomUUID());
        entity.setEmail(email);
        entity.setCode(code);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setExpiresAt(LocalDateTime.now().plusMinutes(10));

        repository.deleteByEmail(email);

        repository.save(entity);

        if ("log".equals(mailDriver)) {
            log.info("Verification code: {}", code);
        }
    }

    @Override
    public boolean verifyCode(String email, String code) {

        Optional<EmailVerification> record = repository.findByEmailAndCode(email, code);

        if (record.isEmpty()) {
            return false;
        }

        EmailVerification entity = record.get();

        if (entity.getExpiresAt().isBefore(LocalDateTime.now())) {
            return false;
        }

        return true;
    }
}