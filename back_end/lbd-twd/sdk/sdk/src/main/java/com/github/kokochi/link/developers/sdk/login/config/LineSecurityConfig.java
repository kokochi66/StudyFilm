package com.github.kokochi.link.developers.sdk.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LineSecurityConfig {
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> clientRegistrations = new ArrayList<>();

        String DEFAULT_LOGIN_REDIRECT_URL = "{baseUrl}/login/oauth2/code/{registrationId}/redirect";

        ClientRegistration.Builder lineBuilder = ClientRegistration.withRegistrationId("line");
        lineBuilder.clientAuthenticationMethod(ClientAuthenticationMethod.POST);
        lineBuilder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
        lineBuilder.redirectUriTemplate(DEFAULT_LOGIN_REDIRECT_URL);
        lineBuilder.authorizationUri("https://access.line.me/oauth2/v2.1/authorize");
        lineBuilder.tokenUri("https://api.line.me/oauth2/v2.1/token");
        lineBuilder.clientName("LINE");
        lineBuilder.scope("profile", "openid");
        lineBuilder.clientId("1656781034");
        lineBuilder.clientSecret("8627fa9d56888af5a1d80098ea4f0a32");

        clientRegistrations.add(lineBuilder.build());
        return new InMemoryClientRegistrationRepository(clientRegistrations);
    }
}
