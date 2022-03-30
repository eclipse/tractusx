package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ValueList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class ValueList   {
  @JsonProperty("valueReferencePairTypes")
  @Valid
  private List<ValueReferencePairType> valueReferencePairTypes = new ArrayList<>();

  public ValueList valueReferencePairTypes(List<ValueReferencePairType> valueReferencePairTypes) {
    this.valueReferencePairTypes = valueReferencePairTypes;
    return this;
  }

  public ValueList addValueReferencePairTypesItem(ValueReferencePairType valueReferencePairTypesItem) {
    this.valueReferencePairTypes.add(valueReferencePairTypesItem);
    return this;
  }

  /**
   * Get valueReferencePairTypes
   * @return valueReferencePairTypes
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<ValueReferencePairType> getValueReferencePairTypes() {
    return valueReferencePairTypes;
  }

  public void setValueReferencePairTypes(List<ValueReferencePairType> valueReferencePairTypes) {
    this.valueReferencePairTypes = valueReferencePairTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValueList valueList = (ValueList) o;
    return Objects.equals(this.valueReferencePairTypes, valueList.valueReferencePairTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueReferencePairTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValueList {\n");
    
    sb.append("    valueReferencePairTypes: ").append(toIndentedString(valueReferencePairTypes)).append("\n");
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
