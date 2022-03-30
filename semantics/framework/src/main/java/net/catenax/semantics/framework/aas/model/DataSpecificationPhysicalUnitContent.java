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
 * DataSpecificationPhysicalUnitContent
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class DataSpecificationPhysicalUnitContent  implements OneOfDataSpecificationContent {
  @JsonProperty("conversionFactor")
  private String conversionFactor = null;

  @JsonProperty("definition")
  @Valid
  private List<LangString> definition = new ArrayList<>();

  @JsonProperty("dinNotation")
  private String dinNotation = null;

  @JsonProperty("eceCode")
  private String eceCode = null;

  @JsonProperty("eceName")
  private String eceName = null;

  @JsonProperty("nistName")
  private String nistName = null;

  @JsonProperty("registrationAuthorityId")
  private String registrationAuthorityId = null;

  @JsonProperty("siName")
  private String siName = null;

  @JsonProperty("siNotation")
  private String siNotation = null;

  @JsonProperty("sourceOfDefinition")
  private String sourceOfDefinition = null;

  @JsonProperty("supplier")
  private String supplier = null;

  @JsonProperty("unitName")
  private String unitName = null;

  @JsonProperty("unitSymbol")
  private String unitSymbol = null;

  public DataSpecificationPhysicalUnitContent conversionFactor(String conversionFactor) {
    this.conversionFactor = conversionFactor;
    return this;
  }

  /**
   * Get conversionFactor
   * @return conversionFactor
   **/
  @Schema(description = "")
  
    public String getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(String conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public DataSpecificationPhysicalUnitContent definition(List<LangString> definition) {
    this.definition = definition;
    return this;
  }

  public DataSpecificationPhysicalUnitContent addDefinitionItem(LangString definitionItem) {
    this.definition.add(definitionItem);
    return this;
  }

  /**
   * Get definition
   * @return definition
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<LangString> getDefinition() {
    return definition;
  }

  public void setDefinition(List<LangString> definition) {
    this.definition = definition;
  }

  public DataSpecificationPhysicalUnitContent dinNotation(String dinNotation) {
    this.dinNotation = dinNotation;
    return this;
  }

  /**
   * Get dinNotation
   * @return dinNotation
   **/
  @Schema(description = "")
  
    public String getDinNotation() {
    return dinNotation;
  }

  public void setDinNotation(String dinNotation) {
    this.dinNotation = dinNotation;
  }

  public DataSpecificationPhysicalUnitContent eceCode(String eceCode) {
    this.eceCode = eceCode;
    return this;
  }

  /**
   * Get eceCode
   * @return eceCode
   **/
  @Schema(description = "")
  
    public String getEceCode() {
    return eceCode;
  }

  public void setEceCode(String eceCode) {
    this.eceCode = eceCode;
  }

  public DataSpecificationPhysicalUnitContent eceName(String eceName) {
    this.eceName = eceName;
    return this;
  }

  /**
   * Get eceName
   * @return eceName
   **/
  @Schema(description = "")
  
    public String getEceName() {
    return eceName;
  }

  public void setEceName(String eceName) {
    this.eceName = eceName;
  }

  public DataSpecificationPhysicalUnitContent nistName(String nistName) {
    this.nistName = nistName;
    return this;
  }

  /**
   * Get nistName
   * @return nistName
   **/
  @Schema(description = "")
  
    public String getNistName() {
    return nistName;
  }

  public void setNistName(String nistName) {
    this.nistName = nistName;
  }

  public DataSpecificationPhysicalUnitContent registrationAuthorityId(String registrationAuthorityId) {
    this.registrationAuthorityId = registrationAuthorityId;
    return this;
  }

  /**
   * Get registrationAuthorityId
   * @return registrationAuthorityId
   **/
  @Schema(description = "")
  
    public String getRegistrationAuthorityId() {
    return registrationAuthorityId;
  }

  public void setRegistrationAuthorityId(String registrationAuthorityId) {
    this.registrationAuthorityId = registrationAuthorityId;
  }

  public DataSpecificationPhysicalUnitContent siName(String siName) {
    this.siName = siName;
    return this;
  }

  /**
   * Get siName
   * @return siName
   **/
  @Schema(description = "")
  
    public String getSiName() {
    return siName;
  }

  public void setSiName(String siName) {
    this.siName = siName;
  }

  public DataSpecificationPhysicalUnitContent siNotation(String siNotation) {
    this.siNotation = siNotation;
    return this;
  }

  /**
   * Get siNotation
   * @return siNotation
   **/
  @Schema(description = "")
  
    public String getSiNotation() {
    return siNotation;
  }

  public void setSiNotation(String siNotation) {
    this.siNotation = siNotation;
  }

  public DataSpecificationPhysicalUnitContent sourceOfDefinition(String sourceOfDefinition) {
    this.sourceOfDefinition = sourceOfDefinition;
    return this;
  }

  /**
   * Get sourceOfDefinition
   * @return sourceOfDefinition
   **/
  @Schema(description = "")
  
    public String getSourceOfDefinition() {
    return sourceOfDefinition;
  }

  public void setSourceOfDefinition(String sourceOfDefinition) {
    this.sourceOfDefinition = sourceOfDefinition;
  }

  public DataSpecificationPhysicalUnitContent supplier(String supplier) {
    this.supplier = supplier;
    return this;
  }

  /**
   * Get supplier
   * @return supplier
   **/
  @Schema(description = "")
  
    public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public DataSpecificationPhysicalUnitContent unitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

  /**
   * Get unitName
   * @return unitName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public DataSpecificationPhysicalUnitContent unitSymbol(String unitSymbol) {
    this.unitSymbol = unitSymbol;
    return this;
  }

  /**
   * Get unitSymbol
   * @return unitSymbol
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUnitSymbol() {
    return unitSymbol;
  }

  public void setUnitSymbol(String unitSymbol) {
    this.unitSymbol = unitSymbol;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSpecificationPhysicalUnitContent dataSpecificationPhysicalUnitContent = (DataSpecificationPhysicalUnitContent) o;
    return Objects.equals(this.conversionFactor, dataSpecificationPhysicalUnitContent.conversionFactor) &&
        Objects.equals(this.definition, dataSpecificationPhysicalUnitContent.definition) &&
        Objects.equals(this.dinNotation, dataSpecificationPhysicalUnitContent.dinNotation) &&
        Objects.equals(this.eceCode, dataSpecificationPhysicalUnitContent.eceCode) &&
        Objects.equals(this.eceName, dataSpecificationPhysicalUnitContent.eceName) &&
        Objects.equals(this.nistName, dataSpecificationPhysicalUnitContent.nistName) &&
        Objects.equals(this.registrationAuthorityId, dataSpecificationPhysicalUnitContent.registrationAuthorityId) &&
        Objects.equals(this.siName, dataSpecificationPhysicalUnitContent.siName) &&
        Objects.equals(this.siNotation, dataSpecificationPhysicalUnitContent.siNotation) &&
        Objects.equals(this.sourceOfDefinition, dataSpecificationPhysicalUnitContent.sourceOfDefinition) &&
        Objects.equals(this.supplier, dataSpecificationPhysicalUnitContent.supplier) &&
        Objects.equals(this.unitName, dataSpecificationPhysicalUnitContent.unitName) &&
        Objects.equals(this.unitSymbol, dataSpecificationPhysicalUnitContent.unitSymbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversionFactor, definition, dinNotation, eceCode, eceName, nistName, registrationAuthorityId, siName, siNotation, sourceOfDefinition, supplier, unitName, unitSymbol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSpecificationPhysicalUnitContent {\n");
    
    sb.append("    conversionFactor: ").append(toIndentedString(conversionFactor)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    dinNotation: ").append(toIndentedString(dinNotation)).append("\n");
    sb.append("    eceCode: ").append(toIndentedString(eceCode)).append("\n");
    sb.append("    eceName: ").append(toIndentedString(eceName)).append("\n");
    sb.append("    nistName: ").append(toIndentedString(nistName)).append("\n");
    sb.append("    registrationAuthorityId: ").append(toIndentedString(registrationAuthorityId)).append("\n");
    sb.append("    siName: ").append(toIndentedString(siName)).append("\n");
    sb.append("    siNotation: ").append(toIndentedString(siNotation)).append("\n");
    sb.append("    sourceOfDefinition: ").append(toIndentedString(sourceOfDefinition)).append("\n");
    sb.append("    supplier: ").append(toIndentedString(supplier)).append("\n");
    sb.append("    unitName: ").append(toIndentedString(unitName)).append("\n");
    sb.append("    unitSymbol: ").append(toIndentedString(unitSymbol)).append("\n");
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
