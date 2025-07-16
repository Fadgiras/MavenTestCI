package com.fadgiras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController {
    
    @GetMapping("/test")
    public String test() {
        return "Test successful from web module!";
    }
    
    @GetMapping("/webmodule")
    public String webModule() {
        return "This is from the web module!";
    }
}
