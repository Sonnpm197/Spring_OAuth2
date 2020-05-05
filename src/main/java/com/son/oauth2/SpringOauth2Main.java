package com.son.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer

// @EnableAuthorizationServer: mark this service will be used as an
// OAuth2 service and to add several
// REST-based endpoints that will be used in the OAuth2
// authentication and authorization processes
@EnableAuthorizationServer
public class SpringOauth2Main {
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2Main.class, args);
    }

    // Authen using:
    // POST http://localhost:8901/oauth/token
    // Authorization:
    //      => Basic Auth
    //          => username: learningenglish / password: thisissecret (defined in OAuth2Config)
    // Body:
    //      => grant_type: password
    //      => scope: webclient
    //      => username: (defined in WebSecurityConfigurer.configure)
    //      => password: (defined in WebSecurityConfigurer.configure)

    // After that go to http://localhost:8901/user
    // Headers: Authorization: Bearer <access_token_above>
    @RequestMapping(value = {"/user"}, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities",
                AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities())
        );
        return userInfo;
    }
}
