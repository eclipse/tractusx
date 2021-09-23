package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductDimension3D
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class ProductDimension3D   {
  @JsonProperty("dimensionX")
  private BigDecimal dimensionX = null;

  @JsonProperty("dimensionY")
  private BigDecimal dimensionY = null;

  @JsonProperty("dimensionZ")
  private BigDecimal dimensionZ = null;

  public ProductDimension3D dimensionX(BigDecimal dimensionX) {
    this.dimensionX = dimensionX;
    return this;
  }

  /**
   * Get dimensionX
   * @return dimensionX
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDimensionX() {
    return dimensionX;
  }

  public void setDimensionX(BigDecimal dimensionX) {
    this.dimensionX = dimensionX;
  }

  public ProductDimension3D dimensionY(BigDecimal dimensionY) {
    this.dimensionY = dimensionY;
    return this;
  }

  /**
   * Get dimensionY
   * @return dimensionY
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDimensionY() {
    return dimensionY;
  }

  public void setDimensionY(BigDecimal dimensionY) {
    this.dimensionY = dimensionY;
  }

  public ProductDimension3D dimensionZ(BigDecimal dimensionZ) {
    this.dimensionZ = dimensionZ;
    return this;
  }

  /**
   * Get dimensionZ
   * @return dimensionZ
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDimensionZ() {
    return dimensionZ;
  }

  public void setDimensionZ(BigDecimal dimensionZ) {
    this.dimensionZ = dimensionZ;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDimension3D productDimension3D = (ProductDimension3D) o;
    return Objects.equals(this.dimensionX, productDimension3D.dimensionX) &&
        Objects.equals(this.dimensionY, productDimension3D.dimensionY) &&
        Objects.equals(this.dimensionZ, productDimension3D.dimensionZ);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dimensionX, dimensionY, dimensionZ);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDimension3D {\n");
    
    sb.append("    dimensionX: ").append(toIndentedString(dimensionX)).append("\n");
    sb.append("    dimensionY: ").append(toIndentedString(dimensionY)).append("\n");
    sb.append("    dimensionZ: ").append(toIndentedString(dimensionZ)).append("\n");
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
