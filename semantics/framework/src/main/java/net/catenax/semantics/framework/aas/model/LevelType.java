package net.catenax.semantics.framework.aas.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets LevelType
 */
public enum LevelType {
  MIN("Min"),
    MAX("Max"),
    NOM("Nom"),
    TYP("Typ");

  private String value;

  LevelType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static LevelType fromValue(String text) {
    for (LevelType b : LevelType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
