/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Logo.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_logo")
public class Logo {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The mime type. */
	@JsonProperty("mimeType")
	private String mimeType = null;

	/** The value. */
	@JsonProperty("value")
	private String value = null;

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
		final Logo logo = (Logo) o;
		return Objects.equals(this.mimeType, logo.mimeType) && Objects.equals(this.value, logo.value);
	}

	/**
	 * Gets the db id.
	 *
	 * @return the db id
	 */
	public Long getDbId() {
		return dbId;
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
		return Objects.hash(mimeType, value);
	}

	/**
	 * Mime type.
	 *
	 * @param mimeType the mime type
	 * @return the logo
	 */
	public Logo mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Sets the db id.
	 *
	 * @param dbId the new db id
	 */
	public void setDbId(Long dbId) {
		this.dbId = dbId;
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
		sb.append("class Logo {\n");

		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Value.
	 *
	 * @param value the value
	 * @return the logo
	 */
	public Logo value(String value) {
		this.value = value;
		return this;
	}
}
