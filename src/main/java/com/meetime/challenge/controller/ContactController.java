package com.meetime.challenge.controller;

import com.meetime.challenge.dto.ContactDTO;
import com.meetime.challenge.service.ContactService;
import com.meetime.challenge.validation.ValidBearerToken;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    @PostMapping
    public ResponseEntity<Mono<String>> createContact(
            @RequestBody @Valid ContactDTO request,
            @RequestHeader("Authorization") @ValidBearerToken(message = "Token é obrigatório") String token) {
        Mono<String> result = service.createContact(request, token.replace("Bearer ", ""));
        return ResponseEntity.ok(result);
    }

}
