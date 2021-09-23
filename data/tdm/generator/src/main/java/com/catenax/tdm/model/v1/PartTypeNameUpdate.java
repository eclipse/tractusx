package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.PartId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Describes an update of a part type name.
 */
@Schema(description = "Describes an update of a part type name.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartTypeNameUpdate implements Serializable {

	private static final long serialVersionUID = -4083086667391519725L;

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

	@JsonProperty("effectTime")
	private OffsetDateTime effectTime = null;

	@JsonProperty("part")
	@ManyToOne
	private PartId part = null;

	@JsonProperty("partTypeName")
	private String partTypeName = null;

	public PartTypeNameUpdate effectTime(OffsetDateTime effectTime) {
		this.effectTime = effectTime;
		return this;
	}

	/**
	 * Instant at which the update was applied
	 * 
	 * @return effectTime
	 **/
	@Schema(required = true, description = "Instant at which the update was applied")
	@NotNull

	@Valid
	public OffsetDateTime getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(OffsetDateTime effectTime) {
		this.effectTime = effectTime;
	}

	public PartTypeNameUpdate part(PartId part) {
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

	public PartTypeNameUpdate partTypeName(String partTypeName) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartTypeNameUpdate partTypeNameUpdate = (PartTypeNameUpdate) o;
		return Objects.equals(this.effectTime, partTypeNameUpdate.effectTime)
				&& Objects.equals(this.part, partTypeNameUpdate.part)
				&& Objects.equals(this.partTypeName, partTypeNameUpdate.partTypeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(effectTime, part, partTypeName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartTypeNameUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    partTypeName: ").append(toIndentedString(partTypeName)).append("\n");
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
