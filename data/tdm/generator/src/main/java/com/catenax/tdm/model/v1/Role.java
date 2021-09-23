package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Role
 */
public enum Role {
  AUTHOR("Author"),
    CUSTOMER("Customer"),
    SUPPLIER("Supplier"),
    MANUFACTURER("Manufacturer"),
    RESPONSIBLE("Responsible");

  private String value;

  Role(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Role fromValue(String text) {
    for (Role b : Role.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
