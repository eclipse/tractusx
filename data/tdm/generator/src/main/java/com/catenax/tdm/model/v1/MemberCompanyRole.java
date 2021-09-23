package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets MemberCompanyRole
 */
public enum MemberCompanyRole {
  ACTIVE_PARTICIPANT("ACTIVE_PARTICIPANT"),
    APP_PROVIDER("APP_PROVIDER"),
    OPERATIONS_INFRASTRUCTURE_PROVIDER("OPERATIONS_INFRASTRUCTURE_PROVIDER"),
    CONSULTING("CONSULTING"),
    CLEARING_HOUSE("CLEARING_HOUSE");

  private String value;

  MemberCompanyRole(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MemberCompanyRole fromValue(String text) {
    for (MemberCompanyRole b : MemberCompanyRole.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
