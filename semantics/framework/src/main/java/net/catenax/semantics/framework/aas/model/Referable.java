package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Referable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Referable extends HasExtensions  {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  @Valid
  private List<LangString> description = null;

  @JsonProperty("displayName")
  @Valid
  private List<LangString> displayName = null;

  @JsonProperty("idShort")
  private String idShort = null;

  @JsonProperty("modelType")
  private ModelType modelType = null;

  public Referable category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(description = "")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Referable description(List<LangString> description) {
    this.description = description;
    return this;
  }

  public Referable addDescriptionItem(LangString descriptionItem) {
    if (this.description == null) {
      this.description = new ArrayList<>();
    }
    this.description.add(descriptionItem);
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
      @Valid
    public List<LangString> getDescription() {
    return description;
  }

  public void setDescription(List<LangString> description) {
    this.description = description;
  }

  public Referable displayName(List<LangString> displayName) {
    this.displayName = displayName;
    return this;
  }

  public Referable addDisplayNameItem(LangString displayNameItem) {
    if (this.displayName == null) {
      this.displayName = new ArrayList<>();
    }
    this.displayName.add(displayNameItem);
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  @Schema(description = "")
      @Valid
    public List<LangString> getDisplayName() {
    return displayName;
  }

  public void setDisplayName(List<LangString> displayName) {
    this.displayName = displayName;
  }

  public Referable idShort(String idShort) {
    this.idShort = idShort;
    return this;
  }

  /**
   * Get idShort
   * @return idShort
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getIdShort() {
    return idShort;
  }

  public void setIdShort(String idShort) {
    this.idShort = idShort;
  }

  public Referable modelType(ModelType modelType) {
    this.modelType = modelType;
    return this;
  }

  /**
   * Get modelType
   * @return modelType
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public ModelType getModelType() {
    return modelType;
  }

  public void setModelType(ModelType modelType) {
    this.modelType = modelType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Referable referable = (Referable) o;
    return Objects.equals(this.category, referable.category) &&
        Objects.equals(this.description, referable.description) &&
        Objects.equals(this.displayName, referable.displayName) &&
        Objects.equals(this.idShort, referable.idShort) &&
        Objects.equals(this.modelType, referable.modelType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, displayName, idShort, modelType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Referable {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    modelType: ").append(toIndentedString(modelType)).append("\n");
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
