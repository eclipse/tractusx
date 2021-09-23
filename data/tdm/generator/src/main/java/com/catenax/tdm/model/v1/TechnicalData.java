package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.FurtherInformation;
import com.catenax.tdm.model.v1.GeneralInformation;
import com.catenax.tdm.model.v1.ProductClassifications;
import com.catenax.tdm.model.v1.TechnicalProperties;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TechnicalData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class TechnicalData   {
  @JsonProperty("generalInformation")
  private GeneralInformation generalInformation = null;

  @JsonProperty("productClassifications")
  private ProductClassifications productClassifications = null;

  @JsonProperty("technicalProperties")
  private TechnicalProperties technicalProperties = null;

  @JsonProperty("furtherInformation")
  private FurtherInformation furtherInformation = null;

  public TechnicalData generalInformation(GeneralInformation generalInformation) {
    this.generalInformation = generalInformation;
    return this;
  }

  /**
   * Get generalInformation
   * @return generalInformation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public GeneralInformation getGeneralInformation() {
    return generalInformation;
  }

  public void setGeneralInformation(GeneralInformation generalInformation) {
    this.generalInformation = generalInformation;
  }

  public TechnicalData productClassifications(ProductClassifications productClassifications) {
    this.productClassifications = productClassifications;
    return this;
  }

  /**
   * Get productClassifications
   * @return productClassifications
   **/
  @Schema(description = "")
  
    @Valid
    public ProductClassifications getProductClassifications() {
    return productClassifications;
  }

  public void setProductClassifications(ProductClassifications productClassifications) {
    this.productClassifications = productClassifications;
  }

  public TechnicalData technicalProperties(TechnicalProperties technicalProperties) {
    this.technicalProperties = technicalProperties;
    return this;
  }

  /**
   * Get technicalProperties
   * @return technicalProperties
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TechnicalProperties getTechnicalProperties() {
    return technicalProperties;
  }

  public void setTechnicalProperties(TechnicalProperties technicalProperties) {
    this.technicalProperties = technicalProperties;
  }

  public TechnicalData furtherInformation(FurtherInformation furtherInformation) {
    this.furtherInformation = furtherInformation;
    return this;
  }

  /**
   * Get furtherInformation
   * @return furtherInformation
   **/
  @Schema(description = "")
  
    @Valid
    public FurtherInformation getFurtherInformation() {
    return furtherInformation;
  }

  public void setFurtherInformation(FurtherInformation furtherInformation) {
    this.furtherInformation = furtherInformation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TechnicalData technicalData = (TechnicalData) o;
    return Objects.equals(this.generalInformation, technicalData.generalInformation) &&
        Objects.equals(this.productClassifications, technicalData.productClassifications) &&
        Objects.equals(this.technicalProperties, technicalData.technicalProperties) &&
        Objects.equals(this.furtherInformation, technicalData.furtherInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(generalInformation, productClassifications, technicalProperties, furtherInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechnicalData {\n");
    
    sb.append("    generalInformation: ").append(toIndentedString(generalInformation)).append("\n");
    sb.append("    productClassifications: ").append(toIndentedString(productClassifications)).append("\n");
    sb.append("    technicalProperties: ").append(toIndentedString(technicalProperties)).append("\n");
    sb.append("    furtherInformation: ").append(toIndentedString(furtherInformation)).append("\n");
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
