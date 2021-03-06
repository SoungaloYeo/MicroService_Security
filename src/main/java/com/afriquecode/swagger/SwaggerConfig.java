package com.afriquecode.swagger;


import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("secured-api")
				.apiInfo(apiInfo()).select().paths((com.google.common.base.Predicate<String>) postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api.*"), regex("/api.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(" API")
				.description("Blog API reference for developers")
				.termsOfServiceUrl("http://blogapp.com")
				.contact(contact).license("me")
				.licenseUrl("soungaloyeo@gmail.com").version("1.0").build();
	}

        Contact contact = new Contact("YEO Soungalo", "objis.com","yeo@10000codeurs.com");
}
