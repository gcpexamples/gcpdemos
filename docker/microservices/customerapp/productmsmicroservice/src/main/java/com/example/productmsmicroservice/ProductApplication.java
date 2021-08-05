package com.example.productmsmicroservice;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductApplication {

    private static final Logger Log = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
        Log.debug("***i am debugged in main");
        Log.info("***i am info in main");
        Log.error("***i am error in main");
    }
}
