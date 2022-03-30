package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * HasExtensions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class HasExtensions   {
  @JsonProperty("extensions")
  @Valid
  private List<Extension> extensions = null;

  public HasExtensions extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public HasExtensions addExtensionsItem(Extension extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new ArrayList<>();
    }
    this.extensions.add(extensionsItem);
    return this;
  }

  /**
   * Get extensions
   * @return extensions
   **/
  @Schema(description = "")
      @Valid
    public List<Extension> getExtensions() {
    return extensions;
  }

  public void setExtensions(List<Extension> extensions) {
    this.extensions = extensions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HasExtensions hasExtensions = (HasExtensions) o;
    return Objects.equals(this.extensions, hasExtensions.extensions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HasExtensions {\n");
    
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
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
