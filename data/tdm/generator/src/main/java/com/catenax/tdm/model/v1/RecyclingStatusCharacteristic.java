/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets RecyclingStatusCharacteristic.
 */
public enum RecyclingStatusCharacteristic {

	/** The recycled. */
	RECYCLED("recycled"),
	/** The not recycled. */
	NOT_RECYCLED("not recycled");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the recycling status characteristic
	 */
	@JsonCreator
	public static RecyclingStatusCharacteristic fromValue(String text) {
		for (final RecyclingStatusCharacteristic b : RecyclingStatusCharacteristic.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new recycling status characteristic.
	 *
	 * @param value the value
	 */
	RecyclingStatusCharacteristic(String value) {
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
