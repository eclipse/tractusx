package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PackagesBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class PackagesBody   {
  @JsonProperty("aasIds")
  @Valid
  private List<String> aasIds = null;

  @JsonProperty("file")
  private Resource file = null;

  @JsonProperty("fileName")
  private String fileName = null;

  public PackagesBody aasIds(List<String> aasIds) {
    this.aasIds = aasIds;
    return this;
  }

  public PackagesBody addAasIdsItem(String aasIdsItem) {
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

  public PackagesBody file(Resource file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   * @return file
   **/
  @Schema(description = "")
  
    @Valid
    public Resource getFile() {
    return file;
  }

  public void setFile(Resource file) {
    this.file = file;
  }

  public PackagesBody fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Get fileName
   * @return fileName
   **/
  @Schema(description = "")
  
    public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackagesBody packagesBody = (PackagesBody) o;
    return Objects.equals(this.aasIds, packagesBody.aasIds) &&
        Objects.equals(this.file, packagesBody.file) &&
        Objects.equals(this.fileName, packagesBody.fileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aasIds, file, fileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackagesBody {\n");
    
    sb.append("    aasIds: ").append(toIndentedString(aasIds)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
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
