package com.github.kokochi.link.developers.sdk.login.service;

import com.github.kokochi.link.developers.sdk.login.domain.LineUser;
import com.github.kokochi.link.developers.sdk.login.repository.LineUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class LineOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final LineUserRepository lineUserRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        LineUser user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUserDTO(user));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
                );
    }

    private LineUser saveOrUpdate(OAuthAttributes attributes) {
        LineUser user = lineUserRepository.findByName(attributes.getName())
                .map(entity -> entity.update(attributes.getName()))
                .orElse(attributes.toEntity());
        return lineUserRepository.save(user);
    }
}
