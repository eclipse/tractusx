/*
 *
 */
package com.catenax.tdm.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */
@Configuration
public class Config {

	/** The base url. */
	public static String BASE_URL = "http://catena-x.net/tdm";

	/**
	 * Gets the catena X api controller delegate.
	 *
	 * @return the catena X api controller delegate
	 */
	@Bean
	public CatenaXApiControllerDelegate getCatenaXApiControllerDelegate() {
		final CatenaXApiControllerDelegate delegate = new CatenaXApiControllerDelegateImpl();

		return delegate;
	}

}
