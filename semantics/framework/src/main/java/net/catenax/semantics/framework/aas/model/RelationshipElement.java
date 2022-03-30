package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RelationshipElement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class RelationshipElement extends SubmodelElement implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("first")
  private Reference first = null;

  @JsonProperty("second")
  private Reference second = null;

  public RelationshipElement first(Reference first) {
    this.first = first;
    return this;
  }

  /**
   * Get first
   * @return first
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Reference getFirst() {
    return first;
  }

  public void setFirst(Reference first) {
    this.first = first;
  }

  public RelationshipElement second(Reference second) {
    this.second = second;
    return this;
  }

  /**
   * Get second
   * @return second
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Reference getSecond() {
    return second;
  }

  public void setSecond(Reference second) {
    this.second = second;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationshipElement relationshipElement = (RelationshipElement) o;
    return Objects.equals(this.first, relationshipElement.first) &&
        Objects.equals(this.second, relationshipElement.second) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipElement {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
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
