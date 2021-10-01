/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

// TODO: Auto-generated Javadoc
/**
 * The Class PartMapping.
 */
@Entity
@Table(name = "part_mapping")
public class PartMapping implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 888583131406517872L;

	/** The part number manufacturer. */
	@Id
	@CsvBindByName
	private String partNumberManufacturer = null;

	/** The part name manufacturer. */
	@CsvBindByName
	private String partNameManufacturer = null;

	/** The part number customer. */
	@CsvBindByName
	private String partNumberCustomer = null;

	/** The part name customer. */
	@CsvBindByName
	private String partNameCustomer = null;

	/** The country 1. */
	@CsvBindByName
	private String country1 = null;

	/** The country 2. */
	@CsvBindByName
	private String country2 = null;

	/**
	 * Instantiates a new part mapping.
	 */
	public PartMapping() {

	}

	/**
	 * Instantiates a new part mapping.
	 *
	 * @param partNumberManufacturer the part number manufacturer
	 * @param partNameManufacturer   the part name manufacturer
	 * @param partNumberCustomer     the part number customer
	 * @param partNameCustomer       the part name customer
	 */
	public PartMapping(String partNumberManufacturer, String partNameManufacturer, String partNumberCustomer,
			String partNameCustomer) {
		this.partNumberCustomer = partNumberCustomer;
		this.partNameCustomer = partNameCustomer;
		this.partNumberManufacturer = partNumberManufacturer;
		this.partNameManufacturer = partNameManufacturer;
	}

	/**
	 * Gets the country 1.
	 *
	 * @return the country 1
	 */
	public String getCountry1() {
		return country1;
	}

	/**
	 * Gets the country 2.
	 *
	 * @return the country 2
	 */
	public String getCountry2() {
		return country2;
	}

	/**
	 * Gets the part name customer.
	 *
	 * @return the part name customer
	 */
	public String getPartNameCustomer() {
		return partNameCustomer;
	}

	/**
	 * Gets the part name manufacturer.
	 *
	 * @return the part name manufacturer
	 */
	public String getPartNameManufacturer() {
		return partNameManufacturer;
	}

	/**
	 * Gets the part number customer.
	 *
	 * @return the part number customer
	 */
	public String getPartNumberCustomer() {
		return partNumberCustomer;
	}

	/**
	 * Gets the part number manufacturer.
	 *
	 * @return the part number manufacturer
	 */
	public String getPartNumberManufacturer() {
		return partNumberManufacturer;
	}

	/**
	 * Sets the country 1.
	 *
	 * @param country1 the new country 1
	 */
	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	/**
	 * Sets the country 2.
	 *
	 * @param country2 the new country 2
	 */
	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	/**
	 * Sets the part name customer.
	 *
	 * @param partNameCustomer the new part name customer
	 */
	public void setPartNameCustomer(String partNameCustomer) {
		this.partNameCustomer = partNameCustomer;
	}

	/**
	 * Sets the part name manufacturer.
	 *
	 * @param partNameManufacturer the new part name manufacturer
	 */
	public void setPartNameManufacturer(String partNameManufacturer) {
		this.partNameManufacturer = partNameManufacturer;
	}

	/**
	 * Sets the part number customer.
	 *
	 * @param partNumberCustomer the new part number customer
	 */
	public void setPartNumberCustomer(String partNumberCustomer) {
		this.partNumberCustomer = partNumberCustomer;
	}

	/**
	 * Sets the part number manufacturer.
	 *
	 * @param partNumberManufacturer the new part number manufacturer
	 */
	public void setPartNumberManufacturer(String partNumberManufacturer) {
		this.partNumberManufacturer = partNumberManufacturer;
	}

}
