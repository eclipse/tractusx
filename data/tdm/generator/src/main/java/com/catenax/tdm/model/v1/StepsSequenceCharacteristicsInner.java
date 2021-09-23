package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StepsSequenceCharacteristicsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class StepsSequenceCharacteristicsInner   {
  @JsonProperty("sequenceId")
  private String sequenceId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public StepsSequenceCharacteristicsInner sequenceId(String sequenceId) {
    this.sequenceId = sequenceId;
    return this;
  }

  /**
   * Get sequenceId
   * @return sequenceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getSequenceId() {
    return sequenceId;
  }

  public void setSequenceId(String sequenceId) {
    this.sequenceId = sequenceId;
  }

  public StepsSequenceCharacteristicsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StepsSequenceCharacteristicsInner description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StepsSequenceCharacteristicsInner stepsSequenceCharacteristicsInner = (StepsSequenceCharacteristicsInner) o;
    return Objects.equals(this.sequenceId, stepsSequenceCharacteristicsInner.sequenceId) &&
        Objects.equals(this.name, stepsSequenceCharacteristicsInner.name) &&
        Objects.equals(this.description, stepsSequenceCharacteristicsInner.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceId, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StepsSequenceCharacteristicsInner {\n");
    
    sb.append("    sequenceId: ").append(toIndentedString(sequenceId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
