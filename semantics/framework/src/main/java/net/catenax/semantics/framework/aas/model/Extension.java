package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Extension
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Extension extends HasSemantics  {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("refersTo")
  private Reference refersTo = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  public Extension name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Extension refersTo(Reference refersTo) {
    this.refersTo = refersTo;
    return this;
  }

  /**
   * Get refersTo
   * @return refersTo
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getRefersTo() {
    return refersTo;
  }

  public void setRefersTo(Reference refersTo) {
    this.refersTo = refersTo;
  }

  public Extension value(String value) {
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

  public Extension valueType(ValueTypeEnum valueType) {
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
    Extension extension = (Extension) o;
    return Objects.equals(this.name, extension.name) &&
        Objects.equals(this.refersTo, extension.refersTo) &&
        Objects.equals(this.value, extension.value) &&
        Objects.equals(this.valueType, extension.valueType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, refersTo, value, valueType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Extension {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    refersTo: ").append(toIndentedString(refersTo)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
