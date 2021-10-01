/*
 *
 */
package com.catenax.tdm;

import org.fluttercode.datafactory.impl.DataFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating TestData objects.
 */
public class TestDataFactory {

	/** The instance. */
	private static DataFactory INSTANCE = null;

	/**
	 * Gets the single instance of TestDataFactory.
	 *
	 * @return single instance of TestDataFactory
	 */
	public static DataFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = prepareGenerator();
		}
		return INSTANCE;
	}

	/**
	 * Prepare generator.
	 *
	 * @return the data factory
	 */
	private static DataFactory prepareGenerator() {
		final DataFactory result = new DataFactory();

		return result;
	}

}
