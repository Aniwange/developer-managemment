package com.vela.developermanagementservice.infrastructure.security;


import com.vela.developermanagementservice.infrastructure.persistence.entities.UserDbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class AuthorizationTokenEnhancer implements TokenEnhancer {

    @Autowired
    private com.vela.developermanagementservice.infrastructure.persistence.repository.UserDbEntityRepository UserDbEntityRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername()+ " principal a");
        UserDbEntity account = UserDbEntityRepository.findByEmail(user.getUsername());
        final Map<String, Object> additionalInfo = new HashMap<String, Object>();
        additionalInfo.put("user", account);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }

}
