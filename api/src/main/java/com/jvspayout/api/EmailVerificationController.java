package com.jvspayout.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.jvspayout.api.service.EmailVerificationService;

@RestController
@RequestMapping("/api/auth")
public class EmailVerificationController {

    private final EmailVerificationService service;

    public EmailVerificationController(EmailVerificationService service) {
        this.service = service;
    }

    @PostMapping("/send-code")
    public ResponseEntity<?> sendCode(@RequestParam String email) {

        try {

            service.sendVerificationCode(email);

            return ResponseEntity.ok().build();

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/verify-code")
    public ResponseEntity<Boolean> verifyCode(
            @RequestParam String email,
            @RequestParam String code) {

        boolean result = service.verifyCode(email, code);

        return ResponseEntity.ok(result);
    }
}