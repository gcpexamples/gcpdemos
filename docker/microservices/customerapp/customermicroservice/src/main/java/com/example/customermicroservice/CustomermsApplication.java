package com.example.customermicroservice;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CustomermsApplication {

    private static final Logger Log = LoggerFactory.getLogger(CustomermsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CustomermsApplication.class, args);
        Log.debug("***i am debugged in main");
        Log.info("***i am info in main");
        Log.error("***i am error in main");
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
