package com.myorg.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Map;

/**
 * Created by Garcia Rios, Emilio R on 1/23/2016.
 */

@SpringBootApplication
@EnableResourceServer
public class Application {

    public static void main(String[] args) {
        if ("true".equals(System.getenv("SKIP_SSL_VALIDATION"))) {
            SSLValidationDisabler.disableSSLValidation();
        }
        SpringApplication.run(Application.class, args);
    }

    @Value("${ssoServiceUrl}")
    private String ssoServiceUrl;

    @Autowired
    OAuth2RestTemplate oauth2RestTemplate;

    @Bean
    public AuthoritiesExtractor myAuthoritiesExtractor(){
        return map -> {
            Map<?,?> userInfoResponse = oauth2RestTemplate.getForObject("{ssoServiceUrl}/me", Map.class,ssoServiceUrl);
            String name = (String)userInfoResponse.get("name");
            String email = (String)userInfoResponse.get("email");
            return AuthorityUtils.commaSeparatedStringToAuthorityList("PERMISSION7,PERMISSION8,PERMISSION9," + name + "," + email);
        };
    }

}
