/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.aas;

import feign.Param;

import java.text.DateFormat;
import java.util.Date;

/**
 * Param Expander to convert {@link Date} to RFC3339
 */
public class ParamExpander implements Param.Expander {

  private static final DateFormat dateformat = new RFC3339DateFormat();

  @Override
  public String expand(Object value) {
    if (value instanceof Date) {
      return dateformat.format(value);
    }
    return value.toString();
  }
}
