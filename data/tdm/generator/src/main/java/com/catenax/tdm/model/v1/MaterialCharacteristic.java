package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.AggregateStatesEnumeration;
import com.catenax.tdm.model.v1.MaterialCollection;
import com.catenax.tdm.model.v1.MaterialNamesEnumeration;
import com.catenax.tdm.model.v1.MaterialTypesEnumeration;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MaterialCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class MaterialCharacteristic   {
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
      @NotNull

    @Valid
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
      @NotNull

    @Valid
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
      @NotNull

    @Valid
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
  
    @Valid
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
      @NotNull

    @Valid
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
  
    @Valid
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
    return Objects.hash(materialName, materialType, aggregateState, chemicalComposition, weight, chemicalCompositionFraction);
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
