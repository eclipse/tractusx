package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UrnBammComCatenaX001QualityAlertDataCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class QualityAlertDataCharacteristic   {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	
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
      @NotNull

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
      @NotNull

    @Valid
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
    QualityAlertDataCharacteristic urnBammComCatenaX001QualityAlertDataCharacteristic = (QualityAlertDataCharacteristic) o;
    return Objects.equals(this.qualityAlert, urnBammComCatenaX001QualityAlertDataCharacteristic.qualityAlert) &&
        Objects.equals(this.qualityType, urnBammComCatenaX001QualityAlertDataCharacteristic.qualityType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qualityAlert, qualityType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrnBammComCatenaX001QualityAlertDataCharacteristic {\n");
    
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
