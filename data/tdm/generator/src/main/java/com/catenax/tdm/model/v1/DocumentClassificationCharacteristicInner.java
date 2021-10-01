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
 * DocumentClassificationCharacteristicInner.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:43:11.126Z[GMT]")

@Entity
@Table(name = "aspect_documentation_classification_inner")
public class DocumentClassificationCharacteristicInner {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The class id. */
	@JsonProperty("classId")
	private String classId = null;

	/** The class name. */
	@JsonProperty("className")
	@OneToOne
	private MultiLanguageProperty className = null;

	/** The document classification system. */
	@JsonProperty("documentClassificationSystem")
	private String documentClassificationSystem = null;

	/**
	 * Class id.
	 *
	 * @param classId the class id
	 * @return the document classification characteristic inner
	 */
	public DocumentClassificationCharacteristicInner classId(String classId) {
		this.classId = classId;
		return this;
	}

	/**
	 * Class name.
	 *
	 * @param className the class name
	 * @return the document classification characteristic inner
	 */
	public DocumentClassificationCharacteristicInner className(MultiLanguageProperty className) {
		this.className = className;
		return this;
	}

	/**
	 * Document classification system.
	 *
	 * @param documentClassificationSystem the document classification system
	 * @return the document classification characteristic inner
	 */
	public DocumentClassificationCharacteristicInner documentClassificationSystem(String documentClassificationSystem) {
		this.documentClassificationSystem = documentClassificationSystem;
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
		final DocumentClassificationCharacteristicInner documentClassificationCharacteristicInner = (DocumentClassificationCharacteristicInner) o;
		return Objects.equals(this.classId, documentClassificationCharacteristicInner.classId)
				&& Objects.equals(this.className, documentClassificationCharacteristicInner.className)
				&& Objects.equals(this.documentClassificationSystem,
						documentClassificationCharacteristicInner.documentClassificationSystem);
	}

	/**
	 * Get classId.
	 *
	 * @return classId
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getClassId() {
		return classId;
	}

	/**
	 * Get className.
	 *
	 * @return className
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public MultiLanguageProperty getClassName() {
		return className;
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
	 * Get documentClassificationSystem.
	 *
	 * @return documentClassificationSystem
	 */
	@Schema(description = "")

	public String getDocumentClassificationSystem() {
		return documentClassificationSystem;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(classId, className, documentClassificationSystem);
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the new class id
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(MultiLanguageProperty className) {
		this.className = className;
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
	 * Sets the document classification system.
	 *
	 * @param documentClassificationSystem the new document classification system
	 */
	public void setDocumentClassificationSystem(String documentClassificationSystem) {
		this.documentClassificationSystem = documentClassificationSystem;
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
		sb.append("class DocumentClassificationCharacteristicInner {\n");

		sb.append("    classId: ").append(toIndentedString(classId)).append("\n");
		sb.append("    className: ").append(toIndentedString(className)).append("\n");
		sb.append("    documentClassificationSystem: ").append(toIndentedString(documentClassificationSystem))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}
}
