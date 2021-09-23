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

/**
 * Information about parts
 */
@Schema(description = "Information about parts")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartInfo implements Serializable {

	private static final long serialVersionUID = -3319712410933340377L;

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

	@JsonProperty("part")
	@OneToOne
	private PartId part = null;

	@JsonProperty("partTypeName")
	private String partTypeName = null;

	@JsonProperty("aspects")
	@Valid
	@OneToMany
	private List<Aspect> aspects = null;

	public PartInfo part(PartId part) {
		this.part = part;
		return this;
	}

	/**
	 * Get part
	 * 
	 * @return part
	 **/
	@Schema(description = "")

	@Valid
	public PartId getPart() {
		return part;
	}

	public void setPart(PartId part) {
		this.part = part;
	}

	public PartInfo partTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
		return this;
	}

	/**
	 * Type of material, (sub)component/part or vehicle
	 * 
	 * @return partTypeName
	 **/
	@Schema(example = "gearbox", description = "Type of material, (sub)component/part or vehicle")

	public String getPartTypeName() {
		return partTypeName;
	}

	public void setPartTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
	}

	public PartInfo aspects(List<Aspect> aspects) {
		this.aspects = aspects;
		return this;
	}

	public PartInfo addAspectsItem(Aspect aspectsItem) {
		if (this.aspects == null) {
			this.aspects = new ArrayList<Aspect>();
		}
		this.aspects.add(aspectsItem);
		return this;
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

	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartInfo partInfo = (PartInfo) o;
		return Objects.equals(this.part, partInfo.part) && Objects.equals(this.partTypeName, partInfo.partTypeName)
				&& Objects.equals(this.aspects, partInfo.aspects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(part, partTypeName, aspects);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartInfo {\n");

		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    partTypeName: ").append(toIndentedString(partTypeName)).append("\n");
		sb.append("    aspects: ").append(toIndentedString(aspects)).append("\n");
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
