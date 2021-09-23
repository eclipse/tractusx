package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AggregateStatesEnumeration
 */
public enum AggregateStatesEnumeration {
  GAS("gas"),
    LIQUID("liquid"),
    SOLID("solid");

  private String value;

  AggregateStatesEnumeration(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AggregateStatesEnumeration fromValue(String text) {
    for (AggregateStatesEnumeration b : AggregateStatesEnumeration.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
