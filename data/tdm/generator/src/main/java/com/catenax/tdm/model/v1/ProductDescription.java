/*
 *
 */
package com.catenax.tdm.model.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * ProductDescription.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_product_description")
public class ProductDescription {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The product ID. */
	@JsonProperty("productID")
	private String productID = null;

	/** The product name. */
	@JsonProperty("productName")
	private String productName = null;

	/** The product description. */
	@JsonProperty("productDescription")
	private String productDescription = null;

	/** The production date GMT. */
	@JsonProperty("productionDateGMT")
	private String productionDateGMT = null;

	/** The build position. */
	@JsonProperty("buildPosition")
	private String buildPosition = null;

	/** The liquid bearing. */
	@JsonProperty("liquidBearing")
	private Boolean liquidBearing = null;

	/** The product weight. */
	@JsonProperty("productWeight")
	private BigDecimal productWeight = null;

	/** The performance indicator. */
	@JsonProperty("performanceIndicator")
	@OneToOne
	private PerformanceIndicatorCharacteristic performanceIndicator = null;

	/** The product dimension. */
	@JsonProperty("productDimension")
	@OneToOne
	private ProductDimension3D productDimension = null;

	/** The product type. */
	@JsonProperty("productType")
	@Column(name = "product_type")
	@ElementCollection(targetClass = String.class)
	private List<String> productType = new ArrayList<>();

	/**
	 * Builds the position.
	 *
	 * @param buildPosition the build position
	 * @return the product description
	 */
	public ProductDescription buildPosition(String buildPosition) {
		this.buildPosition = buildPosition;
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
		final ProductDescription productDescription = (ProductDescription) o;
		return Objects.equals(this.productID, productDescription.productID)
				&& Objects.equals(this.productName, productDescription.productName)
				&& Objects.equals(this.productDescription, productDescription.productDescription)
				&& Objects.equals(this.productionDateGMT, productDescription.productionDateGMT)
				&& Objects.equals(this.buildPosition, productDescription.buildPosition)
				&& Objects.equals(this.liquidBearing, productDescription.liquidBearing)
				&& Objects.equals(this.productWeight, productDescription.productWeight)
				&& Objects.equals(this.performanceIndicator, productDescription.performanceIndicator)
				&& Objects.equals(this.productDimension, productDescription.productDimension)
				&& Objects.equals(this.productType, productDescription.productType);
	}

	/**
	 * Get buildPosition.
	 *
	 * @return buildPosition
	 */
	@Schema(description = "")

	public String getBuildPosition() {
		return buildPosition;
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
	 * Get liquidBearing.
	 *
	 * @return liquidBearing
	 */
	@Schema(description = "")

	public Boolean getLiquidBearing() {
		return liquidBearing;
	}

	/**
	 * Get performanceIndicator.
	 *
	 * @return performanceIndicator
	 */
	@Schema(description = "")

	@Valid
	public PerformanceIndicatorCharacteristic getPerformanceIndicator() {
		return performanceIndicator;
	}

	/**
	 * Get productDescription.
	 *
	 * @return productDescription
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Get productDimension.
	 *
	 * @return productDimension
	 */
	@Schema(description = "")

	@Valid
	public ProductDimension3D getProductDimension() {
		return productDimension;
	}

	/**
	 * Get productID.
	 *
	 * @return productID
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductID() {
		return productID;
	}

	/**
	 * Get productionDateGMT.
	 *
	 * @return productionDateGMT
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductionDateGMT() {
		return productionDateGMT;
	}

	/**
	 * Get productName.
	 *
	 * @return productName
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductName() {
		return productName;
	}

	/**
	 * Get productType.
	 *
	 * @return productType
	 */
	@Schema(description = "")

	@Valid
	public List<String> getProductType() {
		return productType;
	}

	/**
	 * Get productWeight.
	 *
	 * @return productWeight
	 */
	@Schema(description = "")

	@Valid
	public BigDecimal getProductWeight() {
		return productWeight;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(productID, productName, productDescription, productionDateGMT, buildPosition, liquidBearing,
				productWeight, performanceIndicator, productDimension, productType);
	}

	/**
	 * Liquid bearing.
	 *
	 * @param liquidBearing the liquid bearing
	 * @return the product description
	 */
	public ProductDescription liquidBearing(Boolean liquidBearing) {
		this.liquidBearing = liquidBearing;
		return this;
	}

	/**
	 * Performance indicator.
	 *
	 * @param performanceIndicator the performance indicator
	 * @return the product description
	 */
	public ProductDescription performanceIndicator(PerformanceIndicatorCharacteristic performanceIndicator) {
		this.performanceIndicator = performanceIndicator;
		return this;
	}

	/**
	 * Product description.
	 *
	 * @param productDescription the product description
	 * @return the product description
	 */
	public ProductDescription productDescription(String productDescription) {
		this.productDescription = productDescription;
		return this;
	}

	/**
	 * Product dimension.
	 *
	 * @param productDimension the product dimension
	 * @return the product description
	 */
	public ProductDescription productDimension(ProductDimension3D productDimension) {
		this.productDimension = productDimension;
		return this;
	}

	/**
	 * Product ID.
	 *
	 * @param productID the product ID
	 * @return the product description
	 */
	public ProductDescription productID(String productID) {
		this.productID = productID;
		return this;
	}

	/**
	 * Production date GMT.
	 *
	 * @param productionDateGMT the production date GMT
	 * @return the product description
	 */
	public ProductDescription productionDateGMT(String productionDateGMT) {
		this.productionDateGMT = productionDateGMT;
		return this;
	}

	/**
	 * Product name.
	 *
	 * @param productName the product name
	 * @return the product description
	 */
	public ProductDescription productName(String productName) {
		this.productName = productName;
		return this;
	}

	/**
	 * Product type.
	 *
	 * @param productType the product type
	 * @return the product description
	 */
	public ProductDescription productType(SetOfDocumentTypes productType) {
		this.productType = productType;
		return this;
	}

	/**
	 * Product weight.
	 *
	 * @param productWeight the product weight
	 * @return the product description
	 */
	public ProductDescription productWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
		return this;
	}

	/**
	 * Sets the builds the position.
	 *
	 * @param buildPosition the new builds the position
	 */
	public void setBuildPosition(String buildPosition) {
		this.buildPosition = buildPosition;
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
	 * Sets the liquid bearing.
	 *
	 * @param liquidBearing the new liquid bearing
	 */
	public void setLiquidBearing(Boolean liquidBearing) {
		this.liquidBearing = liquidBearing;
	}

	/**
	 * Sets the performance indicator.
	 *
	 * @param performanceIndicator the new performance indicator
	 */
	public void setPerformanceIndicator(PerformanceIndicatorCharacteristic performanceIndicator) {
		this.performanceIndicator = performanceIndicator;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Sets the product dimension.
	 *
	 * @param productDimension the new product dimension
	 */
	public void setProductDimension(ProductDimension3D productDimension) {
		this.productDimension = productDimension;
	}

	/**
	 * Sets the product ID.
	 *
	 * @param productID the new product ID
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

	/**
	 * Sets the production date GMT.
	 *
	 * @param productionDateGMT the new production date GMT
	 */
	public void setProductionDateGMT(String productionDateGMT) {
		this.productionDateGMT = productionDateGMT;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Sets the product type.
	 *
	 * @param productType the new product type
	 */
	public void setProductType(List<String> productType) {
		this.productType = productType;
	}

	/**
	 * Sets the product weight.
	 *
	 * @param productWeight the new product weight
	 */
	public void setProductWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
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
		sb.append("class ProductDescription {\n");

		sb.append("    productID: ").append(toIndentedString(productID)).append("\n");
		sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
		sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
		sb.append("    productionDateGMT: ").append(toIndentedString(productionDateGMT)).append("\n");
		sb.append("    buildPosition: ").append(toIndentedString(buildPosition)).append("\n");
		sb.append("    liquidBearing: ").append(toIndentedString(liquidBearing)).append("\n");
		sb.append("    productWeight: ").append(toIndentedString(productWeight)).append("\n");
		sb.append("    performanceIndicator: ").append(toIndentedString(performanceIndicator)).append("\n");
		sb.append("    productDimension: ").append(toIndentedString(productDimension)).append("\n");
		sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
