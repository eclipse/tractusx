package com.catenax.tdm.sampledata;

import java.util.HashMap;
import java.util.Map;

import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.model.v1.BPNIssuer;
import com.catenax.tdm.model.v1.BusinessPartner;

public class BusinessPartnerSampleData {
	
	private static BPNIssuer DEFAULT_ISSUER = null;
	private static boolean   CATENAX_ISSUER = true;
	
	public static final String BPN_BMWGROUP = "CAXLZJVJEBYWYYZZ";
	public static final String BPN_BMWMUC = "CAXSPGQORIGHFAZZ";
	public static final String BPN_BMWDGF = "CAXSWPFTJQEVZNZZ";
	public static final String BPN_BMWLPZ = "CAXSZJVJEBYWYYZZ";
	public static final String BPN_DAI = "CAXLXCLMNDAAWEZZ";
	public static final String BPN_ZF = "CAXLTHAJNAHZXGZZ";
	public static final String BPN_BOSCH = "CAXLXZZDURIFEUZZ";
	public static final String BPN_BASF = "CAXLBRHHQAJAIOZZ";
	public static final String BPN_HENKEL = "CAXLHNJURNRLPCZZ";
	public static final String BPN_KAPUTT = "CAXLJXFARPBQZQZZ";
	
	public static final String BPN_SAP = "CAXLAPHGVJJFHZZZ";
	public static final String BPN_MICROSOFT = "CAXLCPOZSGFCTJZZ";
	public static final String BPN_TSYSTEMS = "CAXLNDDMHMMNCOZZ";
	
	public static final Map<String, String> BUSINESS_PARTNER_PARENT = new HashMap<String, String>();
	
	public static BPNIssuer getDefaultBPNIssuer() {
		if(DEFAULT_ISSUER == null) {
			DEFAULT_ISSUER = new BPNIssuer();
			if(CATENAX_ISSUER) {
				DEFAULT_ISSUER.setName("Catena-X BPN Issuer");
				DEFAULT_ISSUER.setPrefix("CAX");
			} else {
				DEFAULT_ISSUER.setName("Default BPN Issuer");
				DEFAULT_ISSUER.setPrefix("BPN");
			}
		}
		return DEFAULT_ISSUER;
	}
	
	public static void setDefaultBPNIssuer(BPNIssuer issuer) {
		DEFAULT_ISSUER = issuer;
	}
	
	public static String generateBPN(char classification) {
		return generateBPN(classification, getDefaultBPNIssuer());
	}
	
	public static String generateBPN(char classification, BPNIssuer issuer) {
		String c = ""+classification;
		String result = issuer.getPrefix().toUpperCase() + c.toUpperCase();
		
		result += TestDataFactory.getInstance().getRandomChars(10).toUpperCase();
		
		result += "ZZ";
		
		return result;
	}
	
	public static BusinessPartner createBusinessPartner(String name, char classification, String parent, String accountGroup) {
		return createBusinessPartner(generateBPN(classification), name, parent, accountGroup);
	}
	
	public static BusinessPartner createBusinessPartner(String bpn, String name, String parent, String accountGroup) {
		BusinessPartner bp = new BusinessPartner();
		
		bp.setBpn(bpn);
		bp.setParent(parent);
		
		bp.setAccountGroup(accountGroup);
		
		bp.setName1(name);
		
		bp.setAddressVersion("EN");
		bp.setCity(TestDataFactory.getInstance().getCity());
		bp.setCountry("Germany");
		bp.setHouseNumber(TestDataFactory.getInstance().getNumberText(2));
		bp.setPostalCode(TestDataFactory.getInstance().getNumberText(5));
		bp.setStreet1(TestDataFactory.getInstance().getStreetName());
		
		bp.setTaxNumber1("DE" + TestDataFactory.getInstance().getNumberText(9));
		bp.setTaxNumber1Type("UST-ID");
		
		bp.setVatNumber(bp.getTaxNumber1());
		bp.setVatNumberType(bp.getTaxNumber1Type());
		
		return bp;
	}
	
	public static String resolveTopLevelBPN(String bpn) {
		String result = bpn;
		
		if(BUSINESS_PARTNER_PARENT.containsKey(bpn)) {
			result = BUSINESS_PARTNER_PARENT.get(bpn);
		}
		
		
		if(result == null || result.trim().length() == 0) {
			result = bpn;
		}
		
		return result;
	}

}
