package com.github.kokochi.link.developers.sdk.blockchain.config;

import com.github.kokochi.link.developers.sdk.blockchain.api.ApiClient;
import com.github.kokochi.link.developers.sdk.blockchain.api.factory.ApiClientFactory;
import com.github.kokochi.link.developers.sdk.blockchain.api.factory.ApiClientFactoryConfig;
import com.github.kokochi.link.developers.sdk.blockchain.model.dto.ApiKeySecret;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ApiClient apiClient() {
        return apiClientFactory().build(apiClientFactoryConfig());
    }

    @Bean
    public ApiKeySecret apiKeySecret() {
        return new ApiKeySecret("365822bc-8b1b-4c9f-9c65-22b087753a3f", "9578e7f5-6684-48e0-8055-7874f8f63fbf");
    }

    @Bean
    public ApiClientFactoryConfig apiClientFactoryConfig() {
        return new ApiClientFactoryConfig("https://test-api.blockchain.line.me", apiKeySecret());
    }

    @Bean
    public ApiClientFactory apiClientFactory() {
        return new ApiClientFactory();
    }

}
