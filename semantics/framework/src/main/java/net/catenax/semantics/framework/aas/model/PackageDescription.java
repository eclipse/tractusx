package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PackageDescription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PackageDescription   {
  @JsonProperty("aasIds")
  @Valid
  private List<String> aasIds = null;

  @JsonProperty("packageId")
  private String packageId = null;

  public PackageDescription aasIds(List<String> aasIds) {
    this.aasIds = aasIds;
    return this;
  }

  public PackageDescription addAasIdsItem(String aasIdsItem) {
    if (this.aasIds == null) {
      this.aasIds = new ArrayList<>();
    }
    this.aasIds.add(aasIdsItem);
    return this;
  }

  /**
   * Get aasIds
   * @return aasIds
   **/
  @Schema(description = "")
  
    public List<String> getAasIds() {
    return aasIds;
  }

  public void setAasIds(List<String> aasIds) {
    this.aasIds = aasIds;
  }

  public PackageDescription packageId(String packageId) {
    this.packageId = packageId;
    return this;
  }

  /**
   * Get packageId
   * @return packageId
   **/
  @Schema(description = "")
  
    public String getPackageId() {
    return packageId;
  }

  public void setPackageId(String packageId) {
    this.packageId = packageId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageDescription packageDescription = (PackageDescription) o;
    return Objects.equals(this.aasIds, packageDescription.aasIds) &&
        Objects.equals(this.packageId, packageDescription.packageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aasIds, packageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageDescription {\n");
    
    sb.append("    aasIds: ").append(toIndentedString(aasIds)).append("\n");
    sb.append("    packageId: ").append(toIndentedString(packageId)).append("\n");
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
