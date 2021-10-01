/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Error.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

public class Error {

	/** The message. */
	@JsonProperty("message")
	private String message = null;

	/** The path. */
	@JsonProperty("path")
	private String path = null;

	/** The details. */
	@JsonProperty("details")
	@Valid
	private Map<String, Object> details = new HashMap<>();

	/** The code. */
	@JsonProperty("code")
	private String code = null;

	/**
	 * Code.
	 *
	 * @param code the code
	 * @return the error
	 */
	public Error code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Details.
	 *
	 * @param details the details
	 * @return the error
	 */
	public Error details(Map<String, Object> details) {
		this.details = details;
		return this;
	}

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
		final Error error = (Error) o;
		return Objects.equals(this.message, error.message) && Objects.equals(this.path, error.path)
				&& Objects.equals(this.details, error.details) && Objects.equals(this.code, error.code);
	}

	/**
	 * Get code.
	 *
	 * @return code
	 */
	@Schema(description = "")

	public String getCode() {
		return code;
	}

	/**
	 * Get details.
	 *
	 * @return details
	 */
	@Schema(required = true, description = "")
	@NotNull

	public Map<String, Object> getDetails() {
		return details;
	}

	/**
	 * Get message.
	 *
	 * @return message
	 */
	@Schema(description = "")

	@Size(min = 1)
	public String getMessage() {
		return message;
	}

	/**
	 * Get path.
	 *
	 * @return path
	 */
	@Schema(description = "")

	@Size(min = 1)
	public String getPath() {
		return path;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(message, path, details, code);
	}

	/**
	 * Message.
	 *
	 * @param message the message
	 * @return the error
	 */
	public Error message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Path.
	 *
	 * @param path the path
	 * @return the error
	 */
	public Error path(String path) {
		this.path = path;
		return this;
	}

	/**
	 * Put details item.
	 *
	 * @param key         the key
	 * @param detailsItem the details item
	 * @return the error
	 */
	public Error putDetailsItem(String key, Object detailsItem) {
		this.details.put(key, detailsItem);
		return this;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the details
	 */
	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
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
		sb.append("class Error {\n");

		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    path: ").append(toIndentedString(path)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
