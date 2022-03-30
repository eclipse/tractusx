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
 * Security
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Security   {
  @JsonProperty("accessControlPolicyPoints")
  private AccessControlPolicyPoints accessControlPolicyPoints = null;

  @JsonProperty("certificate")
  @Valid
  private List<Certificate> certificate = null;

  @JsonProperty("requiredCertificateExtension")
  @Valid
  private List<Reference> requiredCertificateExtension = null;

  public Security accessControlPolicyPoints(AccessControlPolicyPoints accessControlPolicyPoints) {
    this.accessControlPolicyPoints = accessControlPolicyPoints;
    return this;
  }

  /**
   * Get accessControlPolicyPoints
   * @return accessControlPolicyPoints
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccessControlPolicyPoints getAccessControlPolicyPoints() {
    return accessControlPolicyPoints;
  }

  public void setAccessControlPolicyPoints(AccessControlPolicyPoints accessControlPolicyPoints) {
    this.accessControlPolicyPoints = accessControlPolicyPoints;
  }

  public Security certificate(List<Certificate> certificate) {
    this.certificate = certificate;
    return this;
  }

  public Security addCertificateItem(Certificate certificateItem) {
    if (this.certificate == null) {
      this.certificate = new ArrayList<>();
    }
    this.certificate.add(certificateItem);
    return this;
  }

  /**
   * Get certificate
   * @return certificate
   **/
  @Schema(description = "")
      @Valid
    public List<Certificate> getCertificate() {
    return certificate;
  }

  public void setCertificate(List<Certificate> certificate) {
    this.certificate = certificate;
  }

  public Security requiredCertificateExtension(List<Reference> requiredCertificateExtension) {
    this.requiredCertificateExtension = requiredCertificateExtension;
    return this;
  }

  public Security addRequiredCertificateExtensionItem(Reference requiredCertificateExtensionItem) {
    if (this.requiredCertificateExtension == null) {
      this.requiredCertificateExtension = new ArrayList<>();
    }
    this.requiredCertificateExtension.add(requiredCertificateExtensionItem);
    return this;
  }

  /**
   * Get requiredCertificateExtension
   * @return requiredCertificateExtension
   **/
  @Schema(description = "")
      @Valid
    public List<Reference> getRequiredCertificateExtension() {
    return requiredCertificateExtension;
  }

  public void setRequiredCertificateExtension(List<Reference> requiredCertificateExtension) {
    this.requiredCertificateExtension = requiredCertificateExtension;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Security security = (Security) o;
    return Objects.equals(this.accessControlPolicyPoints, security.accessControlPolicyPoints) &&
        Objects.equals(this.certificate, security.certificate) &&
        Objects.equals(this.requiredCertificateExtension, security.requiredCertificateExtension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessControlPolicyPoints, certificate, requiredCertificateExtension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Security {\n");
    
    sb.append("    accessControlPolicyPoints: ").append(toIndentedString(accessControlPolicyPoints)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    requiredCertificateExtension: ").append(toIndentedString(requiredCertificateExtension)).append("\n");
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
