package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.Logo;
import com.catenax.tdm.model.v1.MultiLanguageProperty;
import com.catenax.tdm.model.v1.ProductImages;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeneralInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class GeneralInformation   {
  @JsonProperty("manufacturerName")
  private String manufacturerName = null;

  @JsonProperty("manufacturerLogo")
  private Logo manufacturerLogo = null;

  @JsonProperty("manufacturerProductDesignation")
  private MultiLanguageProperty manufacturerProductDesignation = null;

  @JsonProperty("manufacturerPartNumber")
  private String manufacturerPartNumber = null;

  @JsonProperty("manufacturerOrderCode")
  private String manufacturerOrderCode = null;

  @JsonProperty("productImages")
  private ProductImages productImages = null;

  public GeneralInformation manufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
    return this;
  }

  /**
   * Get manufacturerName
   * @return manufacturerName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufacturerName() {
    return manufacturerName;
  }

  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  public GeneralInformation manufacturerLogo(Logo manufacturerLogo) {
    this.manufacturerLogo = manufacturerLogo;
    return this;
  }

  /**
   * Get manufacturerLogo
   * @return manufacturerLogo
   **/
  @Schema(description = "")
  
    @Valid
    public Logo getManufacturerLogo() {
    return manufacturerLogo;
  }

  public void setManufacturerLogo(Logo manufacturerLogo) {
    this.manufacturerLogo = manufacturerLogo;
  }

  public GeneralInformation manufacturerProductDesignation(MultiLanguageProperty manufacturerProductDesignation) {
    this.manufacturerProductDesignation = manufacturerProductDesignation;
    return this;
  }

  /**
   * Get manufacturerProductDesignation
   * @return manufacturerProductDesignation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public MultiLanguageProperty getManufacturerProductDesignation() {
    return manufacturerProductDesignation;
  }

  public void setManufacturerProductDesignation(MultiLanguageProperty manufacturerProductDesignation) {
    this.manufacturerProductDesignation = manufacturerProductDesignation;
  }

  public GeneralInformation manufacturerPartNumber(String manufacturerPartNumber) {
    this.manufacturerPartNumber = manufacturerPartNumber;
    return this;
  }

  /**
   * Get manufacturerPartNumber
   * @return manufacturerPartNumber
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufacturerPartNumber() {
    return manufacturerPartNumber;
  }

  public void setManufacturerPartNumber(String manufacturerPartNumber) {
    this.manufacturerPartNumber = manufacturerPartNumber;
  }

  public GeneralInformation manufacturerOrderCode(String manufacturerOrderCode) {
    this.manufacturerOrderCode = manufacturerOrderCode;
    return this;
  }

  /**
   * Get manufacturerOrderCode
   * @return manufacturerOrderCode
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getManufacturerOrderCode() {
    return manufacturerOrderCode;
  }

  public void setManufacturerOrderCode(String manufacturerOrderCode) {
    this.manufacturerOrderCode = manufacturerOrderCode;
  }

  public GeneralInformation productImages(ProductImages productImages) {
    this.productImages = productImages;
    return this;
  }

  /**
   * Get productImages
   * @return productImages
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public ProductImages getProductImages() {
    return productImages;
  }

  public void setProductImages(ProductImages productImages) {
    this.productImages = productImages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneralInformation generalInformation = (GeneralInformation) o;
    return Objects.equals(this.manufacturerName, generalInformation.manufacturerName) &&
        Objects.equals(this.manufacturerLogo, generalInformation.manufacturerLogo) &&
        Objects.equals(this.manufacturerProductDesignation, generalInformation.manufacturerProductDesignation) &&
        Objects.equals(this.manufacturerPartNumber, generalInformation.manufacturerPartNumber) &&
        Objects.equals(this.manufacturerOrderCode, generalInformation.manufacturerOrderCode) &&
        Objects.equals(this.productImages, generalInformation.productImages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manufacturerName, manufacturerLogo, manufacturerProductDesignation, manufacturerPartNumber, manufacturerOrderCode, productImages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralInformation {\n");
    
    sb.append("    manufacturerName: ").append(toIndentedString(manufacturerName)).append("\n");
    sb.append("    manufacturerLogo: ").append(toIndentedString(manufacturerLogo)).append("\n");
    sb.append("    manufacturerProductDesignation: ").append(toIndentedString(manufacturerProductDesignation)).append("\n");
    sb.append("    manufacturerPartNumber: ").append(toIndentedString(manufacturerPartNumber)).append("\n");
    sb.append("    manufacturerOrderCode: ").append(toIndentedString(manufacturerOrderCode)).append("\n");
    sb.append("    productImages: ").append(toIndentedString(productImages)).append("\n");
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
