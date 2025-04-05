package com.meetime.challenge.controller;

import com.meetime.challenge.DTOs.ContactDTO;
import com.meetime.challenge.DTOs.WebhookPayloadDTO;
import com.meetime.challenge.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService service;

    @GetMapping("/authorize-url")
    public ResponseEntity<String> getAuthorizationUrl() {
        return ResponseEntity.ok(service.getAuthorizationUrl());
    }

    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam String code) {
        return null;
    }

    @PostMapping("/contacts")
    public ResponseEntity<?> createContact(@RequestBody ContactDTO contact) {
        return null;
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> receiveWebhook(@RequestBody WebhookPayloadDTO payload) {
        return null;
    }

}
