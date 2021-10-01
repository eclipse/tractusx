/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * ErrorResponse.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

public class ErrorResponse {

	/** The error. */
	@JsonProperty("error")
	private Error error = null;

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
		final ErrorResponse errorResponse = (ErrorResponse) o;
		return Objects.equals(this.error, errorResponse.error);
	}

	/**
	 * Error.
	 *
	 * @param error the error
	 * @return the error response
	 */
	public ErrorResponse error(Error error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error.
	 *
	 * @return error
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Error getError() {
		return error;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(error);
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(Error error) {
		this.error = error;
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
		sb.append("class ErrorResponse {\n");

		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
