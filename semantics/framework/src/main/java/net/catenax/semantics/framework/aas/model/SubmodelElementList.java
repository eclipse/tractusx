package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SubmodelElementList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class SubmodelElementList extends SubmodelElement implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("semanticIdValues")
  private Reference semanticIdValues = null;

  @JsonProperty("submodelElementTypeValues")
  private ModelType submodelElementTypeValues = null;

  @JsonProperty("value")
  @Valid
  private List<SubmodelElement> value = null;

  @JsonProperty("valueTypeValues")
  private ValueTypeEnum valueTypeValues = null;

  public SubmodelElementList semanticIdValues(Reference semanticIdValues) {
    this.semanticIdValues = semanticIdValues;
    return this;
  }

  /**
   * Get semanticIdValues
   * @return semanticIdValues
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getSemanticIdValues() {
    return semanticIdValues;
  }

  public void setSemanticIdValues(Reference semanticIdValues) {
    this.semanticIdValues = semanticIdValues;
  }

  public SubmodelElementList submodelElementTypeValues(ModelType submodelElementTypeValues) {
    this.submodelElementTypeValues = submodelElementTypeValues;
    return this;
  }

  /**
   * Get submodelElementTypeValues
   * @return submodelElementTypeValues
   **/
  @Schema(description = "")
  
    @Valid
    public ModelType getSubmodelElementTypeValues() {
    return submodelElementTypeValues;
  }

  public void setSubmodelElementTypeValues(ModelType submodelElementTypeValues) {
    this.submodelElementTypeValues = submodelElementTypeValues;
  }

  public SubmodelElementList value(List<SubmodelElement> value) {
    this.value = value;
    return this;
  }

  public SubmodelElementList addValueItem(SubmodelElement valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<>();
    }
    this.value.add(valueItem);
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(description = "")
      @Valid
    public List<SubmodelElement> getValue() {
    return value;
  }

  public void setValue(List<SubmodelElement> value) {
    this.value = value;
  }

  public SubmodelElementList valueTypeValues(ValueTypeEnum valueTypeValues) {
    this.valueTypeValues = valueTypeValues;
    return this;
  }

  /**
   * Get valueTypeValues
   * @return valueTypeValues
   **/
  @Schema(description = "")
  
    @Valid
    public ValueTypeEnum getValueTypeValues() {
    return valueTypeValues;
  }

  public void setValueTypeValues(ValueTypeEnum valueTypeValues) {
    this.valueTypeValues = valueTypeValues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmodelElementList submodelElementList = (SubmodelElementList) o;
    return Objects.equals(this.semanticIdValues, submodelElementList.semanticIdValues) &&
        Objects.equals(this.submodelElementTypeValues, submodelElementList.submodelElementTypeValues) &&
        Objects.equals(this.value, submodelElementList.value) &&
        Objects.equals(this.valueTypeValues, submodelElementList.valueTypeValues) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(semanticIdValues, submodelElementTypeValues, value, valueTypeValues, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmodelElementList {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    semanticIdValues: ").append(toIndentedString(semanticIdValues)).append("\n");
    sb.append("    submodelElementTypeValues: ").append(toIndentedString(submodelElementTypeValues)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueTypeValues: ").append(toIndentedString(valueTypeValues)).append("\n");
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
