/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets RecyclingProcessCharacteristic.
 */
public enum RecyclingProcessCharacteristic {

	/** The process1. */
	PROCESS1("process1"),
	/** The process2. */
	PROCESS2("process2"),
	/** The process3. */
	PROCESS3("process3");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the recycling process characteristic
	 */
	@JsonCreator
	public static RecyclingProcessCharacteristic fromValue(String text) {
		for (final RecyclingProcessCharacteristic b : RecyclingProcessCharacteristic.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new recycling process characteristic.
	 *
	 * @param value the value
	 */
	RecyclingProcessCharacteristic(String value) {
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
