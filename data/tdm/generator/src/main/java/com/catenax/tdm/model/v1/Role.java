/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets Role.
 */
public enum Role {

	/** The author. */
	AUTHOR("Author"),
	/** The customer. */
	CUSTOMER("Customer"),
	/** The supplier. */
	SUPPLIER("Supplier"),
	/** The manufacturer. */
	MANUFACTURER("Manufacturer"),

	/** The responsible. */
	RESPONSIBLE("Responsible");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the role
	 */
	@JsonCreator
	public static Role fromValue(String text) {
		for (final Role b : Role.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new role.
	 *
	 * @param value the value
	 */
	Role(String value) {
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
