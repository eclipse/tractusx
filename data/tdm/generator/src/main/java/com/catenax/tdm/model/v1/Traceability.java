/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

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
 * Traceability.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "traceability")
public class Traceability implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 118419567652659247L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The static data. */
	@OneToOne
	@JsonProperty("staticData")
	private PartStaticDataCharacteristic staticData = null;

	/** The unique data. */
	@OneToOne
	@JsonProperty("uniqueData")
	private PartUniqueDataCharacteristic uniqueData = null;

	/** The individual data. */
	@OneToOne
	@JsonProperty("individualData")
	private PartIndividualDataCharacteristic individualData = null;

	/** The supplier tree. */
	@OneToOne
	@JsonProperty("supplierTree")
	private PartTreeParentCharacteristic supplierTree = null;

	/** The part tree. */
	@OneToOne
	@JsonProperty("partTree")
	private PartTreeParentCharacteristic partTree = null;

	/** The quality alert data. */
	@OneToOne(optional = true)
	@JsonProperty("qualityAlertData")
	private QualityAlertDataCharacteristic qualityAlertData = null;

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
		final Traceability traceability = (Traceability) o;
		return Objects.equals(this.staticData, traceability.staticData)
				&& Objects.equals(this.uniqueData, traceability.uniqueData)
				&& Objects.equals(this.individualData, traceability.individualData)
				&& Objects.equals(this.supplierTree, traceability.supplierTree)
				&& Objects.equals(this.partTree, traceability.partTree)
				&& Objects.equals(this.qualityAlertData, traceability.qualityAlertData);
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
	 * Get individualData.
	 *
	 * @return individualData
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartIndividualDataCharacteristic getIndividualData() {
		return individualData;
	}

	/**
	 * Get partTree.
	 *
	 * @return partTree
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartTreeParentCharacteristic getPartTree() {
		return partTree;
	}

	/**
	 * Get qualityAlertData.
	 *
	 * @return qualityAlertData
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public QualityAlertDataCharacteristic getQualityAlertData() {
		return qualityAlertData;
	}

	/**
	 * Get staticData.
	 *
	 * @return staticData
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartStaticDataCharacteristic getStaticData() {
		return staticData;
	}

	/**
	 * Get supplierTree.
	 *
	 * @return supplierTree
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartTreeParentCharacteristic getSupplierTree() {
		return supplierTree;
	}

	/**
	 * Get uniqueData.
	 *
	 * @return uniqueData
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartUniqueDataCharacteristic getUniqueData() {
		return uniqueData;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(staticData, uniqueData, individualData, supplierTree, partTree, qualityAlertData);
	}

	/**
	 * Individual data.
	 *
	 * @param individualData the individual data
	 * @return the traceability
	 */
	public Traceability individualData(PartIndividualDataCharacteristic individualData) {
		this.individualData = individualData;
		return this;
	}

	/**
	 * Part tree.
	 *
	 * @param partTree the part tree
	 * @return the traceability
	 */
	public Traceability partTree(PartTreeParentCharacteristic partTree) {
		this.partTree = partTree;
		return this;
	}

	/**
	 * Quality alert data.
	 *
	 * @param qualityAlertData the quality alert data
	 * @return the traceability
	 */
	public Traceability qualityAlertData(QualityAlertDataCharacteristic qualityAlertData) {
		this.qualityAlertData = qualityAlertData;
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
	 * Sets the individual data.
	 *
	 * @param individualData the new individual data
	 */
	public void setIndividualData(PartIndividualDataCharacteristic individualData) {
		this.individualData = individualData;
	}

	/**
	 * Sets the part tree.
	 *
	 * @param partTree the new part tree
	 */
	public void setPartTree(PartTreeParentCharacteristic partTree) {
		this.partTree = partTree;
	}

	/**
	 * Sets the quality alert data.
	 *
	 * @param qualityAlertData the new quality alert data
	 */
	public void setQualityAlertData(QualityAlertDataCharacteristic qualityAlertData) {
		this.qualityAlertData = qualityAlertData;
	}

	/**
	 * Sets the static data.
	 *
	 * @param staticData the new static data
	 */
	public void setStaticData(PartStaticDataCharacteristic staticData) {
		this.staticData = staticData;
	}

	/**
	 * Sets the supplier tree.
	 *
	 * @param supplierTree the new supplier tree
	 */
	public void setSupplierTree(PartTreeParentCharacteristic supplierTree) {
		this.supplierTree = supplierTree;
	}

	/**
	 * Sets the unique data.
	 *
	 * @param uniqueData the new unique data
	 */
	public void setUniqueData(PartUniqueDataCharacteristic uniqueData) {
		this.uniqueData = uniqueData;
	}

	/**
	 * Static data.
	 *
	 * @param staticData the static data
	 * @return the traceability
	 */
	public Traceability staticData(PartStaticDataCharacteristic staticData) {
		this.staticData = staticData;
		return this;
	}

	/**
	 * Supplier tree.
	 *
	 * @param supplierTree the supplier tree
	 * @return the traceability
	 */
	public Traceability supplierTree(PartTreeParentCharacteristic supplierTree) {
		this.supplierTree = supplierTree;
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
		sb.append("class Traceability {\n");

		sb.append("    staticData: ").append(toIndentedString(staticData)).append("\n");
		sb.append("    uniqueData: ").append(toIndentedString(uniqueData)).append("\n");
		sb.append("    individualData: ").append(toIndentedString(individualData)).append("\n");
		sb.append("    supplierTree: ").append(toIndentedString(supplierTree)).append("\n");
		sb.append("    partTree: ").append(toIndentedString(partTree)).append("\n");
		sb.append("    qualityAlertData: ").append(toIndentedString(qualityAlertData)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Unique data.
	 *
	 * @param uniqueData the unique data
	 * @return the traceability
	 */
	public Traceability uniqueData(PartUniqueDataCharacteristic uniqueData) {
		this.uniqueData = uniqueData;
		return this;
	}
}
