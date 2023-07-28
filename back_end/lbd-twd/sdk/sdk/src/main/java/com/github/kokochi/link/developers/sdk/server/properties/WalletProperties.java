package com.github.kokochi.link.developers.sdk.server.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "line.blockchain.wallet")
@Getter @Setter
public class WalletProperties {
    private String test1Address;
    private String test2Address;
    private String test3Address;
    private String test1Secret;
    private String test2Secret;
    private String test3Secret;

    private String serviceAddress;
    private String serviceSecret;
}
