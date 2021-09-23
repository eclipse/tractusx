package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.BuildPositionEnumeration;
import com.catenax.tdm.model.v1.DisassemblyStatus;
import com.catenax.tdm.model.v1.RecyclingProcessCharacteristic;
import com.catenax.tdm.model.v1.RecyclingStatusCharacteristic;
import com.catenax.tdm.model.v1.VehicleHealthStatus;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EoLStory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class EoLStory   {
  @JsonProperty("disassemblyStatus")
  private DisassemblyStatus disassemblyStatus = null;

  @JsonProperty("vehicleHealthStatus")
  private VehicleHealthStatus vehicleHealthStatus = null;

  @JsonProperty("recyclingStatus")
  private RecyclingStatusCharacteristic recyclingStatus = null;

  @JsonProperty("recyclingProcess")
  private RecyclingProcessCharacteristic recyclingProcess = null;

  @JsonProperty("crashHistory")
  private Boolean crashHistory = null;

  @JsonProperty("buildPosition")
  private BuildPositionEnumeration buildPosition = null;

  @JsonProperty("weightScrap")
  private BigDecimal weightScrap = null;

  public EoLStory disassemblyStatus(DisassemblyStatus disassemblyStatus) {
    this.disassemblyStatus = disassemblyStatus;
    return this;
  }

  /**
   * Get disassemblyStatus
   * @return disassemblyStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DisassemblyStatus getDisassemblyStatus() {
    return disassemblyStatus;
  }

  public void setDisassemblyStatus(DisassemblyStatus disassemblyStatus) {
    this.disassemblyStatus = disassemblyStatus;
  }

  public EoLStory vehicleHealthStatus(VehicleHealthStatus vehicleHealthStatus) {
    this.vehicleHealthStatus = vehicleHealthStatus;
    return this;
  }

  /**
   * Get vehicleHealthStatus
   * @return vehicleHealthStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public VehicleHealthStatus getVehicleHealthStatus() {
    return vehicleHealthStatus;
  }

  public void setVehicleHealthStatus(VehicleHealthStatus vehicleHealthStatus) {
    this.vehicleHealthStatus = vehicleHealthStatus;
  }

  public EoLStory recyclingStatus(RecyclingStatusCharacteristic recyclingStatus) {
    this.recyclingStatus = recyclingStatus;
    return this;
  }

  /**
   * Get recyclingStatus
   * @return recyclingStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public RecyclingStatusCharacteristic getRecyclingStatus() {
    return recyclingStatus;
  }

  public void setRecyclingStatus(RecyclingStatusCharacteristic recyclingStatus) {
    this.recyclingStatus = recyclingStatus;
  }

  public EoLStory recyclingProcess(RecyclingProcessCharacteristic recyclingProcess) {
    this.recyclingProcess = recyclingProcess;
    return this;
  }

  /**
   * Get recyclingProcess
   * @return recyclingProcess
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public RecyclingProcessCharacteristic getRecyclingProcess() {
    return recyclingProcess;
  }

  public void setRecyclingProcess(RecyclingProcessCharacteristic recyclingProcess) {
    this.recyclingProcess = recyclingProcess;
  }

  public EoLStory crashHistory(Boolean crashHistory) {
    this.crashHistory = crashHistory;
    return this;
  }

  /**
   * Get crashHistory
   * @return crashHistory
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean getCrashHistory() {
    return crashHistory;
  }

  public void setCrashHistory(Boolean crashHistory) {
    this.crashHistory = crashHistory;
  }

  public EoLStory buildPosition(BuildPositionEnumeration buildPosition) {
    this.buildPosition = buildPosition;
    return this;
  }

  /**
   * Get buildPosition
   * @return buildPosition
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BuildPositionEnumeration getBuildPosition() {
    return buildPosition;
  }

  public void setBuildPosition(BuildPositionEnumeration buildPosition) {
    this.buildPosition = buildPosition;
  }

  public EoLStory weightScrap(BigDecimal weightScrap) {
    this.weightScrap = weightScrap;
    return this;
  }

  /**
   * Get weightScrap
   * @return weightScrap
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getWeightScrap() {
    return weightScrap;
  }

  public void setWeightScrap(BigDecimal weightScrap) {
    this.weightScrap = weightScrap;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EoLStory eoLStory = (EoLStory) o;
    return Objects.equals(this.disassemblyStatus, eoLStory.disassemblyStatus) &&
        Objects.equals(this.vehicleHealthStatus, eoLStory.vehicleHealthStatus) &&
        Objects.equals(this.recyclingStatus, eoLStory.recyclingStatus) &&
        Objects.equals(this.recyclingProcess, eoLStory.recyclingProcess) &&
        Objects.equals(this.crashHistory, eoLStory.crashHistory) &&
        Objects.equals(this.buildPosition, eoLStory.buildPosition) &&
        Objects.equals(this.weightScrap, eoLStory.weightScrap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disassemblyStatus, vehicleHealthStatus, recyclingStatus, recyclingProcess, crashHistory, buildPosition, weightScrap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EoLStory {\n");
    
    sb.append("    disassemblyStatus: ").append(toIndentedString(disassemblyStatus)).append("\n");
    sb.append("    vehicleHealthStatus: ").append(toIndentedString(vehicleHealthStatus)).append("\n");
    sb.append("    recyclingStatus: ").append(toIndentedString(recyclingStatus)).append("\n");
    sb.append("    recyclingProcess: ").append(toIndentedString(recyclingProcess)).append("\n");
    sb.append("    crashHistory: ").append(toIndentedString(crashHistory)).append("\n");
    sb.append("    buildPosition: ").append(toIndentedString(buildPosition)).append("\n");
    sb.append("    weightScrap: ").append(toIndentedString(weightScrap)).append("\n");
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
