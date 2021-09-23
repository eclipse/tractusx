package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets MaterialTypesEnumeration
 */
public enum MaterialTypesEnumeration {
  METAL("metal"),
    PLASTIC("plastic"),
    OTHER("other");

  private String value;

  MaterialTypesEnumeration(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MaterialTypesEnumeration fromValue(String text) {
    for (MaterialTypesEnumeration b : MaterialTypesEnumeration.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
