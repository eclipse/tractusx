package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductClassificationsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class ProductClassificationsInner   {
  @JsonProperty("productClassificationSystem")
  private String productClassificationSystem = null;

  @JsonProperty("classificationSystemVersion")
  private String classificationSystemVersion = null;

  @JsonProperty("productClassId")
  private String productClassId = null;

  public ProductClassificationsInner productClassificationSystem(String productClassificationSystem) {
    this.productClassificationSystem = productClassificationSystem;
    return this;
  }

  /**
   * Get productClassificationSystem
   * @return productClassificationSystem
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductClassificationSystem() {
    return productClassificationSystem;
  }

  public void setProductClassificationSystem(String productClassificationSystem) {
    this.productClassificationSystem = productClassificationSystem;
  }

  public ProductClassificationsInner classificationSystemVersion(String classificationSystemVersion) {
    this.classificationSystemVersion = classificationSystemVersion;
    return this;
  }

  /**
   * Get classificationSystemVersion
   * @return classificationSystemVersion
   **/
  @Schema(description = "")
  
    public String getClassificationSystemVersion() {
    return classificationSystemVersion;
  }

  public void setClassificationSystemVersion(String classificationSystemVersion) {
    this.classificationSystemVersion = classificationSystemVersion;
  }

  public ProductClassificationsInner productClassId(String productClassId) {
    this.productClassId = productClassId;
    return this;
  }

  /**
   * Get productClassId
   * @return productClassId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductClassId() {
    return productClassId;
  }

  public void setProductClassId(String productClassId) {
    this.productClassId = productClassId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductClassificationsInner productClassificationsInner = (ProductClassificationsInner) o;
    return Objects.equals(this.productClassificationSystem, productClassificationsInner.productClassificationSystem) &&
        Objects.equals(this.classificationSystemVersion, productClassificationsInner.classificationSystemVersion) &&
        Objects.equals(this.productClassId, productClassificationsInner.productClassId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productClassificationSystem, classificationSystemVersion, productClassId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductClassificationsInner {\n");
    
    sb.append("    productClassificationSystem: ").append(toIndentedString(productClassificationSystem)).append("\n");
    sb.append("    classificationSystemVersion: ").append(toIndentedString(classificationSystemVersion)).append("\n");
    sb.append("    productClassId: ").append(toIndentedString(productClassId)).append("\n");
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
