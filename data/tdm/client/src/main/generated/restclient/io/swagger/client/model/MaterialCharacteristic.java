/*
 * Catena-X Speedboat Test Data Generator
 * Disclaimer: This service serves synthetic, none-productive data for testing purposes only. All BOMs, part trees, VINs, serialNos etc. are synthetic
 *
 * OpenAPI spec version: 0.0.1 Speedboat
 * Contact: christian.kabelin@partner.bmw.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.client.model.AggregateStatesEnumeration;
import io.swagger.client.model.MaterialCollection;
import io.swagger.client.model.MaterialNamesEnumeration;
import io.swagger.client.model.MaterialTypesEnumeration;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * MaterialCharacteristic
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2021-10-03T20:34:34.146648200+02:00[Europe/Berlin]")
public class MaterialCharacteristic {

  
  @JsonProperty("materialName")
  private MaterialNamesEnumeration materialName = null;
  
  
  @JsonProperty("materialType")
  private MaterialTypesEnumeration materialType = null;
  
  
  @JsonProperty("aggregateState")
  private AggregateStatesEnumeration aggregateState = null;
  
  
  @JsonProperty("chemicalComposition")
  private MaterialCollection chemicalComposition = null;
  
  
  @JsonProperty("weight")
  private BigDecimal weight = null;
  
  
  @JsonProperty("chemicalCompositionFraction")
  private BigDecimal chemicalCompositionFraction = null;
  
  public MaterialCharacteristic materialName(MaterialNamesEnumeration materialName) {
    this.materialName = materialName;
    return this;
  }

  
  /**
  * Get materialName
  * @return materialName
  **/
  
  
  @Schema(required = true, description = "")
  public MaterialNamesEnumeration getMaterialName() {
    return materialName;
  }
  public void setMaterialName(MaterialNamesEnumeration materialName) {
    this.materialName = materialName;
  }
  
  public MaterialCharacteristic materialType(MaterialTypesEnumeration materialType) {
    this.materialType = materialType;
    return this;
  }

  
  /**
  * Get materialType
  * @return materialType
  **/
  
  
  @Schema(required = true, description = "")
  public MaterialTypesEnumeration getMaterialType() {
    return materialType;
  }
  public void setMaterialType(MaterialTypesEnumeration materialType) {
    this.materialType = materialType;
  }
  
  public MaterialCharacteristic aggregateState(AggregateStatesEnumeration aggregateState) {
    this.aggregateState = aggregateState;
    return this;
  }

  
  /**
  * Get aggregateState
  * @return aggregateState
  **/
  
  
  @Schema(required = true, description = "")
  public AggregateStatesEnumeration getAggregateState() {
    return aggregateState;
  }
  public void setAggregateState(AggregateStatesEnumeration aggregateState) {
    this.aggregateState = aggregateState;
  }
  
  public MaterialCharacteristic chemicalComposition(MaterialCollection chemicalComposition) {
    this.chemicalComposition = chemicalComposition;
    return this;
  }

  
  /**
  * Get chemicalComposition
  * @return chemicalComposition
  **/
  
  
  @Schema(description = "")
  public MaterialCollection getChemicalComposition() {
    return chemicalComposition;
  }
  public void setChemicalComposition(MaterialCollection chemicalComposition) {
    this.chemicalComposition = chemicalComposition;
  }
  
  public MaterialCharacteristic weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  
  /**
  * Get weight
  * @return weight
  **/
  
  
  @Schema(required = true, description = "")
  public BigDecimal getWeight() {
    return weight;
  }
  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }
  
  public MaterialCharacteristic chemicalCompositionFraction(BigDecimal chemicalCompositionFraction) {
    this.chemicalCompositionFraction = chemicalCompositionFraction;
    return this;
  }

  
  /**
  * Get chemicalCompositionFraction
  * @return chemicalCompositionFraction
  **/
  
  
  @Schema(description = "")
  public BigDecimal getChemicalCompositionFraction() {
    return chemicalCompositionFraction;
  }
  public void setChemicalCompositionFraction(BigDecimal chemicalCompositionFraction) {
    this.chemicalCompositionFraction = chemicalCompositionFraction;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaterialCharacteristic materialCharacteristic = (MaterialCharacteristic) o;
    return Objects.equals(this.materialName, materialCharacteristic.materialName) &&
        Objects.equals(this.materialType, materialCharacteristic.materialType) &&
        Objects.equals(this.aggregateState, materialCharacteristic.aggregateState) &&
        Objects.equals(this.chemicalComposition, materialCharacteristic.chemicalComposition) &&
        Objects.equals(this.weight, materialCharacteristic.weight) &&
        Objects.equals(this.chemicalCompositionFraction, materialCharacteristic.chemicalCompositionFraction);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(materialName, materialType, aggregateState, chemicalComposition, weight, chemicalCompositionFraction);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaterialCharacteristic {\n");
    
    sb.append("    materialName: ").append(toIndentedString(materialName)).append("\n");
    sb.append("    materialType: ").append(toIndentedString(materialType)).append("\n");
    sb.append("    aggregateState: ").append(toIndentedString(aggregateState)).append("\n");
    sb.append("    chemicalComposition: ").append(toIndentedString(chemicalComposition)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    chemicalCompositionFraction: ").append(toIndentedString(chemicalCompositionFraction)).append("\n");
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


