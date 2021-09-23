package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.catenax.tdm.model.v1.RecyclingOptionsSelection;
import com.catenax.tdm.model.v1.ReuseOptionsSelection;
import com.catenax.tdm.model.v1.StepsSequenceCharacteristics;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EoLOptions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")


public class EoLOptions   {
  @JsonProperty("reuseOptions")
  private ReuseOptionsSelection reuseOptions = null;

  @JsonProperty("recyclingOptions")
  private RecyclingOptionsSelection recyclingOptions = null;

  @JsonProperty("disassemblySteps")
  private StepsSequenceCharacteristics disassemblySteps = null;

  @JsonProperty("recyclingSteps")
  private StepsSequenceCharacteristics recyclingSteps = null;

  public EoLOptions reuseOptions(ReuseOptionsSelection reuseOptions) {
    this.reuseOptions = reuseOptions;
    return this;
  }

  /**
   * Get reuseOptions
   * @return reuseOptions
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public ReuseOptionsSelection getReuseOptions() {
    return reuseOptions;
  }

  public void setReuseOptions(ReuseOptionsSelection reuseOptions) {
    this.reuseOptions = reuseOptions;
  }

  public EoLOptions recyclingOptions(RecyclingOptionsSelection recyclingOptions) {
    this.recyclingOptions = recyclingOptions;
    return this;
  }

  /**
   * Get recyclingOptions
   * @return recyclingOptions
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public RecyclingOptionsSelection getRecyclingOptions() {
    return recyclingOptions;
  }

  public void setRecyclingOptions(RecyclingOptionsSelection recyclingOptions) {
    this.recyclingOptions = recyclingOptions;
  }

  public EoLOptions disassemblySteps(StepsSequenceCharacteristics disassemblySteps) {
    this.disassemblySteps = disassemblySteps;
    return this;
  }

  /**
   * Get disassemblySteps
   * @return disassemblySteps
   **/
  @Schema(description = "")
  
    @Valid
    public StepsSequenceCharacteristics getDisassemblySteps() {
    return disassemblySteps;
  }

  public void setDisassemblySteps(StepsSequenceCharacteristics disassemblySteps) {
    this.disassemblySteps = disassemblySteps;
  }

  public EoLOptions recyclingSteps(StepsSequenceCharacteristics recyclingSteps) {
    this.recyclingSteps = recyclingSteps;
    return this;
  }

  /**
   * Get recyclingSteps
   * @return recyclingSteps
   **/
  @Schema(description = "")
  
    @Valid
    public StepsSequenceCharacteristics getRecyclingSteps() {
    return recyclingSteps;
  }

  public void setRecyclingSteps(StepsSequenceCharacteristics recyclingSteps) {
    this.recyclingSteps = recyclingSteps;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EoLOptions eoLOptions = (EoLOptions) o;
    return Objects.equals(this.reuseOptions, eoLOptions.reuseOptions) &&
        Objects.equals(this.recyclingOptions, eoLOptions.recyclingOptions) &&
        Objects.equals(this.disassemblySteps, eoLOptions.disassemblySteps) &&
        Objects.equals(this.recyclingSteps, eoLOptions.recyclingSteps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reuseOptions, recyclingOptions, disassemblySteps, recyclingSteps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EoLOptions {\n");
    
    sb.append("    reuseOptions: ").append(toIndentedString(reuseOptions)).append("\n");
    sb.append("    recyclingOptions: ").append(toIndentedString(recyclingOptions)).append("\n");
    sb.append("    disassemblySteps: ").append(toIndentedString(disassemblySteps)).append("\n");
    sb.append("    recyclingSteps: ").append(toIndentedString(recyclingSteps)).append("\n");
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
