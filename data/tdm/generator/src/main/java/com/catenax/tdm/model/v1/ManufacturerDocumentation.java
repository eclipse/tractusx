/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * ManufacturerDocumentation.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

public class ManufacturerDocumentation {

	/** The documents. */
	@JsonProperty("documents")
	private Documents documents = null;

	/**
	 * Documents.
	 *
	 * @param documents the documents
	 * @return the manufacturer documentation
	 */
	public ManufacturerDocumentation documents(Documents documents) {
		this.documents = documents;
		return this;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final ManufacturerDocumentation manufacturerDocumentation = (ManufacturerDocumentation) o;
		return Objects.equals(this.documents, manufacturerDocumentation.documents);
	}

	/**
	 * Get documents.
	 *
	 * @return documents
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Documents getDocuments() {
		return documents;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(documents);
	}

	/**
	 * Sets the documents.
	 *
	 * @param documents the new documents
	 */
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 *
	 * @param o the o
	 * @return the string
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ManufacturerDocumentation {\n");

		sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
