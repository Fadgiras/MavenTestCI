package com.fadgiras;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:web.properties")
public class WebController {

    public WebController(Environment environment) {
        this.finessUrl = environment.getProperty("finess.url");
        System.out.println("finess.url in WebController: " + finessUrl != null ? finessUrl : "Property not set");
    }

    private String finessUrl;

    @GetMapping("/test")
    public String test() {
        return "Test successful from web module!";
    }
    
    @GetMapping("/webapi")
    public String webModule() {
        return "This is from the web module's webController!";
    }

    @GetMapping("/finess")
    public String finess(@RequestParam(value = "query", required = false) String query) {
        String urlToQuery = finessUrl;
        if (query != null && !query.isEmpty()) {
            urlToQuery = finessUrl + "?query=" + query;
        }
        return "Finess data endpoint! " + urlToQuery;
    }
}
