/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets BuildPositionEnumeration.
 */
public enum BuildPositionEnumeration {

	/** The left. */
	LEFT("left"),
	/** The right. */
	RIGHT("right"),
	/** The front. */
	FRONT("front"),
	/** The back. */
	BACK("back");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the builds the position enumeration
	 */
	@JsonCreator
	public static BuildPositionEnumeration fromValue(String text) {
		for (final BuildPositionEnumeration b : BuildPositionEnumeration.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new builds the position enumeration.
	 *
	 * @param value the value
	 */
	BuildPositionEnumeration(String value) {
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
