/*
 *
 */
package com.catenax.tdm.model.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * Member Company.
 */
@Schema(description = "Member Company")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-15T07:34:43.482Z[GMT]")

@Entity
public class MemberCompany implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7125008668896216247L;

	/** The bpn. */
	@Id
	@JsonProperty("bpn")
	private String BPN = null;

	/** The name. */
	@JsonProperty("name")
	private String name = null;

	/** The parent. */
	@JsonProperty("parent")
	private String parent = null;

	/** The roles. */
	@JsonProperty("roles")
	@Valid
	@ElementCollection
	@CollectionTable(name = "mc_roles")
	@Column(name = "role")
	private List<MemberCompanyRole> roles = null;

	/**
	 * Adds the roles item.
	 *
	 * @param rolesItem the roles item
	 * @return the member company
	 */
	public MemberCompany addRolesItem(MemberCompanyRole rolesItem) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(rolesItem);
		return this;
	}

	/**
	 * Bpn.
	 *
	 * @param BPN the bpn
	 * @return the member company
	 */
	public MemberCompany BPN(String BPN) {
		this.BPN = BPN;
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
		final MemberCompany memberCompany = (MemberCompany) o;
		return Objects.equals(this.BPN, memberCompany.BPN) && Objects.equals(this.name, memberCompany.name)
				&& Objects.equals(this.parent, memberCompany.parent) && Objects.equals(this.roles, memberCompany.roles);
	}

	/**
	 * Get BPN.
	 *
	 * @return BPN
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Size(min = 16, max = 16)
	public String getBPN() {
		return BPN;
	}

	/**
	 * Get name.
	 *
	 * @return name
	 */
	@Schema(required = true, description = "")
	@NotNull

	public String getName() {
		return name;
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
	 * Get roles.
	 *
	 * @return roles
	 */
	@Schema(description = "")
	@Valid
	public List<MemberCompanyRole> getRoles() {
		return roles;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(BPN, name, parent, roles);
	}

	/**
	 * Name.
	 *
	 * @param name the name
	 * @return the member company
	 */
	public MemberCompany name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Parent.
	 *
	 * @param parent the parent
	 * @return the member company
	 */
	public MemberCompany parent(String parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * Roles.
	 *
	 * @param roles the roles
	 * @return the member company
	 */
	public MemberCompany roles(List<MemberCompanyRole> roles) {
		this.roles = roles;
		return this;
	}

	/**
	 * Sets the bpn.
	 *
	 * @param BPN the new bpn
	 */
	public void setBPN(String BPN) {
		this.BPN = BPN;
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
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(List<MemberCompanyRole> roles) {
		this.roles = roles;
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
		sb.append("class MemberCompany {\n");

		sb.append("    BPN: ").append(toIndentedString(BPN)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
