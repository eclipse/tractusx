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
 * UrnBammComCatenaX001PartStaticDataCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability_static")
public class PartStaticDataCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The customer contract one ID. */
	@JsonProperty("customerContractOneID")
	private String customerContractOneID = null;

	/** The customer one ID. */
	@JsonProperty("customerOneID")
	private String customerOneID = null;

	/** The manufacture contract one ID. */
	@JsonProperty("manufactureContractOneID")
	private String manufactureContractOneID = null;

	/** The manufacturer one ID. */
	@JsonProperty("manufacturerOneID")
	private String manufacturerOneID = null;

	/** The part name customer. */
	@JsonProperty("partNameCustomer")
	private String partNameCustomer = null;

	/** The part name manufacturer. */
	@JsonProperty("partNameManufacturer")
	private String partNameManufacturer = null;

	/** The part number customer. */
	@JsonProperty("partNumberCustomer")
	private String partNumberCustomer = null;

	/** The part number manufacturer. */
	@JsonProperty("partNumberManufacturer")
	private String partNumberManufacturer = null;

	/**
	 * Customer contract one ID.
	 *
	 * @param customerContractOneID the customer contract one ID
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic customerContractOneID(String customerContractOneID) {
		this.customerContractOneID = customerContractOneID;
		return this;
	}

	/**
	 * Customer one ID.
	 *
	 * @param customerOneID the customer one ID
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic customerOneID(String customerOneID) {
		this.customerOneID = customerOneID;
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
		final PartStaticDataCharacteristic urnBammComCatenaX001PartStaticDataCharacteristic = (PartStaticDataCharacteristic) o;
		return Objects.equals(this.customerContractOneID,
				urnBammComCatenaX001PartStaticDataCharacteristic.customerContractOneID)
				&& Objects.equals(this.customerOneID, urnBammComCatenaX001PartStaticDataCharacteristic.customerOneID)
				&& Objects.equals(this.manufactureContractOneID,
						urnBammComCatenaX001PartStaticDataCharacteristic.manufactureContractOneID)
				&& Objects.equals(this.manufacturerOneID,
						urnBammComCatenaX001PartStaticDataCharacteristic.manufacturerOneID)
				&& Objects.equals(this.partNameCustomer,
						urnBammComCatenaX001PartStaticDataCharacteristic.partNameCustomer)
				&& Objects.equals(this.partNameManufacturer,
						urnBammComCatenaX001PartStaticDataCharacteristic.partNameManufacturer)
				&& Objects.equals(this.partNumberCustomer,
						urnBammComCatenaX001PartStaticDataCharacteristic.partNumberCustomer)
				&& Objects.equals(this.partNumberManufacturer,
						urnBammComCatenaX001PartStaticDataCharacteristic.partNumberManufacturer);
	}

	/**
	 * Get customerContractOneID.
	 *
	 * @return customerContractOneID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getCustomerContractOneID() {
		return customerContractOneID;
	}

	/**
	 * Get customerOneID.
	 *
	 * @return customerOneID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getCustomerOneID() {
		return customerOneID;
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
	 * Get manufactureContractOneID.
	 *
	 * @return manufactureContractOneID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufactureContractOneID() {
		return manufactureContractOneID;
	}

	/**
	 * Get manufacturerOneID.
	 *
	 * @return manufacturerOneID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufacturerOneID() {
		return manufacturerOneID;
	}

	/**
	 * Get partNameCustomer.
	 *
	 * @return partNameCustomer
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getPartNameCustomer() {
		return partNameCustomer;
	}

	/**
	 * Get partNameManufacturer.
	 *
	 * @return partNameManufacturer
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getPartNameManufacturer() {
		return partNameManufacturer;
	}

	/**
	 * Get partNumberCustomer.
	 *
	 * @return partNumberCustomer
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getPartNumberCustomer() {
		return partNumberCustomer;
	}

	/**
	 * Get partNumberManufacturer.
	 *
	 * @return partNumberManufacturer
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getPartNumberManufacturer() {
		return partNumberManufacturer;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(customerContractOneID, customerOneID, manufactureContractOneID, manufacturerOneID,
				partNameCustomer, partNameManufacturer, partNumberCustomer, partNumberManufacturer);
	}

	/**
	 * Manufacture contract one ID.
	 *
	 * @param manufactureContractOneID the manufacture contract one ID
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic manufactureContractOneID(String manufactureContractOneID) {
		this.manufactureContractOneID = manufactureContractOneID;
		return this;
	}

	/**
	 * Manufacturer one ID.
	 *
	 * @param manufacturerOneID the manufacturer one ID
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic manufacturerOneID(String manufacturerOneID) {
		this.manufacturerOneID = manufacturerOneID;
		return this;
	}

	/**
	 * Part name customer.
	 *
	 * @param partNameCustomer the part name customer
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic partNameCustomer(String partNameCustomer) {
		this.partNameCustomer = partNameCustomer;
		return this;
	}

	/**
	 * Part name manufacturer.
	 *
	 * @param partNameManufacturer the part name manufacturer
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic partNameManufacturer(String partNameManufacturer) {
		this.partNameManufacturer = partNameManufacturer;
		return this;
	}

	/**
	 * Part number customer.
	 *
	 * @param partNumberCustomer the part number customer
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic partNumberCustomer(String partNumberCustomer) {
		this.partNumberCustomer = partNumberCustomer;
		return this;
	}

	/**
	 * Part number manufacturer.
	 *
	 * @param partNumberManufacturer the part number manufacturer
	 * @return the part static data characteristic
	 */
	public PartStaticDataCharacteristic partNumberManufacturer(String partNumberManufacturer) {
		this.partNumberManufacturer = partNumberManufacturer;
		return this;
	}

	/**
	 * Sets the customer contract one ID.
	 *
	 * @param customerContractOneID the new customer contract one ID
	 */
	public void setCustomerContractOneID(String customerContractOneID) {
		this.customerContractOneID = customerContractOneID;
	}

	/**
	 * Sets the customer one ID.
	 *
	 * @param customerOneID the new customer one ID
	 */
	public void setCustomerOneID(String customerOneID) {
		this.customerOneID = customerOneID;
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
	 * Sets the manufacture contract one ID.
	 *
	 * @param manufactureContractOneID the new manufacture contract one ID
	 */
	public void setManufactureContractOneID(String manufactureContractOneID) {
		this.manufactureContractOneID = manufactureContractOneID;
	}

	/**
	 * Sets the manufacturer one ID.
	 *
	 * @param manufacturerOneID the new manufacturer one ID
	 */
	public void setManufacturerOneID(String manufacturerOneID) {
		this.manufacturerOneID = manufacturerOneID;
	}

	/**
	 * Sets the part name customer.
	 *
	 * @param partNameCustomer the new part name customer
	 */
	public void setPartNameCustomer(String partNameCustomer) {
		this.partNameCustomer = partNameCustomer;
	}

	/**
	 * Sets the part name manufacturer.
	 *
	 * @param partNameManufacturer the new part name manufacturer
	 */
	public void setPartNameManufacturer(String partNameManufacturer) {
		this.partNameManufacturer = partNameManufacturer;
	}

	/**
	 * Sets the part number customer.
	 *
	 * @param partNumberCustomer the new part number customer
	 */
	public void setPartNumberCustomer(String partNumberCustomer) {
		this.partNumberCustomer = partNumberCustomer;
	}

	/**
	 * Sets the part number manufacturer.
	 *
	 * @param partNumberManufacturer the new part number manufacturer
	 */
	public void setPartNumberManufacturer(String partNumberManufacturer) {
		this.partNumberManufacturer = partNumberManufacturer;
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
		sb.append("class UrnBammComCatenaX001PartStaticDataCharacteristic {\n");

		sb.append("    customerContractOneID: ").append(toIndentedString(customerContractOneID)).append("\n");
		sb.append("    customerOneID: ").append(toIndentedString(customerOneID)).append("\n");
		sb.append("    manufactureContractOneID: ").append(toIndentedString(manufactureContractOneID)).append("\n");
		sb.append("    manufacturerOneID: ").append(toIndentedString(manufacturerOneID)).append("\n");
		sb.append("    partNameCustomer: ").append(toIndentedString(partNameCustomer)).append("\n");
		sb.append("    partNameManufacturer: ").append(toIndentedString(partNameManufacturer)).append("\n");
		sb.append("    partNumberCustomer: ").append(toIndentedString(partNumberCustomer)).append("\n");
		sb.append("    partNumberManufacturer: ").append(toIndentedString(partNumberManufacturer)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
