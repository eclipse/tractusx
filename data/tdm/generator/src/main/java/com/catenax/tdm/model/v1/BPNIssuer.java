/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Issuer for BPN.
 */
@Schema(description = "Issuer for BPN")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-15T07:34:43.482Z[GMT]")

public class BPNIssuer {

	/** The name. */
	@JsonProperty("name")
	private String name = null;

	/** The prefix. */
	@JsonProperty("prefix")
	private String prefix = null;
	
	public BPNIssuer() {
		
	}
	
	public BPNIssuer(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
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
		final BPNIssuer bpNIssuer = (BPNIssuer) o;
		return Objects.equals(this.name, bpNIssuer.name) && Objects.equals(this.prefix, bpNIssuer.prefix);
	}

	/**
	 * Get name.
	 *
	 * @return name
	 */
	@Schema(description = "")

	public String getName() {
		return name;
	}

	/**
	 * Get prefix.
	 *
	 * @return prefix
	 */
	@Schema(description = "")

	public String getPrefix() {
		return prefix;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, prefix);
	}

	/**
	 * Name.
	 *
	 * @param name the name
	 * @return the BPN issuer
	 */
	public BPNIssuer name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Prefix.
	 *
	 * @param prefix the prefix
	 * @return the BPN issuer
	 */
	public BPNIssuer prefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the prefix.
	 *
	 * @param prefix the new prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
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
		sb.append("class BPNIssuer {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
