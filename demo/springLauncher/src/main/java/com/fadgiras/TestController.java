package com.fadgiras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/")
    public String home() {
        return "Spring Launcher is running!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "Application health: OK";
    }
    
    @GetMapping("/debug")
    public String debug() {
        return "Debug: This controller is in springLauncher module";
    }
}
