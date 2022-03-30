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
 * AssetAdministrationShell
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AssetAdministrationShell extends Identifiable  {
  @JsonProperty("embeddedDataSpecifications")
  @Valid
  private List<EmbeddedDataSpecification> embeddedDataSpecifications = null;

  @JsonProperty("assetInformation")
  private AssetInformation assetInformation = null;

  @JsonProperty("derivedFrom")
  private Reference derivedFrom = null;

  @JsonProperty("security")
  private Security security = null;

  @JsonProperty("submodels")
  @Valid
  private List<Reference> submodels = null;

  @JsonProperty("views")
  @Valid
  private List<View> views = null;

  public AssetAdministrationShell embeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
    this.embeddedDataSpecifications = embeddedDataSpecifications;
    return this;
  }

  public AssetAdministrationShell addEmbeddedDataSpecificationsItem(EmbeddedDataSpecification embeddedDataSpecificationsItem) {
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

  public AssetAdministrationShell assetInformation(AssetInformation assetInformation) {
    this.assetInformation = assetInformation;
    return this;
  }

  /**
   * Get assetInformation
   * @return assetInformation
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AssetInformation getAssetInformation() {
    return assetInformation;
  }

  public void setAssetInformation(AssetInformation assetInformation) {
    this.assetInformation = assetInformation;
  }

  public AssetAdministrationShell derivedFrom(Reference derivedFrom) {
    this.derivedFrom = derivedFrom;
    return this;
  }

  /**
   * Get derivedFrom
   * @return derivedFrom
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getDerivedFrom() {
    return derivedFrom;
  }

  public void setDerivedFrom(Reference derivedFrom) {
    this.derivedFrom = derivedFrom;
  }

  public AssetAdministrationShell security(Security security) {
    this.security = security;
    return this;
  }

  /**
   * Get security
   * @return security
   **/
  @Schema(description = "")
  
    @Valid
    public Security getSecurity() {
    return security;
  }

  public void setSecurity(Security security) {
    this.security = security;
  }

  public AssetAdministrationShell submodels(List<Reference> submodels) {
    this.submodels = submodels;
    return this;
  }

  public AssetAdministrationShell addSubmodelsItem(Reference submodelsItem) {
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
    public List<Reference> getSubmodels() {
    return submodels;
  }

  public void setSubmodels(List<Reference> submodels) {
    this.submodels = submodels;
  }

  public AssetAdministrationShell views(List<View> views) {
    this.views = views;
    return this;
  }

  public AssetAdministrationShell addViewsItem(View viewsItem) {
    if (this.views == null) {
      this.views = new ArrayList<>();
    }
    this.views.add(viewsItem);
    return this;
  }

  /**
   * Get views
   * @return views
   **/
  @Schema(description = "")
      @Valid
    public List<View> getViews() {
    return views;
  }

  public void setViews(List<View> views) {
    this.views = views;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShell assetAdministrationShell = (AssetAdministrationShell) o;
    return Objects.equals(this.embeddedDataSpecifications, assetAdministrationShell.embeddedDataSpecifications) &&
        Objects.equals(this.assetInformation, assetAdministrationShell.assetInformation) &&
        Objects.equals(this.derivedFrom, assetAdministrationShell.derivedFrom) &&
        Objects.equals(this.security, assetAdministrationShell.security) &&
        Objects.equals(this.submodels, assetAdministrationShell.submodels) &&
        Objects.equals(this.views, assetAdministrationShell.views) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(embeddedDataSpecifications, assetInformation, derivedFrom, security, submodels, views, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShell {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    embeddedDataSpecifications: ").append(toIndentedString(embeddedDataSpecifications)).append("\n");
    sb.append("    assetInformation: ").append(toIndentedString(assetInformation)).append("\n");
    sb.append("    derivedFrom: ").append(toIndentedString(derivedFrom)).append("\n");
    sb.append("    security: ").append(toIndentedString(security)).append("\n");
    sb.append("    submodels: ").append(toIndentedString(submodels)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
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
