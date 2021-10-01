/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * DocumentVersionsInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_documentation_version_inner")
public class DocumentVersionsInner {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The languages. */
	@JsonProperty("languages")
	@OneToOne
	private LanguageSet languages = null;

	/** The document version id. */
	@JsonProperty("documentVersionId")
	private String documentVersionId = null;

	/** The title. */
	@JsonProperty("title")
	@OneToOne
	private MultiLanguageProperty title = null;

	/** The summary. */
	@JsonProperty("summary")
	@OneToOne
	private MultiLanguageProperty summary = null;

	/** The key words. */
	@JsonProperty("keyWords")
	@OneToOne
	private MultiLanguageProperty keyWords = null;

	/** The set date. */
	@JsonProperty("setDate")
	private String setDate = null;

	/** The status value. */
	@JsonProperty("statusValue")
	@OneToOne
	private StatusValueCharacteristic statusValue = null;

	/** The role. */
	@JsonProperty("role")
	private Role role = null;

	/** The organization official name. */
	@JsonProperty("organizationOfficialName")
	private String organizationOfficialName = null;

	/** The organization name. */
	@JsonProperty("organizationName")
	private String organizationName = null;

	/** The digital files. */
	@JsonProperty("digitalFiles")
	@OneToOne
	private DigitalFiles digitalFiles = null;

	/**
	 * Digital files.
	 *
	 * @param digitalFiles the digital files
	 * @return the document versions inner
	 */
	public DocumentVersionsInner digitalFiles(DigitalFiles digitalFiles) {
		this.digitalFiles = digitalFiles;
		return this;
	}

	/**
	 * Document version id.
	 *
	 * @param documentVersionId the document version id
	 * @return the document versions inner
	 */
	public DocumentVersionsInner documentVersionId(String documentVersionId) {
		this.documentVersionId = documentVersionId;
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
		final DocumentVersionsInner documentVersionsInner = (DocumentVersionsInner) o;
		return Objects.equals(this.languages, documentVersionsInner.languages)
				&& Objects.equals(this.documentVersionId, documentVersionsInner.documentVersionId)
				&& Objects.equals(this.title, documentVersionsInner.title)
				&& Objects.equals(this.summary, documentVersionsInner.summary)
				&& Objects.equals(this.keyWords, documentVersionsInner.keyWords)
				&& Objects.equals(this.setDate, documentVersionsInner.setDate)
				&& Objects.equals(this.statusValue, documentVersionsInner.statusValue)
				&& Objects.equals(this.role, documentVersionsInner.role)
				&& Objects.equals(this.organizationOfficialName, documentVersionsInner.organizationOfficialName)
				&& Objects.equals(this.organizationName, documentVersionsInner.organizationName)
				&& Objects.equals(this.digitalFiles, documentVersionsInner.digitalFiles);
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
	 * Get digitalFiles.
	 *
	 * @return digitalFiles
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public DigitalFiles getDigitalFiles() {
		return digitalFiles;
	}

	/**
	 * Get documentVersionId.
	 *
	 * @return documentVersionId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getDocumentVersionId() {
		return documentVersionId;
	}

	/**
	 * Get keyWords.
	 *
	 * @return keyWords
	 */
	@Schema(description = "")

	@Valid
	public MultiLanguageProperty getKeyWords() {
		return keyWords;
	}

	/**
	 * Get languages.
	 *
	 * @return languages
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public LanguageSet getLanguages() {
		return languages;
	}

	/**
	 * Get organizationName.
	 *
	 * @return organizationName
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Get organizationOfficialName.
	 *
	 * @return organizationOfficialName
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getOrganizationOfficialName() {
		return organizationOfficialName;
	}

	/**
	 * Get role.
	 *
	 * @return role
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Role getRole() {
		return role;
	}

	/**
	 * Get setDate.
	 *
	 * @return setDate
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getSetDate() {
		return setDate;
	}

	/**
	 * Get statusValue.
	 *
	 * @return statusValue
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public StatusValueCharacteristic getStatusValue() {
		return statusValue;
	}

	/**
	 * Get summary.
	 *
	 * @return summary
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public MultiLanguageProperty getSummary() {
		return summary;
	}

	/**
	 * Get title.
	 *
	 * @return title
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public MultiLanguageProperty getTitle() {
		return title;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(languages, documentVersionId, title, summary, keyWords, setDate, statusValue, role,
				organizationOfficialName, organizationName, digitalFiles);
	}

	/**
	 * Key words.
	 *
	 * @param keyWords the key words
	 * @return the document versions inner
	 */
	public DocumentVersionsInner keyWords(MultiLanguageProperty keyWords) {
		this.keyWords = keyWords;
		return this;
	}

	/**
	 * Languages.
	 *
	 * @param languages the languages
	 * @return the document versions inner
	 */
	public DocumentVersionsInner languages(LanguageSet languages) {
		this.languages = languages;
		return this;
	}

	/**
	 * Organization name.
	 *
	 * @param organizationName the organization name
	 * @return the document versions inner
	 */
	public DocumentVersionsInner organizationName(String organizationName) {
		this.organizationName = organizationName;
		return this;
	}

	/**
	 * Organization official name.
	 *
	 * @param organizationOfficialName the organization official name
	 * @return the document versions inner
	 */
	public DocumentVersionsInner organizationOfficialName(String organizationOfficialName) {
		this.organizationOfficialName = organizationOfficialName;
		return this;
	}

	/**
	 * Role.
	 *
	 * @param role the role
	 * @return the document versions inner
	 */
	public DocumentVersionsInner role(Role role) {
		this.role = role;
		return this;
	}

	/**
	 * Sets the date.
	 *
	 * @param setDate the set date
	 * @return the document versions inner
	 */
	public DocumentVersionsInner setDate(String setDate) {
		this.setDate = setDate;
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
	 * Sets the digital files.
	 *
	 * @param digitalFiles the new digital files
	 */
	public void setDigitalFiles(DigitalFiles digitalFiles) {
		this.digitalFiles = digitalFiles;
	}

	/**
	 * Sets the document version id.
	 *
	 * @param documentVersionId the new document version id
	 */
	public void setDocumentVersionId(String documentVersionId) {
		this.documentVersionId = documentVersionId;
	}

	/**
	 * Sets the key words.
	 *
	 * @param keyWords the new key words
	 */
	public void setKeyWords(MultiLanguageProperty keyWords) {
		this.keyWords = keyWords;
	}

	/**
	 * Sets the languages.
	 *
	 * @param languages the new languages
	 */
	public void setLanguages(LanguageSet languages) {
		this.languages = languages;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organizationName the new organization name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Sets the organization official name.
	 *
	 * @param organizationOfficialName the new organization official name
	 */
	public void setOrganizationOfficialName(String organizationOfficialName) {
		this.organizationOfficialName = organizationOfficialName;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Sets the sets the date.
	 *
	 * @param setDate the new sets the date
	 */
	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}

	/**
	 * Sets the status value.
	 *
	 * @param statusValue the new status value
	 */
	public void setStatusValue(StatusValueCharacteristic statusValue) {
		this.statusValue = statusValue;
	}

	/**
	 * Sets the summary.
	 *
	 * @param summary the new summary
	 */
	public void setSummary(MultiLanguageProperty summary) {
		this.summary = summary;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(MultiLanguageProperty title) {
		this.title = title;
	}

	/**
	 * Status value.
	 *
	 * @param statusValue the status value
	 * @return the document versions inner
	 */
	public DocumentVersionsInner statusValue(StatusValueCharacteristic statusValue) {
		this.statusValue = statusValue;
		return this;
	}

	/**
	 * Summary.
	 *
	 * @param summary the summary
	 * @return the document versions inner
	 */
	public DocumentVersionsInner summary(MultiLanguageProperty summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Title.
	 *
	 * @param title the title
	 * @return the document versions inner
	 */
	public DocumentVersionsInner title(MultiLanguageProperty title) {
		this.title = title;
		return this;
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
		sb.append("class DocumentVersionsInner {\n");

		sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
		sb.append("    documentVersionId: ").append(toIndentedString(documentVersionId)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
		sb.append("    keyWords: ").append(toIndentedString(keyWords)).append("\n");
		sb.append("    setDate: ").append(toIndentedString(setDate)).append("\n");
		sb.append("    statusValue: ").append(toIndentedString(statusValue)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    organizationOfficialName: ").append(toIndentedString(organizationOfficialName)).append("\n");
		sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
		sb.append("    digitalFiles: ").append(toIndentedString(digitalFiles)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
