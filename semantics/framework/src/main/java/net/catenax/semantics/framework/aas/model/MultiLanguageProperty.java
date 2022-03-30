package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MultiLanguageProperty
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class MultiLanguageProperty extends SubmodelElement implements OneOfCapability, OneOfDataElement, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("value")
  @Valid
  private List<LangString> value = null;

  @JsonProperty("valueId")
  private Reference valueId = null;

  public MultiLanguageProperty value(List<LangString> value) {
    this.value = value;
    return this;
  }

  public MultiLanguageProperty addValueItem(LangString valueItem) {
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
    public List<LangString> getValue() {
    return value;
  }

  public void setValue(List<LangString> value) {
    this.value = value;
  }

  public MultiLanguageProperty valueId(Reference valueId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultiLanguageProperty multiLanguageProperty = (MultiLanguageProperty) o;
    return Objects.equals(this.value, multiLanguageProperty.value) &&
        Objects.equals(this.valueId, multiLanguageProperty.valueId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultiLanguageProperty {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
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
