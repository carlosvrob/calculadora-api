package com.proyectoscvr.calculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class CalculatorConfiguration {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Calculator API")
                        .description("API REST Calculadora básica")
                        .contact(new Contact()
                                .name("Carlos Villar")
                                .email("carlosvrob91@gmail.com")
                                .url(""))
                        .version("1.0.0"));
    }
}
