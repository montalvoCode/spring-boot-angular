package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Configuration
public class SwaggerConfig {

	    @Bean
	    public Docket productsApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .pathMapping("/")
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.project.api"))
	                .paths(PathSelectors.any())
	                .build();
	    }
	    
}
