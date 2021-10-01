/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Link between two parts.
 */
@Schema(description = "Link between two parts.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartRelationship implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2651062168473551916L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The parent. */
	@JsonProperty("parent")
	@ManyToOne
	private PartId parent = null;

	/** The child. */
	@JsonProperty("child")
	@ManyToOne
	private PartId child = null;

	/**
	 * Child.
	 *
	 * @param child the child
	 * @return the part relationship
	 */
	public PartRelationship child(PartId child) {
		this.child = child;
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
		final PartRelationship partRelationship = (PartRelationship) o;
		return Objects.equals(this.parent, partRelationship.parent)
				&& Objects.equals(this.child, partRelationship.child);
	}

	/**
	 * Get child.
	 *
	 * @return child
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartId getChild() {
		return child;
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
	 * Get parent.
	 *
	 * @return parent
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartId getParent() {
		return parent;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(parent, child);
	}

	/**
	 * Parent.
	 *
	 * @param parent the parent
	 * @return the part relationship
	 */
	public PartRelationship parent(PartId parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * Sets the child.
	 *
	 * @param child the new child
	 */
	public void setChild(PartId child) {
		this.child = child;
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
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(PartId parent) {
		this.parent = parent;
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
		sb.append("class PartRelationship {\n");

		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    child: ").append(toIndentedString(child)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
