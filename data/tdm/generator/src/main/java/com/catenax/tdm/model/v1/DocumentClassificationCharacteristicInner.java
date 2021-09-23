package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.MultiLanguageProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentClassificationCharacteristicInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class DocumentClassificationCharacteristicInner   {
  @JsonProperty("classId")
  private String classId = null;

  @JsonProperty("className")
  private MultiLanguageProperty className = null;

  @JsonProperty("documentClassificationSystem")
  private String documentClassificationSystem = null;

  public DocumentClassificationCharacteristicInner classId(String classId) {
    this.classId = classId;
    return this;
  }

  /**
   * Get classId
   * @return classId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public DocumentClassificationCharacteristicInner className(MultiLanguageProperty className) {
    this.className = className;
    return this;
  }

  /**
   * Get className
   * @return className
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public MultiLanguageProperty getClassName() {
    return className;
  }

  public void setClassName(MultiLanguageProperty className) {
    this.className = className;
  }

  public DocumentClassificationCharacteristicInner documentClassificationSystem(String documentClassificationSystem) {
    this.documentClassificationSystem = documentClassificationSystem;
    return this;
  }

  /**
   * Get documentClassificationSystem
   * @return documentClassificationSystem
   **/
  @Schema(description = "")
  
    public String getDocumentClassificationSystem() {
    return documentClassificationSystem;
  }

  public void setDocumentClassificationSystem(String documentClassificationSystem) {
    this.documentClassificationSystem = documentClassificationSystem;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentClassificationCharacteristicInner documentClassificationCharacteristicInner = (DocumentClassificationCharacteristicInner) o;
    return Objects.equals(this.classId, documentClassificationCharacteristicInner.classId) &&
        Objects.equals(this.className, documentClassificationCharacteristicInner.className) &&
        Objects.equals(this.documentClassificationSystem, documentClassificationCharacteristicInner.documentClassificationSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classId, className, documentClassificationSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentClassificationCharacteristicInner {\n");
    
    sb.append("    classId: ").append(toIndentedString(classId)).append("\n");
    sb.append("    className: ").append(toIndentedString(className)).append("\n");
    sb.append("    documentClassificationSystem: ").append(toIndentedString(documentClassificationSystem)).append("\n");
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
