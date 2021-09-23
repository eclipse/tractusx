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
 * PerformanceIndicatorCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class PerformanceIndicatorCharacteristic   {
  @JsonProperty("electricCapacityMin")
  private BigDecimal electricCapacityMin = null;

  @JsonProperty("electricCapacityMax")
  private BigDecimal electricCapacityMax = null;

  public PerformanceIndicatorCharacteristic electricCapacityMin(BigDecimal electricCapacityMin) {
    this.electricCapacityMin = electricCapacityMin;
    return this;
  }

  /**
   * Get electricCapacityMin
   * @return electricCapacityMin
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getElectricCapacityMin() {
    return electricCapacityMin;
  }

  public void setElectricCapacityMin(BigDecimal electricCapacityMin) {
    this.electricCapacityMin = electricCapacityMin;
  }

  public PerformanceIndicatorCharacteristic electricCapacityMax(BigDecimal electricCapacityMax) {
    this.electricCapacityMax = electricCapacityMax;
    return this;
  }

  /**
   * Get electricCapacityMax
   * @return electricCapacityMax
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getElectricCapacityMax() {
    return electricCapacityMax;
  }

  public void setElectricCapacityMax(BigDecimal electricCapacityMax) {
    this.electricCapacityMax = electricCapacityMax;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerformanceIndicatorCharacteristic performanceIndicatorCharacteristic = (PerformanceIndicatorCharacteristic) o;
    return Objects.equals(this.electricCapacityMin, performanceIndicatorCharacteristic.electricCapacityMin) &&
        Objects.equals(this.electricCapacityMax, performanceIndicatorCharacteristic.electricCapacityMax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(electricCapacityMin, electricCapacityMax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerformanceIndicatorCharacteristic {\n");
    
    sb.append("    electricCapacityMin: ").append(toIndentedString(electricCapacityMin)).append("\n");
    sb.append("    electricCapacityMax: ").append(toIndentedString(electricCapacityMax)).append("\n");
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
