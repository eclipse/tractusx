/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * DocumentIdCharacteristicInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_documentation_id_inner")
public class DocumentIdCharacteristicInner {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The document domain id. */
	@JsonProperty("documentDomainId")
	private String documentDomainId = null;

	/** The value id. */
	@JsonProperty("valueId")
	private String valueId = null;

	/** The is primary. */
	@JsonProperty("isPrimary")
	private Boolean isPrimary = null;

	/**
	 * Document domain id.
	 *
	 * @param documentDomainId the document domain id
	 * @return the document id characteristic inner
	 */
	public DocumentIdCharacteristicInner documentDomainId(String documentDomainId) {
		this.documentDomainId = documentDomainId;
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
		final DocumentIdCharacteristicInner documentIdCharacteristicInner = (DocumentIdCharacteristicInner) o;
		return Objects.equals(this.documentDomainId, documentIdCharacteristicInner.documentDomainId)
				&& Objects.equals(this.valueId, documentIdCharacteristicInner.valueId)
				&& Objects.equals(this.isPrimary, documentIdCharacteristicInner.isPrimary);
	}

	/**
	 * Gets the db id.
	 *
	 * @return the db id
	 */
	public Long getDbId() {
		return dbId;
	}

	/**
	 * Get documentDomainId.
	 *
	 * @return documentDomainId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getDocumentDomainId() {
		return documentDomainId;
	}

	/**
	 * Get isPrimary.
	 *
	 * @return isPrimary
	 */
	@Schema(description = "")

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	/**
	 * Get valueId.
	 *
	 * @return valueId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getValueId() {
		return valueId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(documentDomainId, valueId, isPrimary);
	}

	/**
	 * Checks if is primary.
	 *
	 * @param isPrimary the is primary
	 * @return the document id characteristic inner
	 */
	public DocumentIdCharacteristicInner isPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
		return this;
	}

	/**
	 * Sets the db id.
	 *
	 * @param dbId the new db id
	 */
	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}

	/**
	 * Sets the document domain id.
	 *
	 * @param documentDomainId the new document domain id
	 */
	public void setDocumentDomainId(String documentDomainId) {
		this.documentDomainId = documentDomainId;
	}

	/**
	 * Sets the checks if is primary.
	 *
	 * @param isPrimary the new checks if is primary
	 */
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	/**
	 * Sets the value id.
	 *
	 * @param valueId the new value id
	 */
	public void setValueId(String valueId) {
		this.valueId = valueId;
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
		sb.append("class DocumentIdCharacteristicInner {\n");

		sb.append("    documentDomainId: ").append(toIndentedString(documentDomainId)).append("\n");
		sb.append("    valueId: ").append(toIndentedString(valueId)).append("\n");
		sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Value id.
	 *
	 * @param valueId the value id
	 * @return the document id characteristic inner
	 */
	public DocumentIdCharacteristicInner valueId(String valueId) {
		this.valueId = valueId;
		return this;
	}
}
