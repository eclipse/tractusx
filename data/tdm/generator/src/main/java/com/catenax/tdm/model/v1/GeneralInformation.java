/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * GeneralInformation.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_technicaldata_general")
public class GeneralInformation {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The manufacturer name. */
	@JsonProperty("manufacturerName")
	private String manufacturerName = null;

	/** The manufacturer logo. */
	@JsonProperty("manufacturerLogo")
	@OneToOne
	private Logo manufacturerLogo = null;

	/** The manufacturer product designation. */
	@JsonProperty("manufacturerProductDesignation")
	@Column(name = "manufacturer_product_designation")
	@ElementCollection(targetClass = String.class)
	private List<String> manufacturerProductDesignation = new ArrayList<>();

	/** The manufacturer part number. */
	@JsonProperty("manufacturerPartNumber")
	private String manufacturerPartNumber = null;

	/** The manufacturer order code. */
	@JsonProperty("manufacturerOrderCode")
	private String manufacturerOrderCode = null;

	/** The product images. */
	@JsonProperty("productImages")
	@OneToMany
	private List<ProductImagesInner> productImages = null;

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
		final GeneralInformation generalInformation = (GeneralInformation) o;
		return Objects.equals(this.manufacturerName, generalInformation.manufacturerName)
				&& Objects.equals(this.manufacturerLogo, generalInformation.manufacturerLogo)
				&& Objects.equals(this.manufacturerProductDesignation,
						generalInformation.manufacturerProductDesignation)
				&& Objects.equals(this.manufacturerPartNumber, generalInformation.manufacturerPartNumber)
				&& Objects.equals(this.manufacturerOrderCode, generalInformation.manufacturerOrderCode)
				&& Objects.equals(this.productImages, generalInformation.productImages);
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
	 * Get manufacturerLogo.
	 *
	 * @return manufacturerLogo
	 */
	@Schema(description = "")

	@Valid
	public Logo getManufacturerLogo() {
		return manufacturerLogo;
	}

	/**
	 * Get manufacturerName.
	 *
	 * @return manufacturerName
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Get manufacturerOrderCode.
	 *
	 * @return manufacturerOrderCode
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufacturerOrderCode() {
		return manufacturerOrderCode;
	}

	/**
	 * Get manufacturerPartNumber.
	 *
	 * @return manufacturerPartNumber
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	/**
	 * Get manufacturerProductDesignation.
	 *
	 * @return manufacturerProductDesignation
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public List<String> getManufacturerProductDesignation() {
		return manufacturerProductDesignation;
	}

	/**
	 * Get productImages.
	 *
	 * @return productImages
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public List<ProductImagesInner> getProductImages() {
		return productImages;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(manufacturerName, manufacturerLogo, manufacturerProductDesignation, manufacturerPartNumber,
				manufacturerOrderCode, productImages);
	}

	/**
	 * Manufacturer logo.
	 *
	 * @param manufacturerLogo the manufacturer logo
	 * @return the general information
	 */
	public GeneralInformation manufacturerLogo(Logo manufacturerLogo) {
		this.manufacturerLogo = manufacturerLogo;
		return this;
	}

	/**
	 * Manufacturer name.
	 *
	 * @param manufacturerName the manufacturer name
	 * @return the general information
	 */
	public GeneralInformation manufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
		return this;
	}

	/**
	 * Manufacturer order code.
	 *
	 * @param manufacturerOrderCode the manufacturer order code
	 * @return the general information
	 */
	public GeneralInformation manufacturerOrderCode(String manufacturerOrderCode) {
		this.manufacturerOrderCode = manufacturerOrderCode;
		return this;
	}

	/**
	 * Manufacturer part number.
	 *
	 * @param manufacturerPartNumber the manufacturer part number
	 * @return the general information
	 */
	public GeneralInformation manufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
		return this;
	}

	/**
	 * Manufacturer product designation.
	 *
	 * @param manufacturerProductDesignation the manufacturer product designation
	 * @return the general information
	 */
	public GeneralInformation manufacturerProductDesignation(List<String> manufacturerProductDesignation) {
		this.manufacturerProductDesignation = manufacturerProductDesignation;
		return this;
	}

	/**
	 * Product images.
	 *
	 * @param productImages the product images
	 * @return the general information
	 */
	public GeneralInformation productImages(List<ProductImagesInner> productImages) {
		this.productImages = productImages;
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
	 * Sets the manufacturer logo.
	 *
	 * @param manufacturerLogo the new manufacturer logo
	 */
	public void setManufacturerLogo(Logo manufacturerLogo) {
		this.manufacturerLogo = manufacturerLogo;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName the new manufacturer name
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Sets the manufacturer order code.
	 *
	 * @param manufacturerOrderCode the new manufacturer order code
	 */
	public void setManufacturerOrderCode(String manufacturerOrderCode) {
		this.manufacturerOrderCode = manufacturerOrderCode;
	}

	/**
	 * Sets the manufacturer part number.
	 *
	 * @param manufacturerPartNumber the new manufacturer part number
	 */
	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}

	/**
	 * Sets the manufacturer product designation.
	 *
	 * @param manufacturerProductDesignation the new manufacturer product
	 *                                       designation
	 */
	public void setManufacturerProductDesignation(List<String> manufacturerProductDesignation) {
		this.manufacturerProductDesignation = manufacturerProductDesignation;
	}

	/**
	 * Sets the product images.
	 *
	 * @param productImages the new product images
	 */
	public void setProductImages(List<ProductImagesInner> productImages) {
		this.productImages = productImages;
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
		sb.append("class GeneralInformation {\n");

		sb.append("    manufacturerName: ").append(toIndentedString(manufacturerName)).append("\n");
		sb.append("    manufacturerLogo: ").append(toIndentedString(manufacturerLogo)).append("\n");
		sb.append("    manufacturerProductDesignation: ").append(toIndentedString(manufacturerProductDesignation))
				.append("\n");
		sb.append("    manufacturerPartNumber: ").append(toIndentedString(manufacturerPartNumber)).append("\n");
		sb.append("    manufacturerOrderCode: ").append(toIndentedString(manufacturerOrderCode)).append("\n");
		sb.append("    productImages: ").append(toIndentedString(productImages)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
