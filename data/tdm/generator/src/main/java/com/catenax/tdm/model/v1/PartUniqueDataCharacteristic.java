/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * UrnBammComCatenaX001PartUniqueDataCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability_unique")
public class PartUniqueDataCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The customer unique ID. */
	@JsonProperty("customerUniqueID")
	private String customerUniqueID = null;

	/** The manufacturer unique ID. */
	@JsonProperty("manufacturerUniqueID")
	private String manufacturerUniqueID = null;

	/** The unique ID. */
	@JsonProperty("uniqueID")
	private String uniqueID = null;

	/**
	 * Customer unique ID.
	 *
	 * @param customerUniqueID the customer unique ID
	 * @return the part unique data characteristic
	 */
	public PartUniqueDataCharacteristic customerUniqueID(String customerUniqueID) {
		this.customerUniqueID = customerUniqueID;
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
		final PartUniqueDataCharacteristic urnBammComCatenaX001PartUniqueDataCharacteristic = (PartUniqueDataCharacteristic) o;
		return Objects.equals(this.customerUniqueID, urnBammComCatenaX001PartUniqueDataCharacteristic.customerUniqueID)
				&& Objects.equals(this.manufacturerUniqueID,
						urnBammComCatenaX001PartUniqueDataCharacteristic.manufacturerUniqueID)
				&& Objects.equals(this.uniqueID, urnBammComCatenaX001PartUniqueDataCharacteristic.uniqueID);
	}

	/**
	 * Get customerUniqueID.
	 *
	 * @return customerUniqueID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getCustomerUniqueID() {
		return customerUniqueID;
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
	 * Get manufacturerUniqueID.
	 *
	 * @return manufacturerUniqueID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufacturerUniqueID() {
		return manufacturerUniqueID;
	}

	/**
	 * Get uniqueID.
	 *
	 * @return uniqueID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getUniqueID() {
		return uniqueID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(customerUniqueID, manufacturerUniqueID, uniqueID);
	}

	/**
	 * Manufacturer unique ID.
	 *
	 * @param manufacturerUniqueID the manufacturer unique ID
	 * @return the part unique data characteristic
	 */
	public PartUniqueDataCharacteristic manufacturerUniqueID(String manufacturerUniqueID) {
		this.manufacturerUniqueID = manufacturerUniqueID;
		return this;
	}

	/**
	 * Sets the customer unique ID.
	 *
	 * @param customerUniqueID the new customer unique ID
	 */
	public void setCustomerUniqueID(String customerUniqueID) {
		this.customerUniqueID = customerUniqueID;
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
	 * Sets the manufacturer unique ID.
	 *
	 * @param manufacturerUniqueID the new manufacturer unique ID
	 */
	public void setManufacturerUniqueID(String manufacturerUniqueID) {
		this.manufacturerUniqueID = manufacturerUniqueID;
	}

	/**
	 * Sets the unique ID.
	 *
	 * @param uniqueID the new unique ID
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
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
		sb.append("class UrnBammComCatenaX001PartUniqueDataCharacteristic {\n");

		sb.append("    customerUniqueID: ").append(toIndentedString(customerUniqueID)).append("\n");
		sb.append("    manufacturerUniqueID: ").append(toIndentedString(manufacturerUniqueID)).append("\n");
		sb.append("    uniqueID: ").append(toIndentedString(uniqueID)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Unique ID.
	 *
	 * @param uniqueID the unique ID
	 * @return the part unique data characteristic
	 */
	public PartUniqueDataCharacteristic uniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
		return this;
	}
}
