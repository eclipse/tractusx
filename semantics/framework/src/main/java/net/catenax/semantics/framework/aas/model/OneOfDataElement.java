package net.catenax.semantics.framework.aas.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfDataElement
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Blob.class, name = "Blob"),
  @JsonSubTypes.Type(value = File.class, name = "File"),
  @JsonSubTypes.Type(value = MultiLanguageProperty.class, name = "MultiLanguageProperty"),
  @JsonSubTypes.Type(value = Property.class, name = "Property"),
  @JsonSubTypes.Type(value = Range.class, name = "Range"),
  @JsonSubTypes.Type(value = ReferenceElement.class, name = "ReferenceElement")
})
public interface OneOfDataElement {

}
