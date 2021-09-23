package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Traceability
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class Traceability implements Serializable {

	private static final long serialVersionUID = 118419567652659247L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}

	@OneToOne
	@JsonProperty("staticData")
	private PartStaticDataCharacteristic staticData = null;

	@OneToOne
	@JsonProperty("uniqueData")
	private PartUniqueDataCharacteristic uniqueData = null;

	@OneToOne
	@JsonProperty("individualData")
	private PartIndividualDataCharacteristic individualData = null;

	@OneToOne
	@JsonProperty("supplierTree")
	private PartTreeParentCharacteristic supplierTree = null;

	@OneToOne
	@JsonProperty("partTree")
	private PartTreeParentCharacteristic partTree = null;

	@OneToOne(optional = true)
	@JsonProperty("qualityAlertData")
	private QualityAlertDataCharacteristic qualityAlertData = null;

	public Traceability staticData(PartStaticDataCharacteristic staticData) {
		this.staticData = staticData;
		return this;
	}

	/**
	 * Get staticData
	 * 
	 * @return staticData
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartStaticDataCharacteristic getStaticData() {
		return staticData;
	}

	public void setStaticData(PartStaticDataCharacteristic staticData) {
		this.staticData = staticData;
	}

	public Traceability uniqueData(PartUniqueDataCharacteristic uniqueData) {
		this.uniqueData = uniqueData;
		return this;
	}

	/**
	 * Get uniqueData
	 * 
	 * @return uniqueData
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartUniqueDataCharacteristic getUniqueData() {
		return uniqueData;
	}

	public void setUniqueData(PartUniqueDataCharacteristic uniqueData) {
		this.uniqueData = uniqueData;
	}

	public Traceability individualData(PartIndividualDataCharacteristic individualData) {
		this.individualData = individualData;
		return this;
	}

	/**
	 * Get individualData
	 * 
	 * @return individualData
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartIndividualDataCharacteristic getIndividualData() {
		return individualData;
	}

	public void setIndividualData(PartIndividualDataCharacteristic individualData) {
		this.individualData = individualData;
	}

	public Traceability supplierTree(PartTreeParentCharacteristic supplierTree) {
		this.supplierTree = supplierTree;
		return this;
	}

	/**
	 * Get supplierTree
	 * 
	 * @return supplierTree
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartTreeParentCharacteristic getSupplierTree() {
		return supplierTree;
	}

	public void setSupplierTree(PartTreeParentCharacteristic supplierTree) {
		this.supplierTree = supplierTree;
	}

	public Traceability partTree(PartTreeParentCharacteristic partTree) {
		this.partTree = partTree;
		return this;
	}

	/**
	 * Get partTree
	 * 
	 * @return partTree
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PartTreeParentCharacteristic getPartTree() {
		return partTree;
	}

	public void setPartTree(PartTreeParentCharacteristic partTree) {
		this.partTree = partTree;
	}

	public Traceability qualityAlertData(QualityAlertDataCharacteristic qualityAlertData) {
		this.qualityAlertData = qualityAlertData;
		return this;
	}

	/**
	 * Get qualityAlertData
	 * 
	 * @return qualityAlertData
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public QualityAlertDataCharacteristic getQualityAlertData() {
		return qualityAlertData;
	}

	public void setQualityAlertData(QualityAlertDataCharacteristic qualityAlertData) {
		this.qualityAlertData = qualityAlertData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Traceability traceability = (Traceability) o;
		return Objects.equals(this.staticData, traceability.staticData)
				&& Objects.equals(this.uniqueData, traceability.uniqueData)
				&& Objects.equals(this.individualData, traceability.individualData)
				&& Objects.equals(this.supplierTree, traceability.supplierTree)
				&& Objects.equals(this.partTree, traceability.partTree)
				&& Objects.equals(this.qualityAlertData, traceability.qualityAlertData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(staticData, uniqueData, individualData, supplierTree, partTree, qualityAlertData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
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
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
