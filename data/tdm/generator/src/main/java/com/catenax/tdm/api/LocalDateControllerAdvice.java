/*
 *
 */
package com.catenax.tdm.api;

import java.beans.PropertyEditorSupport;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalDateControllerAdvice.
 */
@ControllerAdvice
public class LocalDateControllerAdvice {

	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
			}
		});
	}
}