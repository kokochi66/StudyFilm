package com.github.kokochi.link.developers.sdk.blockchain.model.dto;

public class ApiKeySecret {
    public String key;
    public String secret;
    public ApiKeySecret(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }
}
