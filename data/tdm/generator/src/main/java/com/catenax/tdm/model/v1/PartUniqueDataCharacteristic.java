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
 * UrnBammComCatenaX001PartUniqueDataCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class PartUniqueDataCharacteristic   {
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
	
  @JsonProperty("customerUniqueID")
  private String customerUniqueID = null;

  @JsonProperty("manufacturerUniqueID")
  private String manufacturerUniqueID = null;

  @JsonProperty("uniqueID")
  private String uniqueID = null;

  public PartUniqueDataCharacteristic customerUniqueID(String customerUniqueID) {
    this.customerUniqueID = customerUniqueID;
    return this;
  }

  /**
   * Get customerUniqueID
   * @return customerUniqueID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCustomerUniqueID() {
    return customerUniqueID;
  }

  public void setCustomerUniqueID(String customerUniqueID) {
    this.customerUniqueID = customerUniqueID;
  }

  public PartUniqueDataCharacteristic manufacturerUniqueID(String manufacturerUniqueID) {
    this.manufacturerUniqueID = manufacturerUniqueID;
    return this;
  }

  /**
   * Get manufacturerUniqueID
   * @return manufacturerUniqueID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufacturerUniqueID() {
    return manufacturerUniqueID;
  }

  public void setManufacturerUniqueID(String manufacturerUniqueID) {
    this.manufacturerUniqueID = manufacturerUniqueID;
  }

  public PartUniqueDataCharacteristic uniqueID(String uniqueID) {
    this.uniqueID = uniqueID;
    return this;
  }

  /**
   * Get uniqueID
   * @return uniqueID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUniqueID() {
    return uniqueID;
  }

  public void setUniqueID(String uniqueID) {
    this.uniqueID = uniqueID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartUniqueDataCharacteristic urnBammComCatenaX001PartUniqueDataCharacteristic = (PartUniqueDataCharacteristic) o;
    return Objects.equals(this.customerUniqueID, urnBammComCatenaX001PartUniqueDataCharacteristic.customerUniqueID) &&
        Objects.equals(this.manufacturerUniqueID, urnBammComCatenaX001PartUniqueDataCharacteristic.manufacturerUniqueID) &&
        Objects.equals(this.uniqueID, urnBammComCatenaX001PartUniqueDataCharacteristic.uniqueID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerUniqueID, manufacturerUniqueID, uniqueID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrnBammComCatenaX001PartUniqueDataCharacteristic {\n");
    
    sb.append("    customerUniqueID: ").append(toIndentedString(customerUniqueID)).append("\n");
    sb.append("    manufacturerUniqueID: ").append(toIndentedString(manufacturerUniqueID)).append("\n");
    sb.append("    uniqueID: ").append(toIndentedString(uniqueID)).append("\n");
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
