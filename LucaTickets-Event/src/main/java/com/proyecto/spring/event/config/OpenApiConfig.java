package com.proyecto.spring.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
    @Bean
    public OpenAPI EventOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Event API")
                .description("Documentación de la Event API")
                .version("v1.0")
                .contact(new Contact().name("Alberto Egea").
                        url("https://alberto.es").email("alberto.egea.garcia97@gmail.com"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Descripcion del microservicio Event")
                .url("https://miproyecto.es"));
    }
	

}
