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
 * ProductDimension3D.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_product_dimension_3d")
public class ProductDimension3D {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The dimension X. */
	@JsonProperty("dimensionX")
	private BigDecimal dimensionX = null;

	/** The dimension Y. */
	@JsonProperty("dimensionY")
	private BigDecimal dimensionY = null;

	/** The dimension Z. */
	@JsonProperty("dimensionZ")
	private BigDecimal dimensionZ = null;

	/**
	 * Dimension X.
	 *
	 * @param dimensionX the dimension X
	 * @return the product dimension 3 D
	 */
	public ProductDimension3D dimensionX(BigDecimal dimensionX) {
		this.dimensionX = dimensionX;
		return this;
	}

	/**
	 * Dimension Y.
	 *
	 * @param dimensionY the dimension Y
	 * @return the product dimension 3 D
	 */
	public ProductDimension3D dimensionY(BigDecimal dimensionY) {
		this.dimensionY = dimensionY;
		return this;
	}

	/**
	 * Dimension Z.
	 *
	 * @param dimensionZ the dimension Z
	 * @return the product dimension 3 D
	 */
	public ProductDimension3D dimensionZ(BigDecimal dimensionZ) {
		this.dimensionZ = dimensionZ;
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
		final ProductDimension3D productDimension3D = (ProductDimension3D) o;
		return Objects.equals(this.dimensionX, productDimension3D.dimensionX)
				&& Objects.equals(this.dimensionY, productDimension3D.dimensionY)
				&& Objects.equals(this.dimensionZ, productDimension3D.dimensionZ);
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
	 * Get dimensionX.
	 *
	 * @return dimensionX
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getDimensionX() {
		return dimensionX;
	}

	/**
	 * Get dimensionY.
	 *
	 * @return dimensionY
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getDimensionY() {
		return dimensionY;
	}

	/**
	 * Get dimensionZ.
	 *
	 * @return dimensionZ
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getDimensionZ() {
		return dimensionZ;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dimensionX, dimensionY, dimensionZ);
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
	 * Sets the dimension X.
	 *
	 * @param dimensionX the new dimension X
	 */
	public void setDimensionX(BigDecimal dimensionX) {
		this.dimensionX = dimensionX;
	}

	/**
	 * Sets the dimension Y.
	 *
	 * @param dimensionY the new dimension Y
	 */
	public void setDimensionY(BigDecimal dimensionY) {
		this.dimensionY = dimensionY;
	}

	/**
	 * Sets the dimension Z.
	 *
	 * @param dimensionZ the new dimension Z
	 */
	public void setDimensionZ(BigDecimal dimensionZ) {
		this.dimensionZ = dimensionZ;
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
		sb.append("class ProductDimension3D {\n");

		sb.append("    dimensionX: ").append(toIndentedString(dimensionX)).append("\n");
		sb.append("    dimensionY: ").append(toIndentedString(dimensionY)).append("\n");
		sb.append("    dimensionZ: ").append(toIndentedString(dimensionZ)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
