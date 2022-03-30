package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssetInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AssetInformation   {
  @JsonProperty("assetKind")
  private AssetKind assetKind = null;

  @JsonProperty("billOfMaterial")
  @Valid
  private List<Reference> billOfMaterial = null;

  @JsonProperty("globalAssetId")
  private Reference globalAssetId = null;

  @JsonProperty("specificAssetIds")
  @Valid
  private List<IdentifierKeyValuePair> specificAssetIds = null;

  @JsonProperty("thumbnail")
  private File thumbnail = null;

  public AssetInformation assetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
    return this;
  }

  /**
   * Get assetKind
   * @return assetKind
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AssetKind getAssetKind() {
    return assetKind;
  }

  public void setAssetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
  }

  public AssetInformation billOfMaterial(List<Reference> billOfMaterial) {
    this.billOfMaterial = billOfMaterial;
    return this;
  }

  public AssetInformation addBillOfMaterialItem(Reference billOfMaterialItem) {
    if (this.billOfMaterial == null) {
      this.billOfMaterial = new ArrayList<>();
    }
    this.billOfMaterial.add(billOfMaterialItem);
    return this;
  }

  /**
   * Get billOfMaterial
   * @return billOfMaterial
   **/
  @Schema(description = "")
      @Valid
    public List<Reference> getBillOfMaterial() {
    return billOfMaterial;
  }

  public void setBillOfMaterial(List<Reference> billOfMaterial) {
    this.billOfMaterial = billOfMaterial;
  }

  public AssetInformation globalAssetId(Reference globalAssetId) {
    this.globalAssetId = globalAssetId;
    return this;
  }

  /**
   * Get globalAssetId
   * @return globalAssetId
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getGlobalAssetId() {
    return globalAssetId;
  }

  public void setGlobalAssetId(Reference globalAssetId) {
    this.globalAssetId = globalAssetId;
  }

  public AssetInformation specificAssetIds(List<IdentifierKeyValuePair> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public AssetInformation addSpecificAssetIdsItem(IdentifierKeyValuePair specificAssetIdsItem) {
    if (this.specificAssetIds == null) {
      this.specificAssetIds = new ArrayList<>();
    }
    this.specificAssetIds.add(specificAssetIdsItem);
    return this;
  }

  /**
   * Get specificAssetIds
   * @return specificAssetIds
   **/
  @Schema(description = "")
      @Valid
    public List<IdentifierKeyValuePair> getSpecificAssetIds() {
    return specificAssetIds;
  }

  public void setSpecificAssetIds(List<IdentifierKeyValuePair> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
  }

  public AssetInformation thumbnail(File thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

  /**
   * Get thumbnail
   * @return thumbnail
   **/
  @Schema(description = "")
  
    @Valid
    public File getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(File thumbnail) {
    this.thumbnail = thumbnail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetInformation assetInformation = (AssetInformation) o;
    return Objects.equals(this.assetKind, assetInformation.assetKind) &&
        Objects.equals(this.billOfMaterial, assetInformation.billOfMaterial) &&
        Objects.equals(this.globalAssetId, assetInformation.globalAssetId) &&
        Objects.equals(this.specificAssetIds, assetInformation.specificAssetIds) &&
        Objects.equals(this.thumbnail, assetInformation.thumbnail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetKind, billOfMaterial, globalAssetId, specificAssetIds, thumbnail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetInformation {\n");
    
    sb.append("    assetKind: ").append(toIndentedString(assetKind)).append("\n");
    sb.append("    billOfMaterial: ").append(toIndentedString(billOfMaterial)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
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
