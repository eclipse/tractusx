package com.catenax.tdm.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	public static String BASE_URL = "http://catena-x.net/tdm";

	@Bean 
	public CatenaXApiControllerDelegate getCatenaXApiControllerDelegate() {
		CatenaXApiControllerDelegate delegate = new CatenaXApiControllerDelegateImpl();
		
		return delegate;
	}

}
