package com.example.apps.empms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class EmpMainApplication {

	private static final Logger Log= LoggerFactory.getLogger(EmpMainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpMainApplication.class, args);

		}


	@Bean
	public Docket api(){
		Docket docket=new Docket(DocumentationType.SWAGGER_2).
				apiInfo(  apiInfo() )
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.apps.empms"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}


	@Bean
	public ApiInfo apiInfo(){
		ApiInfo info=new ApiInfoBuilder()
				 .title("Employee management application")
				.description("rest api for employee management")
				.build();
		return info;
	}


	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate=new RestTemplate();
		return  restTemplate;
	}


}
