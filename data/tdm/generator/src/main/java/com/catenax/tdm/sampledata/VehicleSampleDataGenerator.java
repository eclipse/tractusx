/*
 *
 */
package com.catenax.tdm.sampledata;

import com.catenax.tdm.BOM;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehicleSampleDataGenerator.
 */
public interface VehicleSampleDataGenerator {

	/**
	 * Generate vehicle.
	 *
	 * @param vin the vin
	 * @return the bom
	 */
	public BOM generateVehicle(String vin);

}
