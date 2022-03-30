package net.catenax.semantics.framework.aas.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AssetKind
 */
public enum AssetKind {
  TYPE("Type"),
    INSTANCE("Instance");

  private String value;

  AssetKind(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AssetKind fromValue(String text) {
    for (AssetKind b : AssetKind.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
