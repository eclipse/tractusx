package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.TextStatementSet;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FurtherInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")


public class FurtherInformation   {
  @JsonProperty("textStatements")
  private TextStatementSet textStatements = null;

  @JsonProperty("validDate")
  private String validDate = null;

  public FurtherInformation textStatements(TextStatementSet textStatements) {
    this.textStatements = textStatements;
    return this;
  }

  /**
   * Get textStatements
   * @return textStatements
   **/
  @Schema(description = "")
  
    @Valid
    public TextStatementSet getTextStatements() {
    return textStatements;
  }

  public void setTextStatements(TextStatementSet textStatements) {
    this.textStatements = textStatements;
  }

  public FurtherInformation validDate(String validDate) {
    this.validDate = validDate;
    return this;
  }

  /**
   * Get validDate
   * @return validDate
   **/
  @Schema(required = true, description = "")
      @NotNull

  public String getValidDate() {
    return validDate;
  }

  public void setValidDate(String validDate) {
    this.validDate = validDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FurtherInformation furtherInformation = (FurtherInformation) o;
    return Objects.equals(this.textStatements, furtherInformation.textStatements) &&
        Objects.equals(this.validDate, furtherInformation.validDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textStatements, validDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FurtherInformation {\n");
    
    sb.append("    textStatements: ").append(toIndentedString(textStatements)).append("\n");
    sb.append("    validDate: ").append(toIndentedString(validDate)).append("\n");
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
