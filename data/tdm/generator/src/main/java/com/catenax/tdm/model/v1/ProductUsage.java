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
 * ProductUsage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class ProductUsage   {
  @JsonProperty("lifeSpan")
  private BigDecimal lifeSpan = null;

  @JsonProperty("stateOfHealth")
  private BigDecimal stateOfHealth = null;

  @JsonProperty("stateOfCharge")
  private BigDecimal stateOfCharge = null;

  @JsonProperty("mileage")
  private BigDecimal mileage = null;

  @JsonProperty("numberOfChargingCycles")
  private BigDecimal numberOfChargingCycles = null;

  @JsonProperty("voltage")
  private BigDecimal voltage = null;

  @JsonProperty("residualCurrentHazard")
  private BigDecimal residualCurrentHazard = null;

  @JsonProperty("lifeSpanAsPlanned")
  private BigDecimal lifeSpanAsPlanned = null;

  @JsonProperty("numberOfChargingCyclesAsPlanned")
  private BigDecimal numberOfChargingCyclesAsPlanned = null;

  public ProductUsage lifeSpan(BigDecimal lifeSpan) {
    this.lifeSpan = lifeSpan;
    return this;
  }

  /**
   * Get lifeSpan
   * @return lifeSpan
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLifeSpan() {
    return lifeSpan;
  }

  public void setLifeSpan(BigDecimal lifeSpan) {
    this.lifeSpan = lifeSpan;
  }

  public ProductUsage stateOfHealth(BigDecimal stateOfHealth) {
    this.stateOfHealth = stateOfHealth;
    return this;
  }

  /**
   * Get stateOfHealth
   * @return stateOfHealth
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getStateOfHealth() {
    return stateOfHealth;
  }

  public void setStateOfHealth(BigDecimal stateOfHealth) {
    this.stateOfHealth = stateOfHealth;
  }

  public ProductUsage stateOfCharge(BigDecimal stateOfCharge) {
    this.stateOfCharge = stateOfCharge;
    return this;
  }

  /**
   * Get stateOfCharge
   * @return stateOfCharge
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getStateOfCharge() {
    return stateOfCharge;
  }

  public void setStateOfCharge(BigDecimal stateOfCharge) {
    this.stateOfCharge = stateOfCharge;
  }

  public ProductUsage mileage(BigDecimal mileage) {
    this.mileage = mileage;
    return this;
  }

  /**
   * Get mileage
   * @return mileage
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getMileage() {
    return mileage;
  }

  public void setMileage(BigDecimal mileage) {
    this.mileage = mileage;
  }

  public ProductUsage numberOfChargingCycles(BigDecimal numberOfChargingCycles) {
    this.numberOfChargingCycles = numberOfChargingCycles;
    return this;
  }

  /**
   * Get numberOfChargingCycles
   * @return numberOfChargingCycles
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getNumberOfChargingCycles() {
    return numberOfChargingCycles;
  }

  public void setNumberOfChargingCycles(BigDecimal numberOfChargingCycles) {
    this.numberOfChargingCycles = numberOfChargingCycles;
  }

  public ProductUsage voltage(BigDecimal voltage) {
    this.voltage = voltage;
    return this;
  }

  /**
   * Get voltage
   * @return voltage
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getVoltage() {
    return voltage;
  }

  public void setVoltage(BigDecimal voltage) {
    this.voltage = voltage;
  }

  public ProductUsage residualCurrentHazard(BigDecimal residualCurrentHazard) {
    this.residualCurrentHazard = residualCurrentHazard;
    return this;
  }

  /**
   * Get residualCurrentHazard
   * @return residualCurrentHazard
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getResidualCurrentHazard() {
    return residualCurrentHazard;
  }

  public void setResidualCurrentHazard(BigDecimal residualCurrentHazard) {
    this.residualCurrentHazard = residualCurrentHazard;
  }

  public ProductUsage lifeSpanAsPlanned(BigDecimal lifeSpanAsPlanned) {
    this.lifeSpanAsPlanned = lifeSpanAsPlanned;
    return this;
  }

  /**
   * Get lifeSpanAsPlanned
   * @return lifeSpanAsPlanned
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLifeSpanAsPlanned() {
    return lifeSpanAsPlanned;
  }

  public void setLifeSpanAsPlanned(BigDecimal lifeSpanAsPlanned) {
    this.lifeSpanAsPlanned = lifeSpanAsPlanned;
  }

  public ProductUsage numberOfChargingCyclesAsPlanned(BigDecimal numberOfChargingCyclesAsPlanned) {
    this.numberOfChargingCyclesAsPlanned = numberOfChargingCyclesAsPlanned;
    return this;
  }

  /**
   * Get numberOfChargingCyclesAsPlanned
   * @return numberOfChargingCyclesAsPlanned
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getNumberOfChargingCyclesAsPlanned() {
    return numberOfChargingCyclesAsPlanned;
  }

  public void setNumberOfChargingCyclesAsPlanned(BigDecimal numberOfChargingCyclesAsPlanned) {
    this.numberOfChargingCyclesAsPlanned = numberOfChargingCyclesAsPlanned;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductUsage productUsage = (ProductUsage) o;
    return Objects.equals(this.lifeSpan, productUsage.lifeSpan) &&
        Objects.equals(this.stateOfHealth, productUsage.stateOfHealth) &&
        Objects.equals(this.stateOfCharge, productUsage.stateOfCharge) &&
        Objects.equals(this.mileage, productUsage.mileage) &&
        Objects.equals(this.numberOfChargingCycles, productUsage.numberOfChargingCycles) &&
        Objects.equals(this.voltage, productUsage.voltage) &&
        Objects.equals(this.residualCurrentHazard, productUsage.residualCurrentHazard) &&
        Objects.equals(this.lifeSpanAsPlanned, productUsage.lifeSpanAsPlanned) &&
        Objects.equals(this.numberOfChargingCyclesAsPlanned, productUsage.numberOfChargingCyclesAsPlanned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifeSpan, stateOfHealth, stateOfCharge, mileage, numberOfChargingCycles, voltage, residualCurrentHazard, lifeSpanAsPlanned, numberOfChargingCyclesAsPlanned);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductUsage {\n");
    
    sb.append("    lifeSpan: ").append(toIndentedString(lifeSpan)).append("\n");
    sb.append("    stateOfHealth: ").append(toIndentedString(stateOfHealth)).append("\n");
    sb.append("    stateOfCharge: ").append(toIndentedString(stateOfCharge)).append("\n");
    sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
    sb.append("    numberOfChargingCycles: ").append(toIndentedString(numberOfChargingCycles)).append("\n");
    sb.append("    voltage: ").append(toIndentedString(voltage)).append("\n");
    sb.append("    residualCurrentHazard: ").append(toIndentedString(residualCurrentHazard)).append("\n");
    sb.append("    lifeSpanAsPlanned: ").append(toIndentedString(lifeSpanAsPlanned)).append("\n");
    sb.append("    numberOfChargingCyclesAsPlanned: ").append(toIndentedString(numberOfChargingCyclesAsPlanned)).append("\n");
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
