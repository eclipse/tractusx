/*
 * Catena-X Speedboat Test Data Generator
 * Disclaimer: This service serves synthetic, none-productive data for testing purposes only. All BOMs, part trees, VINs, serialNos etc. are synthetic
 *
 * OpenAPI spec version: 0.0.1 Speedboat
 * Contact: christian.kabelin@partner.bmw.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.client.model.QualityTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * QualityAlertDataCharacteristic
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2021-10-03T20:34:34.146648200+02:00[Europe/Berlin]")
public class QualityAlertDataCharacteristic {

  
  @JsonProperty("qualityAlert")
  private Boolean qualityAlert = null;
  
  
  @JsonProperty("qualityType")
  private QualityTypeEnum qualityType = null;
  
  public QualityAlertDataCharacteristic qualityAlert(Boolean qualityAlert) {
    this.qualityAlert = qualityAlert;
    return this;
  }

  
  /**
  * Get qualityAlert
  * @return qualityAlert
  **/
  
  
  @Schema(required = true, description = "")
  public Boolean getQualityAlert() {
    return qualityAlert;
  }
  public void setQualityAlert(Boolean qualityAlert) {
    this.qualityAlert = qualityAlert;
  }
  
  public QualityAlertDataCharacteristic qualityType(QualityTypeEnum qualityType) {
    this.qualityType = qualityType;
    return this;
  }

  
  /**
  * Get qualityType
  * @return qualityType
  **/
  
  
  @Schema(required = true, description = "")
  public QualityTypeEnum getQualityType() {
    return qualityType;
  }
  public void setQualityType(QualityTypeEnum qualityType) {
    this.qualityType = qualityType;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QualityAlertDataCharacteristic qualityAlertDataCharacteristic = (QualityAlertDataCharacteristic) o;
    return Objects.equals(this.qualityAlert, qualityAlertDataCharacteristic.qualityAlert) &&
        Objects.equals(this.qualityType, qualityAlertDataCharacteristic.qualityType);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(qualityAlert, qualityType);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QualityAlertDataCharacteristic {\n");
    
    sb.append("    qualityAlert: ").append(toIndentedString(qualityAlert)).append("\n");
    sb.append("    qualityType: ").append(toIndentedString(qualityType)).append("\n");
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


