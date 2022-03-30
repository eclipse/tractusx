package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BasicEvent
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class BasicEvent extends Event implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("observed")
  private Reference observed = null;

  public BasicEvent observed(Reference observed) {
    this.observed = observed;
    return this;
  }

  /**
   * Get observed
   * @return observed
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Reference getObserved() {
    return observed;
  }

  public void setObserved(Reference observed) {
    this.observed = observed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicEvent basicEvent = (BasicEvent) o;
    return Objects.equals(this.observed, basicEvent.observed) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observed, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicEvent {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    observed: ").append(toIndentedString(observed)).append("\n");
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
