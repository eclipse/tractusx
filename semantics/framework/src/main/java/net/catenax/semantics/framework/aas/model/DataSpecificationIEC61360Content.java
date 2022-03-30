package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataSpecificationIEC61360Content
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class DataSpecificationIEC61360Content extends ValueObject implements OneOfDataSpecificationContent {
  /**
   * Gets or Sets dataType
   */
  public enum DataTypeEnum {
    DATE("DATE"),
    
    STRING("STRING"),
    
    STRING_TRANSLATABLE("STRING_TRANSLATABLE"),
    
    REAL_MEASURE("REAL_MEASURE"),
    
    REAL_COUNT("REAL_COUNT"),
    
    REAL_CURRENCY("REAL_CURRENCY"),
    
    BOOLEAN("BOOLEAN"),
    
    URL("URL"),
    
    RATIONAL("RATIONAL"),
    
    RATIONAL_MEASURE("RATIONAL_MEASURE"),
    
    TIME("TIME"),
    
    TIMESTAMP("TIMESTAMP"),
    
    INTEGER_COUNT("INTEGER_COUNT"),
    
    INTEGER_MEASURE("INTEGER_MEASURE"),
    
    INTEGER_CURRENCY("INTEGER_CURRENCY");

    private String value;

    DataTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DataTypeEnum fromValue(String text) {
      for (DataTypeEnum b : DataTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("dataType")
  private DataTypeEnum dataType = null;

  @JsonProperty("definition")
  @Valid
  private List<LangString> definition = null;

  @JsonProperty("levelType")
  @Valid
  private List<LevelType> levelType = null;

  @JsonProperty("preferredName")
  @Valid
  private List<LangString> preferredName = new ArrayList<>();

  @JsonProperty("shortName")
  @Valid
  private List<LangString> shortName = null;

  @JsonProperty("sourceOfDefinition")
  private String sourceOfDefinition = null;

  @JsonProperty("symbol")
  private String symbol = null;

  @JsonProperty("unit")
  private String unit = null;

  @JsonProperty("unitId")
  private Reference unitId = null;

  @JsonProperty("valueFormat")
  private String valueFormat = null;

  @JsonProperty("valueList")
  private ValueList valueList = null;

  public DataSpecificationIEC61360Content dataType(DataTypeEnum dataType) {
    this.dataType = dataType;
    return this;
  }

  /**
   * Get dataType
   * @return dataType
   **/
  @Schema(description = "")
  
    public DataTypeEnum getDataType() {
    return dataType;
  }

  public void setDataType(DataTypeEnum dataType) {
    this.dataType = dataType;
  }

  public DataSpecificationIEC61360Content definition(List<LangString> definition) {
    this.definition = definition;
    return this;
  }

  public DataSpecificationIEC61360Content addDefinitionItem(LangString definitionItem) {
    if (this.definition == null) {
      this.definition = new ArrayList<>();
    }
    this.definition.add(definitionItem);
    return this;
  }

  /**
   * Get definition
   * @return definition
   **/
  @Schema(description = "")
      @Valid
    public List<LangString> getDefinition() {
    return definition;
  }

  public void setDefinition(List<LangString> definition) {
    this.definition = definition;
  }

  public DataSpecificationIEC61360Content levelType(List<LevelType> levelType) {
    this.levelType = levelType;
    return this;
  }

  public DataSpecificationIEC61360Content addLevelTypeItem(LevelType levelTypeItem) {
    if (this.levelType == null) {
      this.levelType = new ArrayList<>();
    }
    this.levelType.add(levelTypeItem);
    return this;
  }

  /**
   * Get levelType
   * @return levelType
   **/
  @Schema(description = "")
      @Valid
    public List<LevelType> getLevelType() {
    return levelType;
  }

  public void setLevelType(List<LevelType> levelType) {
    this.levelType = levelType;
  }

  public DataSpecificationIEC61360Content preferredName(List<LangString> preferredName) {
    this.preferredName = preferredName;
    return this;
  }

  public DataSpecificationIEC61360Content addPreferredNameItem(LangString preferredNameItem) {
    this.preferredName.add(preferredNameItem);
    return this;
  }

  /**
   * Get preferredName
   * @return preferredName
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<LangString> getPreferredName() {
    return preferredName;
  }

  public void setPreferredName(List<LangString> preferredName) {
    this.preferredName = preferredName;
  }

  public DataSpecificationIEC61360Content shortName(List<LangString> shortName) {
    this.shortName = shortName;
    return this;
  }

  public DataSpecificationIEC61360Content addShortNameItem(LangString shortNameItem) {
    if (this.shortName == null) {
      this.shortName = new ArrayList<>();
    }
    this.shortName.add(shortNameItem);
    return this;
  }

  /**
   * Get shortName
   * @return shortName
   **/
  @Schema(description = "")
      @Valid
    public List<LangString> getShortName() {
    return shortName;
  }

  public void setShortName(List<LangString> shortName) {
    this.shortName = shortName;
  }

  public DataSpecificationIEC61360Content sourceOfDefinition(String sourceOfDefinition) {
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

  public DataSpecificationIEC61360Content symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   * Get symbol
   * @return symbol
   **/
  @Schema(description = "")
  
    public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public DataSpecificationIEC61360Content unit(String unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
   **/
  @Schema(description = "")
  
    public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public DataSpecificationIEC61360Content unitId(Reference unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * Get unitId
   * @return unitId
   **/
  @Schema(description = "")
  
    @Valid
    public Reference getUnitId() {
    return unitId;
  }

  public void setUnitId(Reference unitId) {
    this.unitId = unitId;
  }

  public DataSpecificationIEC61360Content valueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
    return this;
  }

  /**
   * Get valueFormat
   * @return valueFormat
   **/
  @Schema(description = "")
  
    public String getValueFormat() {
    return valueFormat;
  }

  public void setValueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
  }

  public DataSpecificationIEC61360Content valueList(ValueList valueList) {
    this.valueList = valueList;
    return this;
  }

  /**
   * Get valueList
   * @return valueList
   **/
  @Schema(description = "")
  
    @Valid
    public ValueList getValueList() {
    return valueList;
  }

  public void setValueList(ValueList valueList) {
    this.valueList = valueList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSpecificationIEC61360Content dataSpecificationIEC61360Content = (DataSpecificationIEC61360Content) o;
    return Objects.equals(this.dataType, dataSpecificationIEC61360Content.dataType) &&
        Objects.equals(this.definition, dataSpecificationIEC61360Content.definition) &&
        Objects.equals(this.levelType, dataSpecificationIEC61360Content.levelType) &&
        Objects.equals(this.preferredName, dataSpecificationIEC61360Content.preferredName) &&
        Objects.equals(this.shortName, dataSpecificationIEC61360Content.shortName) &&
        Objects.equals(this.sourceOfDefinition, dataSpecificationIEC61360Content.sourceOfDefinition) &&
        Objects.equals(this.symbol, dataSpecificationIEC61360Content.symbol) &&
        Objects.equals(this.unit, dataSpecificationIEC61360Content.unit) &&
        Objects.equals(this.unitId, dataSpecificationIEC61360Content.unitId) &&
        Objects.equals(this.valueFormat, dataSpecificationIEC61360Content.valueFormat) &&
        Objects.equals(this.valueList, dataSpecificationIEC61360Content.valueList) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataType, definition, levelType, preferredName, shortName, sourceOfDefinition, symbol, unit, unitId, valueFormat, valueList, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSpecificationIEC61360Content {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    levelType: ").append(toIndentedString(levelType)).append("\n");
    sb.append("    preferredName: ").append(toIndentedString(preferredName)).append("\n");
    sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
    sb.append("    sourceOfDefinition: ").append(toIndentedString(sourceOfDefinition)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("    valueFormat: ").append(toIndentedString(valueFormat)).append("\n");
    sb.append("    valueList: ").append(toIndentedString(valueList)).append("\n");
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
