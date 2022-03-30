package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SubmodelElement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class SubmodelElement extends Referable implements OneOfSubmodelElement {
  @JsonProperty("embeddedDataSpecifications")
  @Valid
  private List<EmbeddedDataSpecification> embeddedDataSpecifications = null;

  @JsonProperty("semanticId")
  private Reference semanticId = null;

  @JsonProperty("qualifiers")
  @Valid
  private List<Constraint> qualifiers = null;

  @JsonProperty("kind")
  private ModelingKind kind = null;

  public SubmodelElement embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public SubmodelElement addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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

  public SubmodelElement semanticId(Reference semanticId) {
    this.semanticId = semanticId;
    return this;
  }

  /**
   * Get semanticId
   * @return semanticId
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getSemanticId() {
    return semanticId;
  }

  public void setSemanticId(Reference semanticId) {
    this.semanticId = semanticId;
  }

  public SubmodelElement qualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public SubmodelElement addQualifiersItem(Constraint qualifiersItem) {
    if (this.qualifiers == null) {
      this.qualifiers = new ArrayList<>();
    }
    this.qualifiers.add(qualifiersItem);
    return this;
  }

  /**
   * Get qualifiers
   * @return qualifiers
   **/
  @Schema(description = "")
      @Valid
    public List<Constraint> getQualifiers() {
    return qualifiers;
  }

  public void setQualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
  }

  public SubmodelElement kind(ModelingKind kind) {
    this.kind = kind;
    return this;
  }

  /**
   * Get kind
   * @return kind
   **/
  @Schema(description = "")
  
    @Valid
    public ModelingKind getKind() {
    return kind;
  }

  public void setKind(ModelingKind kind) {
    this.kind = kind;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmodelElement submodelElement = (SubmodelElement) o;
    return Objects.equals(this.embeddedDataSpecifications, submodelElement.embeddedDataSpecifications) &&
        Objects.equals(this.semanticId, submodelElement.semanticId) &&
        Objects.equals(this.qualifiers, submodelElement.qualifiers) &&
        Objects.equals(this.kind, submodelElement.kind) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(embeddedDataSpecifications, semanticId, qualifiers, kind, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmodelElement {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
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
