package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AccessControl
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AccessControl   {
  @JsonProperty("accessPermissionRule")
  @Valid
  private List<AccessPermissionRule> accessPermissionRule = null;

  @JsonProperty("defaultEnvironmentAttributes")
  private Reference defaultEnvironmentAttributes = null;

  @JsonProperty("defaultPermissions")
  private Reference defaultPermissions = null;

  @JsonProperty("defaultSubjectAttributes")
  private Reference defaultSubjectAttributes = null;

  @JsonProperty("selectableEnvironmentAttributes")
  private Reference selectableEnvironmentAttributes = null;

  @JsonProperty("selectablePermissions")
  private Reference selectablePermissions = null;

  @JsonProperty("selectableSubjectAttributes")
  private Reference selectableSubjectAttributes = null;

  public AccessControl accessPermissionRule(List<AccessPermissionRule> accessPermissionRule) {
    this.accessPermissionRule = accessPermissionRule;
    return this;
  }

  public AccessControl addAccessPermissionRuleItem(AccessPermissionRule accessPermissionRuleItem) {
    if (this.accessPermissionRule == null) {
      this.accessPermissionRule = new ArrayList<>();
    }
    this.accessPermissionRule.add(accessPermissionRuleItem);
    return this;
  }

  /**
   * Get accessPermissionRule
   * @return accessPermissionRule
   **/
  @Schema(description = "")
      @Valid
    public List<AccessPermissionRule> getAccessPermissionRule() {
    return accessPermissionRule;
  }

  public void setAccessPermissionRule(List<AccessPermissionRule> accessPermissionRule) {
    this.accessPermissionRule = accessPermissionRule;
  }

  public AccessControl defaultEnvironmentAttributes(Reference defaultEnvironmentAttributes) {
    this.defaultEnvironmentAttributes = defaultEnvironmentAttributes;
    return this;
  }

  /**
   * Get defaultEnvironmentAttributes
   * @return defaultEnvironmentAttributes
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getDefaultEnvironmentAttributes() {
    return defaultEnvironmentAttributes;
  }

  public void setDefaultEnvironmentAttributes(Reference defaultEnvironmentAttributes) {
    this.defaultEnvironmentAttributes = defaultEnvironmentAttributes;
  }

  public AccessControl defaultPermissions(Reference defaultPermissions) {
    this.defaultPermissions = defaultPermissions;
    return this;
  }

  /**
   * Get defaultPermissions
   * @return defaultPermissions
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getDefaultPermissions() {
    return defaultPermissions;
  }

  public void setDefaultPermissions(Reference defaultPermissions) {
    this.defaultPermissions = defaultPermissions;
  }

  public AccessControl defaultSubjectAttributes(Reference defaultSubjectAttributes) {
    this.defaultSubjectAttributes = defaultSubjectAttributes;
    return this;
  }

  /**
   * Get defaultSubjectAttributes
   * @return defaultSubjectAttributes
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getDefaultSubjectAttributes() {
    return defaultSubjectAttributes;
  }

  public void setDefaultSubjectAttributes(Reference defaultSubjectAttributes) {
    this.defaultSubjectAttributes = defaultSubjectAttributes;
  }

  public AccessControl selectableEnvironmentAttributes(Reference selectableEnvironmentAttributes) {
    this.selectableEnvironmentAttributes = selectableEnvironmentAttributes;
    return this;
  }

  /**
   * Get selectableEnvironmentAttributes
   * @return selectableEnvironmentAttributes
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getSelectableEnvironmentAttributes() {
    return selectableEnvironmentAttributes;
  }

  public void setSelectableEnvironmentAttributes(Reference selectableEnvironmentAttributes) {
    this.selectableEnvironmentAttributes = selectableEnvironmentAttributes;
  }

  public AccessControl selectablePermissions(Reference selectablePermissions) {
    this.selectablePermissions = selectablePermissions;
    return this;
  }

  /**
   * Get selectablePermissions
   * @return selectablePermissions
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getSelectablePermissions() {
    return selectablePermissions;
  }

  public void setSelectablePermissions(Reference selectablePermissions) {
    this.selectablePermissions = selectablePermissions;
  }

  public AccessControl selectableSubjectAttributes(Reference selectableSubjectAttributes) {
    this.selectableSubjectAttributes = selectableSubjectAttributes;
    return this;
  }

  /**
   * Get selectableSubjectAttributes
   * @return selectableSubjectAttributes
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getSelectableSubjectAttributes() {
    return selectableSubjectAttributes;
  }

  public void setSelectableSubjectAttributes(Reference selectableSubjectAttributes) {
    this.selectableSubjectAttributes = selectableSubjectAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessControl accessControl = (AccessControl) o;
    return Objects.equals(this.accessPermissionRule, accessControl.accessPermissionRule) &&
        Objects.equals(this.defaultEnvironmentAttributes, accessControl.defaultEnvironmentAttributes) &&
        Objects.equals(this.defaultPermissions, accessControl.defaultPermissions) &&
        Objects.equals(this.defaultSubjectAttributes, accessControl.defaultSubjectAttributes) &&
        Objects.equals(this.selectableEnvironmentAttributes, accessControl.selectableEnvironmentAttributes) &&
        Objects.equals(this.selectablePermissions, accessControl.selectablePermissions) &&
        Objects.equals(this.selectableSubjectAttributes, accessControl.selectableSubjectAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessPermissionRule, defaultEnvironmentAttributes, defaultPermissions, defaultSubjectAttributes, selectableEnvironmentAttributes, selectablePermissions, selectableSubjectAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessControl {\n");
    
    sb.append("    accessPermissionRule: ").append(toIndentedString(accessPermissionRule)).append("\n");
    sb.append("    defaultEnvironmentAttributes: ").append(toIndentedString(defaultEnvironmentAttributes)).append("\n");
    sb.append("    defaultPermissions: ").append(toIndentedString(defaultPermissions)).append("\n");
    sb.append("    defaultSubjectAttributes: ").append(toIndentedString(defaultSubjectAttributes)).append("\n");
    sb.append("    selectableEnvironmentAttributes: ").append(toIndentedString(selectableEnvironmentAttributes)).append("\n");
    sb.append("    selectablePermissions: ").append(toIndentedString(selectablePermissions)).append("\n");
    sb.append("    selectableSubjectAttributes: ").append(toIndentedString(selectableSubjectAttributes)).append("\n");
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
