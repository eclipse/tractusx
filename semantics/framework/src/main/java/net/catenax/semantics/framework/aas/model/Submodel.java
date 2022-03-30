/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.aas.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AAS Submodel implementation which also capture the "value" or mixed modes.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")

public class Submodel extends Identifiable  {
  @JsonProperty("embeddedDataSpecifications")
  @Valid
  private List<EmbeddedDataSpecification> embeddedDataSpecifications = null;

  @JsonProperty("qualifiers")
  @Valid
  private List<Constraint> qualifiers = null;

  @JsonProperty("semanticId")
  private OneOfReference semanticId = null;

  @JsonProperty("kind")
  private ModelingKind kind = null;

  @JsonProperty("submodelElements")
  @Valid
  private List<SubmodelElement> submodelElements = null;

  // capture all other fields that jackson does not match
  private Map<String, Object> data = new HashMap<>();

  public Submodel embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public Submodel addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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

  public Submodel qualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public Submodel addQualifiersItem(Constraint qualifiersItem) {
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

  public Submodel semanticId(Reference semanticId) {
    this.semanticId = semanticId;
    return this;
  }

  /**
   * Get semanticId
   * @return semanticId
   **/
  @Schema(description = "")
  
    @Valid
    public OneOfReference getSemanticId() {
    return semanticId;
  }

  public void setSemanticId(OneOfReference semanticId) {
    this.semanticId = semanticId;
  }

  public Submodel kind(ModelingKind kind) {
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

  public Submodel submodelElements(List<SubmodelElement> submodelElements) {
    this.submodelElements = submodelElements;
    return this;
  }

  public Submodel addSubmodelElementsItem(SubmodelElement submodelElementsItem) {
    if (this.submodelElements == null) {
      this.submodelElements = new ArrayList<>();
    }
    this.submodelElements.add(submodelElementsItem);
    return this;
  }

  /**
   * Get submodelElements
   * @return submodelElements
   **/
  @Schema(description = "")
      @Valid
    public List<SubmodelElement> getSubmodelElements() {
    return submodelElements;
  }

  public void setSubmodelElements(List<SubmodelElement> submodelElements) {
    this.submodelElements = submodelElements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Submodel submodel = (Submodel) o;
    return Objects.equals(this.embeddedDataSpecifications, submodel.embeddedDataSpecifications) &&
        Objects.equals(this.qualifiers, submodel.qualifiers) &&
        Objects.equals(this.semanticId, submodel.semanticId) &&
        Objects.equals(this.kind, submodel.kind) &&
        Objects.equals(this.submodelElements, submodel.submodelElements) &&
        Objects.equals(this.data, submodel.data) &&
        super.equals(o);
  }

  // Capture all other fields that Jackson do not match other members
  @JsonAnyGetter
  public Map<String, Object> data() {
    return data;
  }

  @JsonAnySetter
  public void setData(String name, Object value) {
    data.put(name, value);
  }


  @Override
  public int hashCode() {
    return Objects.hash(embeddedDataSpecifications, qualifiers, semanticId, kind, submodelElements, data, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Submodel {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    semanticId: ").append(toIndentedString(semanticId)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    submodelElements: ").append(toIndentedString(submodelElements)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
