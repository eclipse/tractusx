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
 * PolicyInformationPoints
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PolicyInformationPoints   {
  @JsonProperty("externalInformationPoint")
  private Boolean externalInformationPoint = null;

  @JsonProperty("internalInformationPoint")
  @Valid
  private List<Reference> internalInformationPoint = null;

  public PolicyInformationPoints externalInformationPoint(Boolean externalInformationPoint) {
    this.externalInformationPoint = externalInformationPoint;
    return this;
  }

  /**
   * Get externalInformationPoint
   * @return externalInformationPoint
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isExternalInformationPoint() {
    return externalInformationPoint;
  }

  public void setExternalInformationPoint(Boolean externalInformationPoint) {
    this.externalInformationPoint = externalInformationPoint;
  }

  public PolicyInformationPoints internalInformationPoint(List<Reference> internalInformationPoint) {
    this.internalInformationPoint = internalInformationPoint;
    return this;
  }

  public PolicyInformationPoints addInternalInformationPointItem(Reference internalInformationPointItem) {
    if (this.internalInformationPoint == null) {
      this.internalInformationPoint = new ArrayList<>();
    }
    this.internalInformationPoint.add(internalInformationPointItem);
    return this;
  }

  /**
   * Get internalInformationPoint
   * @return internalInformationPoint
   **/
  @Schema(description = "")
      @Valid
    public List<Reference> getInternalInformationPoint() {
    return internalInformationPoint;
  }

  public void setInternalInformationPoint(List<Reference> internalInformationPoint) {
    this.internalInformationPoint = internalInformationPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyInformationPoints policyInformationPoints = (PolicyInformationPoints) o;
    return Objects.equals(this.externalInformationPoint, policyInformationPoints.externalInformationPoint) &&
        Objects.equals(this.internalInformationPoint, policyInformationPoints.internalInformationPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalInformationPoint, internalInformationPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyInformationPoints {\n");
    
    sb.append("    externalInformationPoint: ").append(toIndentedString(externalInformationPoint)).append("\n");
    sb.append("    internalInformationPoint: ").append(toIndentedString(internalInformationPoint)).append("\n");
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
