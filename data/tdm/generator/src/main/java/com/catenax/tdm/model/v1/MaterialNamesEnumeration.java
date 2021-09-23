package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets MaterialNamesEnumeration
 */
public enum MaterialNamesEnumeration {
  ALUMINIUM("aluminium"),
    POLYAMIDE("polyamide"),
    OTHERS("others");

  private String value;

  MaterialNamesEnumeration(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MaterialNamesEnumeration fromValue(String text) {
    for (MaterialNamesEnumeration b : MaterialNamesEnumeration.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
