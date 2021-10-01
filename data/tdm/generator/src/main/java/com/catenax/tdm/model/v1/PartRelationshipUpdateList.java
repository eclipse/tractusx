/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Describes an update of (part of) a BOM.
 */
@Schema(description = "Describes an update of (part of) a BOM.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

public class PartRelationshipUpdateList {

	/** The relationships. */
	@JsonProperty("relationships")
	@Valid
	private List<PartRelationshipUpdate> relationships = null;

	/**
	 * Adds the relationships item.
	 *
	 * @param relationshipsItem the relationships item
	 * @return the part relationship update list
	 */
	public PartRelationshipUpdateList addRelationshipsItem(PartRelationshipUpdate relationshipsItem) {
		if (this.relationships == null) {
			this.relationships = new ArrayList<>();
		}
		this.relationships.add(relationshipsItem);
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
		final PartRelationshipUpdateList partRelationshipUpdateList = (PartRelationshipUpdateList) o;
		return Objects.equals(this.relationships, partRelationshipUpdateList.relationships);
	}

	/**
	 * List of relationships updates.
	 *
	 * @return relationships
	 */
	@Schema(description = "List of relationships updates")
	@Valid
	public List<PartRelationshipUpdate> getRelationships() {
		return relationships;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(relationships);
	}

	/**
	 * Relationships.
	 *
	 * @param relationships the relationships
	 * @return the part relationship update list
	 */
	public PartRelationshipUpdateList relationships(List<PartRelationshipUpdate> relationships) {
		this.relationships = relationships;
		return this;
	}

	/**
	 * Sets the relationships.
	 *
	 * @param relationships the new relationships
	 */
	public void setRelationships(List<PartRelationshipUpdate> relationships) {
		this.relationships = relationships;
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
		sb.append("class PartRelationshipUpdateList {\n");

		sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
