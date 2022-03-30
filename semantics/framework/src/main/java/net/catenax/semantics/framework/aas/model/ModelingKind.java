package net.catenax.semantics.framework.aas.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets ModelingKind
 */
public enum ModelingKind {
  TEMPLATE("Template"),
    INSTANCE("Instance");

  private String value;

  ModelingKind(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ModelingKind fromValue(String text) {
    for (ModelingKind b : ModelingKind.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
