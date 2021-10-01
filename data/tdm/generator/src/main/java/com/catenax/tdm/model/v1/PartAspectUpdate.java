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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Describes an update of a part aspect location.
 */
@Schema(description = "Describes an update of a part aspect location.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartAspectUpdate implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5638847114548097951L;

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

	/** The aspects. */
	@JsonProperty("aspects")
	@Valid
	@OneToMany
	private List<Aspect> aspects = new ArrayList<>();

	/** The remove. */
	@JsonProperty("remove")
	private Boolean remove = null;

	/**
	 * Adds the aspects item.
	 *
	 * @param aspectsItem the aspects item
	 * @return the part aspect update
	 */
	public PartAspectUpdate addAspectsItem(Aspect aspectsItem) {
		this.aspects.add(aspectsItem);
		return this;
	}

	/**
	 * Aspects.
	 *
	 * @param aspects the aspects
	 * @return the part aspect update
	 */
	public PartAspectUpdate aspects(List<Aspect> aspects) {
		this.aspects = aspects;
		return this;
	}

	/**
	 * Effect time.
	 *
	 * @param effectTime the effect time
	 * @return the part aspect update
	 */
	public PartAspectUpdate effectTime(OffsetDateTime effectTime) {
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
		final PartAspectUpdate partAspectUpdate = (PartAspectUpdate) o;
		return Objects.equals(this.effectTime, partAspectUpdate.effectTime)
				&& Objects.equals(this.part, partAspectUpdate.part)
				&& Objects.equals(this.aspects, partAspectUpdate.aspects)
				&& Objects.equals(this.remove, partAspectUpdate.remove);
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

	/**
	 * Gets the db id.
	 *
	 * @return the db id
	 */
	public Long getDbId() {
		return dbId;
	}

	/**
	 * Instant at which the update was applied.
	 *
	 * @return effectTime
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effectTime, part, aspects, remove);
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

	/**
	 * Part.
	 *
	 * @param part the part
	 * @return the part aspect update
	 */
	public PartAspectUpdate part(PartId part) {
		this.part = part;
		return this;
	}

	/**
	 * Removes the.
	 *
	 * @param remove the remove
	 * @return the part aspect update
	 */
	public PartAspectUpdate remove(Boolean remove) {
		this.remove = remove;
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
	 * Sets the removes the.
	 *
	 * @param remove the new removes the
	 */
	public void setRemove(Boolean remove) {
		this.remove = remove;
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
		sb.append("class PartAspectUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    aspects: ").append(toIndentedString(aspects)).append("\n");
		sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
