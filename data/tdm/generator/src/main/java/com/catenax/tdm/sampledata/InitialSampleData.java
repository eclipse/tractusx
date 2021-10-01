/*
 *
 */
package com.catenax.tdm.sampledata;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;

// TODO: Auto-generated Javadoc
/**
 * The Class InitialSampleData.
 */
public class InitialSampleData {

	/**
	 * The Class BPMC.
	 */
	public static class BPMC {

		/** The business partner. */
		private BusinessPartner businessPartner = null;

		/** The member company. */
		private MemberCompany memberCompany = null;

		/**
		 * Instantiates a new bpmc.
		 *
		 * @param bp the bp
		 * @param mc the mc
		 */
		public BPMC(BusinessPartner bp, MemberCompany mc) {
			this.businessPartner = bp;
			this.memberCompany = mc;
		}

		/**
		 * Gets the business partner.
		 *
		 * @return the business partner
		 */
		public BusinessPartner getBusinessPartner() {
			return businessPartner;
		}

		/**
		 * Gets the member company.
		 *
		 * @return the member company
		 */
		public MemberCompany getMemberCompany() {
			return memberCompany;
		}
	}

	/**
	 * Creates the BPMC.
	 *
	 * @param name           the name
	 * @param classification the classification
	 * @param parent         the parent
	 * @param accountGroup   the account group
	 * @param roles          the roles
	 * @return the bpmc
	 */
	public static BPMC createBPMC(String name, char classification, String parent, String accountGroup,
			List<MemberCompanyRole> roles) {
		final BusinessPartner bp = BusinessPartnerSampleData.createBusinessPartner(name, classification, parent,
				accountGroup);
		final MemberCompany mc = createMemberCompanyFromBusinessPartner(bp, roles);
		return new BPMC(bp, mc);
	}

	/**
	 * Creates the BPMC.
	 *
	 * @param BPN          the bpn
	 * @param name         the name
	 * @param parent       the parent
	 * @param accountGroup the account group
	 * @param roles        the roles
	 * @return the bpmc
	 */
	public static BPMC createBPMC(String BPN, String name, String parent, String accountGroup,
			List<MemberCompanyRole> roles) {
		final BusinessPartner bp = BusinessPartnerSampleData.createBusinessPartner(BPN, name, parent, accountGroup);
		final MemberCompany mc = createMemberCompanyFromBusinessPartner(bp, roles);
		return new BPMC(bp, mc);
	}

	/**
	 * Creates the initial business partners.
	 *
	 * @return the list
	 */
	public static List<BPMC> createInitialBusinessPartners() {
		final List<BPMC> result = new ArrayList<>();

		final List<MemberCompanyRole> participant = new ArrayList<>();
		final List<MemberCompanyRole> infra = new ArrayList<>();
		final List<MemberCompanyRole> app = new ArrayList<>();
		final List<MemberCompanyRole> partapp = new ArrayList<>();

		participant.add(MemberCompanyRole.ACTIVE_PARTICIPANT);
		infra.add(MemberCompanyRole.OPERATIONS_INFRASTRUCTURE_PROVIDER);
		app.add(MemberCompanyRole.APP_PROVIDER);

		partapp.add(MemberCompanyRole.ACTIVE_PARTICIPANT);
		partapp.add(MemberCompanyRole.APP_PROVIDER);

		final BPMC bmwGroup = createBPMC(BusinessPartnerSampleData.BPN_BMWGROUP,
				"Bayerische Motoren Werke Aktiengesellschaft", null, "OEM", participant);
		final BPMC bmwMuc = createBPMC(BusinessPartnerSampleData.BPN_BMWMUC, "BMW Plant Munich",
				bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);
		final BPMC bmwDgf = createBPMC(BusinessPartnerSampleData.BPN_BMWDGF, "BMW Plant Dingolfing",
				bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);
		final BPMC bmwLpz = createBPMC(BusinessPartnerSampleData.BPN_BMWLPZ, "BMW Plant Leipzig",
				bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);

		final BPMC daimler = createBPMC(BusinessPartnerSampleData.BPN_DAI, "Daimler AG", null, "OEM", participant);

		final BPMC zfGroup = createBPMC(BusinessPartnerSampleData.BPN_ZFGROUP, "ZF Friedrichshafen AG", null,
				"Supplier", participant);
		final BPMC bosch = createBPMC(BusinessPartnerSampleData.BPN_BOSCH, "Robert Bosch GmbH", null, "Supplier",
				participant);
		final BPMC basf = createBPMC(BusinessPartnerSampleData.BPN_BASF, "BASF", null, "Supplier", participant);
		final BPMC henkel = createBPMC(BusinessPartnerSampleData.BPN_HENKEL, "Henkel", null, "Supplier", participant);
		final BPMC kaputt = createBPMC(BusinessPartnerSampleData.BPN_KAPUTT, "Kaputt GmbH", null, "Supplier", partapp);

		final BPMC sap = createBPMC(BusinessPartnerSampleData.BPN_SAP, "SAP AG", null, "Technology", app);

		final BPMC microsoft = createBPMC(BusinessPartnerSampleData.BPN_MICROSOFT, "Microsoft", null, "Technology",
				infra);
		final BPMC tsystems = createBPMC(BusinessPartnerSampleData.BPN_TSYSTEMS, "T-Systems", null, "Technology",
				infra);

		result.add(bmwGroup);
		result.add(bmwMuc);
		result.add(bmwDgf);
		result.add(bmwLpz);

		result.add(daimler);

		result.add(zfGroup);
		result.add(bosch);
		result.add(basf);
		result.add(henkel);
		result.add(kaputt);

		result.add(sap);

		result.add(microsoft);
		result.add(tsystems);

		return result;
	}

	/**
	 * Creates the member company from business partner.
	 *
	 * @param businessPartner the business partner
	 * @param roles           the roles
	 * @return the member company
	 */
	public static MemberCompany createMemberCompanyFromBusinessPartner(BusinessPartner businessPartner,
			List<MemberCompanyRole> roles) {
		MemberCompany member = null;

		if (businessPartner != null && businessPartner.getParent() == null) {
			member = new MemberCompany();
			member.setBPN(businessPartner.getBpn());
			member.setName(businessPartner.getName1());
			member.setParent(businessPartner.getParent());
			member.setRoles(roles);
		}

		return member;
	}

}
