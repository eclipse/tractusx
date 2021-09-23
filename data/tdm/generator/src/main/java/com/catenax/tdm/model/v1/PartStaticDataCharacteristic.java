package com.catenax.tdm.model.v1;

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
 * UrnBammComCatenaX001PartStaticDataCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class PartStaticDataCharacteristic   {
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
	
  @JsonProperty("customerContractOneID")
  private String customerContractOneID = null;

  @JsonProperty("customerOneID")
  private String customerOneID = null;

  @JsonProperty("manufactureContractOneID")
  private String manufactureContractOneID = null;

  @JsonProperty("manufacturerOneID")
  private String manufacturerOneID = null;

  @JsonProperty("partNameCustomer")
  private String partNameCustomer = null;

  @JsonProperty("partNameManufacturer")
  private String partNameManufacturer = null;

  @JsonProperty("partNumberCustomer")
  private String partNumberCustomer = null;

  @JsonProperty("partNumberManufacturer")
  private String partNumberManufacturer = null;

  public PartStaticDataCharacteristic customerContractOneID(String customerContractOneID) {
    this.customerContractOneID = customerContractOneID;
    return this;
  }

  /**
   * Get customerContractOneID
   * @return customerContractOneID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCustomerContractOneID() {
    return customerContractOneID;
  }

  public void setCustomerContractOneID(String customerContractOneID) {
    this.customerContractOneID = customerContractOneID;
  }

  public PartStaticDataCharacteristic customerOneID(String customerOneID) {
    this.customerOneID = customerOneID;
    return this;
  }

  /**
   * Get customerOneID
   * @return customerOneID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCustomerOneID() {
    return customerOneID;
  }

  public void setCustomerOneID(String customerOneID) {
    this.customerOneID = customerOneID;
  }

  public PartStaticDataCharacteristic manufactureContractOneID(String manufactureContractOneID) {
    this.manufactureContractOneID = manufactureContractOneID;
    return this;
  }

  /**
   * Get manufactureContractOneID
   * @return manufactureContractOneID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufactureContractOneID() {
    return manufactureContractOneID;
  }

  public void setManufactureContractOneID(String manufactureContractOneID) {
    this.manufactureContractOneID = manufactureContractOneID;
  }

  public PartStaticDataCharacteristic manufacturerOneID(String manufacturerOneID) {
    this.manufacturerOneID = manufacturerOneID;
    return this;
  }

  /**
   * Get manufacturerOneID
   * @return manufacturerOneID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufacturerOneID() {
    return manufacturerOneID;
  }

  public void setManufacturerOneID(String manufacturerOneID) {
    this.manufacturerOneID = manufacturerOneID;
  }

  public PartStaticDataCharacteristic partNameCustomer(String partNameCustomer) {
    this.partNameCustomer = partNameCustomer;
    return this;
  }

  /**
   * Get partNameCustomer
   * @return partNameCustomer
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPartNameCustomer() {
    return partNameCustomer;
  }

  public void setPartNameCustomer(String partNameCustomer) {
    this.partNameCustomer = partNameCustomer;
  }

  public PartStaticDataCharacteristic partNameManufacturer(String partNameManufacturer) {
    this.partNameManufacturer = partNameManufacturer;
    return this;
  }

  /**
   * Get partNameManufacturer
   * @return partNameManufacturer
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPartNameManufacturer() {
    return partNameManufacturer;
  }

  public void setPartNameManufacturer(String partNameManufacturer) {
    this.partNameManufacturer = partNameManufacturer;
  }

  public PartStaticDataCharacteristic partNumberCustomer(String partNumberCustomer) {
    this.partNumberCustomer = partNumberCustomer;
    return this;
  }

  /**
   * Get partNumberCustomer
   * @return partNumberCustomer
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPartNumberCustomer() {
    return partNumberCustomer;
  }

  public void setPartNumberCustomer(String partNumberCustomer) {
    this.partNumberCustomer = partNumberCustomer;
  }

  public PartStaticDataCharacteristic partNumberManufacturer(String partNumberManufacturer) {
    this.partNumberManufacturer = partNumberManufacturer;
    return this;
  }

  /**
   * Get partNumberManufacturer
   * @return partNumberManufacturer
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPartNumberManufacturer() {
    return partNumberManufacturer;
  }

  public void setPartNumberManufacturer(String partNumberManufacturer) {
    this.partNumberManufacturer = partNumberManufacturer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartStaticDataCharacteristic urnBammComCatenaX001PartStaticDataCharacteristic = (PartStaticDataCharacteristic) o;
    return Objects.equals(this.customerContractOneID, urnBammComCatenaX001PartStaticDataCharacteristic.customerContractOneID) &&
        Objects.equals(this.customerOneID, urnBammComCatenaX001PartStaticDataCharacteristic.customerOneID) &&
        Objects.equals(this.manufactureContractOneID, urnBammComCatenaX001PartStaticDataCharacteristic.manufactureContractOneID) &&
        Objects.equals(this.manufacturerOneID, urnBammComCatenaX001PartStaticDataCharacteristic.manufacturerOneID) &&
        Objects.equals(this.partNameCustomer, urnBammComCatenaX001PartStaticDataCharacteristic.partNameCustomer) &&
        Objects.equals(this.partNameManufacturer, urnBammComCatenaX001PartStaticDataCharacteristic.partNameManufacturer) &&
        Objects.equals(this.partNumberCustomer, urnBammComCatenaX001PartStaticDataCharacteristic.partNumberCustomer) &&
        Objects.equals(this.partNumberManufacturer, urnBammComCatenaX001PartStaticDataCharacteristic.partNumberManufacturer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerContractOneID, customerOneID, manufactureContractOneID, manufacturerOneID, partNameCustomer, partNameManufacturer, partNumberCustomer, partNumberManufacturer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
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
