/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Aspect location data.
 */
@Schema(description = "Aspect location data")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
@Table(name = "aspect_reference")
public class Aspect implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3906957138698189701L;

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	/** The name. */
	@JsonProperty("name")
	private String name = null;

	/** The url. */
	@JsonProperty("url")
	private String url = null;

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
		final Aspect aspect = (Aspect) o;
		return Objects.equals(this.name, aspect.name) && Objects.equals(this.url, aspect.url);
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
	 * Aspect name.
	 *
	 * @return name
	 */
	@Schema(example = "CE", description = "Aspect name")

	public String getName() {
		return name;
	}

	/**
	 * Url location of an aspect.
	 *
	 * @return url
	 */
	@Schema(example = "http://aspects-url/CE", description = "Url location of an aspect")

	public String getUrl() {
		return url;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, url);
	}

	/**
	 * Name.
	 *
	 * @param name the name
	 * @return the aspect
	 */
	public Aspect name(String name) {
		this.name = name;
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
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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
		sb.append("class Aspect {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Url.
	 *
	 * @param url the url
	 * @return the aspect
	 */
	public Aspect url(String url) {
		this.url = url;
		return this;
	}
}
