package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service Discovery built-in Netflix Eureka.
 *
 * @author Marcos Barbero
 */
@EnableEurekaServer
@SpringCloudApplication
public class DiscoveryApplication {

    public static void main(String... args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}
