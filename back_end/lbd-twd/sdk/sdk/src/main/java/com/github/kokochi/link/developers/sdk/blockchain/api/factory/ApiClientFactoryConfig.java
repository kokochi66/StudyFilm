package com.github.kokochi.link.developers.sdk.blockchain.api.factory;

import com.github.kokochi.link.developers.sdk.blockchain.model.dto.ApiKeySecret;

public class ApiClientFactoryConfig {
    public ApiClientFactoryConfig(String apiBaseUrl, ApiKeySecret apiKeySecret) {
        this.apiBaseUrl = apiBaseUrl;
        this.apiKeySecret = apiKeySecret;
    }

    String apiBaseUrl;
    ApiKeySecret apiKeySecret;
//    HttpClient client;
//    Boolean enableResponseValidation;
//    Long requestTimeout;
//    Boolean enableLogging;
    // KOTLIN::CHECK
}
