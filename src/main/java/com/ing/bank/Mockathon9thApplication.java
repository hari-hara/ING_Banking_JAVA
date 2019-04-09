package com.ing.bank;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class Mockathon9thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mockathon9thApplication.class, args);
	}
	
	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		//return or(regex("/api/v1.*"), regex("/api/v1.*"));
		return or(regex("/.*"), regex("/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ing API")
				.description("Ing Product Group API reference for developers")
				.termsOfServiceUrl("http://ing.com")
				.contact("Squad2@hcl.com").license("Ing License")
				.licenseUrl("Squad2@hcl.com").version("1.0").build();
	}

}
