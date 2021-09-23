package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describes an update of a relationship
 */
@Schema(description = "Describes an update of a relationship")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartRelationshipUpdate implements Serializable {

	private static final long serialVersionUID = 7610785901821556595L;

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

	@JsonProperty("relationship")
	@ManyToOne
	private PartRelationship relationship = null;

	@JsonProperty("remove")
	private Boolean remove = null;

	/**
	 * Stage defining whether changes apply to the AS_BUILT or AS_MAINTAINED BOM
	 * views.
	 */
	public enum StageEnum {
		BUILD("BUILD"),

		MAINTENANCE("MAINTENANCE");

		private String value;

		StageEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StageEnum fromValue(String text) {
			for (StageEnum b : StageEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("stage")
	private StageEnum stage = null;

	public PartRelationshipUpdate effectTime(OffsetDateTime effectTime) {
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

	public PartRelationshipUpdate relationship(PartRelationship relationship) {
		this.relationship = relationship;
		return this;
	}

	/**
	 * Get relationship
	 * 
	 * @return relationship
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartRelationship getRelationship() {
		return relationship;
	}

	public void setRelationship(PartRelationship relationship) {
		this.relationship = relationship;
	}

	public PartRelationshipUpdate remove(Boolean remove) {
		this.remove = remove;
		return this;
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

	public void setRemove(Boolean remove) {
		this.remove = remove;
	}

	public PartRelationshipUpdate stage(StageEnum stage) {
		this.stage = stage;
		return this;
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

	public void setStage(StageEnum stage) {
		this.stage = stage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartRelationshipUpdate partRelationshipUpdate = (PartRelationshipUpdate) o;
		return Objects.equals(this.effectTime, partRelationshipUpdate.effectTime)
				&& Objects.equals(this.relationship, partRelationshipUpdate.relationship)
				&& Objects.equals(this.remove, partRelationshipUpdate.remove)
				&& Objects.equals(this.stage, partRelationshipUpdate.stage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(effectTime, relationship, remove, stage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartRelationshipUpdate {\n");

		sb.append("    effectTime: ").append(toIndentedString(effectTime)).append("\n");
		sb.append("    relationship: ").append(toIndentedString(relationship)).append("\n");
		sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
		sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
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
