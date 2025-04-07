package com.meetime.challenge.controller;

import com.meetime.challenge.DTOs.ContactDTO;
import com.meetime.challenge.service.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    @PostMapping
    public ResponseEntity<Mono<String>> createContact(
            @RequestBody @Valid ContactDTO request, @RequestHeader("Authorization") String token) {
        Mono<String> result = service.createContact(request, token.replace("Bearer ", ""));
        return ResponseEntity.ok(result);
    }

}
