package com.we.us.catalogservice.controller;

import com.we.us.catalogservice.config.CatalogProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final CatalogProperties catalogProperties;

    public WelcomeController(CatalogProperties catalogProperties) {
        this.catalogProperties = catalogProperties;
    }

    @GetMapping("/")
    public String welcome()
    {
        return catalogProperties.getGreeting();
    }
}
