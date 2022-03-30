package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Certificate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Certificate   {
  @JsonProperty("blobCertificate")
  private Blob blobCertificate = null;

  @JsonProperty("containedExtension")
  @Valid
  private List<Reference> containedExtension = null;

  @JsonProperty("lastCertificate")
  private Boolean lastCertificate = null;

  public Certificate blobCertificate(Blob blobCertificate) {
    this.blobCertificate = blobCertificate;
    return this;
  }

  /**
   * Get blobCertificate
   * @return blobCertificate
   **/
  @Schema(description = "")
  
    @Valid
    public Blob getBlobCertificate() {
    return blobCertificate;
  }

  public void setBlobCertificate(Blob blobCertificate) {
    this.blobCertificate = blobCertificate;
  }

  public Certificate containedExtension(List<Reference> containedExtension) {
    this.containedExtension = containedExtension;
    return this;
  }

  public Certificate addContainedExtensionItem(Reference containedExtensionItem) {
    if (this.containedExtension == null) {
      this.containedExtension = new ArrayList<>();
    }
    this.containedExtension.add(containedExtensionItem);
    return this;
  }

  /**
   * Get containedExtension
   * @return containedExtension
   **/
  @Schema(description = "")
      @Valid
    public List<Reference> getContainedExtension() {
    return containedExtension;
  }

  public void setContainedExtension(List<Reference> containedExtension) {
    this.containedExtension = containedExtension;
  }

  public Certificate lastCertificate(Boolean lastCertificate) {
    this.lastCertificate = lastCertificate;
    return this;
  }

  /**
   * Get lastCertificate
   * @return lastCertificate
   **/
  @Schema(description = "")
  
    public Boolean isLastCertificate() {
    return lastCertificate;
  }

  public void setLastCertificate(Boolean lastCertificate) {
    this.lastCertificate = lastCertificate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Certificate certificate = (Certificate) o;
    return Objects.equals(this.blobCertificate, certificate.blobCertificate) &&
        Objects.equals(this.containedExtension, certificate.containedExtension) &&
        Objects.equals(this.lastCertificate, certificate.lastCertificate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blobCertificate, containedExtension, lastCertificate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Certificate {\n");
    
    sb.append("    blobCertificate: ").append(toIndentedString(blobCertificate)).append("\n");
    sb.append("    containedExtension: ").append(toIndentedString(containedExtension)).append("\n");
    sb.append("    lastCertificate: ").append(toIndentedString(lastCertificate)).append("\n");
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
