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
 * SubjectAttributes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class SubjectAttributes   {
  @JsonProperty("subjectAttributes")
  @Valid
  private List<Reference> subjectAttributes = null;

  public SubjectAttributes subjectAttributes(List<Reference> subjectAttributes) {
    this.subjectAttributes = subjectAttributes;
    return this;
  }

  public SubjectAttributes addSubjectAttributesItem(Reference subjectAttributesItem) {
    if (this.subjectAttributes == null) {
      this.subjectAttributes = new ArrayList<>();
    }
    this.subjectAttributes.add(subjectAttributesItem);
    return this;
  }

  /**
   * Get subjectAttributes
   * @return subjectAttributes
   **/
  @Schema(description = "")
      @Valid
  @Size(min=1)   public List<Reference> getSubjectAttributes() {
    return subjectAttributes;
  }

  public void setSubjectAttributes(List<Reference> subjectAttributes) {
    this.subjectAttributes = subjectAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectAttributes subjectAttributes = (SubjectAttributes) o;
    return Objects.equals(this.subjectAttributes, subjectAttributes.subjectAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjectAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectAttributes {\n");
    
    sb.append("    subjectAttributes: ").append(toIndentedString(subjectAttributes)).append("\n");
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
