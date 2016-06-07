package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Sidecar application to bind non-jvm service to eureka.
 *
 * @author Marcos Barbero
 */
@EnableSidecar
@SpringCloudApplication
public class SidecarApplication {

    public static void main(String... args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
}
