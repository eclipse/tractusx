package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AssetAdministrationShellEnvironment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AssetAdministrationShellEnvironment   {
  @JsonProperty("assetAdministrationShells")
  @Valid
  private List<AssetAdministrationShell> assetAdministrationShells = null;

  @JsonProperty("conceptDescriptions")
  @Valid
  private List<ConceptDescription> conceptDescriptions = null;

  @JsonProperty("submodels")
  @Valid
  private List<Submodel> submodels = null;

  public AssetAdministrationShellEnvironment assetAdministrationShells(List<AssetAdministrationShell> assetAdministrationShells) {
    this.assetAdministrationShells = assetAdministrationShells;
    return this;
  }

  public AssetAdministrationShellEnvironment addAssetAdministrationShellsItem(AssetAdministrationShell assetAdministrationShellsItem) {
    if (this.assetAdministrationShells == null) {
      this.assetAdministrationShells = new ArrayList<>();
    }
    this.assetAdministrationShells.add(assetAdministrationShellsItem);
    return this;
  }

  /**
   * Get assetAdministrationShells
   * @return assetAdministrationShells
   **/
  @Schema(description = "")
      @Valid
    public List<AssetAdministrationShell> getAssetAdministrationShells() {
    return assetAdministrationShells;
  }

  public void setAssetAdministrationShells(List<AssetAdministrationShell> assetAdministrationShells) {
    this.assetAdministrationShells = assetAdministrationShells;
  }

  public AssetAdministrationShellEnvironment conceptDescriptions(List<ConceptDescription> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
    return this;
  }

  public AssetAdministrationShellEnvironment addConceptDescriptionsItem(ConceptDescription conceptDescriptionsItem) {
    if (this.conceptDescriptions == null) {
      this.conceptDescriptions = new ArrayList<>();
    }
    this.conceptDescriptions.add(conceptDescriptionsItem);
    return this;
  }

  /**
   * Get conceptDescriptions
   * @return conceptDescriptions
   **/
  @Schema(description = "")
      @Valid
    public List<ConceptDescription> getConceptDescriptions() {
    return conceptDescriptions;
  }

  public void setConceptDescriptions(List<ConceptDescription> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
  }

  public AssetAdministrationShellEnvironment submodels(List<Submodel> submodels) {
    this.submodels = submodels;
    return this;
  }

  public AssetAdministrationShellEnvironment addSubmodelsItem(Submodel submodelsItem) {
    if (this.submodels == null) {
      this.submodels = new ArrayList<>();
    }
    this.submodels.add(submodelsItem);
    return this;
  }

  /**
   * Get submodels
   * @return submodels
   **/
  @Schema(description = "")
      @Valid
    public List<Submodel> getSubmodels() {
    return submodels;
  }

  public void setSubmodels(List<Submodel> submodels) {
    this.submodels = submodels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShellEnvironment assetAdministrationShellEnvironment = (AssetAdministrationShellEnvironment) o;
    return Objects.equals(this.assetAdministrationShells, assetAdministrationShellEnvironment.assetAdministrationShells) &&
        Objects.equals(this.conceptDescriptions, assetAdministrationShellEnvironment.conceptDescriptions) &&
        Objects.equals(this.submodels, assetAdministrationShellEnvironment.submodels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetAdministrationShells, conceptDescriptions, submodels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShellEnvironment {\n");
    
    sb.append("    assetAdministrationShells: ").append(toIndentedString(assetAdministrationShells)).append("\n");
    sb.append("    conceptDescriptions: ").append(toIndentedString(conceptDescriptions)).append("\n");
    sb.append("    submodels: ").append(toIndentedString(submodels)).append("\n");
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
