package net.catenax.semantics.framework.aas.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfCapability
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Blob.class, name = "Blob"),
  @JsonSubTypes.Type(value = File.class, name = "File"),
  @JsonSubTypes.Type(value = Capability.class, name = "Capability"),
  @JsonSubTypes.Type(value = Entity.class, name = "Entity"),
  @JsonSubTypes.Type(value = Event.class, name = "Event"),
  @JsonSubTypes.Type(value = BasicEvent.class, name = "BasicEvent"),
  @JsonSubTypes.Type(value = MultiLanguageProperty.class, name = "MultiLanguageProperty"),
  @JsonSubTypes.Type(value = Operation.class, name = "Operation"),
  @JsonSubTypes.Type(value = Property.class, name = "Property"),
  @JsonSubTypes.Type(value = Range.class, name = "Range"),
  @JsonSubTypes.Type(value = ReferenceElement.class, name = "ReferenceElement"),
  @JsonSubTypes.Type(value = AnnotatedRelationshipElement.class, name = "AnnotatedRelationshipElement"),
  @JsonSubTypes.Type(value = RelationshipElement.class, name = "RelationshipElement"),
  @JsonSubTypes.Type(value = SubmodelElementList.class, name = "SubmodelElementList"),
  @JsonSubTypes.Type(value = SubmodelElementStruct.class, name = "SubmodelElementStruct")
})
public interface OneOfCapability {

}
