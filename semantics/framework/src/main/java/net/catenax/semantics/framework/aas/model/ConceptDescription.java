package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ConceptDescription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class ConceptDescription extends Identifiable  {
  @JsonProperty("embeddedDataSpecifications")
  @Valid
  private List<EmbeddedDataSpecification> embeddedDataSpecifications = null;

  @JsonProperty("isCaseOf")
  @Valid
  private List<Reference> isCaseOf = null;

  public ConceptDescription embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public ConceptDescription addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
    if (this.embeddedDataSpecifications == null) {
      this.embeddedDataSpecifications = new ArrayList<>();
    }
    this.embeddedDataSpecifications.add(embeddedDataSpecificationsItem);
    return this;
  }

  /**
   * Get embeddedDataSpecifications
   * @return embeddedDataSpecifications
   **/
  @Schema(description = "")
      @Valid
    public List<EmbeddedDataSpecification> getEmbeddedDataSpecifications() {
    return embeddedDataSpecifications;
  }

  public void setEmbeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
  }

  public ConceptDescription isCaseOf(List<Reference> isCaseOf) {
    this.isCaseOf = isCaseOf;
    return this;
  }

  public ConceptDescription addIsCaseOfItem(Reference isCaseOfItem) {
    if (this.isCaseOf == null) {
      this.isCaseOf = new ArrayList<>();
    }
    this.isCaseOf.add(isCaseOfItem);
    return this;
  }

  /**
   * Get isCaseOf
   * @return isCaseOf
   **/
  @Schema(description = "")
      @Valid
    public List<Reference> getIsCaseOf() {
    return isCaseOf;
  }

  public void setIsCaseOf(List<Reference> isCaseOf) {
    this.isCaseOf = isCaseOf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConceptDescription conceptDescription = (ConceptDescription) o;
    return Objects.equals(this.embeddedDataSpecifications, conceptDescription.embeddedDataSpecifications) &&
        Objects.equals(this.isCaseOf, conceptDescription.isCaseOf) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(embeddedDataSpecifications, isCaseOf, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConceptDescription {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    isCaseOf: ").append(toIndentedString(isCaseOf)).append("\n");
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
