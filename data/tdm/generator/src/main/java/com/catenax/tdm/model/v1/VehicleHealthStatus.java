/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets VehicleHealthStatus.
 */
public enum VehicleHealthStatus {

	/** The in running condition. */
	IN_RUNNING_CONDITION("in running condition"),
	/** The repair required. */
	REPAIR_REQUIRED("repair required"),
	/** The broken. */
	BROKEN("broken");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the vehicle health status
	 */
	@JsonCreator
	public static VehicleHealthStatus fromValue(String text) {
		for (final VehicleHealthStatus b : VehicleHealthStatus.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new vehicle health status.
	 *
	 * @param value the value
	 */
	VehicleHealthStatus(String value) {
		this.value = value;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}
}
