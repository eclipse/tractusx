/*
 *
 */
package io.swagger.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerUiConfiguration.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-22T08:24:51.189Z[GMT]")
@Configuration
public class SwaggerUiConfiguration implements WebMvcConfigurer {

	/**
	 * Adds the resource handlers.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
				.resourceChain(false);
	}

	/**
	 * Adds the view controllers.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
	}
}
