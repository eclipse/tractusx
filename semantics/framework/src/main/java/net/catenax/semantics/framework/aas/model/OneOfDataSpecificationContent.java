package net.catenax.semantics.framework.aas.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfDataSpecificationContent
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = DataSpecificationIEC61360Content.class, name = "DataSpecificationIEC61360Content"),
  @JsonSubTypes.Type(value = DataSpecificationPhysicalUnitContent.class, name = "DataSpecificationPhysicalUnitContent")
})
public interface OneOfDataSpecificationContent {

}
