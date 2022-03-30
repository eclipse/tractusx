/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.adapter;

import net.catenax.semantics.framework.auth.TokenIncomingInterceptor;
import net.catenax.semantics.framework.auth.TokenOutgoingInterceptor;
import net.catenax.semantics.framework.auth.TokenWrapper;
import net.catenax.semantics.framework.edc.EdcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main Adapter Application
 * TODO make sure openapi description is correct, referrer-header should give us a hint.
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigurationData.class})
@ComponentScan(basePackages = {"net.catenax.semantics.framework.aas.api.proxy", "net.catenax.semantics.adapter", "net.catenax.semantics.framework", "org.openapitools.configuration"},
		excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="net\\.catenax\\.semantics\\.framework\\.aas\\.api\\.proxy\\.AssetIdentifierApiController"))
public class Application {

	private static final String OPEN_ID_CONNECT_DISCOVERY_PATH = "/.well-known/openid-configuration";

	/**
	 * add a webmvc configurer allowing local cors
	 * @return webmvc
	 */
	@Bean
	public WebMvcConfigurer configurer(ApplicationContext context) {
		TokenIncomingInterceptor interceptor=context.getBean(TokenIncomingInterceptor.class);
		OAuth2ResourceServerProperties securityProperties=context.getBean(OAuth2ResourceServerProperties.class);

		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			  registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				if(securityProperties.getJwt().getIssuerUri()!=null) {
					registry.addInterceptor(interceptor);
				}
			}
			@Override
			public void addViewControllers(ViewControllerRegistry registry){
				// this redirect ensures that the SwaggerUI can get the open id discovery data
				if(securityProperties.getJwt().getIssuerUri()!=null) {
					String fullDiscoveryPath = securityProperties.getJwt().getIssuerUri() + OPEN_ID_CONNECT_DISCOVERY_PATH;
					registry.addRedirectViewController(OPEN_ID_CONNECT_DISCOVERY_PATH, fullDiscoveryPath);
				}
			}
		};
	 }

	@Bean
	public TokenIncomingInterceptor bearerTokenIncomingInterceptor(ApplicationContext context) {
		return new TokenIncomingInterceptor(context.getBean(TokenWrapper.class));
	}

	@Bean
	public TokenOutgoingInterceptor bearerTokenOutgoingInterceptor(ApplicationContext context) {
		return new TokenOutgoingInterceptor(context.getBean(TokenWrapper.class));
	}

	/**
	 * entry point if started as an app
	 * @param args command line
	 */
	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}

}
