package com.meetime.challenge.service;

import com.meetime.challenge.config.HubspotProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final HubspotProperties properties;

    public String getAuthorizationUrl() {
        return UriComponentsBuilder.fromUriString(properties.getAuthorizeUrl())
                .queryParam("client_id", properties.getClientId())
                .queryParam("redirect_uri", properties.getRedirectUri())
                .queryParam("scope", properties.getScopes())
                .queryParam("response_type", "code")
                .build(true)
                .toUriString();
    }
}
