package com.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Dummie catalog service.
 *
 * @author Marcos Barbero
 */
@RestController
//@EnableResourceServer
@SpringCloudApplication
@EnableConfigurationProperties(CatalogProperties.class)
public class CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Autowired
    CatalogProperties catalog;

    @RequestMapping("/products")
    public Collection<String> products() {
        return catalog.products();
    }

    @RequestMapping("/throw")
    @HystrixCommand(fallbackMethod = "fallbackThrowUpMethod")
    public Collection<String> throwUP() {
        throw new RuntimeException("throwUP");
    }

    private Collection<String> fallbackThrowUpMethod(RuntimeException e) {
        return Arrays.asList("it,works".split(","));
    }
}

@Data
@ConfigurationProperties(prefix = "catalog")
class CatalogProperties {
    List<String> products = new ArrayList<>();

    public List<String> products() {
        return this.products;
    }
}