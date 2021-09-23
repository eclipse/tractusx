package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.DigitalFiles;
import com.catenax.tdm.model.v1.LanguageSet;
import com.catenax.tdm.model.v1.MultiLanguageProperty;
import com.catenax.tdm.model.v1.Role;
import com.catenax.tdm.model.v1.StatusValueCharacteristic;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentVersionsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class DocumentVersionsInner   {
  @JsonProperty("languages")
  private LanguageSet languages = null;

  @JsonProperty("documentVersionId")
  private String documentVersionId = null;

  @JsonProperty("title")
  private MultiLanguageProperty title = null;

  @JsonProperty("summary")
  private MultiLanguageProperty summary = null;

  @JsonProperty("keyWords")
  private MultiLanguageProperty keyWords = null;

  @JsonProperty("setDate")
  private String setDate = null;

  @JsonProperty("statusValue")
  private StatusValueCharacteristic statusValue = null;

  @JsonProperty("role")
  private Role role = null;

  @JsonProperty("organizationOfficialName")
  private String organizationOfficialName = null;

  @JsonProperty("organizationName")
  private String organizationName = null;

  @JsonProperty("digitalFiles")
  private DigitalFiles digitalFiles = null;

  public DocumentVersionsInner languages(LanguageSet languages) {
    this.languages = languages;
    return this;
  }

  /**
   * Get languages
   * @return languages
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LanguageSet getLanguages() {
    return languages;
  }

  public void setLanguages(LanguageSet languages) {
    this.languages = languages;
  }

  public DocumentVersionsInner documentVersionId(String documentVersionId) {
    this.documentVersionId = documentVersionId;
    return this;
  }

  /**
   * Get documentVersionId
   * @return documentVersionId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocumentVersionId() {
    return documentVersionId;
  }

  public void setDocumentVersionId(String documentVersionId) {
    this.documentVersionId = documentVersionId;
  }

  public DocumentVersionsInner title(MultiLanguageProperty title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public MultiLanguageProperty getTitle() {
    return title;
  }

  public void setTitle(MultiLanguageProperty title) {
    this.title = title;
  }

  public DocumentVersionsInner summary(MultiLanguageProperty summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public MultiLanguageProperty getSummary() {
    return summary;
  }

  public void setSummary(MultiLanguageProperty summary) {
    this.summary = summary;
  }

  public DocumentVersionsInner keyWords(MultiLanguageProperty keyWords) {
    this.keyWords = keyWords;
    return this;
  }

  /**
   * Get keyWords
   * @return keyWords
   **/
  @Schema(description = "")
  
    @Valid
    public MultiLanguageProperty getKeyWords() {
    return keyWords;
  }

  public void setKeyWords(MultiLanguageProperty keyWords) {
    this.keyWords = keyWords;
  }

  public DocumentVersionsInner setDate(String setDate) {
    this.setDate = setDate;
    return this;
  }

  /**
   * Get setDate
   * @return setDate
   **/
  @Schema(required = true, description = "")
      @NotNull

  public String getSetDate() {
    return setDate;
  }

  public void setSetDate(String setDate) {
    this.setDate = setDate;
  }

  public DocumentVersionsInner statusValue(StatusValueCharacteristic statusValue) {
    this.statusValue = statusValue;
    return this;
  }

  /**
   * Get statusValue
   * @return statusValue
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public StatusValueCharacteristic getStatusValue() {
    return statusValue;
  }

  public void setStatusValue(StatusValueCharacteristic statusValue) {
    this.statusValue = statusValue;
  }

  public DocumentVersionsInner role(Role role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public DocumentVersionsInner organizationOfficialName(String organizationOfficialName) {
    this.organizationOfficialName = organizationOfficialName;
    return this;
  }

  /**
   * Get organizationOfficialName
   * @return organizationOfficialName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getOrganizationOfficialName() {
    return organizationOfficialName;
  }

  public void setOrganizationOfficialName(String organizationOfficialName) {
    this.organizationOfficialName = organizationOfficialName;
  }

  public DocumentVersionsInner organizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  /**
   * Get organizationName
   * @return organizationName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public DocumentVersionsInner digitalFiles(DigitalFiles digitalFiles) {
    this.digitalFiles = digitalFiles;
    return this;
  }

  /**
   * Get digitalFiles
   * @return digitalFiles
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DigitalFiles getDigitalFiles() {
    return digitalFiles;
  }

  public void setDigitalFiles(DigitalFiles digitalFiles) {
    this.digitalFiles = digitalFiles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentVersionsInner documentVersionsInner = (DocumentVersionsInner) o;
    return Objects.equals(this.languages, documentVersionsInner.languages) &&
        Objects.equals(this.documentVersionId, documentVersionsInner.documentVersionId) &&
        Objects.equals(this.title, documentVersionsInner.title) &&
        Objects.equals(this.summary, documentVersionsInner.summary) &&
        Objects.equals(this.keyWords, documentVersionsInner.keyWords) &&
        Objects.equals(this.setDate, documentVersionsInner.setDate) &&
        Objects.equals(this.statusValue, documentVersionsInner.statusValue) &&
        Objects.equals(this.role, documentVersionsInner.role) &&
        Objects.equals(this.organizationOfficialName, documentVersionsInner.organizationOfficialName) &&
        Objects.equals(this.organizationName, documentVersionsInner.organizationName) &&
        Objects.equals(this.digitalFiles, documentVersionsInner.digitalFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languages, documentVersionId, title, summary, keyWords, setDate, statusValue, role, organizationOfficialName, organizationName, digitalFiles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentVersionsInner {\n");
    
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("    documentVersionId: ").append(toIndentedString(documentVersionId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    keyWords: ").append(toIndentedString(keyWords)).append("\n");
    sb.append("    setDate: ").append(toIndentedString(setDate)).append("\n");
    sb.append("    statusValue: ").append(toIndentedString(statusValue)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    organizationOfficialName: ").append(toIndentedString(organizationOfficialName)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    digitalFiles: ").append(toIndentedString(digitalFiles)).append("\n");
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
