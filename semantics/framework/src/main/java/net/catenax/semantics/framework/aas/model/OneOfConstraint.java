package net.catenax.semantics.framework.aas.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfConstraint
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Qualifier.class, name = "Qualifier"),
  @JsonSubTypes.Type(value = Formula.class, name = "Formula")
})
public interface OneOfConstraint {

}
