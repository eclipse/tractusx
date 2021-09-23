package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Aspect location data
 */
@Schema(description = "Aspect location data")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T07:44:31.526Z[GMT]")

@Entity
public class Aspect implements Serializable {

	private static final long serialVersionUID = -3906957138698189701L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;

	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("url")
	private String url = null;

	public Aspect name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Aspect name
	 * 
	 * @return name
	 **/
	@Schema(example = "CE", description = "Aspect name")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aspect url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Url location of an aspect
	 * 
	 * @return url
	 **/
	@Schema(example = "http://aspects-url/CE", description = "Url location of an aspect")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Aspect aspect = (Aspect) o;
		return Objects.equals(this.name, aspect.name) && Objects.equals(this.url, aspect.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Aspect {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
