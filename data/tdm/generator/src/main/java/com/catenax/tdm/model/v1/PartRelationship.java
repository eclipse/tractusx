package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.PartId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Link between two parts.
 */
@Schema(description = "Link between two parts.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartRelationship implements Serializable {

	private static final long serialVersionUID = -2651062168473551916L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}

	@JsonProperty("parent")
	@ManyToOne
	private PartId parent = null;

	@JsonProperty("child")
	@ManyToOne
	private PartId child = null;

	public PartRelationship parent(PartId parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * Get parent
	 * 
	 * @return parent
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartId getParent() {
		return parent;
	}

	public void setParent(PartId parent) {
		this.parent = parent;
	}

	public PartRelationship child(PartId child) {
		this.child = child;
		return this;
	}

	/**
	 * Get child
	 * 
	 * @return child
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartId getChild() {
		return child;
	}

	public void setChild(PartId child) {
		this.child = child;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartRelationship partRelationship = (PartRelationship) o;
		return Objects.equals(this.parent, partRelationship.parent)
				&& Objects.equals(this.child, partRelationship.child);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parent, child);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartRelationship {\n");

		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    child: ").append(toIndentedString(child)).append("\n");
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
