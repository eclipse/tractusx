package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartRelationship;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * List of the relationships with their infos
 */
@Schema(description = "List of the relationships with their infos")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-17T07:10:14.920Z[GMT]")


public class PartRelationshipWithInfos   {
  @JsonProperty("relationships")
  @Valid
  private List<PartRelationship> relationships = null;

  @JsonProperty("partInfos")
  @Valid
  private List<PartInfo> partInfos = null;

  public PartRelationshipWithInfos relationships(List<PartRelationship> relationships) {
    this.relationships = relationships;
    return this;
  }

  public PartRelationshipWithInfos addRelationshipsItem(PartRelationship relationshipsItem) {
    if (this.relationships == null) {
      this.relationships = new ArrayList<PartRelationship>();
    }
    this.relationships.add(relationshipsItem);
    return this;
  }

  /**
   * List of the relationships
   * @return relationships
   **/
  @Schema(description = "List of the relationships")
      @Valid
    public List<PartRelationship> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<PartRelationship> relationships) {
    this.relationships = relationships;
  }

  public PartRelationshipWithInfos partInfos(List<PartInfo> partInfos) {
    this.partInfos = partInfos;
    return this;
  }

  public PartRelationshipWithInfos addPartInfosItem(PartInfo partInfosItem) {
    if (this.partInfos == null) {
      this.partInfos = new ArrayList<PartInfo>();
    }
    this.partInfos.add(partInfosItem);
    return this;
  }

  /**
   * List of part infos
   * @return partInfos
   **/
  @Schema(description = "List of part infos")
      @Valid
    public List<PartInfo> getPartInfos() {
    return partInfos;
  }

  public void setPartInfos(List<PartInfo> partInfos) {
    this.partInfos = partInfos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartRelationshipWithInfos partRelationshipWithInfos = (PartRelationshipWithInfos) o;
    return Objects.equals(this.relationships, partRelationshipWithInfos.relationships) &&
        Objects.equals(this.partInfos, partRelationshipWithInfos.partInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationships, partInfos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartRelationshipWithInfos {\n");
    
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
    sb.append("    partInfos: ").append(toIndentedString(partInfos)).append("\n");
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
