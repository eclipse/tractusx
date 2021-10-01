/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

// TODO: Auto-generated Javadoc
/**
 * ReuseOptionsSelection.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

public class ReuseOptionsSelection extends ArrayList<String> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8317010330185528806L;

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
		return true;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
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
		sb.append("class ReuseOptionsSelection {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
