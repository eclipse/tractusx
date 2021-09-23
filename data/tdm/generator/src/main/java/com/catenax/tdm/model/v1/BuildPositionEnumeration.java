package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets BuildPositionEnumeration
 */
public enum BuildPositionEnumeration {
  LEFT("left"),
    RIGHT("right"),
    FRONT("front"),
    BACK("back");

  private String value;

  BuildPositionEnumeration(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BuildPositionEnumeration fromValue(String text) {
    for (BuildPositionEnumeration b : BuildPositionEnumeration.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
