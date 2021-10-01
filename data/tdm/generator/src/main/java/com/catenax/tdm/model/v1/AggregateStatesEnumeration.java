/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets AggregateStatesEnumeration.
 */
public enum AggregateStatesEnumeration {

	/** The gas. */
	GAS("gas"),
	/** The liquid. */
	LIQUID("liquid"),
	/** The solid. */
	SOLID("solid");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the aggregate states enumeration
	 */
	@JsonCreator
	public static AggregateStatesEnumeration fromValue(String text) {
		for (final AggregateStatesEnumeration b : AggregateStatesEnumeration.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new aggregate states enumeration.
	 *
	 * @param value the value
	 */
	AggregateStatesEnumeration(String value) {
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
