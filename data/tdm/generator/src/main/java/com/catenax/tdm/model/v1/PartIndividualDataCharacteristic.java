package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UrnBammComCatenaX001PartIndividualDataCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class PartIndividualDataCharacteristic   {
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
	
  @JsonProperty("productionCountryCode")
  private String productionCountryCode = null;

  @JsonProperty("productionDateGMT")
  private LocalDate productionDateGMT = null;

  public PartIndividualDataCharacteristic productionCountryCode(String productionCountryCode) {
    this.productionCountryCode = productionCountryCode;
    return this;
  }

  /**
   * Get productionCountryCode
   * @return productionCountryCode
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductionCountryCode() {
    return productionCountryCode;
  }

  public void setProductionCountryCode(String productionCountryCode) {
    this.productionCountryCode = productionCountryCode;
  }

  public PartIndividualDataCharacteristic productionDateGMT(LocalDate productionDateGMT) {
    this.productionDateGMT = productionDateGMT;
    return this;
  }

  /**
   * Get productionDateGMT
   * @return productionDateGMT
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDate getProductionDateGMT() {
    return productionDateGMT;
  }

  public void setProductionDateGMT(LocalDate productionDateGMT) {
    this.productionDateGMT = productionDateGMT;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartIndividualDataCharacteristic urnBammComCatenaX001PartIndividualDataCharacteristic = (PartIndividualDataCharacteristic) o;
    return Objects.equals(this.productionCountryCode, urnBammComCatenaX001PartIndividualDataCharacteristic.productionCountryCode) &&
        Objects.equals(this.productionDateGMT, urnBammComCatenaX001PartIndividualDataCharacteristic.productionDateGMT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productionCountryCode, productionDateGMT);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrnBammComCatenaX001PartIndividualDataCharacteristic {\n");
    
    sb.append("    productionCountryCode: ").append(toIndentedString(productionCountryCode)).append("\n");
    sb.append("    productionDateGMT: ").append(toIndentedString(productionDateGMT)).append("\n");
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
