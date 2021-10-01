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
 * PerformanceIndicatorCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_performance_indicator")
public class PerformanceIndicatorCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The electric capacity min. */
	@JsonProperty("electricCapacityMin")
	private BigDecimal electricCapacityMin = null;

	/** The electric capacity max. */
	@JsonProperty("electricCapacityMax")
	private BigDecimal electricCapacityMax = null;

	/**
	 * Electric capacity max.
	 *
	 * @param electricCapacityMax the electric capacity max
	 * @return the performance indicator characteristic
	 */
	public PerformanceIndicatorCharacteristic electricCapacityMax(BigDecimal electricCapacityMax) {
		this.electricCapacityMax = electricCapacityMax;
		return this;
	}

	/**
	 * Electric capacity min.
	 *
	 * @param electricCapacityMin the electric capacity min
	 * @return the performance indicator characteristic
	 */
	public PerformanceIndicatorCharacteristic electricCapacityMin(BigDecimal electricCapacityMin) {
		this.electricCapacityMin = electricCapacityMin;
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
		final PerformanceIndicatorCharacteristic performanceIndicatorCharacteristic = (PerformanceIndicatorCharacteristic) o;
		return Objects.equals(this.electricCapacityMin, performanceIndicatorCharacteristic.electricCapacityMin)
				&& Objects.equals(this.electricCapacityMax, performanceIndicatorCharacteristic.electricCapacityMax);
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
	 * Get electricCapacityMax.
	 *
	 * @return electricCapacityMax
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getElectricCapacityMax() {
		return electricCapacityMax;
	}

	/**
	 * Get electricCapacityMin.
	 *
	 * @return electricCapacityMin
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getElectricCapacityMin() {
		return electricCapacityMin;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(electricCapacityMin, electricCapacityMax);
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
	 * Sets the electric capacity max.
	 *
	 * @param electricCapacityMax the new electric capacity max
	 */
	public void setElectricCapacityMax(BigDecimal electricCapacityMax) {
		this.electricCapacityMax = electricCapacityMax;
	}

	/**
	 * Sets the electric capacity min.
	 *
	 * @param electricCapacityMin the new electric capacity min
	 */
	public void setElectricCapacityMin(BigDecimal electricCapacityMin) {
		this.electricCapacityMin = electricCapacityMin;
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
		sb.append("class PerformanceIndicatorCharacteristic {\n");

		sb.append("    electricCapacityMin: ").append(toIndentedString(electricCapacityMin)).append("\n");
		sb.append("    electricCapacityMax: ").append(toIndentedString(electricCapacityMax)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
