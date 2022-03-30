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
 * AccessPermissionRule
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AccessPermissionRule extends Referable  {
  @JsonProperty("qualifiers")
  @Valid
  private List<Constraint> qualifiers = null;

  @JsonProperty("permissionsPerObject")
  @Valid
  private List<PermissionsPerObject> permissionsPerObject = null;

  @JsonProperty("targetSubjectAttributes")
  @Valid
  private List<SubjectAttributes> targetSubjectAttributes = new ArrayList<>();

  public AccessPermissionRule qualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public AccessPermissionRule addQualifiersItem(Constraint qualifiersItem) {
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

  public AccessPermissionRule permissionsPerObject(List<PermissionsPerObject> permissionsPerObject) {
    this.permissionsPerObject = permissionsPerObject;
    return this;
  }

  public AccessPermissionRule addPermissionsPerObjectItem(PermissionsPerObject permissionsPerObjectItem) {
    if (this.permissionsPerObject == null) {
      this.permissionsPerObject = new ArrayList<>();
    }
    this.permissionsPerObject.add(permissionsPerObjectItem);
    return this;
  }

  /**
   * Get permissionsPerObject
   * @return permissionsPerObject
   **/
  @Schema(description = "")
      @Valid
    public List<PermissionsPerObject> getPermissionsPerObject() {
    return permissionsPerObject;
  }

  public void setPermissionsPerObject(List<PermissionsPerObject> permissionsPerObject) {
    this.permissionsPerObject = permissionsPerObject;
  }

  public AccessPermissionRule targetSubjectAttributes(List<SubjectAttributes> targetSubjectAttributes) {
    this.targetSubjectAttributes = targetSubjectAttributes;
    return this;
  }

  public AccessPermissionRule addTargetSubjectAttributesItem(SubjectAttributes targetSubjectAttributesItem) {
    this.targetSubjectAttributes.add(targetSubjectAttributesItem);
    return this;
  }

  /**
   * Get targetSubjectAttributes
   * @return targetSubjectAttributes
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<SubjectAttributes> getTargetSubjectAttributes() {
    return targetSubjectAttributes;
  }

  public void setTargetSubjectAttributes(List<SubjectAttributes> targetSubjectAttributes) {
    this.targetSubjectAttributes = targetSubjectAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessPermissionRule accessPermissionRule = (AccessPermissionRule) o;
    return Objects.equals(this.qualifiers, accessPermissionRule.qualifiers) &&
        Objects.equals(this.permissionsPerObject, accessPermissionRule.permissionsPerObject) &&
        Objects.equals(this.targetSubjectAttributes, accessPermissionRule.targetSubjectAttributes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qualifiers, permissionsPerObject, targetSubjectAttributes, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessPermissionRule {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
    sb.append("    permissionsPerObject: ").append(toIndentedString(permissionsPerObject)).append("\n");
    sb.append("    targetSubjectAttributes: ").append(toIndentedString(targetSubjectAttributes)).append("\n");
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
