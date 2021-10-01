/*
 *
 */
package com.catenax.tdm.model.v1;

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
 * UrnBammComCatenaX001QualityAlertDataCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability_quality_alert")
public class QualityAlertDataCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The quality alert. */
	@JsonProperty("qualityAlert")
	private Boolean qualityAlert = null;

	/** The quality type. */
	@JsonProperty("qualityType")
	private QualityTypeEnum qualityType = null;

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
		final QualityAlertDataCharacteristic urnBammComCatenaX001QualityAlertDataCharacteristic = (QualityAlertDataCharacteristic) o;
		return Objects.equals(this.qualityAlert, urnBammComCatenaX001QualityAlertDataCharacteristic.qualityAlert)
				&& Objects.equals(this.qualityType, urnBammComCatenaX001QualityAlertDataCharacteristic.qualityType);
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
	 * Get qualityAlert.
	 *
	 * @return qualityAlert
	 */
	@Schema(required = true, description = "")
	@NotNull

	public Boolean getQualityAlert() {
		return qualityAlert;
	}

	/**
	 * Get qualityType.
	 *
	 * @return qualityType
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public QualityTypeEnum getQualityType() {
		return qualityType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(qualityAlert, qualityType);
	}

	/**
	 * Quality alert.
	 *
	 * @param qualityAlert the quality alert
	 * @return the quality alert data characteristic
	 */
	public QualityAlertDataCharacteristic qualityAlert(Boolean qualityAlert) {
		this.qualityAlert = qualityAlert;
		return this;
	}

	/**
	 * Quality type.
	 *
	 * @param qualityType the quality type
	 * @return the quality alert data characteristic
	 */
	public QualityAlertDataCharacteristic qualityType(QualityTypeEnum qualityType) {
		this.qualityType = qualityType;
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
	 * Sets the quality alert.
	 *
	 * @param qualityAlert the new quality alert
	 */
	public void setQualityAlert(Boolean qualityAlert) {
		this.qualityAlert = qualityAlert;
	}

	/**
	 * Sets the quality type.
	 *
	 * @param qualityType the new quality type
	 */
	public void setQualityType(QualityTypeEnum qualityType) {
		this.qualityType = qualityType;
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
		sb.append("class UrnBammComCatenaX001QualityAlertDataCharacteristic {\n");

		sb.append("    qualityAlert: ").append(toIndentedString(qualityAlert)).append("\n");
		sb.append("    qualityType: ").append(toIndentedString(qualityType)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
