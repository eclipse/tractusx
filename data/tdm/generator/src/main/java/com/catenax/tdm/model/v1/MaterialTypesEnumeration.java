/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets MaterialTypesEnumeration.
 */
public enum MaterialTypesEnumeration {

	/** The metal. */
	METAL("metal"),
	/** The plastic. */
	PLASTIC("plastic"),
	/** The other. */
	OTHER("other");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the material types enumeration
	 */
	@JsonCreator
	public static MaterialTypesEnumeration fromValue(String text) {
		for (final MaterialTypesEnumeration b : MaterialTypesEnumeration.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new material types enumeration.
	 *
	 * @param value the value
	 */
	MaterialTypesEnumeration(String value) {
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
