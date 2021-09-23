package com.catenax.tdm.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets DisassemblyStatus
 */
public enum DisassemblyStatus {
  ASSEMBLED("assembled"),
    DISASSEMBLED("disassembled");

  private String value;

  DisassemblyStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DisassemblyStatus fromValue(String text) {
    for (DisassemblyStatus b : DisassemblyStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
