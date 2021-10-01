/*
 *
 */
package com.catenax.tdm.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Gets or Sets DisassemblyStatus.
 */
public enum DisassemblyStatus {

	/** The assembled. */
	ASSEMBLED("assembled"),
	/** The disassembled. */
	DISASSEMBLED("disassembled");

	/**
	 * From value.
	 *
	 * @param text the text
	 * @return the disassembly status
	 */
	@JsonCreator
	public static DisassemblyStatus fromValue(String text) {
		for (final DisassemblyStatus b : DisassemblyStatus.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	/** The value. */
	private String value;

	/**
	 * Instantiates a new disassembly status.
	 *
	 * @param value the value
	 */
	DisassemblyStatus(String value) {
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
