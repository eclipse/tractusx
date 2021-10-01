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
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Describes an update of a part type name.
 */
@Schema(description = "Describes an update of a part type name.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartTypeNameUpdate implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4083086667391519725L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The effect time. */
	@JsonProperty("effectTime")
	private OffsetDateTime effectTime = null;

	/** The part. */
	@JsonProperty("part")
	@ManyToOne
	private PartId part = null;

	/** The part type name. */
	@JsonProperty("partTypeName")
	private String partTypeName = null;

	/**
	 * Effect time.
	 *
	 * @param effectTime the effect time
	 * @return the part type name update
	 */
	public PartTypeNameUpdate effectTime(OffsetDateTime effectTime) {
		this.effectTime = effectTime;
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
		final PartTypeNameUpdate partTypeNameUpdate = (PartTypeNameUpdate) o;
		return Objects.equals(this.effectTime, partTypeNameUpdate.effectTime)
				&& Objects.equals(this.part, partTypeNameUpdate.part)
				&& Objects.equals(this.partTypeName, partTypeNameUpdate.partTypeName);
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
	 * Gets the effect time.
	 *
	 * @return the effect time
	 */
	@Schema(required = true, description = "Instant at which the update was applied")
	@NotNull

	@Valid
	public OffsetDateTime getEffectTime() {
		return effectTime;
	}

	/**
	 * Get part.
	 *
	 * @return part
	 */
	@Schema(description = "")

	@Valid
	public PartId getPart() {
		return part;
	}

	/**
	 * Type of material, (sub)component/part or vehicle.
	 *
	 * @return partTypeName
	 */
	@Schema(example = "gearbox", description = "Type of material, (sub)component/part or vehicle")

	public String getPartTypeName() {
		return partTypeName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effectTime, part, partTypeName);
	}

	/**
	 * Part.
	 *
	 * @param part the part
	 * @return the part type name update
	 */
	public PartTypeNameUpdate part(PartId part) {
		this.part = part;
		return this;
	}

	/**
	 * Part type name.
	 *
	 * @param partTypeName the part type name
	 * @return the part type name update
	 */
	public PartTypeNameUpdate partTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
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
	 * Sets the effect time.
	 *
	 * @param effectTime the new effect time
	 */
	public void setEffectTime(OffsetDateTime effectTime) {
		this.effectTime = effectTime;
	}

	/**
	 * Sets the part.
	 *
	 * @param part the new part
	 */
	public void setPart(PartId part) {
		this.part = part;
	}

	/**
	 * Sets the part type name.
	 *
	 * @param partTypeName the new part type name
	 */
	public void setPartTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
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
		sb.append("class PartTypeNameUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    partTypeName: ").append(toIndentedString(partTypeName)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
