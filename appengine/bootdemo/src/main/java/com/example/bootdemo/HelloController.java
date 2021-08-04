package com.example.bootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "hello appengine example";
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping back, Application is running";
    }
}
