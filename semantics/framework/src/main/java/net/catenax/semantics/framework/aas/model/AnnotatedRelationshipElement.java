package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AnnotatedRelationshipElement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AnnotatedRelationshipElement extends RelationshipElement implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("annotation")
  @Valid
  private List<DataElement> annotation = null;

  public AnnotatedRelationshipElement annotation(List<DataElement> annotation) {
    this.annotation = annotation;
    return this;
  }

  public AnnotatedRelationshipElement addAnnotationItem(DataElement annotationItem) {
    if (this.annotation == null) {
      this.annotation = new ArrayList<>();
    }
    this.annotation.add(annotationItem);
    return this;
  }

  /**
   * Get annotation
   * @return annotation
   **/
  @Schema(description = "")
      @Valid
    public List<DataElement> getAnnotation() {
    return annotation;
  }

  public void setAnnotation(List<DataElement> annotation) {
    this.annotation = annotation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnnotatedRelationshipElement annotatedRelationshipElement = (AnnotatedRelationshipElement) o;
    return Objects.equals(this.annotation, annotatedRelationshipElement.annotation) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annotation, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnotatedRelationshipElement {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
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
