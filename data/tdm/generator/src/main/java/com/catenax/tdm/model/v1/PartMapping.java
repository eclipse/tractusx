package com.catenax.tdm.model.v1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

@Entity
public class PartMapping implements Serializable {

	private static final long serialVersionUID = 888583131406517872L;

	@Id
	@CsvBindByName
	private String partNumberManufacturer = null;
	
	@CsvBindByName
	private String partNameManufacturer = null;
	
	@CsvBindByName
	private String partNumberCustomer = null;
	
	@CsvBindByName
	private String partNameCustomer = null;

	public PartMapping() {

	}

	public PartMapping(String partNumberManufacturer, String partNameManufacturer, String partNumberCustomer, String partNameCustomer) {
		this.partNumberCustomer = partNumberCustomer;
		this.partNameCustomer = partNameCustomer;		
		this.partNumberManufacturer = partNumberManufacturer;
		this.partNameManufacturer = partNameManufacturer;
	}

	public String getPartNumberManufacturer() {
		return partNumberManufacturer;
	}

	public void setPartNumberManufacturer(String partNumberManufacturer) {
		this.partNumberManufacturer = partNumberManufacturer;
	}

	public String getPartNameManufacturer() {
		return partNameManufacturer;
	}

	public void setPartNameManufacturer(String partNameManufacturer) {
		this.partNameManufacturer = partNameManufacturer;
	}

	public String getPartNumberCustomer() {
		return partNumberCustomer;
	}

	public void setPartNumberCustomer(String partNumberCustomer) {
		this.partNumberCustomer = partNumberCustomer;
	}

	public String getPartNameCustomer() {
		return partNameCustomer;
	}

	public void setPartNameCustomer(String partNameCustomer) {
		this.partNameCustomer = partNameCustomer;
	}

	

}
