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
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * UrnBammComCatenaX001PartIndividualDataCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability_individual")
public class PartIndividualDataCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The production country code. */
	@JsonProperty("productionCountryCode")
	private String productionCountryCode = null;

	/** The production date GMT. */
	@JsonProperty("productionDateGMT")
	private OffsetDateTime productionDateGMT = null;

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
		final PartIndividualDataCharacteristic urnBammComCatenaX001PartIndividualDataCharacteristic = (PartIndividualDataCharacteristic) o;
		return Objects.equals(this.productionCountryCode,
				urnBammComCatenaX001PartIndividualDataCharacteristic.productionCountryCode)
				&& Objects.equals(this.productionDateGMT,
						urnBammComCatenaX001PartIndividualDataCharacteristic.productionDateGMT);
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
	 * Get productionCountryCode.
	 *
	 * @return productionCountryCode
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductionCountryCode() {
		return productionCountryCode;
	}

	/**
	 * Get productionDateGMT.
	 *
	 * @return productionDateGMT
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getProductionDateGMT() {
		return productionDateGMT;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(productionCountryCode, productionDateGMT);
	}

	/**
	 * Production country code.
	 *
	 * @param productionCountryCode the production country code
	 * @return the part individual data characteristic
	 */
	public PartIndividualDataCharacteristic productionCountryCode(String productionCountryCode) {
		this.productionCountryCode = productionCountryCode;
		return this;
	}

	/**
	 * Production date GMT.
	 *
	 * @param productionDateGMT the production date GMT
	 * @return the part individual data characteristic
	 */
	public PartIndividualDataCharacteristic productionDateGMT(OffsetDateTime productionDateGMT) {
		this.productionDateGMT = productionDateGMT;
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
	 * Sets the production country code.
	 *
	 * @param productionCountryCode the new production country code
	 */
	public void setProductionCountryCode(String productionCountryCode) {
		this.productionCountryCode = productionCountryCode;
	}

	/**
	 * Sets the production date GMT.
	 *
	 * @param productionDateGMT the new production date GMT
	 */
	public void setProductionDateGMT(OffsetDateTime productionDateGMT) {
		this.productionDateGMT = productionDateGMT;
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
		sb.append("class UrnBammComCatenaX001PartIndividualDataCharacteristic {\n");

		sb.append("    productionCountryCode: ").append(toIndentedString(productionCountryCode)).append("\n");
		sb.append("    productionDateGMT: ").append(toIndentedString(productionDateGMT)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
