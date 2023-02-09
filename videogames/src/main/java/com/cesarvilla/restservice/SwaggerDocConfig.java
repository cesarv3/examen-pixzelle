package com.cesarvilla.restservice;

import java.lang.annotation.Annotation;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerDocConfig {
	private static final String ALL_CHILD = ".*";
	
//	private ApiInfo metadata() {
//		return new ApiInfoBuilder().title("Examen Pixelle").description("Referencia API para desarrolladores")
//				.termsOfServiceUrl("https://www.javacodegeeks.com/").contact(new Contact("","","cvillaf89@gmail.com"))
//				.version("0.1").build();
//	}
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SpringShop API")
	              .description("Spring shop sample application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"));
	  }



}
