package com.meetime.challenge.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/webhooks")
public class Webhook {

    @PostMapping
    public ResponseEntity<Void> webhook(@RequestBody String payload) {
        System.out.println("Webhook recebido: " + payload);
        return ResponseEntity.ok().build();
    }

}
