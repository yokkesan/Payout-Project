package com.jvspayout.api.repository;

import com.jvspayout.api.entity.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, UUID> {

    void deleteByEmail(String email);

    Optional<EmailVerification> findTopByEmailOrderByCreatedAtDesc(String email);

    Optional<EmailVerification> findByEmailAndCode(String email, String code);

}