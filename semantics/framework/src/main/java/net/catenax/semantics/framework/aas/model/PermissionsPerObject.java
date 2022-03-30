package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PermissionsPerObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PermissionsPerObject   {
  @JsonProperty("object")
  private Reference object = null;

  @JsonProperty("permission")
  @Valid
  private List<Permission> permission = null;

  @JsonProperty("targetObjectAttributes")
  private ObjectAttributes targetObjectAttributes = null;

  public PermissionsPerObject object(Reference object) {
    this.object = object;
    return this;
  }

  /**
   * Get object
   * @return object
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getObject() {
    return object;
  }

  public void setObject(Reference object) {
    this.object = object;
  }

  public PermissionsPerObject permission(List<Permission> permission) {
    this.permission = permission;
    return this;
  }

  public PermissionsPerObject addPermissionItem(Permission permissionItem) {
    if (this.permission == null) {
      this.permission = new ArrayList<>();
    }
    this.permission.add(permissionItem);
    return this;
  }

  /**
   * Get permission
   * @return permission
   **/
  @Schema(description = "")
      @Valid
    public List<Permission> getPermission() {
    return permission;
  }

  public void setPermission(List<Permission> permission) {
    this.permission = permission;
  }

  public PermissionsPerObject targetObjectAttributes(ObjectAttributes targetObjectAttributes) {
    this.targetObjectAttributes = targetObjectAttributes;
    return this;
  }

  /**
   * Get targetObjectAttributes
   * @return targetObjectAttributes
   **/
  @Schema(description = "")
  
    @Valid
    public ObjectAttributes getTargetObjectAttributes() {
    return targetObjectAttributes;
  }

  public void setTargetObjectAttributes(ObjectAttributes targetObjectAttributes) {
    this.targetObjectAttributes = targetObjectAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionsPerObject permissionsPerObject = (PermissionsPerObject) o;
    return Objects.equals(this.object, permissionsPerObject.object) &&
        Objects.equals(this.permission, permissionsPerObject.permission) &&
        Objects.equals(this.targetObjectAttributes, permissionsPerObject.targetObjectAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object, permission, targetObjectAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionsPerObject {\n");
    
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    targetObjectAttributes: ").append(toIndentedString(targetObjectAttributes)).append("\n");
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
