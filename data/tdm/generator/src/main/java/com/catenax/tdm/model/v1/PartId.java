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

/**
 * Unique part identifier
 */
@Schema(description = "Unique part identifier")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")

@Entity
public class PartId implements Serializable {
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

	@JsonProperty("oneIDManufacturer")
	private String oneIDManufacturer = null;

	@JsonProperty("objectIDManufacturer")
	private String objectIDManufacturer = null;

	public PartId oneIDManufacturer(String oneIDManufacturer) {
		this.oneIDManufacturer = oneIDManufacturer;
		return this;
	}

	/**
	 * Readable ID of manufacturer including plant
	 * 
	 * @return oneIDManufacturer
	 **/
	@Schema(example = "BMW MUC", required = true, description = "Readable ID of manufacturer including plant")
	@NotNull

	public String getOneIDManufacturer() {
		return oneIDManufacturer;
	}

	public void setOneIDManufacturer(String oneIDManufacturer) {
		this.oneIDManufacturer = oneIDManufacturer;
	}

	public PartId objectIDManufacturer(String objectIDManufacturer) {
		this.objectIDManufacturer = objectIDManufacturer;
		return this;
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

	public void setObjectIDManufacturer(String objectIDManufacturer) {
		this.objectIDManufacturer = objectIDManufacturer;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartId partId = (PartId) o;
		return Objects.equals(this.oneIDManufacturer, partId.oneIDManufacturer)
				&& Objects.equals(this.objectIDManufacturer, partId.objectIDManufacturer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oneIDManufacturer, objectIDManufacturer);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PartId {\n");

		sb.append("    oneIDManufacturer: ").append(toIndentedString(oneIDManufacturer)).append("\n");
		sb.append("    objectIDManufacturer: ").append(toIndentedString(objectIDManufacturer)).append("\n");
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
