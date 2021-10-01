/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets MaterialNamesEnumeration.
 */
public enum MaterialNamesEnumeration {

	/** The aluminium. */
	ALUMINIUM("aluminium"),
	/** The polyamide. */
	POLYAMIDE("polyamide"),
	/** The lithium. */
	LITHIUM("lithium"),
	/** The iron. */
	IRON("iron"),
	/** The others. */
	OTHERS("others");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the material names enumeration
	 */
	@JsonCreator
	public static MaterialNamesEnumeration fromValue(String text) {
		for (final MaterialNamesEnumeration b : MaterialNamesEnumeration.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new material names enumeration.
	 *
	 * @param value the value
	 */
	MaterialNamesEnumeration(String value) {
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
