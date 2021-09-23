package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.MaterialCharacteristic;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Material
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class Material   {
  @JsonProperty("materialDetails")
  private MaterialCharacteristic materialDetails = null;

  public Material materialDetails(MaterialCharacteristic materialDetails) {
    this.materialDetails = materialDetails;
    return this;
  }

  /**
   * Get materialDetails
   * @return materialDetails
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public MaterialCharacteristic getMaterialDetails() {
    return materialDetails;
  }

  public void setMaterialDetails(MaterialCharacteristic materialDetails) {
    this.materialDetails = materialDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Material material = (Material) o;
    return Objects.equals(this.materialDetails, material.materialDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(materialDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Material {\n");
    
    sb.append("    materialDetails: ").append(toIndentedString(materialDetails)).append("\n");
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
