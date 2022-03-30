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
 * ObjectAttributes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class ObjectAttributes   {
  @JsonProperty("objectAttribute")
  @Valid
  private List<Property> objectAttribute = null;

  public ObjectAttributes objectAttribute(List<Property> objectAttribute) {
    this.objectAttribute = objectAttribute;
    return this;
  }

  public ObjectAttributes addObjectAttributeItem(Property objectAttributeItem) {
    if (this.objectAttribute == null) {
      this.objectAttribute = new ArrayList<>();
    }
    this.objectAttribute.add(objectAttributeItem);
    return this;
  }

  /**
   * Get objectAttribute
   * @return objectAttribute
   **/
  @Schema(description = "")
      @Valid
  @Size(min=1)   public List<Property> getObjectAttribute() {
    return objectAttribute;
  }

  public void setObjectAttribute(List<Property> objectAttribute) {
    this.objectAttribute = objectAttribute;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectAttributes objectAttributes = (ObjectAttributes) o;
    return Objects.equals(this.objectAttribute, objectAttributes.objectAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectAttribute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectAttributes {\n");
    
    sb.append("    objectAttribute: ").append(toIndentedString(objectAttribute)).append("\n");
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
