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
import javax.persistence.JoinColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Member Company
 */
@Schema(description = "Member Company")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-15T07:34:43.482Z[GMT]")

@Entity
public class MemberCompany implements Serializable {

	private static final long serialVersionUID = 7125008668896216247L;

	@Id
	@JsonProperty("bpn")
	private String BPN = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("parent")
	private String parent = null;

	@JsonProperty("roles")
	@Valid
	@ElementCollection
    @CollectionTable(name = "mc_roles")
    @Column(name = "role")
	private List<MemberCompanyRole> roles = null;

	public MemberCompany BPN(String BPN) {
		this.BPN = BPN;
		return this;
	}

	/**
	 * Get BPN
	 * 
	 * @return BPN
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Size(min = 16, max = 16)
	public String getBPN() {
		return BPN;
	}

	public void setBPN(String BPN) {
		this.BPN = BPN;
	}

	public MemberCompany name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MemberCompany parent(String parent) {
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

	public MemberCompany roles(List<MemberCompanyRole> roles) {
		this.roles = roles;
		return this;
	}

	public MemberCompany addRolesItem(MemberCompanyRole rolesItem) {
		if (this.roles == null) {
			this.roles = new ArrayList<MemberCompanyRole>();
		}
		this.roles.add(rolesItem);
		return this;
	}

	/**
	 * Get roles
	 * 
	 * @return roles
	 **/
	@Schema(description = "")
	@Valid
	public List<MemberCompanyRole> getRoles() {
		return roles;
	}

	public void setRoles(List<MemberCompanyRole> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MemberCompany memberCompany = (MemberCompany) o;
		return Objects.equals(this.BPN, memberCompany.BPN) && Objects.equals(this.name, memberCompany.name)
				&& Objects.equals(this.parent, memberCompany.parent) && Objects.equals(this.roles, memberCompany.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(BPN, name, parent, roles);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MemberCompany {\n");

		sb.append("    BPN: ").append(toIndentedString(BPN)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
