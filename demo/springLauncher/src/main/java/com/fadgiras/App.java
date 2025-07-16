package com.fadgiras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Spring Boot Application for local development
 */
@SpringBootApplication(scanBasePackages = {"com.fadgiras", "com.example.demo"})
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        
        // Debug: Print all beans to see if web module controllers are loaded
        System.out.println("=== Loaded Controllers ===");
        String[] beanNames = context.getBeanNamesForAnnotation(org.springframework.web.bind.annotation.RestController.class);
        for (String beanName : beanNames) {
            System.out.println("Found controller: " + beanName + " -> " + context.getBean(beanName).getClass().getName());
        }
        System.out.println("=========================");
    }
}
