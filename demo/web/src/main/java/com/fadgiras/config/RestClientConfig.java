package com.fadgiras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com") // URL d'exemple pour test
            .defaultHeader("Content-Type", "application/json")
            .defaultHeader("User-Agent", "Spring-Boot-App")
            .build();
    }
}
