/*
 *
 */
package com.catenax.tdm.model.v1;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * EoLStory.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

public class EoLStory {

	/** The disassembly status. */
	@JsonProperty("disassemblyStatus")
	private DisassemblyStatus disassemblyStatus = null;

	/** The vehicle health status. */
	@JsonProperty("vehicleHealthStatus")
	private VehicleHealthStatus vehicleHealthStatus = null;

	/** The recycling status. */
	@JsonProperty("recyclingStatus")
	private RecyclingStatusCharacteristic recyclingStatus = null;

	/** The recycling process. */
	@JsonProperty("recyclingProcess")
	private RecyclingProcessCharacteristic recyclingProcess = null;

	/** The crash history. */
	@JsonProperty("crashHistory")
	private Boolean crashHistory = null;

	/** The build position. */
	@JsonProperty("buildPosition")
	private BuildPositionEnumeration buildPosition = null;

	/** The weight scrap. */
	@JsonProperty("weightScrap")
	private BigDecimal weightScrap = null;

	/**
	 * Builds the position.
	 *
	 * @param buildPosition the build position
	 * @return the eo L story
	 */
	public EoLStory buildPosition(BuildPositionEnumeration buildPosition) {
		this.buildPosition = buildPosition;
		return this;
	}

	/**
	 * Crash history.
	 *
	 * @param crashHistory the crash history
	 * @return the eo L story
	 */
	public EoLStory crashHistory(Boolean crashHistory) {
		this.crashHistory = crashHistory;
		return this;
	}

	/**
	 * Disassembly status.
	 *
	 * @param disassemblyStatus the disassembly status
	 * @return the eo L story
	 */
	public EoLStory disassemblyStatus(DisassemblyStatus disassemblyStatus) {
		this.disassemblyStatus = disassemblyStatus;
		return this;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final EoLStory eoLStory = (EoLStory) o;
		return Objects.equals(this.disassemblyStatus, eoLStory.disassemblyStatus)
				&& Objects.equals(this.vehicleHealthStatus, eoLStory.vehicleHealthStatus)
				&& Objects.equals(this.recyclingStatus, eoLStory.recyclingStatus)
				&& Objects.equals(this.recyclingProcess, eoLStory.recyclingProcess)
				&& Objects.equals(this.crashHistory, eoLStory.crashHistory)
				&& Objects.equals(this.buildPosition, eoLStory.buildPosition)
				&& Objects.equals(this.weightScrap, eoLStory.weightScrap);
	}

	/**
	 * Get buildPosition.
	 *
	 * @return buildPosition
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BuildPositionEnumeration getBuildPosition() {
		return buildPosition;
	}

	/**
	 * Get crashHistory.
	 *
	 * @return crashHistory
	 */
	@Schema(required = true, description = "")
	@NotNull

	public Boolean getCrashHistory() {
		return crashHistory;
	}

	/**
	 * Get disassemblyStatus.
	 *
	 * @return disassemblyStatus
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public DisassemblyStatus getDisassemblyStatus() {
		return disassemblyStatus;
	}

	/**
	 * Get recyclingProcess.
	 *
	 * @return recyclingProcess
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public RecyclingProcessCharacteristic getRecyclingProcess() {
		return recyclingProcess;
	}

	/**
	 * Get recyclingStatus.
	 *
	 * @return recyclingStatus
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public RecyclingStatusCharacteristic getRecyclingStatus() {
		return recyclingStatus;
	}

	/**
	 * Get vehicleHealthStatus.
	 *
	 * @return vehicleHealthStatus
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public VehicleHealthStatus getVehicleHealthStatus() {
		return vehicleHealthStatus;
	}

	/**
	 * Get weightScrap.
	 *
	 * @return weightScrap
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getWeightScrap() {
		return weightScrap;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(disassemblyStatus, vehicleHealthStatus, recyclingStatus, recyclingProcess, crashHistory,
				buildPosition, weightScrap);
	}

	/**
	 * Recycling process.
	 *
	 * @param recyclingProcess the recycling process
	 * @return the eo L story
	 */
	public EoLStory recyclingProcess(RecyclingProcessCharacteristic recyclingProcess) {
		this.recyclingProcess = recyclingProcess;
		return this;
	}

	/**
	 * Recycling status.
	 *
	 * @param recyclingStatus the recycling status
	 * @return the eo L story
	 */
	public EoLStory recyclingStatus(RecyclingStatusCharacteristic recyclingStatus) {
		this.recyclingStatus = recyclingStatus;
		return this;
	}

	/**
	 * Sets the builds the position.
	 *
	 * @param buildPosition the new builds the position
	 */
	public void setBuildPosition(BuildPositionEnumeration buildPosition) {
		this.buildPosition = buildPosition;
	}

	/**
	 * Sets the crash history.
	 *
	 * @param crashHistory the new crash history
	 */
	public void setCrashHistory(Boolean crashHistory) {
		this.crashHistory = crashHistory;
	}

	/**
	 * Sets the disassembly status.
	 *
	 * @param disassemblyStatus the new disassembly status
	 */
	public void setDisassemblyStatus(DisassemblyStatus disassemblyStatus) {
		this.disassemblyStatus = disassemblyStatus;
	}

	/**
	 * Sets the recycling process.
	 *
	 * @param recyclingProcess the new recycling process
	 */
	public void setRecyclingProcess(RecyclingProcessCharacteristic recyclingProcess) {
		this.recyclingProcess = recyclingProcess;
	}

	/**
	 * Sets the recycling status.
	 *
	 * @param recyclingStatus the new recycling status
	 */
	public void setRecyclingStatus(RecyclingStatusCharacteristic recyclingStatus) {
		this.recyclingStatus = recyclingStatus;
	}

	/**
	 * Sets the vehicle health status.
	 *
	 * @param vehicleHealthStatus the new vehicle health status
	 */
	public void setVehicleHealthStatus(VehicleHealthStatus vehicleHealthStatus) {
		this.vehicleHealthStatus = vehicleHealthStatus;
	}

	/**
	 * Sets the weight scrap.
	 *
	 * @param weightScrap the new weight scrap
	 */
	public void setWeightScrap(BigDecimal weightScrap) {
		this.weightScrap = weightScrap;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 *
	 * @param o the o
	 * @return the string
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
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
	 * Vehicle health status.
	 *
	 * @param vehicleHealthStatus the vehicle health status
	 * @return the eo L story
	 */
	public EoLStory vehicleHealthStatus(VehicleHealthStatus vehicleHealthStatus) {
		this.vehicleHealthStatus = vehicleHealthStatus;
		return this;
	}

	/**
	 * Weight scrap.
	 *
	 * @param weightScrap the weight scrap
	 * @return the eo L story
	 */
	public EoLStory weightScrap(BigDecimal weightScrap) {
		this.weightScrap = weightScrap;
		return this;
	}
}
