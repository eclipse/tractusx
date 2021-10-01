/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Released.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

public class Released implements OneOfurnBammOrgIdtwin100StatusValueCharacteristic {

	/**
	 * Gets or Sets status.
	 */
	public enum StatusEnum {

		/** The released. */
		RELEASED("Released");

		/**
		 * From value.
		 *
		 * @param text the text
		 * @return the status enum
		 */
		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (final StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new status enum.
		 *
		 * @param value the value
		 */
		StatusEnum(String value) {
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

	/** The status. */
	@JsonProperty("status")
	private StatusEnum status = null;

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Released released = (Released) o;
		return Objects.equals(this.status, released.status);
	}

	/**
	 * Get status.
	 *
	 * @return status
	 */
	@Schema(required = true, description = "")
	@NotNull

	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(status);
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Status.
	 *
	 * @param status the status
	 * @return the released
	 */
	public Released status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 *
	 * @param o the o
	 * @return the string
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class Released {\n");

		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
