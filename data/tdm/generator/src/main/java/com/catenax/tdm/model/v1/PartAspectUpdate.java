package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describes an update of a part aspect location.
 */
@Schema(description = "Describes an update of a part aspect location.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartAspectUpdate implements Serializable {

	private static final long serialVersionUID = -5638847114548097951L;

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

	@JsonProperty("aspects")
	@Valid
	@OneToMany
	private List<Aspect> aspects = new ArrayList<Aspect>();

	@JsonProperty("remove")
	private Boolean remove = null;

	public PartAspectUpdate effectTime(OffsetDateTime effectTime) {
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

	public PartAspectUpdate part(PartId part) {
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

	public PartAspectUpdate aspects(List<Aspect> aspects) {
		this.aspects = aspects;
		return this;
	}

	public PartAspectUpdate addAspectsItem(Aspect aspectsItem) {
		this.aspects.add(aspectsItem);
		return this;
	}

	/**
	 * Aspect location.
	 * 
	 * @return aspects
	 **/
	@Schema(required = true, description = "Aspect location.")
	@NotNull
	@Valid
	public List<Aspect> getAspects() {
		return aspects;
	}

	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
	}

	public PartAspectUpdate remove(Boolean remove) {
		this.remove = remove;
		return this;
	}

	/**
	 * <ul>
	 * <li>TRUE if the aspect URLs are to be deleted from the part</li>
	 * <li>FALSE otherwise (“normal case” - an aspect URL is added to a part).</li>
	 * </ul>
	 * 
	 * @return remove
	 **/
	@Schema(description = "<ul>   <li>TRUE if the aspect URLs are to be deleted from the part</li>   <li>FALSE otherwise (“normal case” - an aspect URL is added to a part).</li></ul>")

	public Boolean isRemove() {
		return remove;
	}

	public void setRemove(Boolean remove) {
		this.remove = remove;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartAspectUpdate partAspectUpdate = (PartAspectUpdate) o;
		return Objects.equals(this.effectTime, partAspectUpdate.effectTime)
				&& Objects.equals(this.part, partAspectUpdate.part)
				&& Objects.equals(this.aspects, partAspectUpdate.aspects)
				&& Objects.equals(this.remove, partAspectUpdate.remove);
	}

	@Override
	public int hashCode() {
		return Objects.hash(effectTime, part, aspects, remove);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartAspectUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    aspects: ").append(toIndentedString(aspects)).append("\n");
		sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
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
