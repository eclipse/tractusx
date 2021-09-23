package com.catenax.tdm.sampledata;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;

public class InitialSampleData {
	
	public static class BPMC {
		private BusinessPartner businessPartner = null;
		private MemberCompany memberCompany = null;
		
		public BPMC(BusinessPartner bp, MemberCompany mc) {
			this.businessPartner = bp;
			this.memberCompany = mc;
		}

		public BusinessPartner getBusinessPartner() {
			return businessPartner;
		}

		public MemberCompany getMemberCompany() {
			return memberCompany;
		}
	}
	
	public static List<BPMC> createInitialBusinessPartners() {
		List<BPMC> result = new ArrayList<BPMC>();
		
		List<MemberCompanyRole> participant = new ArrayList<MemberCompanyRole>();
		List<MemberCompanyRole> infra       = new ArrayList<MemberCompanyRole>();
		List<MemberCompanyRole> app         = new ArrayList<MemberCompanyRole>();
		List<MemberCompanyRole> partapp         = new ArrayList<MemberCompanyRole>();
		
		participant.add(MemberCompanyRole.ACTIVE_PARTICIPANT);
		infra.add(MemberCompanyRole.OPERATIONS_INFRASTRUCTURE_PROVIDER);
		app.add(MemberCompanyRole.APP_PROVIDER);
		
		partapp.add(MemberCompanyRole.ACTIVE_PARTICIPANT);
		partapp.add(MemberCompanyRole.APP_PROVIDER);

		BPMC bmwGroup = createBPMC(BusinessPartnerSampleData.BPN_BMWGROUP, "Bayerische Motoren Werke Aktiengesellschaft", null, "OEM", participant);
		BPMC bmwMuc   = createBPMC(BusinessPartnerSampleData.BPN_BMWMUC, "BMW Plant Munich", bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);
		BPMC bmwDgf   = createBPMC(BusinessPartnerSampleData.BPN_BMWDGF, "BMW Plant Dingolfing", bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);
		BPMC bmwLpz   = createBPMC(BusinessPartnerSampleData.BPN_BMWLPZ, "BMW Plant Leipzig", bmwGroup.getBusinessPartner().getBpn(), "OEM Plant", participant);
		
		BPMC daimler  = createBPMC(BusinessPartnerSampleData.BPN_DAI, "Daimler AG", null, "OEM", participant);
		
		BPMC zfGroup  = createBPMC(BusinessPartnerSampleData.BPN_ZF, "ZF Friedrichshafen AG", null, "Supplier", participant);
		BPMC bosch    = createBPMC(BusinessPartnerSampleData.BPN_BOSCH, "Robert Bosch GmbH", null, "Supplier", participant);
		BPMC basf     = createBPMC(BusinessPartnerSampleData.BPN_BASF, "BASF", null, "Supplier", participant);
		BPMC henkel   = createBPMC(BusinessPartnerSampleData.BPN_HENKEL, "Henkel", null, "Supplier", participant);
		BPMC kaputt   = createBPMC(BusinessPartnerSampleData.BPN_KAPUTT, "Kaputt GmbH", null, "Supplier", partapp);
		
		BPMC sap      = createBPMC(BusinessPartnerSampleData.BPN_SAP, "SAP AG", null, "Technology", app);
		
		BPMC microsoft = createBPMC(BusinessPartnerSampleData.BPN_MICROSOFT, "Microsoft", null, "Technology", infra);
		BPMC tsystems  = createBPMC(BusinessPartnerSampleData.BPN_TSYSTEMS, "T-Systems", null, "Technology", infra);
		
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
	
	public static BPMC createBPMC(String name, char classification, String parent, String accountGroup, List<MemberCompanyRole> roles) {
		BusinessPartner bp = BusinessPartnerSampleData.createBusinessPartner(name, classification, parent, accountGroup);
		MemberCompany mc = createMemberCompanyFromBusinessPartner(bp, roles);
		return new BPMC(bp, mc);
	}
	
	public static BPMC createBPMC(String BPN, String name, String parent, String accountGroup, List<MemberCompanyRole> roles) {
		BusinessPartner bp = BusinessPartnerSampleData.createBusinessPartner(BPN, name, parent, accountGroup);
		MemberCompany mc = createMemberCompanyFromBusinessPartner(bp, roles);
		return new BPMC(bp, mc);
	}

	public static MemberCompany createMemberCompanyFromBusinessPartner(BusinessPartner businessPartner, List<MemberCompanyRole> roles) {
		MemberCompany member = null;
		
		if(businessPartner != null && businessPartner.getParent() == null) {
			member = new MemberCompany();
			member.setBPN(businessPartner.getBpn());
			member.setName(businessPartner.getName1());
			member.setParent(businessPartner.getParent());
			member.setRoles(roles);
		}
		
		return member;
	}

}
