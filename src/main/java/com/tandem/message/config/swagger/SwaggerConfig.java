package com.tandem.message.config.swagger;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiKey;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.tandem.message.controller"))
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
            .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()//
            .title("Message API")//
            .description("Simple messaging service API")//
            .version("1.0.0")//
            .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
            .contact(new Contact("Gururaj B M", null, "guru.bm@gmail.com"))//
            .build();
    }
}
