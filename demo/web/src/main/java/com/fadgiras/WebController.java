package com.fadgiras;

import com.fadgiras.config.RestClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@PropertySource("classpath:web.properties")
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping(value = "/finess", produces = "application/json")
    public String finess(@RequestParam(value = "query", required = false) String query) {
        String urlToQuery = finessUrl;
        if (query != null && !query.isEmpty()) {
            urlToQuery = finessUrl + "?" + query;
            System.err.println("Querying Finess with: " + urlToQuery);
        }
        RestClient restClient = RestClientConfig.restClient();
        return restClient.get()
                                    .uri(urlToQuery)
                                    .retrieve().body(String.class);
    }
}
