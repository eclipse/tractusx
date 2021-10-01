/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * UrnBammComCatenaX001PartTreeParentCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability_tree_parent")
public class PartTreeParentCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The is parent of. */
	@JsonProperty("isParentOf")
	private IsParentOfCharacteristic isParentOf = null;

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
		final PartTreeParentCharacteristic urnBammComCatenaX001PartTreeParentCharacteristic = (PartTreeParentCharacteristic) o;
		return Objects.equals(this.isParentOf, urnBammComCatenaX001PartTreeParentCharacteristic.isParentOf);
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
	 * Get isParentOf.
	 *
	 * @return isParentOf
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public IsParentOfCharacteristic getIsParentOf() {
		return isParentOf;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isParentOf);
	}

	/**
	 * Checks if is parent of.
	 *
	 * @param isParentOf the is parent of
	 * @return the part tree parent characteristic
	 */
	public PartTreeParentCharacteristic isParentOf(IsParentOfCharacteristic isParentOf) {
		this.isParentOf = isParentOf;
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
	 * Sets the checks if is parent of.
	 *
	 * @param isParentOf the new checks if is parent of
	 */
	public void setIsParentOf(IsParentOfCharacteristic isParentOf) {
		this.isParentOf = isParentOf;
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
		sb.append("class UrnBammComCatenaX001PartTreeParentCharacteristic {\n");

		sb.append("    isParentOf: ").append(toIndentedString(isParentOf)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
