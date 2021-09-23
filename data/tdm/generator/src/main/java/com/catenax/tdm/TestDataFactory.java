package com.catenax.tdm;

import org.fluttercode.datafactory.impl.DataFactory;

public class TestDataFactory {
	
	private static DataFactory INSTANCE = null;
	
	public static DataFactory getInstance() {
		if(INSTANCE == null) {
			INSTANCE = prepareGenerator();
		}
		return INSTANCE;
	}
	
	private static DataFactory prepareGenerator() {
		DataFactory result = new DataFactory();
		
		return result;
	}

}
