/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectMapping.
 */
@Entity
@Table(name = "aspect_mapping")
public class AspectMapping {

	/** The db id. */
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long dbId;
	
	private String parentBpn = null;

	/** The part. */
	@OneToOne
	private PartId part = null;

	/** The material. */
	@OneToMany
	private List<Material> material = new ArrayList<>();

	/** The documents. */
	@OneToMany
	private List<DocumentsInner> documents = new ArrayList<>();

	/** The technical data. */
	@OneToMany
	private List<TechnicalData> technicalData = new ArrayList<>();

	/** The product description. */
	@OneToMany
	private List<ProductDescription> productDescription = new ArrayList<>();

	/** The product usage. */
	@OneToMany
	private List<ProductUsage> productUsage = new ArrayList<>();

	/** The return request. */
	@OneToMany
	private List<ReturnRequest> returnRequest = new ArrayList<>();

	/**
	 * Instantiates a new aspect mapping.
	 */
	public AspectMapping() {

	}

	/**
	 * Instantiates a new aspect mapping.
	 *
	 * @param partId the part id
	 */
	public AspectMapping(PartId partId) {
		this.part = partId;
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
	 * Gets the documents.
	 *
	 * @return the documents
	 */
	public List<DocumentsInner> getDocuments() {
		return documents;
	}

	/**
	 * Gets the material.
	 *
	 * @return the material
	 */
	public List<Material> getMaterial() {
		return material;
	}

	/**
	 * Gets the part.
	 *
	 * @return the part
	 */
	public PartId getPart() {
		return part;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public List<ProductDescription> getProductDescription() {
		return productDescription;
	}

	/**
	 * Gets the product usage.
	 *
	 * @return the product usage
	 */
	public List<ProductUsage> getProductUsage() {
		return productUsage;
	}

	/**
	 * Gets the return request.
	 *
	 * @return the return request
	 */
	public List<ReturnRequest> getReturnRequest() {
		return returnRequest;
	}

	/**
	 * Gets the technical data.
	 *
	 * @return the technical data
	 */
	public List<TechnicalData> getTechnicalData() {
		return technicalData;
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
	 * Sets the documents.
	 *
	 * @param documents the new documents
	 */
	public void setDocuments(List<DocumentsInner> documents) {
		this.documents = documents;
	}

	/**
	 * Sets the material.
	 *
	 * @param material the new material
	 */
	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	/**
	 * Sets the part.
	 *
	 * @param part the new part
	 */
	public void setPart(PartId part) {
		this.part = part;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(List<ProductDescription> productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Sets the product usage.
	 *
	 * @param productUsage the new product usage
	 */
	public void setProductUsage(List<ProductUsage> productUsage) {
		this.productUsage = productUsage;
	}

	/**
	 * Sets the return request.
	 *
	 * @param returnRequest the new return request
	 */
	public void setReturnRequest(List<ReturnRequest> returnRequest) {
		this.returnRequest = returnRequest;
	}

	/**
	 * Sets the technical data.
	 *
	 * @param technicalData the new technical data
	 */
	public void setTechnicalData(List<TechnicalData> technicalData) {
		this.technicalData = technicalData;
	}

	public String getParentBpn() {
		return this.parentBpn;
	}

	public void setParentBpn(String pParentBpn) {
		this.parentBpn = pParentBpn;
	}

}
