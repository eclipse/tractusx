package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccessControlPolicyPoints
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class AccessControlPolicyPoints   {
  @JsonProperty("policyAdministrationPoint")
  private PolicyAdministrationPoint policyAdministrationPoint = null;

  @JsonProperty("policyDecisionPoint")
  private PolicyDecisionPoint policyDecisionPoint = null;

  @JsonProperty("policyEnforcementPoint")
  private PolicyEnforcementPoint policyEnforcementPoint = null;

  @JsonProperty("policyInformationPoints")
  private PolicyInformationPoints policyInformationPoints = null;

  public AccessControlPolicyPoints policyAdministrationPoint(PolicyAdministrationPoint policyAdministrationPoint) {
    this.policyAdministrationPoint = policyAdministrationPoint;
    return this;
  }

  /**
   * Get policyAdministrationPoint
   * @return policyAdministrationPoint
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public PolicyAdministrationPoint getPolicyAdministrationPoint() {
    return policyAdministrationPoint;
  }

  public void setPolicyAdministrationPoint(PolicyAdministrationPoint policyAdministrationPoint) {
    this.policyAdministrationPoint = policyAdministrationPoint;
  }

  public AccessControlPolicyPoints policyDecisionPoint(PolicyDecisionPoint policyDecisionPoint) {
    this.policyDecisionPoint = policyDecisionPoint;
    return this;
  }

  /**
   * Get policyDecisionPoint
   * @return policyDecisionPoint
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public PolicyDecisionPoint getPolicyDecisionPoint() {
    return policyDecisionPoint;
  }

  public void setPolicyDecisionPoint(PolicyDecisionPoint policyDecisionPoint) {
    this.policyDecisionPoint = policyDecisionPoint;
  }

  public AccessControlPolicyPoints policyEnforcementPoint(PolicyEnforcementPoint policyEnforcementPoint) {
    this.policyEnforcementPoint = policyEnforcementPoint;
    return this;
  }

  /**
   * Get policyEnforcementPoint
   * @return policyEnforcementPoint
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public PolicyEnforcementPoint getPolicyEnforcementPoint() {
    return policyEnforcementPoint;
  }

  public void setPolicyEnforcementPoint(PolicyEnforcementPoint policyEnforcementPoint) {
    this.policyEnforcementPoint = policyEnforcementPoint;
  }

  public AccessControlPolicyPoints policyInformationPoints(PolicyInformationPoints policyInformationPoints) {
    this.policyInformationPoints = policyInformationPoints;
    return this;
  }

  /**
   * Get policyInformationPoints
   * @return policyInformationPoints
   **/
  @Schema(description = "")
  
    @Valid
    public PolicyInformationPoints getPolicyInformationPoints() {
    return policyInformationPoints;
  }

  public void setPolicyInformationPoints(PolicyInformationPoints policyInformationPoints) {
    this.policyInformationPoints = policyInformationPoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessControlPolicyPoints accessControlPolicyPoints = (AccessControlPolicyPoints) o;
    return Objects.equals(this.policyAdministrationPoint, accessControlPolicyPoints.policyAdministrationPoint) &&
        Objects.equals(this.policyDecisionPoint, accessControlPolicyPoints.policyDecisionPoint) &&
        Objects.equals(this.policyEnforcementPoint, accessControlPolicyPoints.policyEnforcementPoint) &&
        Objects.equals(this.policyInformationPoints, accessControlPolicyPoints.policyInformationPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyAdministrationPoint, policyDecisionPoint, policyEnforcementPoint, policyInformationPoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessControlPolicyPoints {\n");
    
    sb.append("    policyAdministrationPoint: ").append(toIndentedString(policyAdministrationPoint)).append("\n");
    sb.append("    policyDecisionPoint: ").append(toIndentedString(policyDecisionPoint)).append("\n");
    sb.append("    policyEnforcementPoint: ").append(toIndentedString(policyEnforcementPoint)).append("\n");
    sb.append("    policyInformationPoints: ").append(toIndentedString(policyInformationPoints)).append("\n");
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
