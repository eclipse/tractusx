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
 * List of the relationships with their infos.
 */
@Schema(description = "List of the relationships with their infos")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

public class PartRelationshipWithInfos {

	/** The relationships. */
	@JsonProperty("relationships")
	@Valid
	private List<PartRelationship> relationships = null;

	/** The part infos. */
	@JsonProperty("partInfos")
	@Valid
	private List<PartInfo> partInfos = null;

	/**
	 * Adds the part infos item.
	 *
	 * @param partInfosItem the part infos item
	 * @return the part relationship with infos
	 */
	public PartRelationshipWithInfos addPartInfosItem(PartInfo partInfosItem) {
		if (this.partInfos == null) {
			this.partInfos = new ArrayList<>();
		}
		this.partInfos.add(partInfosItem);
		return this;
	}

	/**
	 * Adds the relationships item.
	 *
	 * @param relationshipsItem the relationships item
	 * @return the part relationship with infos
	 */
	public PartRelationshipWithInfos addRelationshipsItem(PartRelationship relationshipsItem) {
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
		final PartRelationshipWithInfos partRelationshipWithInfos = (PartRelationshipWithInfos) o;
		return Objects.equals(this.relationships, partRelationshipWithInfos.relationships)
				&& Objects.equals(this.partInfos, partRelationshipWithInfos.partInfos);
	}

	/**
	 * List of part infos.
	 *
	 * @return partInfos
	 */
	@Schema(description = "List of part infos")
	@Valid
	public List<PartInfo> getPartInfos() {
		return partInfos;
	}

	/**
	 * List of the relationships.
	 *
	 * @return relationships
	 */
	@Schema(description = "List of the relationships")
	@Valid
	public List<PartRelationship> getRelationships() {
		return relationships;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(relationships, partInfos);
	}

	/**
	 * Part infos.
	 *
	 * @param partInfos the part infos
	 * @return the part relationship with infos
	 */
	public PartRelationshipWithInfos partInfos(List<PartInfo> partInfos) {
		this.partInfos = partInfos;
		return this;
	}

	/**
	 * Relationships.
	 *
	 * @param relationships the relationships
	 * @return the part relationship with infos
	 */
	public PartRelationshipWithInfos relationships(List<PartRelationship> relationships) {
		this.relationships = relationships;
		return this;
	}

	/**
	 * Sets the part infos.
	 *
	 * @param partInfos the new part infos
	 */
	public void setPartInfos(List<PartInfo> partInfos) {
		this.partInfos = partInfos;
	}

	/**
	 * Sets the relationships.
	 *
	 * @param relationships the new relationships
	 */
	public void setRelationships(List<PartRelationship> relationships) {
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
		sb.append("class PartRelationshipWithInfos {\n");

		sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
		sb.append("    partInfos: ").append(toIndentedString(partInfos)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
