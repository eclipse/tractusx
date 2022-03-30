package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Qualifier
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Qualifier extends HasSemantics implements OneOfConstraint {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("valueId")
  private Reference valueId = null;

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  @JsonProperty("type")
  private String type = null;

  public Qualifier value(String value) {
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

  public Qualifier valueId(Reference valueId) {
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

  public Qualifier valueType(ValueTypeEnum valueType) {
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

  public Qualifier type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Qualifier qualifier = (Qualifier) o;
    return Objects.equals(this.value, qualifier.value) &&
        Objects.equals(this.valueId, qualifier.valueId) &&
        Objects.equals(this.valueType, qualifier.valueType) &&
        Objects.equals(this.type, qualifier.type) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueId, valueType, type, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Qualifier {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
