package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * OAuth2 Server.
 *
 * @author Marcos Barbero
 */
@RestController
@EnableResourceServer
@SpringCloudApplication
public class SecurityApplication {

    public static void main(String... args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/me")
    public Principal authenticatedUser(Principal user) {
        return user;
    }
}
