/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Information about parts.
 */
@Schema(description = "Information about parts")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3319712410933340377L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The part. */
	@JsonProperty("part")
	@OneToOne
	private PartId part = null;

	/** The part type name. */
	@JsonProperty("partTypeName")
	private String partTypeName = null;

	/** The aspects. */
	@JsonProperty("aspects")
	@Valid
	@OneToMany
	private List<Aspect> aspects = null;

	/**
	 * Adds the aspects item.
	 *
	 * @param aspectsItem the aspects item
	 * @return the part info
	 */
	public PartInfo addAspectsItem(Aspect aspectsItem) {
		if (this.aspects == null) {
			this.aspects = new ArrayList<>();
		}
		this.aspects.add(aspectsItem);
		return this;
	}

	/**
	 * Aspects.
	 *
	 * @param aspects the aspects
	 * @return the part info
	 */
	public PartInfo aspects(List<Aspect> aspects) {
		this.aspects = aspects;
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
		final PartInfo partInfo = (PartInfo) o;
		return Objects.equals(this.part, partInfo.part) && Objects.equals(this.partTypeName, partInfo.partTypeName)
				&& Objects.equals(this.aspects, partInfo.aspects);
	}

	/**
	 * List of aspect locations.
	 *
	 * @return aspects
	 **/
	@Schema(description = "List of aspect locations.")
	@Valid
	public List<Aspect> getAspects() {
		return aspects;
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
		return Objects.hash(part, partTypeName, aspects);
	}

	/**
	 * Part.
	 *
	 * @param part the part
	 * @return the part info
	 */
	public PartInfo part(PartId part) {
		this.part = part;
		return this;
	}

	/**
	 * Part type name.
	 *
	 * @param partTypeName the part type name
	 * @return the part info
	 */
	public PartInfo partTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
		return this;
	}

	/**
	 * Sets the aspects.
	 *
	 * @param aspects the new aspects
	 */
	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
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
		sb.append("class PartInfo {\n");

		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    partTypeName: ").append(toIndentedString(partTypeName)).append("\n");
		sb.append("    aspects: ").append(toIndentedString(aspects)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
