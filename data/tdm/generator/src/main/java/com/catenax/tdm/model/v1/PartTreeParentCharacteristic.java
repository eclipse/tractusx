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
 * UrnBammComCatenaX001PartTreeParentCharacteristic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class PartTreeParentCharacteristic   {
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
	
  @JsonProperty("isParentOf")
  private IsParentOfCharacteristic isParentOf = null;

  public PartTreeParentCharacteristic isParentOf(IsParentOfCharacteristic isParentOf) {
    this.isParentOf = isParentOf;
    return this;
  }

  /**
   * Get isParentOf
   * @return isParentOf
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public IsParentOfCharacteristic getIsParentOf() {
    return isParentOf;
  }

  public void setIsParentOf(IsParentOfCharacteristic isParentOf) {
    this.isParentOf = isParentOf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartTreeParentCharacteristic urnBammComCatenaX001PartTreeParentCharacteristic = (PartTreeParentCharacteristic) o;
    return Objects.equals(this.isParentOf, urnBammComCatenaX001PartTreeParentCharacteristic.isParentOf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isParentOf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrnBammComCatenaX001PartTreeParentCharacteristic {\n");
    
    sb.append("    isParentOf: ").append(toIndentedString(isParentOf)).append("\n");
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
