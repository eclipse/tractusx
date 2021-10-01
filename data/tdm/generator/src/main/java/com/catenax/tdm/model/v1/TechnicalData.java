/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * TechnicalData.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_technicaldata")
public class TechnicalData {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The general information. */
	@JsonProperty("generalInformation")
	@OneToOne
	private GeneralInformation generalInformation = null;

	/** The product classifications. */
	@JsonProperty("productClassifications")
	@OneToMany
	private List<ProductClassificationsInner> productClassifications = new ArrayList<>();

	/** The technical properties. */
	@JsonProperty("technicalProperties")
	@OneToOne
	private TechnicalProperties technicalProperties = null;

	/** The further information. */
	@JsonProperty("furtherInformation")
	@OneToOne
	private FurtherInformation furtherInformation = null;

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
		final TechnicalData technicalData = (TechnicalData) o;
		return Objects.equals(this.generalInformation, technicalData.generalInformation)
				&& Objects.equals(this.productClassifications, technicalData.productClassifications)
				&& Objects.equals(this.technicalProperties, technicalData.technicalProperties)
				&& Objects.equals(this.furtherInformation, technicalData.furtherInformation);
	}

	/**
	 * Further information.
	 *
	 * @param furtherInformation the further information
	 * @return the technical data
	 */
	public TechnicalData furtherInformation(FurtherInformation furtherInformation) {
		this.furtherInformation = furtherInformation;
		return this;
	}

	/**
	 * General information.
	 *
	 * @param generalInformation the general information
	 * @return the technical data
	 */
	public TechnicalData generalInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
		return this;
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
	 * Get furtherInformation.
	 *
	 * @return furtherInformation
	 */
	@Schema(description = "")

	@Valid
	public FurtherInformation getFurtherInformation() {
		return furtherInformation;
	}

	/**
	 * Get generalInformation.
	 *
	 * @return generalInformation
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}

	/**
	 * Get productClassifications.
	 *
	 * @return productClassifications
	 */
	@Schema(description = "")

	@Valid
	public List<ProductClassificationsInner> getProductClassifications() {
		return productClassifications;
	}

	/**
	 * Get technicalProperties.
	 *
	 * @return technicalProperties
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public TechnicalProperties getTechnicalProperties() {
		return technicalProperties;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(generalInformation, productClassifications, technicalProperties, furtherInformation);
	}

	/**
	 * Product classifications.
	 *
	 * @param productClassifications the product classifications
	 * @return the technical data
	 */
	public TechnicalData productClassifications(ProductClassifications productClassifications) {
		this.productClassifications = productClassifications;
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
	 * Sets the further information.
	 *
	 * @param furtherInformation the new further information
	 */
	public void setFurtherInformation(FurtherInformation furtherInformation) {
		this.furtherInformation = furtherInformation;
	}

	/**
	 * Sets the general information.
	 *
	 * @param generalInformation the new general information
	 */
	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}

	/**
	 * Sets the product classifications.
	 *
	 * @param productClassifications the new product classifications
	 */
	public void setProductClassifications(List<ProductClassificationsInner> productClassifications) {
		this.productClassifications = productClassifications;
	}

	/**
	 * Sets the technical properties.
	 *
	 * @param technicalProperties the new technical properties
	 */
	public void setTechnicalProperties(TechnicalProperties technicalProperties) {
		this.technicalProperties = technicalProperties;
	}

	/**
	 * Technical properties.
	 *
	 * @param technicalProperties the technical properties
	 * @return the technical data
	 */
	public TechnicalData technicalProperties(TechnicalProperties technicalProperties) {
		this.technicalProperties = technicalProperties;
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
		sb.append("class TechnicalData {\n");

		sb.append("    generalInformation: ").append(toIndentedString(generalInformation)).append("\n");
		sb.append("    productClassifications: ").append(toIndentedString(productClassifications)).append("\n");
		sb.append("    technicalProperties: ").append(toIndentedString(technicalProperties)).append("\n");
		sb.append("    furtherInformation: ").append(toIndentedString(furtherInformation)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
