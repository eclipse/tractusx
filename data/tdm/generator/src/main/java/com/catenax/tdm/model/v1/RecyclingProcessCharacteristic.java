package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RecyclingProcessCharacteristic
 */
public enum RecyclingProcessCharacteristic {
  PROCESS1("process1"),
    PROCESS2("process2"),
    PROCESS3("process3");

  private String value;

  RecyclingProcessCharacteristic(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RecyclingProcessCharacteristic fromValue(String text) {
    for (RecyclingProcessCharacteristic b : RecyclingProcessCharacteristic.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
