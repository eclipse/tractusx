/*
 *
 */
package com.catenax.tdm.sampledata;

import java.util.HashMap;
import java.util.Map;

import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.model.v1.BPNIssuer;
import com.catenax.tdm.model.v1.BusinessPartner;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessPartnerSampleData.
 */
public class BusinessPartnerSampleData {	

	/** The catenax issuer. */
	private static final boolean CATENAX_ISSUER = true;
	
	/** The default issuer. */
	private static BPNIssuer DEFAULT_ISSUER = CATENAX_ISSUER?new BPNIssuer("Catena-X BPN Issuer", "CAX"):new BPNIssuer("Default BPN Issuer", "BPN");

	/** The Constant BPN_BMWGROUP. */
	public static final String BPN_BMWGROUP = "CAXLZJVJEBYWYYZZ";

	/** The Constant BPN_BMWMUC. */
	public static final String BPN_BMWMUC = "CAXSPGQORIGHFAZZ";

	/** The Constant BPN_BMWDGF. */
	public static final String BPN_BMWDGF = "CAXSWPFTJQEVZNZZ";

	/** The Constant BPN_BMWLPZ. */
	public static final String BPN_BMWLPZ = "CAXSZJVJEBYWYYZZ";

	/** The Constant BPN_DAI. */
	public static final String BPN_DAI = "CAXLXCLMNDAAWEZZ";

	/** The Constant BPN_ZFGROUP. */
	public static final String BPN_ZFGROUP = "CAXLTHAJNAHZXGZZ";

	/** The Constant BPN_ZFSBR. */
	public static final String BPN_ZFSBR = "CAXSJRTGOPVESVZZ";

	/** The Constant BPN_BOSCH. */
	public static final String BPN_BOSCH = "CAXLXZZDURIFEUZZ";

	/** The Constant BPN_BASF. */
	public static final String BPN_BASF = "CAXLBRHHQAJAIOZZ";

	/** The Constant BPN_HENKEL. */
	public static final String BPN_HENKEL = "CAXLHNJURNRLPCZZ";

	/** The Constant BPN_KAPUTT. */
	public static final String BPN_KAPUTT = "CAXLJXFARPBQZQZZ";

	/** The Constant BPN_SAP. */
	public static final String BPN_SAP = "CAXLAPHGVJJFHZZZ";

	/** The Constant BPN_MICROSOFT. */
	public static final String BPN_MICROSOFT = "CAXLCPOZSGFCTJZZ";

	/** The Constant BPN_TSYSTEMS. */
	public static final String BPN_TSYSTEMS = "CAXLNDDMHMMNCOZZ";

	/** The Constant BPN_SAMSUNG. */
	public static final String BPN_SAMSUNG = "CAXLYSHKEZTCKAZZ";

	/** The Constant BUSINESS_PARTNER_PARENT. */
	public static final Map<String, String> BUSINESS_PARTNER_PARENT = new HashMap<>();

	/**
	 * Creates the business partner.
	 *
	 * @param name           the name
	 * @param classification the classification
	 * @param parent         the parent
	 * @param accountGroup   the account group
	 * @return the business partner
	 */
	public static BusinessPartner createBusinessPartner(String name, char classification, String parent,
			String accountGroup) {
		return createBusinessPartner(generateBPN(classification), name, parent, accountGroup);
	}

	/**
	 * Creates the business partner.
	 *
	 * @param bpn          the bpn
	 * @param name         the name
	 * @param parent       the parent
	 * @param accountGroup the account group
	 * @return the business partner
	 */
	public static BusinessPartner createBusinessPartner(String bpn, String name, String parent, String accountGroup) {
		final BusinessPartner bp = new BusinessPartner();

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

	/**
	 * Generate BPN.
	 *
	 * @param classification the classification
	 * @return the string
	 */
	public static String generateBPN(char classification) {
		return generateBPN(classification, getDefaultBPNIssuer());
	}

	/**
	 * Generate BPN.
	 *
	 * @param classification the classification
	 * @param issuer         the issuer
	 * @return the string
	 */
	public static String generateBPN(char classification, BPNIssuer issuer) {
		final String c = "" + classification;
		String result = issuer.getPrefix().toUpperCase() + c.toUpperCase();

		result += TestDataFactory.getInstance().getRandomChars(10).toUpperCase();

		result += "ZZ";

		return result;
	}

	/**
	 * Gets the default BPN issuer.
	 *
	 * @return the default BPN issuer
	 */
	public static BPNIssuer getDefaultBPNIssuer() {
		return DEFAULT_ISSUER;
	}

	/**
	 * Resolve top level BPN.
	 *
	 * @param bpn the bpn
	 * @return the string
	 */
	public static String resolveTopLevelBPN(String bpn) {
		String result = bpn;

		if (BUSINESS_PARTNER_PARENT.containsKey(bpn)) {
			result = BUSINESS_PARTNER_PARENT.get(bpn);
		}

		if (result == null || result.trim().length() == 0) {
			result = bpn;
		}

		return result;
	}

	/**
	 * Sets the default BPN issuer.
	 *
	 * @param issuer the new default BPN issuer
	 */
	public static void setDefaultBPNIssuer(BPNIssuer issuer) {
		DEFAULT_ISSUER = issuer;
	}

}
