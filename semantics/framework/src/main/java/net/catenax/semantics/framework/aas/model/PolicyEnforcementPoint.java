package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * PolicyEnforcementPoint
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PolicyEnforcementPoint   {
  @JsonProperty("externalPolicyEnforcementPoint")
  private Boolean externalPolicyEnforcementPoint = null;

  public PolicyEnforcementPoint externalPolicyEnforcementPoint(Boolean externalPolicyEnforcementPoint) {
    this.externalPolicyEnforcementPoint = externalPolicyEnforcementPoint;
    return this;
  }

  /**
   * Get externalPolicyEnforcementPoint
   * @return externalPolicyEnforcementPoint
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isExternalPolicyEnforcementPoint() {
    return externalPolicyEnforcementPoint;
  }

  public void setExternalPolicyEnforcementPoint(Boolean externalPolicyEnforcementPoint) {
    this.externalPolicyEnforcementPoint = externalPolicyEnforcementPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyEnforcementPoint policyEnforcementPoint = (PolicyEnforcementPoint) o;
    return Objects.equals(this.externalPolicyEnforcementPoint, policyEnforcementPoint.externalPolicyEnforcementPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalPolicyEnforcementPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyEnforcementPoint {\n");
    
    sb.append("    externalPolicyEnforcementPoint: ").append(toIndentedString(externalPolicyEnforcementPoint)).append("\n");
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
