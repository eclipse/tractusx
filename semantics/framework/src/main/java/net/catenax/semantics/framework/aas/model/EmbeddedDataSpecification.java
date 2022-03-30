package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmbeddedDataSpecification
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class EmbeddedDataSpecification   {
  @JsonProperty("dataSpecification")
  private Reference dataSpecification = null;

  @JsonProperty("dataSpecificationContent")
  private DataSpecificationContent dataSpecificationContent = null;

  public EmbeddedDataSpecification dataSpecification(Reference dataSpecification) {
    this.dataSpecification = dataSpecification;
    return this;
  }

  /**
   * Get dataSpecification
   * @return dataSpecification
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Reference getDataSpecification() {
    return dataSpecification;
  }

  public void setDataSpecification(Reference dataSpecification) {
    this.dataSpecification = dataSpecification;
  }

  public EmbeddedDataSpecification dataSpecificationContent(DataSpecificationContent dataSpecificationContent) {
    this.dataSpecificationContent = dataSpecificationContent;
    return this;
  }

  /**
   * Get dataSpecificationContent
   * @return dataSpecificationContent
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DataSpecificationContent getDataSpecificationContent() {
    return dataSpecificationContent;
  }

  public void setDataSpecificationContent(DataSpecificationContent dataSpecificationContent) {
    this.dataSpecificationContent = dataSpecificationContent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmbeddedDataSpecification embeddedDataSpecification = (EmbeddedDataSpecification) o;
    return Objects.equals(this.dataSpecification, embeddedDataSpecification.dataSpecification) &&
        Objects.equals(this.dataSpecificationContent, embeddedDataSpecification.dataSpecificationContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSpecification, dataSpecificationContent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmbeddedDataSpecification {\n");
    
    sb.append("    dataSpecification: ").append(toIndentedString(dataSpecification)).append("\n");
    sb.append("    dataSpecificationContent: ").append(toIndentedString(dataSpecificationContent)).append("\n");
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
