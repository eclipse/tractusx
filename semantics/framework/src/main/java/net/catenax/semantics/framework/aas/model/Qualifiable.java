package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Qualifiable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Qualifiable   {
  @JsonProperty("qualifiers")
  @Valid
  private List<Constraint> qualifiers = null;

  public Qualifiable qualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
    return this;
  }

  public Qualifiable addQualifiersItem(Constraint qualifiersItem) {
    if (this.qualifiers == null) {
      this.qualifiers = new ArrayList<>();
    }
    this.qualifiers.add(qualifiersItem);
    return this;
  }

  /**
   * Get qualifiers
   * @return qualifiers
   **/
  @Schema(description = "")
      @Valid
    public List<Constraint> getQualifiers() {
    return qualifiers;
  }

  public void setQualifiers(List<Constraint> qualifiers) {
    this.qualifiers = qualifiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Qualifiable qualifiable = (Qualifiable) o;
    return Objects.equals(this.qualifiers, qualifiable.qualifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qualifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Qualifiable {\n");
    
    sb.append("    qualifiers: ").append(toIndentedString(qualifiers)).append("\n");
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
