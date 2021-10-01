/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * DigitalFilesInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

public class DigitalFilesInner {

	/** The value. */
	@JsonProperty("value")
	private String value = null;

	/** The mime type. */
	@JsonProperty("mimeType")
	private String mimeType = null;

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
		final DigitalFilesInner digitalFilesInner = (DigitalFilesInner) o;
		return Objects.equals(this.value, digitalFilesInner.value)
				&& Objects.equals(this.mimeType, digitalFilesInner.mimeType);
	}

	/**
	 * Get mimeType.
	 *
	 * @return mimeType
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getMimeType() {
		return mimeType;
	}

	/**
	 * Get value.
	 *
	 * @return value
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getValue() {
		return value;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(value, mimeType);
	}

	/**
	 * Mime type.
	 *
	 * @param mimeType the mime type
	 * @return the digital files inner
	 */
	public DigitalFilesInner mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Sets the mime type.
	 *
	 * @param mimeType the new mime type
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
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
		sb.append("class DigitalFilesInner {\n");

		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Value.
	 *
	 * @param value the value
	 * @return the digital files inner
	 */
	public DigitalFilesInner value(String value) {
		this.value = value;
		return this;
	}
}
