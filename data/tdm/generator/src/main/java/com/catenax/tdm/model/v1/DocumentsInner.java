/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * DocumentsInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_documentation")
public class DocumentsInner {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The document id. */
	@JsonProperty("documentId")
	@OneToMany
	private List<DocumentIdCharacteristicInner> documentId = new ArrayList<>();

	/** The document classifications. */
	@JsonProperty("documentClassifications")
	@OneToMany
	private List<DocumentClassificationCharacteristicInner> documentClassifications = new ArrayList<>();

	/** The document entities. */
	@JsonProperty("documentEntities")
	@Column(name = "document_entity")
	@ElementCollection(targetClass = String.class)
	private List<String> documentEntities = new ArrayList<>();

	/** The document versions. */
	@JsonProperty("documentVersions")
	@OneToMany
	private List<DocumentVersionsInner> documentVersions = new ArrayList<>();

	/**
	 * Document classifications.
	 *
	 * @param documentClassifications the document classifications
	 * @return the documents inner
	 */
	public DocumentsInner documentClassifications(DocumentClassificationCharacteristic documentClassifications) {
		this.documentClassifications = documentClassifications;
		return this;
	}

	/**
	 * Document entities.
	 *
	 * @param documentEntities the document entities
	 * @return the documents inner
	 */
	public DocumentsInner documentEntities(ReferenceElementSet documentEntities) {
		this.documentEntities = documentEntities;
		return this;
	}

	/**
	 * Document id.
	 *
	 * @param documentId the document id
	 * @return the documents inner
	 */
	public DocumentsInner documentId(DocumentIdCharacteristic documentId) {
		this.documentId = documentId;
		return this;
	}

	/**
	 * Document versions.
	 *
	 * @param documentVersions the document versions
	 * @return the documents inner
	 */
	public DocumentsInner documentVersions(DocumentVersions documentVersions) {
		this.documentVersions = documentVersions;
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
		final DocumentsInner documentsInner = (DocumentsInner) o;
		return Objects.equals(this.documentId, documentsInner.documentId)
				&& Objects.equals(this.documentClassifications, documentsInner.documentClassifications)
				&& Objects.equals(this.documentEntities, documentsInner.documentEntities)
				&& Objects.equals(this.documentVersions, documentsInner.documentVersions);
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
	 * Get documentClassifications.
	 *
	 * @return documentClassifications
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public List<DocumentClassificationCharacteristicInner> getDocumentClassifications() {
		return documentClassifications;
	}

	/**
	 * Get documentEntities.
	 *
	 * @return documentEntities
	 */
	@Schema(description = "")

	@Valid
	public List<String> getDocumentEntities() {
		return documentEntities;
	}

	/**
	 * Get documentId.
	 *
	 * @return documentId
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public List<DocumentIdCharacteristicInner> getDocumentId() {
		return documentId;
	}

	/**
	 * Get documentVersions.
	 *
	 * @return documentVersions
	 */
	@Schema(description = "")

	@Valid
	public List<DocumentVersionsInner> getDocumentVersions() {
		return documentVersions;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(documentId, documentClassifications, documentEntities, documentVersions);
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
	 * Sets the document classifications.
	 *
	 * @param documentClassifications the new document classifications
	 */
	public void setDocumentClassifications(List<DocumentClassificationCharacteristicInner> documentClassifications) {
		this.documentClassifications = documentClassifications;
	}

	/**
	 * Sets the document entities.
	 *
	 * @param documentEntities the new document entities
	 */
	public void setDocumentEntities(List<String> documentEntities) {
		this.documentEntities = documentEntities;
	}

	/**
	 * Sets the document id.
	 *
	 * @param documentId the new document id
	 */
	public void setDocumentId(List<DocumentIdCharacteristicInner> documentId) {
		this.documentId = documentId;
	}

	/**
	 * Sets the document versions.
	 *
	 * @param documentVersions the new document versions
	 */
	public void setDocumentVersions(List<DocumentVersionsInner> documentVersions) {
		this.documentVersions = documentVersions;
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
		sb.append("class DocumentsInner {\n");

		sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
		sb.append("    documentClassifications: ").append(toIndentedString(documentClassifications)).append("\n");
		sb.append("    documentEntities: ").append(toIndentedString(documentEntities)).append("\n");
		sb.append("    documentVersions: ").append(toIndentedString(documentVersions)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
