package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.DocumentClassificationCharacteristic;
import com.catenax.tdm.model.v1.DocumentIdCharacteristic;
import com.catenax.tdm.model.v1.DocumentVersions;
import com.catenax.tdm.model.v1.ReferenceElementSet;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class DocumentsInner   {
  @JsonProperty("documentId")
  private DocumentIdCharacteristic documentId = null;

  @JsonProperty("documentClassifications")
  private DocumentClassificationCharacteristic documentClassifications = null;

  @JsonProperty("documentEntities")
  private ReferenceElementSet documentEntities = null;

  @JsonProperty("documentVersions")
  private DocumentVersions documentVersions = null;

  public DocumentsInner documentId(DocumentIdCharacteristic documentId) {
    this.documentId = documentId;
    return this;
  }

  /**
   * Get documentId
   * @return documentId
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DocumentIdCharacteristic getDocumentId() {
    return documentId;
  }

  public void setDocumentId(DocumentIdCharacteristic documentId) {
    this.documentId = documentId;
  }

  public DocumentsInner documentClassifications(DocumentClassificationCharacteristic documentClassifications) {
    this.documentClassifications = documentClassifications;
    return this;
  }

  /**
   * Get documentClassifications
   * @return documentClassifications
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DocumentClassificationCharacteristic getDocumentClassifications() {
    return documentClassifications;
  }

  public void setDocumentClassifications(DocumentClassificationCharacteristic documentClassifications) {
    this.documentClassifications = documentClassifications;
  }

  public DocumentsInner documentEntities(ReferenceElementSet documentEntities) {
    this.documentEntities = documentEntities;
    return this;
  }

  /**
   * Get documentEntities
   * @return documentEntities
   **/
  @Schema(description = "")
  
    @Valid
    public ReferenceElementSet getDocumentEntities() {
    return documentEntities;
  }

  public void setDocumentEntities(ReferenceElementSet documentEntities) {
    this.documentEntities = documentEntities;
  }

  public DocumentsInner documentVersions(DocumentVersions documentVersions) {
    this.documentVersions = documentVersions;
    return this;
  }

  /**
   * Get documentVersions
   * @return documentVersions
   **/
  @Schema(description = "")
  
    @Valid
    public DocumentVersions getDocumentVersions() {
    return documentVersions;
  }

  public void setDocumentVersions(DocumentVersions documentVersions) {
    this.documentVersions = documentVersions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentsInner documentsInner = (DocumentsInner) o;
    return Objects.equals(this.documentId, documentsInner.documentId) &&
        Objects.equals(this.documentClassifications, documentsInner.documentClassifications) &&
        Objects.equals(this.documentEntities, documentsInner.documentEntities) &&
        Objects.equals(this.documentVersions, documentsInner.documentVersions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentId, documentClassifications, documentEntities, documentVersions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentsInner {\n");
    
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    documentClassifications: ").append(toIndentedString(documentClassifications)).append("\n");
    sb.append("    documentEntities: ").append(toIndentedString(documentEntities)).append("\n");
    sb.append("    documentVersions: ").append(toIndentedString(documentVersions)).append("\n");
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
