package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentIdCharacteristicInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class DocumentIdCharacteristicInner   {
  @JsonProperty("documentDomainId")
  private String documentDomainId = null;

  @JsonProperty("valueId")
  private String valueId = null;

  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  public DocumentIdCharacteristicInner documentDomainId(String documentDomainId) {
    this.documentDomainId = documentDomainId;
    return this;
  }

  /**
   * Get documentDomainId
   * @return documentDomainId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocumentDomainId() {
    return documentDomainId;
  }

  public void setDocumentDomainId(String documentDomainId) {
    this.documentDomainId = documentDomainId;
  }

  public DocumentIdCharacteristicInner valueId(String valueId) {
    this.valueId = valueId;
    return this;
  }

  /**
   * Get valueId
   * @return valueId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getValueId() {
    return valueId;
  }

  public void setValueId(String valueId) {
    this.valueId = valueId;
  }

  public DocumentIdCharacteristicInner isPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
    return this;
  }

  /**
   * Get isPrimary
   * @return isPrimary
   **/
  @Schema(description = "")
  
    public Boolean getIsPrimary() {
    return isPrimary;
  }

  public void setIsPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentIdCharacteristicInner documentIdCharacteristicInner = (DocumentIdCharacteristicInner) o;
    return Objects.equals(this.documentDomainId, documentIdCharacteristicInner.documentDomainId) &&
        Objects.equals(this.valueId, documentIdCharacteristicInner.valueId) &&
        Objects.equals(this.isPrimary, documentIdCharacteristicInner.isPrimary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentDomainId, valueId, isPrimary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentIdCharacteristicInner {\n");
    
    sb.append("    documentDomainId: ").append(toIndentedString(documentDomainId)).append("\n");
    sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
    sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
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
