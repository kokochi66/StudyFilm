package com.github.kokochi.link.developers.sdk.login.service;

import com.github.kokochi.link.developers.sdk.login.domain.LineUser;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter @ToString
public class SessionUserDTO implements Serializable {
    private String userId;
    private String displayName;
    private String accessToken;
    private String walletAddress;

    public SessionUserDTO(String userId, String displayName, String accessToken, String walletAddress) {
        this.userId = userId;
        this.displayName = displayName;
        this.accessToken = accessToken;
        this.walletAddress = walletAddress;
    }

    public SessionUserDTO(LineUser user) {
        this.userId = user.getName();
    }
}
