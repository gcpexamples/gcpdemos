package com.example.cedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "hello ce demo";
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping successful, app is running";
    }

}
