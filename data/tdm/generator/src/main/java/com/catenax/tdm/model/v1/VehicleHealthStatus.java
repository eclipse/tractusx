package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets VehicleHealthStatus
 */
public enum VehicleHealthStatus {
  IN_RUNNING_CONDITION("in running condition"),
    REPAIR_REQUIRED("repair required"),
    BROKEN("broken");

  private String value;

  VehicleHealthStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static VehicleHealthStatus fromValue(String text) {
    for (VehicleHealthStatus b : VehicleHealthStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
