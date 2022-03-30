package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * PolicyDecisionPoint
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PolicyDecisionPoint   {
  @JsonProperty("externalPolicyDecisionPoints")
  private Boolean externalPolicyDecisionPoints = null;

  public PolicyDecisionPoint externalPolicyDecisionPoints(Boolean externalPolicyDecisionPoints) {
    this.externalPolicyDecisionPoints = externalPolicyDecisionPoints;
    return this;
  }

  /**
   * Get externalPolicyDecisionPoints
   * @return externalPolicyDecisionPoints
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isExternalPolicyDecisionPoints() {
    return externalPolicyDecisionPoints;
  }

  public void setExternalPolicyDecisionPoints(Boolean externalPolicyDecisionPoints) {
    this.externalPolicyDecisionPoints = externalPolicyDecisionPoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyDecisionPoint policyDecisionPoint = (PolicyDecisionPoint) o;
    return Objects.equals(this.externalPolicyDecisionPoints, policyDecisionPoint.externalPolicyDecisionPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalPolicyDecisionPoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyDecisionPoint {\n");
    
    sb.append("    externalPolicyDecisionPoints: ").append(toIndentedString(externalPolicyDecisionPoints)).append("\n");
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
