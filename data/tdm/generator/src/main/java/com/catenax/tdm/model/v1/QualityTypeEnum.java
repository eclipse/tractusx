/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets urn_bamm_com.catenaX_0.0.1_QualityTypeEnum
 */
public enum QualityTypeEnum {

	/** The major. */
	MAJOR("major"),
	/** The minor. */
	MINOR("minor"),
	/** The critical. */
	CRITICAL("critical");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the quality type enum
	 */
	@JsonCreator
	public static QualityTypeEnum fromValue(String text) {
		for (final QualityTypeEnum b : QualityTypeEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new quality type enum.
	 *
	 * @param value the value
	 */
	QualityTypeEnum(String value) {
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
