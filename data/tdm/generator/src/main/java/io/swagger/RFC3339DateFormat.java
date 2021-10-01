/*
 *
 */
package io.swagger;

import java.text.FieldPosition;
import java.util.Date;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class RFC3339DateFormat.
 */
public class RFC3339DateFormat extends ISO8601DateFormat {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Format.
	 *
	 * @param date          the date
	 * @param toAppendTo    the to append to
	 * @param fieldPosition the field position
	 * @return the string buffer
	 */
	// Same as ISO8601DateFormat but serializing milliseconds.
	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		final String value = ISO8601Utils.format(date, true);
		toAppendTo.append(value);
		return toAppendTo;
	}

}