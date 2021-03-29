package com.gutotech.fatecandoapi.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Java config for Springfox swagger documentation plugin
 */

@Configuration
@EnableSwagger2
public class ApplicationSwaggerConfig {

	@Bean
	public Docket customDocket() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
		// @formatter:on
	}

	private ApiInfo getApiInfo() {
		// @formatter:off
		return new ApiInfoBuilder()
				.title("REST Fatecando backend Api Documentation")
				.description("This is REST API documentation of the Fatecando backend.")
				.version("1.0")
				.termsOfServiceUrl("Fatecando backend terms of service")
				.contact(new Contact("Gustavo Alves", "https://github.com/guto-alves/fatecando-api", 
						"gustavo.almeida13@fatec.sp.gov.br"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
		// @formatter:on
	}

}
