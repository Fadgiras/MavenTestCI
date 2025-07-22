package com.fadgiras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Spring Boot Application for local development
 */
@SpringBootApplication(scanBasePackages = {"com.fadgiras", "com.example.demo"})
public class App {
    public static void main(String[] args) {
    }
}
