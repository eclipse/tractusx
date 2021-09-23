package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")


public class Error   {
  @JsonProperty("message")
  private String message = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("details")
  @Valid
  private Map<String, Object> details = new HashMap<String, Object>();

  @JsonProperty("code")
  private String code = null;

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(description = "")
  
  @Size(min=1)   public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Get path
   * @return path
   **/
  @Schema(description = "")
  
  @Size(min=1)   public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Error details(Map<String, Object> details) {
    this.details = details;
    return this;
  }

  public Error putDetailsItem(String key, Object detailsItem) {
    this.details.put(key, detailsItem);
    return this;
  }

  /**
   * Get details
   * @return details
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Map<String, Object> getDetails() {
    return details;
  }

  public void setDetails(Map<String, Object> details) {
    this.details = details;
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(description = "")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.message, error.message) &&
        Objects.equals(this.path, error.path) &&
        Objects.equals(this.details, error.details) &&
        Objects.equals(this.code, error.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, path, details, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
