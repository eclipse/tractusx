package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Property
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Property extends SubmodelElement implements OneOfCapability, OneOfDataElement, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("valueId")
  private Reference valueId = null;

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  public Property value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(description = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Property valueId(Reference valueId) {
    this.valueId = valueId;
    return this;
  }

  /**
   * Get valueId
   * @return valueId
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getValueId() {
    return valueId;
  }

  public void setValueId(Reference valueId) {
    this.valueId = valueId;
  }

  public Property valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * Get valueType
   * @return valueType
   **/
  @Schema(description = "")
  
    @Valid
    public ValueTypeEnum getValueType() {
    return valueType;
  }

  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Property property = (Property) o;
    return Objects.equals(this.value, property.value) &&
        Objects.equals(this.valueId, property.valueId) &&
        Objects.equals(this.valueType, property.valueType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueId, valueType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Property {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
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
