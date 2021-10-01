/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Unique part identifier.
 */
@Schema(description = "Unique part identifier")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartId implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 762514945118187029L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The one ID manufacturer. */
	@JsonProperty("oneIDManufacturer")
	private String oneIDManufacturer = null;

	/** The object ID manufacturer. */
	@JsonProperty("objectIDManufacturer")
	private String objectIDManufacturer = null;

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
		final PartId partId = (PartId) o;
		return Objects.equals(this.oneIDManufacturer, partId.oneIDManufacturer)
				&& Objects.equals(this.objectIDManufacturer, partId.objectIDManufacturer);
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
	 * Unique identifier of a single, unique physical (sub)component/part/batch,
	 * given by its manufacturer. For a vehicle, the Vehicle Identification Number
	 * (VIN).
	 *
	 * @return objectIDManufacturer
	 **/
	@Schema(example = "1122334455", description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer. For a vehicle, the Vehicle Identification Number (VIN).")

	public String getObjectIDManufacturer() {
		return objectIDManufacturer;
	}

	/**
	 * Readable ID of manufacturer including plant.
	 *
	 * @return oneIDManufacturer
	 */
	@Schema(example = "BMW MUC", required = true, description = "Readable ID of manufacturer including plant")
	@NotNull

	public String getOneIDManufacturer() {
		return oneIDManufacturer;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(oneIDManufacturer, objectIDManufacturer);
	}

	/**
	 * Object ID manufacturer.
	 *
	 * @param objectIDManufacturer the object ID manufacturer
	 * @return the part id
	 */
	public PartId objectIDManufacturer(String objectIDManufacturer) {
		this.objectIDManufacturer = objectIDManufacturer;
		return this;
	}

	/**
	 * One ID manufacturer.
	 *
	 * @param oneIDManufacturer the one ID manufacturer
	 * @return the part id
	 */
	public PartId oneIDManufacturer(String oneIDManufacturer) {
		this.oneIDManufacturer = oneIDManufacturer;
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
	 * Sets the object ID manufacturer.
	 *
	 * @param objectIDManufacturer the new object ID manufacturer
	 */
	public void setObjectIDManufacturer(String objectIDManufacturer) {
		this.objectIDManufacturer = objectIDManufacturer;
	}

	/**
	 * Sets the one ID manufacturer.
	 *
	 * @param oneIDManufacturer the new one ID manufacturer
	 */
	public void setOneIDManufacturer(String oneIDManufacturer) {
		this.oneIDManufacturer = oneIDManufacturer;
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
		sb.append("class PartId {\n");

		sb.append("    oneIDManufacturer: ").append(toIndentedString(oneIDManufacturer)).append("\n");
		sb.append("    objectIDManufacturer: ").append(toIndentedString(objectIDManufacturer)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
