package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RecyclingStatusCharacteristic
 */
public enum RecyclingStatusCharacteristic {
  RECYCLED("recycled"),
    NOT_RECYCLED("not recycled");

  private String value;

  RecyclingStatusCharacteristic(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RecyclingStatusCharacteristic fromValue(String text) {
    for (RecyclingStatusCharacteristic b : RecyclingStatusCharacteristic.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
