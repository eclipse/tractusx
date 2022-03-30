package net.catenax.semantics.framework.aas.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets ModelTypes
 */
public enum ModelTypes {
  ASSETADMINISTRATIONSHELL("AssetAdministrationShell"),
    CONCEPTDESCRIPTION("ConceptDescription"),
    SUBMODEL("Submodel"),
    ANNOTATEDRELATIONSHIPELEMENT("AnnotatedRelationshipElement"),
    BASICEVENT("BasicEvent"),
    BLOB("Blob"),
    CAPABILITY("Capability"),
    DATAELEMENT("DataElement"),
    FILE("File"),
    ENTITY("Entity"),
    EVENT("Event"),
    MODELREFERENCE("ModelReference"),
    MULTILANGUAGEPROPERTY("MultiLanguageProperty"),
    OPERATION("Operation"),
    PROPERTY("Property"),
    RANGE("Range"),
    REFERENCEELEMENT("ReferenceElement"),
    RELATIONSHIPELEMENT("RelationshipElement"),
    SUBMODELELEMENT("SubmodelElement"),
    SUBMODELELEMENTLIST("SubmodelElementList"),
    SUBMODELELEMENTSTRUCT("SubmodelElementStruct"),
    VIEW("View"),
    GLOBALREFERENCE("GlobalReference"),
    FRAGMENTREFERENCE("FragmentReference"),
    CONSTRAINT("Constraint"),
    FORMULA("Formula"),
    QUALIFIER("Qualifier");

  private String value;

  ModelTypes(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ModelTypes fromValue(String text) {
    for (ModelTypes b : ModelTypes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
