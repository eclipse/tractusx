package net.catenax.semantics.framework.aas.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets ValueTypeEnum
 */
public enum ValueTypeEnum {
  ANYURI("anyUri"),
    BASE64BINARY("base64Binary"),
    BOOLEAN("boolean"),
    DATE("date"),
    DATETIME("dateTime"),
    DATETIMESTAMP("dateTimeStamp"),
    DECIMAL("decimal"),
    INTEGER("integer"),
    LONG("long"),
    INT("int"),
    SHORT("short"),
    BYTE("byte"),
    NONNEGATIVEINTEGER("nonNegativeInteger"),
    POSITIVEINTEGER("positiveInteger"),
    UNSIGNEDLONG("unsignedLong"),
    UNSIGNEDINT("unsignedInt"),
    UNSIGNEDSHORT("unsignedShort"),
    UNSIGNEDBYTE("unsignedByte"),
    NONPOSITIVEINTEGER("nonPositiveInteger"),
    NEGATIVEINTEGER("negativeInteger"),
    DOUBLE("double"),
    DURATION("duration"),
    DAYTIMEDURATION("dayTimeDuration"),
    YEARMONTHDURATION("yearMonthDuration"),
    FLOAT("float"),
    GDAY("gDay"),
    GMONTH("gMonth"),
    GMONTHDAY("gMonthDay"),
    GYEAR("gYear"),
    GYEARMONTH("gYearMonth"),
    HEXBINARY("hexBinary"),
    NOTATION("NOTATION"),
    QNAME("QName"),
    STRING("string"),
    NORMALIZEDSTRING("normalizedString"),
    TOKEN("token"),
    LANGUAGE("language"),
    NAME("Name"),
    NCNAME("NCName"),
    ENTITY("ENTITY"),
    ID("ID"),
    IDREF("IDREF"),
    NMTOKEN("NMTOKEN"),
    TIME("time");

  private String value;

  ValueTypeEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ValueTypeEnum fromValue(String text) {
    for (ValueTypeEnum b : ValueTypeEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
