package net.catenax.semantics.framework.aas.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Operation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")


public class Operation extends SubmodelElement implements OneOfCapability, OneOfOperationVariableValue, OneOfSubmodelElement {
  @JsonProperty("inoutputVariable")
  @Valid
  private List<OperationVariable> inoutputVariable = null;

  @JsonProperty("inputVariable")
  @Valid
  private List<OperationVariable> inputVariable = null;

  @JsonProperty("outputVariable")
  @Valid
  private List<OperationVariable> outputVariable = null;

  public Operation inoutputVariable(List<OperationVariable> inoutputVariable) {
    this.inoutputVariable = inoutputVariable;
    return this;
  }

  public Operation addInoutputVariableItem(OperationVariable inoutputVariableItem) {
    if (this.inoutputVariable == null) {
      this.inoutputVariable = new ArrayList<>();
    }
    this.inoutputVariable.add(inoutputVariableItem);
    return this;
  }

  /**
   * Get inoutputVariable
   * @return inoutputVariable
   **/
  @Schema(description = "")
      @Valid
    public List<OperationVariable> getInoutputVariable() {
    return inoutputVariable;
  }

  public void setInoutputVariable(List<OperationVariable> inoutputVariable) {
    this.inoutputVariable = inoutputVariable;
  }

  public Operation inputVariable(List<OperationVariable> inputVariable) {
    this.inputVariable = inputVariable;
    return this;
  }

  public Operation addInputVariableItem(OperationVariable inputVariableItem) {
    if (this.inputVariable == null) {
      this.inputVariable = new ArrayList<>();
    }
    this.inputVariable.add(inputVariableItem);
    return this;
  }

  /**
   * Get inputVariable
   * @return inputVariable
   **/
  @Schema(description = "")
      @Valid
    public List<OperationVariable> getInputVariable() {
    return inputVariable;
  }

  public void setInputVariable(List<OperationVariable> inputVariable) {
    this.inputVariable = inputVariable;
  }

  public Operation outputVariable(List<OperationVariable> outputVariable) {
    this.outputVariable = outputVariable;
    return this;
  }

  public Operation addOutputVariableItem(OperationVariable outputVariableItem) {
    if (this.outputVariable == null) {
      this.outputVariable = new ArrayList<>();
    }
    this.outputVariable.add(outputVariableItem);
    return this;
  }

  /**
   * Get outputVariable
   * @return outputVariable
   **/
  @Schema(description = "")
      @Valid
    public List<OperationVariable> getOutputVariable() {
    return outputVariable;
  }

  public void setOutputVariable(List<OperationVariable> outputVariable) {
    this.outputVariable = outputVariable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operation operation = (Operation) o;
    return Objects.equals(this.inoutputVariable, operation.inoutputVariable) &&
        Objects.equals(this.inputVariable, operation.inputVariable) &&
        Objects.equals(this.outputVariable, operation.outputVariable) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inoutputVariable, inputVariable, outputVariable, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inoutputVariable: ").append(toIndentedString(inoutputVariable)).append("\n");
    sb.append("    inputVariable: ").append(toIndentedString(inputVariable)).append("\n");
    sb.append("    outputVariable: ").append(toIndentedString(outputVariable)).append("\n");
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
