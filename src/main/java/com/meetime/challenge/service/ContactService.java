package com.meetime.challenge.service;

import com.meetime.challenge.DTOs.ContactDTO;
import com.meetime.challenge.config.HubspotProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@AllArgsConstructor
public class ContactService {

    private final HubspotProperties properties;
    private final WebClient webClient = WebClient.create();

    public Mono<String> createContact(ContactDTO contact, String accessToken) {

        Map<String, Object> body = Map.of(
                "properties", Map.of(
                        "email", contact.getEmail(),
                        "firstname", contact.getFirstname(),
                        "lastname", contact.getLastname()
                )
        );

        return webClient.post()
                .uri(properties.getApiContactUrl())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class);
    }
}
