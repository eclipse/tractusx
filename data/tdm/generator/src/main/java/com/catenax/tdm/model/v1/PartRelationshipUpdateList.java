package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.PartRelationshipUpdate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Describes an update of (part of) a BOM.
 */
@Schema(description = "Describes an update of (part of) a BOM.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

public class PartRelationshipUpdateList {

	@JsonProperty("relationships")
	@Valid
	private List<PartRelationshipUpdate> relationships = null;

	public PartRelationshipUpdateList relationships(List<PartRelationshipUpdate> relationships) {
		this.relationships = relationships;
		return this;
	}

	public PartRelationshipUpdateList addRelationshipsItem(PartRelationshipUpdate relationshipsItem) {
		if (this.relationships == null) {
			this.relationships = new ArrayList<PartRelationshipUpdate>();
		}
		this.relationships.add(relationshipsItem);
		return this;
	}

	/**
	 * List of relationships updates
	 * 
	 * @return relationships
	 **/
	@Schema(description = "List of relationships updates")
	@Valid
	public List<PartRelationshipUpdate> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<PartRelationshipUpdate> relationships) {
		this.relationships = relationships;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartRelationshipUpdateList partRelationshipUpdateList = (PartRelationshipUpdateList) o;
		return Objects.equals(this.relationships, partRelationshipUpdateList.relationships);
	}

	@Override
	public int hashCode() {
		return Objects.hash(relationships);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartRelationshipUpdateList {\n");

		sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
