package com.meetime.challenge.service;

import com.meetime.challenge.DTOs.ContactDTO;
import com.meetime.challenge.DTOs.TokenResponseDTO;
import com.meetime.challenge.config.HubspotProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final HubspotProperties properties;
    private final WebClient webClient = WebClient.create();

    public String getAuthorizationUrl() {
        return UriComponentsBuilder.fromUriString(properties.getAuthorizeUrl())
                .queryParam("client_id", properties.getClientId())
                .queryParam("redirect_uri", properties.getRedirectUri())
                .queryParam("scope", properties.getScopes())
                .queryParam("response_type", "code")
                .build(true)
                .toUriString();
    }

    public Mono<TokenResponseDTO> codeToToken(String code) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "authorization_code");
        form.add("client_id", properties.getClientId());
        form.add("client_secret", properties.getClientSecret());
        form.add("redirect_uri", properties.getRedirectUri());
        form.add("code", code);

        return webClient.post()
                .uri(properties.getTokenUrl())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(form)
                .retrieve()
                .bodyToMono(TokenResponseDTO.class);
    }


}
