/*
 *
 */
package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerDocumentationConfig.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-22T08:24:51.189Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Catena-X Speedboat Test Data Generator (TDG)").description(
				"Disclaimer: This service serves synthetic, none-productive data for testing purposes only. All BOMs, part trees, VINs, serialNos etc. are synthetic")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("").version("0.0.1 Speedboat")
				.contact(new Contact("", "", "christian.kabelin@partner.bmw.de")).build();
	}

	/**
	 * Custom implementation.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.OAS_30).select().apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
				.build().directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
	}

	/**
	 * Open api.
	 *
	 * @return the open API
	 */
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().title("Catena-X Speedboat Test Data Generator (TDG)").description(
				"Disclaimer: This service serves synthetic, none-productive data for testing purposes only. All BOMs, part trees, VINs, serialNos etc. are synthetic")
				.termsOfService("").version("0.0.1 Speedboat")
				.license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"))
				.contact(new io.swagger.v3.oas.models.info.Contact().email("christian.kabelin@partner.bmw.de")));
	}

}
