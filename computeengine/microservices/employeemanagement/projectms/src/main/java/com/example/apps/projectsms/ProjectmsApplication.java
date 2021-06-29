package com.example.apps.projectsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
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
public class ProjectmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectmsApplication.class, args);
	}




	@Bean
	public Docket api(){
		Docket docket=new Docket(DocumentationType.SWAGGER_2).
				apiInfo(  apiInfo() )
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.apps.projectsms"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}


	@Bean
	public ApiInfo apiInfo(){
		ApiInfo info=new ApiInfoBuilder()
				.title("Projects management application")
				.description("rest api for projects management")
				.build();
		return info;
	}

}
