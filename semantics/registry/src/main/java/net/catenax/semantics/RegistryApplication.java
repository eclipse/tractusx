/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics;

import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main Adapter Application
 */
@SpringBootApplication
@EnableJdbcAuditing
@EnableConfigurationProperties(RegistryProperties.class)
@ComponentScan(basePackages = {"net.catenax.semantics", "org.openapitools.configuration"})
public class RegistryApplication {

	private static final String OPEN_ID_CONNECT_DISCOVERY_PATH = "/.well-known/openid-configuration";

	@Bean
	public WebMvcConfigurer configurer(OAuth2ResourceServerProperties securityProperties) {
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			    registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
			@Override
			public void addViewControllers(ViewControllerRegistry registry){
				// this redirect ensures that the SwaggerUI can get the open id discovery data
				String fullDiscoveryPath = securityProperties.getJwt().getIssuerUri() + OPEN_ID_CONNECT_DISCOVERY_PATH;
				registry.addRedirectViewController(OPEN_ID_CONNECT_DISCOVERY_PATH, fullDiscoveryPath);
			}
		};
	}

	@Bean
	SpringDocConfiguration springDocConfiguration(){
		return new SpringDocConfiguration();
	}

	@Bean
	public SpringDocConfigProperties springDocConfigProperties() {
		return new SpringDocConfigProperties();
	}

	@Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

	@Bean
	public AuthorizationEvaluator authorizationEvaluator(RegistryProperties registryProperties){
		return new AuthorizationEvaluator(registryProperties.getIdm().getPublicClientId());
	}

	/**
	 * entry point if started as an app
	 * @param args command line
	 */
	public static void main(String[] args) {
		new SpringApplication(RegistryApplication.class).run(args);
	}

}
