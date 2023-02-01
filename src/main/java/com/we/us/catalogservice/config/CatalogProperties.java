package com.we.us.catalogservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "catalog")
@Data
public class CatalogProperties {
    /*
    Welcome message for user
     */
    private String greeting;


}
