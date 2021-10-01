/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Business Partner.
 */
@Schema(description = "Business Partner")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-15T07:34:43.482Z[GMT]")

@Entity
@Table(name = "BUSINESS_PARTNER")
public class BusinessPartner implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2022622745531725843L;

	/** The bpn. */
	@Id
	@JsonProperty("bpn")
	private String bpn = null;

	/** The parent. */
	@JsonProperty("parent")
	private String parent = null;

	/** The account group. */
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

	/** The name 1. */
	@JsonProperty("name1")
	private String name1 = null;

	/** The name 2. */
	@JsonProperty("name2")
	private String name2 = null;

	/** The name 3. */
	@JsonProperty("name3")
	private String name3 = null;

	/** The name 4. */
	@JsonProperty("name4")
	private String name4 = null;

	/** The address version. */
	@JsonProperty("addressVersion")
	private String addressVersion = null;

	/** The country. */
	@JsonProperty("country")
	private String country = null;

	/** The city. */
	@JsonProperty("city")
	private String city = null;

	/** The postal code. */
	@JsonProperty("postalCode")
	private String postalCode = null;

	/** The street 1. */
	@JsonProperty("street1")
	private String street1 = null;

	/** The street 2. */
	@JsonProperty("street2")
	private String street2 = null;

	/** The street 3. */
	@JsonProperty("street3")
	private String street3 = null;

	/** The house number. */
	@JsonProperty("houseNumber")
	private String houseNumber = null;

	/** The tax number 1. */
	@JsonProperty("taxNumber1")
	private String taxNumber1 = null;

	/** The tax number 1 type. */
	@JsonProperty("taxNumber1Type")
	private String taxNumber1Type = null;

	/** The tax number 2. */
	@JsonProperty("taxNumber2")
	private String taxNumber2 = null;

	/** The tax number 2 type. */
	@JsonProperty("taxNumber2Type")
	private String taxNumber2Type = null;

	/** The tax number 3. */
	@JsonProperty("taxNumber3")
	private String taxNumber3 = null;

	/** The tax number 3 type. */
	@JsonProperty("taxNumber3Type")
	private String taxNumber3Type = null;

	/** The tax number 4. */
	@JsonProperty("taxNumber4")
	private String taxNumber4 = null;

	/** The tax number 4 type. */
	@JsonProperty("taxNumber4Type")
	private String taxNumber4Type = null;

	/** The tax number 5. */
	@JsonProperty("taxNumber5")
	private String taxNumber5 = null;

	/** The tax number 5 type. */
	@JsonProperty("taxNumber5Type")
	private String taxNumber5Type = null;

	/** The vat number. */
	@JsonProperty("vatNumber")
	private String vatNumber = null;

	/** The vat number type. */
	@JsonProperty("vatNumberType")
	private String vatNumberType = null;

	/**
	 * Account group.
	 *
	 * @param accountGroup the account group
	 * @return the business partner
	 */
	public BusinessPartner accountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
		return this;
	}

	/**
	 * Address version.
	 *
	 * @param addressVersion the address version
	 * @return the business partner
	 */
	public BusinessPartner addressVersion(String addressVersion) {
		this.addressVersion = addressVersion;
		return this;
	}

	/**
	 * Bpn.
	 *
	 * @param bpn the bpn
	 * @return the business partner
	 */
	public BusinessPartner bpn(String bpn) {
		this.bpn = bpn;
		return this;
	}

	/**
	 * City.
	 *
	 * @param city the city
	 * @return the business partner
	 */
	public BusinessPartner city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Country.
	 *
	 * @param country the country
	 * @return the business partner
	 */
	public BusinessPartner country(String country) {
		this.country = country;
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
		final BusinessPartner businessPartner = (BusinessPartner) o;
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

	/**
	 * Get accountGroup.
	 *
	 * @return accountGroup
	 */
	@Schema(description = "")

	public String getAccountGroup() {
		return accountGroup;
	}

	/**
	 * Get addressVersion.
	 *
	 * @return addressVersion
	 */
	@Schema(description = "")

	public String getAddressVersion() {
		return addressVersion;
	}

	/**
	 * Get BPN.
	 *
	 * @return BPN
	 */
	@Schema(description = "")

	@Size(min = 16, max = 16)
	public String getBpn() {
		return bpn;
	}

	/**
	 * Get city.
	 *
	 * @return city
	 */
	@Schema(description = "")

	public String getCity() {
		return city;
	}

	/**
	 * Get country.
	 *
	 * @return country
	 */
	@Schema(description = "")

	public String getCountry() {
		return country;
	}

	/**
	 * Get houseNumber.
	 *
	 * @return houseNumber
	 */
	@Schema(description = "")

	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Get name1.
	 *
	 * @return name1
	 */
	@Schema(description = "")

	public String getName1() {
		return name1;
	}

	/**
	 * Get name2.
	 *
	 * @return name2
	 */
	@Schema(description = "")

	public String getName2() {
		return name2;
	}

	/**
	 * Get name3.
	 *
	 * @return name3
	 */
	@Schema(description = "")

	public String getName3() {
		return name3;
	}

	/**
	 * Get name4.
	 *
	 * @return name4
	 */
	@Schema(description = "")

	public String getName4() {
		return name4;
	}

	/**
	 * Get parent.
	 *
	 * @return parent
	 */
	@Schema(description = "")

	@Size(min = 16, max = 16)
	public String getParent() {
		return parent;
	}

	/**
	 * Get postalCode.
	 *
	 * @return postalCode
	 */
	@Schema(description = "")

	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Get street1.
	 *
	 * @return street1
	 */
	@Schema(description = "")

	public String getStreet1() {
		return street1;
	}

	/**
	 * Get street2.
	 *
	 * @return street2
	 */
	@Schema(description = "")

	public String getStreet2() {
		return street2;
	}

	/**
	 * Get street3.
	 *
	 * @return street3
	 */
	@Schema(description = "")

	public String getStreet3() {
		return street3;
	}

	/**
	 * Get taxNumber1.
	 *
	 * @return taxNumber1
	 */
	@Schema(description = "")

	public String getTaxNumber1() {
		return taxNumber1;
	}

	/**
	 * Get taxNumber1Type.
	 *
	 * @return taxNumber1Type
	 */
	@Schema(description = "")

	public String getTaxNumber1Type() {
		return taxNumber1Type;
	}

	/**
	 * Get taxNumber2.
	 *
	 * @return taxNumber2
	 */
	@Schema(description = "")

	public String getTaxNumber2() {
		return taxNumber2;
	}

	/**
	 * Get taxNumber2Type.
	 *
	 * @return taxNumber2Type
	 */
	@Schema(description = "")

	public String getTaxNumber2Type() {
		return taxNumber2Type;
	}

	/**
	 * Get taxNumber3.
	 *
	 * @return taxNumber3
	 */
	@Schema(description = "")

	public String getTaxNumber3() {
		return taxNumber3;
	}

	/**
	 * Get taxNumber3Type.
	 *
	 * @return taxNumber3Type
	 */
	@Schema(description = "")

	public String getTaxNumber3Type() {
		return taxNumber3Type;
	}

	/**
	 * Get taxNumber4.
	 *
	 * @return taxNumber4
	 */
	@Schema(description = "")

	public String getTaxNumber4() {
		return taxNumber4;
	}

	/**
	 * Get taxNumber4Type.
	 *
	 * @return taxNumber4Type
	 */
	@Schema(description = "")

	public String getTaxNumber4Type() {
		return taxNumber4Type;
	}

	/**
	 * Get taxNumber5.
	 *
	 * @return taxNumber5
	 */
	@Schema(description = "")

	public String getTaxNumber5() {
		return taxNumber5;
	}

	/**
	 * Get taxNumber5Type.
	 *
	 * @return taxNumber5Type
	 */
	@Schema(description = "")

	public String getTaxNumber5Type() {
		return taxNumber5Type;
	}

	/**
	 * Get vatNumber.
	 *
	 * @return vatNumber
	 */
	@Schema(description = "")

	public String getVatNumber() {
		return vatNumber;
	}

	/**
	 * Get vatNumberType.
	 *
	 * @return vatNumberType
	 */
	@Schema(description = "")

	public String getVatNumberType() {
		return vatNumberType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bpn, parent, accountGroup, name1, name2, name3, name4, addressVersion, country, city,
				postalCode, street1, street2, street3, houseNumber, taxNumber1, taxNumber1Type, taxNumber2,
				taxNumber2Type, taxNumber3, taxNumber3Type, taxNumber4, taxNumber4Type, taxNumber5, taxNumber5Type,
				vatNumber, vatNumberType);
	}

	/**
	 * House number.
	 *
	 * @param houseNumber the house number
	 * @return the business partner
	 */
	public BusinessPartner houseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	/**
	 * Name 1.
	 *
	 * @param name1 the name 1
	 * @return the business partner
	 */
	public BusinessPartner name1(String name1) {
		this.name1 = name1;
		return this;
	}

	/**
	 * Name 2.
	 *
	 * @param name2 the name 2
	 * @return the business partner
	 */
	public BusinessPartner name2(String name2) {
		this.name2 = name2;
		return this;
	}

	/**
	 * Name 3.
	 *
	 * @param name3 the name 3
	 * @return the business partner
	 */
	public BusinessPartner name3(String name3) {
		this.name3 = name3;
		return this;
	}

	/**
	 * Name 4.
	 *
	 * @param name4 the name 4
	 * @return the business partner
	 */
	public BusinessPartner name4(String name4) {
		this.name4 = name4;
		return this;
	}

	/**
	 * Parent.
	 *
	 * @param parent the parent
	 * @return the business partner
	 */
	public BusinessPartner parent(String parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * Postal code.
	 *
	 * @param postalCode the postal code
	 * @return the business partner
	 */
	public BusinessPartner postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Sets the account group.
	 *
	 * @param accountGroup the new account group
	 */
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	/**
	 * Sets the address version.
	 *
	 * @param addressVersion the new address version
	 */
	public void setAddressVersion(String addressVersion) {
		this.addressVersion = addressVersion;
	}

	/**
	 * Sets the bpn.
	 *
	 * @param bpn the new bpn
	 */
	public void setBpn(String bpn) {
		this.bpn = bpn;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Sets the house number.
	 *
	 * @param houseNumber the new house number
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Sets the name 1.
	 *
	 * @param name1 the new name 1
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * Sets the name 2.
	 *
	 * @param name2 the new name 2
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * Sets the name 3.
	 *
	 * @param name3 the new name 3
	 */
	public void setName3(String name3) {
		this.name3 = name3;
	}

	/**
	 * Sets the name 4.
	 *
	 * @param name4 the new name 4
	 */
	public void setName4(String name4) {
		this.name4 = name4;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Sets the street 1.
	 *
	 * @param street1 the new street 1
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Sets the street 2.
	 *
	 * @param street2 the new street 2
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * Sets the street 3.
	 *
	 * @param street3 the new street 3
	 */
	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	/**
	 * Sets the tax number 1.
	 *
	 * @param taxNumber1 the new tax number 1
	 */
	public void setTaxNumber1(String taxNumber1) {
		this.taxNumber1 = taxNumber1;
	}

	/**
	 * Sets the tax number 1 type.
	 *
	 * @param taxNumber1Type the new tax number 1 type
	 */
	public void setTaxNumber1Type(String taxNumber1Type) {
		this.taxNumber1Type = taxNumber1Type;
	}

	/**
	 * Sets the tax number 2.
	 *
	 * @param taxNumber2 the new tax number 2
	 */
	public void setTaxNumber2(String taxNumber2) {
		this.taxNumber2 = taxNumber2;
	}

	/**
	 * Sets the tax number 2 type.
	 *
	 * @param taxNumber2Type the new tax number 2 type
	 */
	public void setTaxNumber2Type(String taxNumber2Type) {
		this.taxNumber2Type = taxNumber2Type;
	}

	/**
	 * Sets the tax number 3.
	 *
	 * @param taxNumber3 the new tax number 3
	 */
	public void setTaxNumber3(String taxNumber3) {
		this.taxNumber3 = taxNumber3;
	}

	/**
	 * Sets the tax number 3 type.
	 *
	 * @param taxNumber3Type the new tax number 3 type
	 */
	public void setTaxNumber3Type(String taxNumber3Type) {
		this.taxNumber3Type = taxNumber3Type;
	}

	/**
	 * Sets the tax number 4.
	 *
	 * @param taxNumber4 the new tax number 4
	 */
	public void setTaxNumber4(String taxNumber4) {
		this.taxNumber4 = taxNumber4;
	}

	/**
	 * Sets the tax number 4 type.
	 *
	 * @param taxNumber4Type the new tax number 4 type
	 */
	public void setTaxNumber4Type(String taxNumber4Type) {
		this.taxNumber4Type = taxNumber4Type;
	}

	/**
	 * Sets the tax number 5.
	 *
	 * @param taxNumber5 the new tax number 5
	 */
	public void setTaxNumber5(String taxNumber5) {
		this.taxNumber5 = taxNumber5;
	}

	/**
	 * Sets the tax number 5 type.
	 *
	 * @param taxNumber5Type the new tax number 5 type
	 */
	public void setTaxNumber5Type(String taxNumber5Type) {
		this.taxNumber5Type = taxNumber5Type;
	}

	/**
	 * Sets the vat number.
	 *
	 * @param vatNumber the new vat number
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	/**
	 * Sets the vat number type.
	 *
	 * @param vatNumberType the new vat number type
	 */
	public void setVatNumberType(String vatNumberType) {
		this.vatNumberType = vatNumberType;
	}

	/**
	 * Street 1.
	 *
	 * @param street1 the street 1
	 * @return the business partner
	 */
	public BusinessPartner street1(String street1) {
		this.street1 = street1;
		return this;
	}

	/**
	 * Street 2.
	 *
	 * @param street2 the street 2
	 * @return the business partner
	 */
	public BusinessPartner street2(String street2) {
		this.street2 = street2;
		return this;
	}

	/**
	 * Street 3.
	 *
	 * @param street3 the street 3
	 * @return the business partner
	 */
	public BusinessPartner street3(String street3) {
		this.street3 = street3;
		return this;
	}

	/**
	 * Tax number 1.
	 *
	 * @param taxNumber1 the tax number 1
	 * @return the business partner
	 */
	public BusinessPartner taxNumber1(String taxNumber1) {
		this.taxNumber1 = taxNumber1;
		return this;
	}

	/**
	 * Tax number 1 type.
	 *
	 * @param taxNumber1Type the tax number 1 type
	 * @return the business partner
	 */
	public BusinessPartner taxNumber1Type(String taxNumber1Type) {
		this.taxNumber1Type = taxNumber1Type;
		return this;
	}

	/**
	 * Tax number 2.
	 *
	 * @param taxNumber2 the tax number 2
	 * @return the business partner
	 */
	public BusinessPartner taxNumber2(String taxNumber2) {
		this.taxNumber2 = taxNumber2;
		return this;
	}

	/**
	 * Tax number 2 type.
	 *
	 * @param taxNumber2Type the tax number 2 type
	 * @return the business partner
	 */
	public BusinessPartner taxNumber2Type(String taxNumber2Type) {
		this.taxNumber2Type = taxNumber2Type;
		return this;
	}

	/**
	 * Tax number 3.
	 *
	 * @param taxNumber3 the tax number 3
	 * @return the business partner
	 */
	public BusinessPartner taxNumber3(String taxNumber3) {
		this.taxNumber3 = taxNumber3;
		return this;
	}

	/**
	 * Tax number 3 type.
	 *
	 * @param taxNumber3Type the tax number 3 type
	 * @return the business partner
	 */
	public BusinessPartner taxNumber3Type(String taxNumber3Type) {
		this.taxNumber3Type = taxNumber3Type;
		return this;
	}

	/**
	 * Tax number 4.
	 *
	 * @param taxNumber4 the tax number 4
	 * @return the business partner
	 */
	public BusinessPartner taxNumber4(String taxNumber4) {
		this.taxNumber4 = taxNumber4;
		return this;
	}

	/**
	 * Tax number 4 type.
	 *
	 * @param taxNumber4Type the tax number 4 type
	 * @return the business partner
	 */
	public BusinessPartner taxNumber4Type(String taxNumber4Type) {
		this.taxNumber4Type = taxNumber4Type;
		return this;
	}

	/**
	 * Tax number 5.
	 *
	 * @param taxNumber5 the tax number 5
	 * @return the business partner
	 */
	public BusinessPartner taxNumber5(String taxNumber5) {
		this.taxNumber5 = taxNumber5;
		return this;
	}

	/**
	 * Tax number 5 type.
	 *
	 * @param taxNumber5Type the tax number 5 type
	 * @return the business partner
	 */
	public BusinessPartner taxNumber5Type(String taxNumber5Type) {
		this.taxNumber5Type = taxNumber5Type;
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
	 * Vat number.
	 *
	 * @param vatNumber the vat number
	 * @return the business partner
	 */
	public BusinessPartner vatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}

	/**
	 * Vat number type.
	 *
	 * @param vatNumberType the vat number type
	 * @return the business partner
	 */
	public BusinessPartner vatNumberType(String vatNumberType) {
		this.vatNumberType = vatNumberType;
		return this;
	}
}
