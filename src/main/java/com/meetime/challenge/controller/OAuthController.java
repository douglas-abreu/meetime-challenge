package com.meetime.challenge.controller;

import com.meetime.challenge.dto.TokenResponseDTO;
import com.meetime.challenge.service.OAuthService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/oauth")
public class OAuthController {

    private final OAuthService service;

    @GetMapping("/authorize-url")
    public ResponseEntity<String> getAuthorizationUrl() {
        return ResponseEntity.ok(service.getAuthorizationUrl());
    }

    @GetMapping("/callback")
    public ResponseEntity<Mono<TokenResponseDTO>> callback(
            @RequestParam @NotBlank(message = "Código de autorização é obrigatório.") String code) {
        Mono<TokenResponseDTO> response = service.codeToToken(code);
        return ResponseEntity.ok(response);
    }

}
