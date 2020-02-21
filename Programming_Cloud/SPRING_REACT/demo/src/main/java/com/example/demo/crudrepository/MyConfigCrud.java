package com.example.demo.crudrepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfigCrud {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
