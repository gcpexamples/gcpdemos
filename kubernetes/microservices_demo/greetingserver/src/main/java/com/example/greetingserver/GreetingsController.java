package com.example.greetingserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    private static final Logger Log= LoggerFactory.getLogger(GreetingsController.class);

    @GetMapping("/greet")
    public String getUsers() {
        return "hello user";
    }

}
