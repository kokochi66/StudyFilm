package com.github.kokochi.link.developers.sdk.login.service;

import com.github.kokochi.link.developers.sdk.login.domain.LineUser;
import com.github.kokochi.link.developers.sdk.login.domain.LineUserRole;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofLine(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofLine(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public LineUser toEntity() {
        return LineUser.builder()
                .name(name)
                .email(email)
                .role(LineUserRole.GUEST)
                .build();
    }
}
