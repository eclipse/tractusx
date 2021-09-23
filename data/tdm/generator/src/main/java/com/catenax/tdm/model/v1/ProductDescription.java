package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.PerformanceIndicatorCharacteristic;
import com.catenax.tdm.model.v1.ProductDimension3D;
import com.catenax.tdm.model.v1.SetOfDocumentTypes;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductDescription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class ProductDescription   {
  @JsonProperty("productID")
  private String productID = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("productDescription")
  private String productDescription = null;

  @JsonProperty("productionDateGMT")
  private String productionDateGMT = null;

  @JsonProperty("buildPosition")
  private String buildPosition = null;

  @JsonProperty("liquidBearing")
  private Boolean liquidBearing = null;

  @JsonProperty("productWeight")
  private BigDecimal productWeight = null;

  @JsonProperty("performanceIndicator")
  private PerformanceIndicatorCharacteristic performanceIndicator = null;

  @JsonProperty("productDimension")
  private ProductDimension3D productDimension = null;

  @JsonProperty("productType")
  private SetOfDocumentTypes productType = null;

  public ProductDescription productID(String productID) {
    this.productID = productID;
    return this;
  }

  /**
   * Get productID
   * @return productID
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public ProductDescription productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public ProductDescription productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

  /**
   * Get productDescription
   * @return productDescription
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public ProductDescription productionDateGMT(String productionDateGMT) {
    this.productionDateGMT = productionDateGMT;
    return this;
  }

  /**
   * Get productionDateGMT
   * @return productionDateGMT
   **/
  @Schema(required = true, description = "")
      @NotNull

  public String getProductionDateGMT() {
    return productionDateGMT;
  }

  public void setProductionDateGMT(String productionDateGMT) {
    this.productionDateGMT = productionDateGMT;
  }

  public ProductDescription buildPosition(String buildPosition) {
    this.buildPosition = buildPosition;
    return this;
  }

  /**
   * Get buildPosition
   * @return buildPosition
   **/
  @Schema(description = "")
  
    public String getBuildPosition() {
    return buildPosition;
  }

  public void setBuildPosition(String buildPosition) {
    this.buildPosition = buildPosition;
  }

  public ProductDescription liquidBearing(Boolean liquidBearing) {
    this.liquidBearing = liquidBearing;
    return this;
  }

  /**
   * Get liquidBearing
   * @return liquidBearing
   **/
  @Schema(description = "")
  
    public Boolean getLiquidBearing() {
    return liquidBearing;
  }

  public void setLiquidBearing(Boolean liquidBearing) {
    this.liquidBearing = liquidBearing;
  }

  public ProductDescription productWeight(BigDecimal productWeight) {
    this.productWeight = productWeight;
    return this;
  }

  /**
   * Get productWeight
   * @return productWeight
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getProductWeight() {
    return productWeight;
  }

  public void setProductWeight(BigDecimal productWeight) {
    this.productWeight = productWeight;
  }

  public ProductDescription performanceIndicator(PerformanceIndicatorCharacteristic performanceIndicator) {
    this.performanceIndicator = performanceIndicator;
    return this;
  }

  /**
   * Get performanceIndicator
   * @return performanceIndicator
   **/
  @Schema(description = "")
  
    @Valid
    public PerformanceIndicatorCharacteristic getPerformanceIndicator() {
    return performanceIndicator;
  }

  public void setPerformanceIndicator(PerformanceIndicatorCharacteristic performanceIndicator) {
    this.performanceIndicator = performanceIndicator;
  }

  public ProductDescription productDimension(ProductDimension3D productDimension) {
    this.productDimension = productDimension;
    return this;
  }

  /**
   * Get productDimension
   * @return productDimension
   **/
  @Schema(description = "")
  
    @Valid
    public ProductDimension3D getProductDimension() {
    return productDimension;
  }

  public void setProductDimension(ProductDimension3D productDimension) {
    this.productDimension = productDimension;
  }

  public ProductDescription productType(SetOfDocumentTypes productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
   **/
  @Schema(description = "")
  
    @Valid
    public SetOfDocumentTypes getProductType() {
    return productType;
  }

  public void setProductType(SetOfDocumentTypes productType) {
    this.productType = productType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDescription productDescription = (ProductDescription) o;
    return Objects.equals(this.productID, productDescription.productID) &&
        Objects.equals(this.productName, productDescription.productName) &&
        Objects.equals(this.productDescription, productDescription.productDescription) &&
        Objects.equals(this.productionDateGMT, productDescription.productionDateGMT) &&
        Objects.equals(this.buildPosition, productDescription.buildPosition) &&
        Objects.equals(this.liquidBearing, productDescription.liquidBearing) &&
        Objects.equals(this.productWeight, productDescription.productWeight) &&
        Objects.equals(this.performanceIndicator, productDescription.performanceIndicator) &&
        Objects.equals(this.productDimension, productDescription.productDimension) &&
        Objects.equals(this.productType, productDescription.productType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productID, productName, productDescription, productionDateGMT, buildPosition, liquidBearing, productWeight, performanceIndicator, productDimension, productType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDescription {\n");
    
    sb.append("    productID: ").append(toIndentedString(productID)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    productionDateGMT: ").append(toIndentedString(productionDateGMT)).append("\n");
    sb.append("    buildPosition: ").append(toIndentedString(buildPosition)).append("\n");
    sb.append("    liquidBearing: ").append(toIndentedString(liquidBearing)).append("\n");
    sb.append("    productWeight: ").append(toIndentedString(productWeight)).append("\n");
    sb.append("    performanceIndicator: ").append(toIndentedString(performanceIndicator)).append("\n");
    sb.append("    productDimension: ").append(toIndentedString(productDimension)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
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
