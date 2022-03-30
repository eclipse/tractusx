package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Permission
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Permission   {
  /**
   * Gets or Sets kindOfPermission
   */
  public enum KindOfPermissionEnum {
    ALLOW("Allow"),
    
    DENY("Deny"),
    
    NOTAPPLICABLE("NotApplicable"),
    
    UNDEFINED("Undefined");

    private String value;

    KindOfPermissionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KindOfPermissionEnum fromValue(String text) {
      for (KindOfPermissionEnum b : KindOfPermissionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("kindOfPermission")
  private KindOfPermissionEnum kindOfPermission = null;

  @JsonProperty("permission")
  private Reference permission = null;

  public Permission kindOfPermission(KindOfPermissionEnum kindOfPermission) {
    this.kindOfPermission = kindOfPermission;
    return this;
  }

  /**
   * Get kindOfPermission
   * @return kindOfPermission
   **/
  @Schema(required = true, description = "")
      @NotNull

    public KindOfPermissionEnum getKindOfPermission() {
    return kindOfPermission;
  }

  public void setKindOfPermission(KindOfPermissionEnum kindOfPermission) {
    this.kindOfPermission = kindOfPermission;
  }

  public Permission permission(Reference permission) {
    this.permission = permission;
    return this;
  }

  /**
   * Get permission
   * @return permission
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Reference getPermission() {
    return permission;
  }

  public void setPermission(Reference permission) {
    this.permission = permission;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Permission permission = (Permission) o;
    return Objects.equals(this.kindOfPermission, permission.kindOfPermission) &&
        Objects.equals(this.permission, permission.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kindOfPermission, permission);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Permission {\n");
    
    sb.append("    kindOfPermission: ").append(toIndentedString(kindOfPermission)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
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
