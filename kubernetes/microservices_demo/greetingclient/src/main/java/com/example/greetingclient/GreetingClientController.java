package com.example.greetingclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/client")
@RestController
public class GreetingClientController {
    private static final Logger Log= LoggerFactory.getLogger(GreetingClientController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${greetingserver.baseurl}")
    private String greetServerBaseUrl;

    @GetMapping
    public String  welcome() {
        return "greeting client example";
    }

    @GetMapping("/msg")
    public String  greeting() {
        //kubectl create service nodeport greetingserver   --tcp 8585:8885
        String url = greetServerBaseUrl+"/greetings/greet";
        String msg = restTemplate.getForObject(url, String.class);
        return msg;
    }
}
