/**
 * 
 */
package com.challido.RiskApplication.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author URK7KOR
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        .groupName("RiskApplication")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.challido.RiskApplication.controller"))
        .paths(regex("/.*"))
        .build();                                           
    }
	
    @SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
    	return new ApiInfo(
          "REST APIs for Risk Application Management",
          "This WebUI describe the REST APIs that can be used to manipulate the Settled and Unsettled bets",
          "v2.0",
          "Terms of service",
          "<Ranjithprabhu.kumar@in.bosch.com>",
          "License of API",
          "API license URL");
    }
}
