/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * StepsSequenceCharacteristicsInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

public class StepsSequenceCharacteristicsInner {

	/** The sequence id. */
	@JsonProperty("sequenceId")
	private String sequenceId = null;

	/** The name. */
	@JsonProperty("name")
	private String name = null;

	/** The description. */
	@JsonProperty("description")
	private String description = null;

	/**
	 * Description.
	 *
	 * @param description the description
	 * @return the steps sequence characteristics inner
	 */
	public StepsSequenceCharacteristicsInner description(String description) {
		this.description = description;
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
		final StepsSequenceCharacteristicsInner stepsSequenceCharacteristicsInner = (StepsSequenceCharacteristicsInner) o;
		return Objects.equals(this.sequenceId, stepsSequenceCharacteristicsInner.sequenceId)
				&& Objects.equals(this.name, stepsSequenceCharacteristicsInner.name)
				&& Objects.equals(this.description, stepsSequenceCharacteristicsInner.description);
	}

	/**
	 * Get description.
	 *
	 * @return description
	 */
	@Schema(description = "")

	public String getDescription() {
		return description;
	}

	/**
	 * Get name.
	 *
	 * @return name
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getName() {
		return name;
	}

	/**
	 * Get sequenceId.
	 *
	 * @return sequenceId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getSequenceId() {
		return sequenceId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(sequenceId, name, description);
	}

	/**
	 * Name.
	 *
	 * @param name the name
	 * @return the steps sequence characteristics inner
	 */
	public StepsSequenceCharacteristicsInner name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sequence id.
	 *
	 * @param sequenceId the sequence id
	 * @return the steps sequence characteristics inner
	 */
	public StepsSequenceCharacteristicsInner sequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
		return this;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the sequence id.
	 *
	 * @param sequenceId the new sequence id
	 */
	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
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
		sb.append("class StepsSequenceCharacteristicsInner {\n");

		sb.append("    sequenceId: ").append(toIndentedString(sequenceId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
