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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Describes an update of a relationship.
 */
@Schema(description = "Describes an update of a relationship")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartRelationshipUpdate implements Serializable {

	/**
	 * Stage defining whether changes apply to the AS_BUILT or AS_MAINTAINED BOM
	 * views.
	 */
	public enum StageEnum {

		/** The build. */
		BUILD("BUILD"),

		/** The maintenance. */
		MAINTENANCE("MAINTENANCE");

		/**
		 * From value.
		 *
		 * @param text the text
		 * @return the stage enum
		 */
		@JsonCreator
		public static StageEnum fromValue(String text) {
			for (final StageEnum b : StageEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new stage enum.
		 *
		 * @param value the value
		 */
		StageEnum(String value) {
			this.value = value;
		}

		/**
		 * To string.
		 *
		 * @return the string
		 */
		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7610785901821556595L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The effect time. */
	@JsonProperty("effectTime")
	private OffsetDateTime effectTime = null;

	/** The relationship. */
	@JsonProperty("relationship")
	@ManyToOne
	private PartRelationship relationship = null;

	/** The remove. */
	@JsonProperty("remove")
	private Boolean remove = null;

	/** The stage. */
	@JsonProperty("stage")
	private StageEnum stage = null;

	/**
	 * Effect time.
	 *
	 * @param effectTime the effect time
	 * @return the part relationship update
	 */
	public PartRelationshipUpdate effectTime(OffsetDateTime effectTime) {
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
		final PartRelationshipUpdate partRelationshipUpdate = (PartRelationshipUpdate) o;
		return Objects.equals(this.effectTime, partRelationshipUpdate.effectTime)
				&& Objects.equals(this.relationship, partRelationshipUpdate.relationship)
				&& Objects.equals(this.remove, partRelationshipUpdate.remove)
				&& Objects.equals(this.stage, partRelationshipUpdate.stage);
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
	 * Get relationship.
	 *
	 * @return relationship
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartRelationship getRelationship() {
		return relationship;
	}

	/**
	 * Stage defining whether changes apply to the AS_BUILT or AS_MAINTAINED BOM
	 * views.
	 *
	 * @return stage
	 **/
	@Schema(required = true, description = "Stage defining whether changes apply to the AS_BUILT or AS_MAINTAINED BOM views.")
	@NotNull

	public StageEnum getStage() {
		return stage;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effectTime, relationship, remove, stage);
	}

	/**
	 * <ul>
	 * <li>TRUE if the child is not part of the parent (used to update data, e.g. a
	 * relationship was wrongly submitted, or a part is removed from a car during
	 * maintenance)</li>
	 * <li>FALSE otherwise (“normal case” - a part is added into a parent
	 * part).</li>
	 * </ul>
	 *
	 * @return remove
	 **/
	@Schema(description = "<ul>   <li>TRUE if the child is not part of the parent (used to update data, e.g. a relationship was wrongly submitted, or a part is removed from a car during maintenance)</li>   <li>FALSE otherwise (“normal case” - a part is added into a parent part).</li></ul>")

	public Boolean isRemove() {
		return remove;
	}

	/**
	 * Relationship.
	 *
	 * @param relationship the relationship
	 * @return the part relationship update
	 */
	public PartRelationshipUpdate relationship(PartRelationship relationship) {
		this.relationship = relationship;
		return this;
	}

	/**
	 * Removes the.
	 *
	 * @param remove the remove
	 * @return the part relationship update
	 */
	public PartRelationshipUpdate remove(Boolean remove) {
		this.remove = remove;
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
	 * Sets the relationship.
	 *
	 * @param relationship the new relationship
	 */
	public void setRelationship(PartRelationship relationship) {
		this.relationship = relationship;
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
	 * Sets the stage.
	 *
	 * @param stage the new stage
	 */
	public void setStage(StageEnum stage) {
		this.stage = stage;
	}

	/**
	 * Stage.
	 *
	 * @param stage the stage
	 * @return the part relationship update
	 */
	public PartRelationshipUpdate stage(StageEnum stage) {
		this.stage = stage;
		return this;
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
		sb.append("class PartRelationshipUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    relationship: ").append(toIndentedString(relationship)).append("\n");
		sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
		sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
