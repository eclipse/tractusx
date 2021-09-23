package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets urn_bamm_com.catenaX_0.0.1_QualityTypeEnum
 */
public enum QualityTypeEnum {
  MAJOR("major"),
    MINOR("minor"),
    CRITICAL("critical");

  private String value;

  QualityTypeEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static QualityTypeEnum fromValue(String text) {
    for (QualityTypeEnum b : QualityTypeEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
