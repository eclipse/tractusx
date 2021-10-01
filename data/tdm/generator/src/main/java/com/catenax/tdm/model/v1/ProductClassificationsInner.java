/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * ProductClassificationsInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_technicaldata_product_inner")
public class ProductClassificationsInner {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The product classification system. */
	@JsonProperty("productClassificationSystem")
	private String productClassificationSystem = null;

	/** The classification system version. */
	@JsonProperty("classificationSystemVersion")
	private String classificationSystemVersion = null;

	/** The product class id. */
	@JsonProperty("productClassId")
	private String productClassId = null;

	/**
	 * Classification system version.
	 *
	 * @param classificationSystemVersion the classification system version
	 * @return the product classifications inner
	 */
	public ProductClassificationsInner classificationSystemVersion(String classificationSystemVersion) {
		this.classificationSystemVersion = classificationSystemVersion;
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
		final ProductClassificationsInner productClassificationsInner = (ProductClassificationsInner) o;
		return Objects.equals(this.productClassificationSystem, productClassificationsInner.productClassificationSystem)
				&& Objects.equals(this.classificationSystemVersion,
						productClassificationsInner.classificationSystemVersion)
				&& Objects.equals(this.productClassId, productClassificationsInner.productClassId);
	}

	/**
	 * Get classificationSystemVersion.
	 *
	 * @return classificationSystemVersion
	 */
	@Schema(description = "")

	public String getClassificationSystemVersion() {
		return classificationSystemVersion;
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
	 * Get productClassId.
	 *
	 * @return productClassId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductClassId() {
		return productClassId;
	}

	/**
	 * Get productClassificationSystem.
	 *
	 * @return productClassificationSystem
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getProductClassificationSystem() {
		return productClassificationSystem;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(productClassificationSystem, classificationSystemVersion, productClassId);
	}

	/**
	 * Product class id.
	 *
	 * @param productClassId the product class id
	 * @return the product classifications inner
	 */
	public ProductClassificationsInner productClassId(String productClassId) {
		this.productClassId = productClassId;
		return this;
	}

	/**
	 * Product classification system.
	 *
	 * @param productClassificationSystem the product classification system
	 * @return the product classifications inner
	 */
	public ProductClassificationsInner productClassificationSystem(String productClassificationSystem) {
		this.productClassificationSystem = productClassificationSystem;
		return this;
	}

	/**
	 * Sets the classification system version.
	 *
	 * @param classificationSystemVersion the new classification system version
	 */
	public void setClassificationSystemVersion(String classificationSystemVersion) {
		this.classificationSystemVersion = classificationSystemVersion;
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
	 * Sets the product class id.
	 *
	 * @param productClassId the new product class id
	 */
	public void setProductClassId(String productClassId) {
		this.productClassId = productClassId;
	}

	/**
	 * Sets the product classification system.
	 *
	 * @param productClassificationSystem the new product classification system
	 */
	public void setProductClassificationSystem(String productClassificationSystem) {
		this.productClassificationSystem = productClassificationSystem;
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
		sb.append("class ProductClassificationsInner {\n");

		sb.append("    productClassificationSystem: ").append(toIndentedString(productClassificationSystem))
				.append("\n");
		sb.append("    classificationSystemVersion: ").append(toIndentedString(classificationSystemVersion))
				.append("\n");
		sb.append("    productClassId: ").append(toIndentedString(productClassId)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
