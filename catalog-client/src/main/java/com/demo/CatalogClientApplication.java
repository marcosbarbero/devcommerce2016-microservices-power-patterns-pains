package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Feign Client to consume and aggregate services.
 *
 * @author Marcos Barbero
 */
@EnableFeignClients
@RestController
@SpringCloudApplication
public class CatalogClientApplication {

    public static void main(String... args) {
        SpringApplication.run(CatalogClientApplication.class, args);
    }

    @Autowired
    private CatalogClient catalog;

    @Autowired
    private MenuClient menu;

    @RequestMapping("/aggregate")
    public Collection<String> aggregate() {
        Collection<String> products = catalog.products();
        Collection<String> sports = menu.sports();

        products.addAll(sports);

        return products;
    }


    /**
     * Feign client to make service-to-service calls.
     */
    @FeignClient("catalog")
    interface CatalogClient {
        @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        Collection<String> products();
    }

    @FeignClient("menu")
    interface MenuClient {
        @RequestMapping(value = "/sports.php", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        Collection<String> sports();
    }
}
