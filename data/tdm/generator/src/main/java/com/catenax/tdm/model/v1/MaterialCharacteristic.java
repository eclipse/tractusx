/*
 *
 */
package com.catenax.tdm.model.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * MaterialCharacteristic.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

@Entity
@Table(name = "aspect_material_characteristic")
public class MaterialCharacteristic {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The material name. */
	@JsonProperty("materialName")
	private MaterialNamesEnumeration materialName = null;

	/** The material type. */
	@JsonProperty("materialType")
	private MaterialTypesEnumeration materialType = null;

	/** The aggregate state. */
	@JsonProperty("aggregateState")
	private AggregateStatesEnumeration aggregateState = null;

	/** The chemical composition. */
	@JsonProperty("chemicalComposition")
	@OneToMany
	private List<MaterialCollectionInner> chemicalComposition = new ArrayList<>();

	/** The weight. */
	@JsonProperty("weight")
	private BigDecimal weight = null;

	/** The chemical composition fraction. */
	@JsonProperty("chemicalCompositionFraction")
	private BigDecimal chemicalCompositionFraction = null;

	/**
	 * Aggregate state.
	 *
	 * @param aggregateState the aggregate state
	 * @return the material characteristic
	 */
	public MaterialCharacteristic aggregateState(AggregateStatesEnumeration aggregateState) {
		this.aggregateState = aggregateState;
		return this;
	}

	/**
	 * Chemical composition.
	 *
	 * @param chemicalComposition the chemical composition
	 * @return the material characteristic
	 */
	public MaterialCharacteristic chemicalComposition(List<MaterialCollectionInner> chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
		return this;
	}

	/**
	 * Chemical composition fraction.
	 *
	 * @param chemicalCompositionFraction the chemical composition fraction
	 * @return the material characteristic
	 */
	public MaterialCharacteristic chemicalCompositionFraction(BigDecimal chemicalCompositionFraction) {
		this.chemicalCompositionFraction = chemicalCompositionFraction;
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
		final MaterialCharacteristic materialCharacteristic = (MaterialCharacteristic) o;
		return Objects.equals(this.materialName, materialCharacteristic.materialName)
				&& Objects.equals(this.materialType, materialCharacteristic.materialType)
				&& Objects.equals(this.aggregateState, materialCharacteristic.aggregateState)
				&& Objects.equals(this.chemicalComposition, materialCharacteristic.chemicalComposition)
				&& Objects.equals(this.weight, materialCharacteristic.weight)
				&& Objects.equals(this.chemicalCompositionFraction, materialCharacteristic.chemicalCompositionFraction);
	}

	/**
	 * Get aggregateState.
	 *
	 * @return aggregateState
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public AggregateStatesEnumeration getAggregateState() {
		return aggregateState;
	}

	/**
	 * Get chemicalComposition.
	 *
	 * @return chemicalComposition
	 */
	@Schema(description = "")

	@Valid
	public List<MaterialCollectionInner> getChemicalComposition() {
		return chemicalComposition;
	}

	/**
	 * Get chemicalCompositionFraction.
	 *
	 * @return chemicalCompositionFraction
	 */
	@Schema(description = "")

	@Valid
	public BigDecimal getChemicalCompositionFraction() {
		return chemicalCompositionFraction;
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
	 * Get materialName.
	 *
	 * @return materialName
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public MaterialNamesEnumeration getMaterialName() {
		return materialName;
	}

	/**
	 * Get materialType.
	 *
	 * @return materialType
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public MaterialTypesEnumeration getMaterialType() {
		return materialType;
	}

	/**
	 * Get weight.
	 *
	 * @return weight
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(materialName, materialType, aggregateState, chemicalComposition, weight,
				chemicalCompositionFraction);
	}

	/**
	 * Material name.
	 *
	 * @param materialName the material name
	 * @return the material characteristic
	 */
	public MaterialCharacteristic materialName(MaterialNamesEnumeration materialName) {
		this.materialName = materialName;
		return this;
	}

	/**
	 * Material type.
	 *
	 * @param materialType the material type
	 * @return the material characteristic
	 */
	public MaterialCharacteristic materialType(MaterialTypesEnumeration materialType) {
		this.materialType = materialType;
		return this;
	}

	/**
	 * Sets the aggregate state.
	 *
	 * @param aggregateState the new aggregate state
	 */
	public void setAggregateState(AggregateStatesEnumeration aggregateState) {
		this.aggregateState = aggregateState;
	}

	/**
	 * Sets the chemical composition.
	 *
	 * @param chemicalComposition the new chemical composition
	 */
	public void setChemicalComposition(List<MaterialCollectionInner> chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}

	/**
	 * Sets the chemical composition fraction.
	 *
	 * @param chemicalCompositionFraction the new chemical composition fraction
	 */
	public void setChemicalCompositionFraction(BigDecimal chemicalCompositionFraction) {
		this.chemicalCompositionFraction = chemicalCompositionFraction;
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
	 * Sets the material name.
	 *
	 * @param materialName the new material name
	 */
	public void setMaterialName(MaterialNamesEnumeration materialName) {
		this.materialName = materialName;
	}

	/**
	 * Sets the material type.
	 *
	 * @param materialType the new material type
	 */
	public void setMaterialType(MaterialTypesEnumeration materialType) {
		this.materialType = materialType;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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
		sb.append("class MaterialCharacteristic {\n");

		sb.append("    materialName: ").append(toIndentedString(materialName)).append("\n");
		sb.append("    materialType: ").append(toIndentedString(materialType)).append("\n");
		sb.append("    aggregateState: ").append(toIndentedString(aggregateState)).append("\n");
		sb.append("    chemicalComposition: ").append(toIndentedString(chemicalComposition)).append("\n");
		sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
		sb.append("    chemicalCompositionFraction: ").append(toIndentedString(chemicalCompositionFraction))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Weight.
	 *
	 * @param weight the weight
	 * @return the material characteristic
	 */
	public MaterialCharacteristic weight(BigDecimal weight) {
		this.weight = weight;
		return this;
	}
}
