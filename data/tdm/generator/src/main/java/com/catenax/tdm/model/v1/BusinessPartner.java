package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Business Partner
 */
@Schema(description = "Business Partner")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-15T07:34:43.482Z[GMT]")

@Entity
@Table(name = "BUSINESS_PARTNER")
public class BusinessPartner implements Serializable {

	private static final long serialVersionUID = 2022622745531725843L;

	@Id
	@JsonProperty("bpn")
	private String bpn = null;

	@JsonProperty("parent")
	private String parent = null;

	@JsonProperty("accountGroup")
	private String accountGroup = null;

	/*
	 * @JsonProperty("name")
	 * 
	 * @Valid
	 * 
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "BUSINESS_PARTNER_NAMES")
	 * 
	 * @Column(name = "name") private List<String> name = null;
	 */

	@JsonProperty("name1")
	private String name1 = null;

	@JsonProperty("name2")
	private String name2 = null;

	@JsonProperty("name3")
	private String name3 = null;

	@JsonProperty("name4")
	private String name4 = null;

	@JsonProperty("addressVersion")
	private String addressVersion = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("postalCode")
	private String postalCode = null;

	@JsonProperty("street1")
	private String street1 = null;

	@JsonProperty("street2")
	private String street2 = null;

	@JsonProperty("street3")
	private String street3 = null;

	@JsonProperty("houseNumber")
	private String houseNumber = null;

	@JsonProperty("taxNumber1")
	private String taxNumber1 = null;

	@JsonProperty("taxNumber1Type")
	private String taxNumber1Type = null;

	@JsonProperty("taxNumber2")
	private String taxNumber2 = null;

	@JsonProperty("taxNumber2Type")
	private String taxNumber2Type = null;

	@JsonProperty("taxNumber3")
	private String taxNumber3 = null;

	@JsonProperty("taxNumber3Type")
	private String taxNumber3Type = null;

	@JsonProperty("taxNumber4")
	private String taxNumber4 = null;

	@JsonProperty("taxNumber4Type")
	private String taxNumber4Type = null;

	@JsonProperty("taxNumber5")
	private String taxNumber5 = null;

	@JsonProperty("taxNumber5Type")
	private String taxNumber5Type = null;

	@JsonProperty("vatNumber")
	private String vatNumber = null;

	@JsonProperty("vatNumberType")
	private String vatNumberType = null;

	public BusinessPartner bpn(String bpn) {
		this.bpn = bpn;
		return this;
	}

	/**
	 * Get BPN
	 * 
	 * @return BPN
	 **/
	@Schema(description = "")

	@Size(min = 16, max = 16)
	public String getBpn() {
		return bpn;
	}

	public void setBpn(String bpn) {
		this.bpn = bpn;
	}

	public BusinessPartner parent(String parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * Get parent
	 * 
	 * @return parent
	 **/
	@Schema(description = "")

	@Size(min = 16, max = 16)
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public BusinessPartner accountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
		return this;
	}

	/**
	 * Get accountGroup
	 * 
	 * @return accountGroup
	 **/
	@Schema(description = "")

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public BusinessPartner name1(String name1) {
		this.name1 = name1;
		return this;
	}

	/**
	 * Get name1
	 * 
	 * @return name1
	 **/
	@Schema(description = "")

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public BusinessPartner name2(String name2) {
		this.name2 = name2;
		return this;
	}

	/**
	 * Get name2
	 * 
	 * @return name2
	 **/
	@Schema(description = "")

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public BusinessPartner name3(String name3) {
		this.name3 = name3;
		return this;
	}

	/**
	 * Get name3
	 * 
	 * @return name3
	 **/
	@Schema(description = "")

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public BusinessPartner name4(String name4) {
		this.name4 = name4;
		return this;
	}

	/**
	 * Get name4
	 * 
	 * @return name4
	 **/
	@Schema(description = "")

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public BusinessPartner addressVersion(String addressVersion) {
		this.addressVersion = addressVersion;
		return this;
	}

	/**
	 * Get addressVersion
	 * 
	 * @return addressVersion
	 **/
	@Schema(description = "")

	public String getAddressVersion() {
		return addressVersion;
	}

	public void setAddressVersion(String addressVersion) {
		this.addressVersion = addressVersion;
	}

	public BusinessPartner country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	@Schema(description = "")

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BusinessPartner city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 **/
	@Schema(description = "")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BusinessPartner postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Get postalCode
	 * 
	 * @return postalCode
	 **/
	@Schema(description = "")

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public BusinessPartner street1(String street1) {
		this.street1 = street1;
		return this;
	}

	/**
	 * Get street1
	 * 
	 * @return street1
	 **/
	@Schema(description = "")

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public BusinessPartner street2(String street2) {
		this.street2 = street2;
		return this;
	}

	/**
	 * Get street2
	 * 
	 * @return street2
	 **/
	@Schema(description = "")

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public BusinessPartner street3(String street3) {
		this.street3 = street3;
		return this;
	}

	/**
	 * Get street3
	 * 
	 * @return street3
	 **/
	@Schema(description = "")

	public String getStreet3() {
		return street3;
	}

	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	public BusinessPartner houseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	/**
	 * Get houseNumber
	 * 
	 * @return houseNumber
	 **/
	@Schema(description = "")

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public BusinessPartner taxNumber1(String taxNumber1) {
		this.taxNumber1 = taxNumber1;
		return this;
	}

	/**
	 * Get taxNumber1
	 * 
	 * @return taxNumber1
	 **/
	@Schema(description = "")

	public String getTaxNumber1() {
		return taxNumber1;
	}

	public void setTaxNumber1(String taxNumber1) {
		this.taxNumber1 = taxNumber1;
	}

	public BusinessPartner taxNumber1Type(String taxNumber1Type) {
		this.taxNumber1Type = taxNumber1Type;
		return this;
	}

	/**
	 * Get taxNumber1Type
	 * 
	 * @return taxNumber1Type
	 **/
	@Schema(description = "")

	public String getTaxNumber1Type() {
		return taxNumber1Type;
	}

	public void setTaxNumber1Type(String taxNumber1Type) {
		this.taxNumber1Type = taxNumber1Type;
	}

	public BusinessPartner taxNumber2(String taxNumber2) {
		this.taxNumber2 = taxNumber2;
		return this;
	}

	/**
	 * Get taxNumber2
	 * 
	 * @return taxNumber2
	 **/
	@Schema(description = "")

	public String getTaxNumber2() {
		return taxNumber2;
	}

	public void setTaxNumber2(String taxNumber2) {
		this.taxNumber2 = taxNumber2;
	}

	public BusinessPartner taxNumber2Type(String taxNumber2Type) {
		this.taxNumber2Type = taxNumber2Type;
		return this;
	}

	/**
	 * Get taxNumber2Type
	 * 
	 * @return taxNumber2Type
	 **/
	@Schema(description = "")

	public String getTaxNumber2Type() {
		return taxNumber2Type;
	}

	public void setTaxNumber2Type(String taxNumber2Type) {
		this.taxNumber2Type = taxNumber2Type;
	}

	public BusinessPartner taxNumber3(String taxNumber3) {
		this.taxNumber3 = taxNumber3;
		return this;
	}

	/**
	 * Get taxNumber3
	 * 
	 * @return taxNumber3
	 **/
	@Schema(description = "")

	public String getTaxNumber3() {
		return taxNumber3;
	}

	public void setTaxNumber3(String taxNumber3) {
		this.taxNumber3 = taxNumber3;
	}

	public BusinessPartner taxNumber3Type(String taxNumber3Type) {
		this.taxNumber3Type = taxNumber3Type;
		return this;
	}

	/**
	 * Get taxNumber3Type
	 * 
	 * @return taxNumber3Type
	 **/
	@Schema(description = "")

	public String getTaxNumber3Type() {
		return taxNumber3Type;
	}

	public void setTaxNumber3Type(String taxNumber3Type) {
		this.taxNumber3Type = taxNumber3Type;
	}

	public BusinessPartner taxNumber4(String taxNumber4) {
		this.taxNumber4 = taxNumber4;
		return this;
	}

	/**
	 * Get taxNumber4
	 * 
	 * @return taxNumber4
	 **/
	@Schema(description = "")

	public String getTaxNumber4() {
		return taxNumber4;
	}

	public void setTaxNumber4(String taxNumber4) {
		this.taxNumber4 = taxNumber4;
	}

	public BusinessPartner taxNumber4Type(String taxNumber4Type) {
		this.taxNumber4Type = taxNumber4Type;
		return this;
	}

	/**
	 * Get taxNumber4Type
	 * 
	 * @return taxNumber4Type
	 **/
	@Schema(description = "")

	public String getTaxNumber4Type() {
		return taxNumber4Type;
	}

	public void setTaxNumber4Type(String taxNumber4Type) {
		this.taxNumber4Type = taxNumber4Type;
	}

	public BusinessPartner taxNumber5(String taxNumber5) {
		this.taxNumber5 = taxNumber5;
		return this;
	}

	/**
	 * Get taxNumber5
	 * 
	 * @return taxNumber5
	 **/
	@Schema(description = "")

	public String getTaxNumber5() {
		return taxNumber5;
	}

	public void setTaxNumber5(String taxNumber5) {
		this.taxNumber5 = taxNumber5;
	}

	public BusinessPartner taxNumber5Type(String taxNumber5Type) {
		this.taxNumber5Type = taxNumber5Type;
		return this;
	}

	/**
	 * Get taxNumber5Type
	 * 
	 * @return taxNumber5Type
	 **/
	@Schema(description = "")

	public String getTaxNumber5Type() {
		return taxNumber5Type;
	}

	public void setTaxNumber5Type(String taxNumber5Type) {
		this.taxNumber5Type = taxNumber5Type;
	}

	public BusinessPartner vatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}

	/**
	 * Get vatNumber
	 * 
	 * @return vatNumber
	 **/
	@Schema(description = "")

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public BusinessPartner vatNumberType(String vatNumberType) {
		this.vatNumberType = vatNumberType;
		return this;
	}

	/**
	 * Get vatNumberType
	 * 
	 * @return vatNumberType
	 **/
	@Schema(description = "")

	public String getVatNumberType() {
		return vatNumberType;
	}

	public void setVatNumberType(String vatNumberType) {
		this.vatNumberType = vatNumberType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BusinessPartner businessPartner = (BusinessPartner) o;
		return Objects.equals(this.bpn, businessPartner.bpn) && Objects.equals(this.parent, businessPartner.parent)
				&& Objects.equals(this.accountGroup, businessPartner.accountGroup)
				&& Objects.equals(this.name1, businessPartner.name1)
				&& Objects.equals(this.name2, businessPartner.name2)
				&& Objects.equals(this.name3, businessPartner.name3)
				&& Objects.equals(this.name4, businessPartner.name4)
				&& Objects.equals(this.addressVersion, businessPartner.addressVersion)
				&& Objects.equals(this.country, businessPartner.country)
				&& Objects.equals(this.city, businessPartner.city)
				&& Objects.equals(this.postalCode, businessPartner.postalCode)
				&& Objects.equals(this.street1, businessPartner.street1)
				&& Objects.equals(this.street2, businessPartner.street2)
				&& Objects.equals(this.street3, businessPartner.street3)
				&& Objects.equals(this.houseNumber, businessPartner.houseNumber)
				&& Objects.equals(this.taxNumber1, businessPartner.taxNumber1)
				&& Objects.equals(this.taxNumber1Type, businessPartner.taxNumber1Type)
				&& Objects.equals(this.taxNumber2, businessPartner.taxNumber2)
				&& Objects.equals(this.taxNumber2Type, businessPartner.taxNumber2Type)
				&& Objects.equals(this.taxNumber3, businessPartner.taxNumber3)
				&& Objects.equals(this.taxNumber3Type, businessPartner.taxNumber3Type)
				&& Objects.equals(this.taxNumber4, businessPartner.taxNumber4)
				&& Objects.equals(this.taxNumber4Type, businessPartner.taxNumber4Type)
				&& Objects.equals(this.taxNumber5, businessPartner.taxNumber5)
				&& Objects.equals(this.taxNumber5Type, businessPartner.taxNumber5Type)
				&& Objects.equals(this.vatNumber, businessPartner.vatNumber)
				&& Objects.equals(this.vatNumberType, businessPartner.vatNumberType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bpn, parent, accountGroup, name1, name2, name3, name4, addressVersion, country, city,
				postalCode, street1, street2, street3, houseNumber, taxNumber1, taxNumber1Type, taxNumber2,
				taxNumber2Type, taxNumber3, taxNumber3Type, taxNumber4, taxNumber4Type, taxNumber5, taxNumber5Type,
				vatNumber, vatNumberType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BusinessPartner {\n");

		sb.append("    bpn: ").append(toIndentedString(bpn)).append("\n");
		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    accountGroup: ").append(toIndentedString(accountGroup)).append("\n");
		sb.append("    name1: ").append(toIndentedString(name1)).append("\n");
		sb.append("    name2: ").append(toIndentedString(name2)).append("\n");
		sb.append("    name3: ").append(toIndentedString(name3)).append("\n");
		sb.append("    name4: ").append(toIndentedString(name4)).append("\n");
		sb.append("    addressVersion: ").append(toIndentedString(addressVersion)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
		sb.append("    street1: ").append(toIndentedString(street1)).append("\n");
		sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
		sb.append("    street3: ").append(toIndentedString(street3)).append("\n");
		sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
		sb.append("    taxNumber1: ").append(toIndentedString(taxNumber1)).append("\n");
		sb.append("    taxNumber1Type: ").append(toIndentedString(taxNumber1Type)).append("\n");
		sb.append("    taxNumber2: ").append(toIndentedString(taxNumber2)).append("\n");
		sb.append("    taxNumber2Type: ").append(toIndentedString(taxNumber2Type)).append("\n");
		sb.append("    taxNumber3: ").append(toIndentedString(taxNumber3)).append("\n");
		sb.append("    taxNumber3Type: ").append(toIndentedString(taxNumber3Type)).append("\n");
		sb.append("    taxNumber4: ").append(toIndentedString(taxNumber4)).append("\n");
		sb.append("    taxNumber4Type: ").append(toIndentedString(taxNumber4Type)).append("\n");
		sb.append("    taxNumber5: ").append(toIndentedString(taxNumber5)).append("\n");
		sb.append("    taxNumber5Type: ").append(toIndentedString(taxNumber5Type)).append("\n");
		sb.append("    vatNumber: ").append(toIndentedString(vatNumber)).append("\n");
		sb.append("    vatNumberType: ").append(toIndentedString(vatNumberType)).append("\n");
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
