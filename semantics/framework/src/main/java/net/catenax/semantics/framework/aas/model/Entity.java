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
 * Entity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Entity extends SubmodelElement implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("entityType")
  private EntityType entityType = null;

  @JsonProperty("globalAssetId")
  private Reference globalAssetId = null;

  @JsonProperty("specificAssetIds")
  @Valid
  private List<IdentifierKeyValuePair> specificAssetIds = null;

  @JsonProperty("statements")
  @Valid
  private List<SubmodelElement> statements = null;

  public Entity entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Get entityType
   * @return entityType
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public EntityType getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }

  public Entity globalAssetId(Reference globalAssetId) {
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

  public Entity specificAssetIds(List<IdentifierKeyValuePair> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public Entity addSpecificAssetIdsItem(IdentifierKeyValuePair specificAssetIdsItem) {
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

  public Entity statements(List<SubmodelElement> statements) {
    this.statements = statements;
    return this;
  }

  public Entity addStatementsItem(SubmodelElement statementsItem) {
    if (this.statements == null) {
      this.statements = new ArrayList<>();
    }
    this.statements.add(statementsItem);
    return this;
  }

  /**
   * Get statements
   * @return statements
   **/
  @Schema(description = "")
      @Valid
    public List<SubmodelElement> getStatements() {
    return statements;
  }

  public void setStatements(List<SubmodelElement> statements) {
    this.statements = statements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(this.entityType, entity.entityType) &&
        Objects.equals(this.globalAssetId, entity.globalAssetId) &&
        Objects.equals(this.specificAssetIds, entity.specificAssetIds) &&
        Objects.equals(this.statements, entity.statements) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, globalAssetId, specificAssetIds, statements, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    statements: ").append(toIndentedString(statements)).append("\n");
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
