/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets MemberCompanyRole.
 */
public enum MemberCompanyRole {

	/** The active participant. */
	ACTIVE_PARTICIPANT("ACTIVE_PARTICIPANT"),
	/** The app provider. */
	APP_PROVIDER("APP_PROVIDER"),

	/** The operations infrastructure provider. */
	OPERATIONS_INFRASTRUCTURE_PROVIDER("OPERATIONS_INFRASTRUCTURE_PROVIDER"),
	/** The consulting. */
	CONSULTING("CONSULTING"),

	/** The clearing house. */
	CLEARING_HOUSE("CLEARING_HOUSE");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the member company role
	 */
	@JsonCreator
	public static MemberCompanyRole fromValue(String text) {
		for (final MemberCompanyRole b : MemberCompanyRole.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new member company role.
	 *
	 * @param value the value
	 */
	MemberCompanyRole(String value) {
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
