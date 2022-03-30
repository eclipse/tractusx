package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Identifiable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Identifiable extends Referable  {
  @JsonProperty("administration")
  private AdministrativeInformation administration = null;

  @JsonProperty("identification")
  private String identification = null;

  public Identifiable administration(AdministrativeInformation administration) {
    this.administration = administration;
    return this;
  }

  /**
   * Get administration
   * @return administration
   **/
  @Schema(description = "")
  
    @Valid
    public AdministrativeInformation getAdministration() {
    return administration;
  }

  public void setAdministration(AdministrativeInformation administration) {
    this.administration = administration;
  }

  public Identifiable identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Get identification
   * @return identification
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identifiable identifiable = (Identifiable) o;
    return Objects.equals(this.administration, identifiable.administration) &&
        Objects.equals(this.identification, identifiable.identification) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(administration, identification, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identifiable {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    administration: ").append(toIndentedString(administration)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
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
