/*
 *
 */
package com.catenax.tdm.model.v1;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * ProductUsage.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_product_usage")
public class ProductUsage {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The life span. */
	@JsonProperty("lifeSpan")
	private BigDecimal lifeSpan = null;

	/** The state of health. */
	@JsonProperty("stateOfHealth")
	private BigDecimal stateOfHealth = null;

	/** The state of charge. */
	@JsonProperty("stateOfCharge")
	private BigDecimal stateOfCharge = null;

	/** The mileage. */
	@JsonProperty("mileage")
	private BigDecimal mileage = null;

	/** The number of charging cycles. */
	@JsonProperty("numberOfChargingCycles")
	private BigDecimal numberOfChargingCycles = null;

	/** The voltage. */
	@JsonProperty("voltage")
	private BigDecimal voltage = null;

	/** The residual current hazard. */
	@JsonProperty("residualCurrentHazard")
	private BigDecimal residualCurrentHazard = null;

	/** The life span as planned. */
	@JsonProperty("lifeSpanAsPlanned")
	private BigDecimal lifeSpanAsPlanned = null;

	/** The number of charging cycles as planned. */
	@JsonProperty("numberOfChargingCyclesAsPlanned")
	private BigDecimal numberOfChargingCyclesAsPlanned = null;

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
		final ProductUsage productUsage = (ProductUsage) o;
		return Objects.equals(this.lifeSpan, productUsage.lifeSpan)
				&& Objects.equals(this.stateOfHealth, productUsage.stateOfHealth)
				&& Objects.equals(this.stateOfCharge, productUsage.stateOfCharge)
				&& Objects.equals(this.mileage, productUsage.mileage)
				&& Objects.equals(this.numberOfChargingCycles, productUsage.numberOfChargingCycles)
				&& Objects.equals(this.voltage, productUsage.voltage)
				&& Objects.equals(this.residualCurrentHazard, productUsage.residualCurrentHazard)
				&& Objects.equals(this.lifeSpanAsPlanned, productUsage.lifeSpanAsPlanned)
				&& Objects.equals(this.numberOfChargingCyclesAsPlanned, productUsage.numberOfChargingCyclesAsPlanned);
	}

	/**
	 * Gets the db id.
	 *
	 * @return the db id
	 */
	public Long getDbId() {
		return dbId;
	}

	/**
	 * Get lifeSpan.
	 *
	 * @return lifeSpan
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getLifeSpan() {
		return lifeSpan;
	}

	/**
	 * Get lifeSpanAsPlanned.
	 *
	 * @return lifeSpanAsPlanned
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getLifeSpanAsPlanned() {
		return lifeSpanAsPlanned;
	}

	/**
	 * Get mileage.
	 *
	 * @return mileage
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getMileage() {
		return mileage;
	}

	/**
	 * Get numberOfChargingCycles.
	 *
	 * @return numberOfChargingCycles
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getNumberOfChargingCycles() {
		return numberOfChargingCycles;
	}

	/**
	 * Get numberOfChargingCyclesAsPlanned.
	 *
	 * @return numberOfChargingCyclesAsPlanned
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getNumberOfChargingCyclesAsPlanned() {
		return numberOfChargingCyclesAsPlanned;
	}

	/**
	 * Get residualCurrentHazard.
	 *
	 * @return residualCurrentHazard
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getResidualCurrentHazard() {
		return residualCurrentHazard;
	}

	/**
	 * Get stateOfCharge.
	 *
	 * @return stateOfCharge
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getStateOfCharge() {
		return stateOfCharge;
	}

	/**
	 * Get stateOfHealth.
	 *
	 * @return stateOfHealth
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getStateOfHealth() {
		return stateOfHealth;
	}

	/**
	 * Get voltage.
	 *
	 * @return voltage
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getVoltage() {
		return voltage;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lifeSpan, stateOfHealth, stateOfCharge, mileage, numberOfChargingCycles, voltage,
				residualCurrentHazard, lifeSpanAsPlanned, numberOfChargingCyclesAsPlanned);
	}

	/**
	 * Life span.
	 *
	 * @param lifeSpan the life span
	 * @return the product usage
	 */
	public ProductUsage lifeSpan(BigDecimal lifeSpan) {
		this.lifeSpan = lifeSpan;
		return this;
	}

	/**
	 * Life span as planned.
	 *
	 * @param lifeSpanAsPlanned the life span as planned
	 * @return the product usage
	 */
	public ProductUsage lifeSpanAsPlanned(BigDecimal lifeSpanAsPlanned) {
		this.lifeSpanAsPlanned = lifeSpanAsPlanned;
		return this;
	}

	/**
	 * Mileage.
	 *
	 * @param mileage the mileage
	 * @return the product usage
	 */
	public ProductUsage mileage(BigDecimal mileage) {
		this.mileage = mileage;
		return this;
	}

	/**
	 * Number of charging cycles.
	 *
	 * @param numberOfChargingCycles the number of charging cycles
	 * @return the product usage
	 */
	public ProductUsage numberOfChargingCycles(BigDecimal numberOfChargingCycles) {
		this.numberOfChargingCycles = numberOfChargingCycles;
		return this;
	}

	/**
	 * Number of charging cycles as planned.
	 *
	 * @param numberOfChargingCyclesAsPlanned the number of charging cycles as
	 *                                        planned
	 * @return the product usage
	 */
	public ProductUsage numberOfChargingCyclesAsPlanned(BigDecimal numberOfChargingCyclesAsPlanned) {
		this.numberOfChargingCyclesAsPlanned = numberOfChargingCyclesAsPlanned;
		return this;
	}

	/**
	 * Residual current hazard.
	 *
	 * @param residualCurrentHazard the residual current hazard
	 * @return the product usage
	 */
	public ProductUsage residualCurrentHazard(BigDecimal residualCurrentHazard) {
		this.residualCurrentHazard = residualCurrentHazard;
		return this;
	}

	/**
	 * Sets the db id.
	 *
	 * @param dbId the new db id
	 */
	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}

	/**
	 * Sets the life span.
	 *
	 * @param lifeSpan the new life span
	 */
	public void setLifeSpan(BigDecimal lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	/**
	 * Sets the life span as planned.
	 *
	 * @param lifeSpanAsPlanned the new life span as planned
	 */
	public void setLifeSpanAsPlanned(BigDecimal lifeSpanAsPlanned) {
		this.lifeSpanAsPlanned = lifeSpanAsPlanned;
	}

	/**
	 * Sets the mileage.
	 *
	 * @param mileage the new mileage
	 */
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	/**
	 * Sets the number of charging cycles.
	 *
	 * @param numberOfChargingCycles the new number of charging cycles
	 */
	public void setNumberOfChargingCycles(BigDecimal numberOfChargingCycles) {
		this.numberOfChargingCycles = numberOfChargingCycles;
	}

	/**
	 * Sets the number of charging cycles as planned.
	 *
	 * @param numberOfChargingCyclesAsPlanned the new number of charging cycles as
	 *                                        planned
	 */
	public void setNumberOfChargingCyclesAsPlanned(BigDecimal numberOfChargingCyclesAsPlanned) {
		this.numberOfChargingCyclesAsPlanned = numberOfChargingCyclesAsPlanned;
	}

	/**
	 * Sets the residual current hazard.
	 *
	 * @param residualCurrentHazard the new residual current hazard
	 */
	public void setResidualCurrentHazard(BigDecimal residualCurrentHazard) {
		this.residualCurrentHazard = residualCurrentHazard;
	}

	/**
	 * Sets the state of charge.
	 *
	 * @param stateOfCharge the new state of charge
	 */
	public void setStateOfCharge(BigDecimal stateOfCharge) {
		this.stateOfCharge = stateOfCharge;
	}

	/**
	 * Sets the state of health.
	 *
	 * @param stateOfHealth the new state of health
	 */
	public void setStateOfHealth(BigDecimal stateOfHealth) {
		this.stateOfHealth = stateOfHealth;
	}

	/**
	 * Sets the voltage.
	 *
	 * @param voltage the new voltage
	 */
	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}

	/**
	 * State of charge.
	 *
	 * @param stateOfCharge the state of charge
	 * @return the product usage
	 */
	public ProductUsage stateOfCharge(BigDecimal stateOfCharge) {
		this.stateOfCharge = stateOfCharge;
		return this;
	}

	/**
	 * State of health.
	 *
	 * @param stateOfHealth the state of health
	 * @return the product usage
	 */
	public ProductUsage stateOfHealth(BigDecimal stateOfHealth) {
		this.stateOfHealth = stateOfHealth;
		return this;
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
		sb.append("class ProductUsage {\n");

		sb.append("    lifeSpan: ").append(toIndentedString(lifeSpan)).append("\n");
		sb.append("    stateOfHealth: ").append(toIndentedString(stateOfHealth)).append("\n");
		sb.append("    stateOfCharge: ").append(toIndentedString(stateOfCharge)).append("\n");
		sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
		sb.append("    numberOfChargingCycles: ").append(toIndentedString(numberOfChargingCycles)).append("\n");
		sb.append("    voltage: ").append(toIndentedString(voltage)).append("\n");
		sb.append("    residualCurrentHazard: ").append(toIndentedString(residualCurrentHazard)).append("\n");
		sb.append("    lifeSpanAsPlanned: ").append(toIndentedString(lifeSpanAsPlanned)).append("\n");
		sb.append("    numberOfChargingCyclesAsPlanned: ").append(toIndentedString(numberOfChargingCyclesAsPlanned))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Voltage.
	 *
	 * @param voltage the voltage
	 * @return the product usage
	 */
	public ProductUsage voltage(BigDecimal voltage) {
		this.voltage = voltage;
		return this;
	}
}
