package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Range
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Range extends SubmodelElement implements OneOfCapability, OneOfDataElement, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("max")
  private String max = null;

  @JsonProperty("min")
  private String min = null;

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  public Range max(String max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
   **/
  @Schema(description = "")
  
    public String getMax() {
    return max;
  }

  public void setMax(String max) {
    this.max = max;
  }

  public Range min(String min) {
    this.min = min;
    return this;
  }

  /**
   * Get min
   * @return min
   **/
  @Schema(description = "")
  
    public String getMin() {
    return min;
  }

  public void setMin(String min) {
    this.min = min;
  }

  public Range valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * Get valueType
   * @return valueType
   **/
  @Schema(required = true, description = "")
      @NotNull

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
    Range range = (Range) o;
    return Objects.equals(this.max, range.max) &&
        Objects.equals(this.min, range.min) &&
        Objects.equals(this.valueType, range.valueType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, min, valueType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Range {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
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
