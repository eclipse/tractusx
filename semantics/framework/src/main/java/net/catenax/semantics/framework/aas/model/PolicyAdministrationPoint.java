package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PolicyAdministrationPoint
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PolicyAdministrationPoint   {
  @JsonProperty("externalAccessControl")
  private Boolean externalAccessControl = null;

  @JsonProperty("localAccessControl")
  private AccessControl localAccessControl = null;

  public PolicyAdministrationPoint externalAccessControl(Boolean externalAccessControl) {
    this.externalAccessControl = externalAccessControl;
    return this;
  }

  /**
   * Get externalAccessControl
   * @return externalAccessControl
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isExternalAccessControl() {
    return externalAccessControl;
  }

  public void setExternalAccessControl(Boolean externalAccessControl) {
    this.externalAccessControl = externalAccessControl;
  }

  public PolicyAdministrationPoint localAccessControl(AccessControl localAccessControl) {
    this.localAccessControl = localAccessControl;
    return this;
  }

  /**
   * Get localAccessControl
   * @return localAccessControl
   **/
  @Schema(description = "")
  
    @Valid
    public AccessControl getLocalAccessControl() {
    return localAccessControl;
  }

  public void setLocalAccessControl(AccessControl localAccessControl) {
    this.localAccessControl = localAccessControl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyAdministrationPoint policyAdministrationPoint = (PolicyAdministrationPoint) o;
    return Objects.equals(this.externalAccessControl, policyAdministrationPoint.externalAccessControl) &&
        Objects.equals(this.localAccessControl, policyAdministrationPoint.localAccessControl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalAccessControl, localAccessControl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyAdministrationPoint {\n");
    
    sb.append("    externalAccessControl: ").append(toIndentedString(externalAccessControl)).append("\n");
    sb.append("    localAccessControl: ").append(toIndentedString(localAccessControl)).append("\n");
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
