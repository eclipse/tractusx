/*
 *
 */
package com.catenax.tdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.sampledata.PartRelationshipSampleData;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDataGenerator.
 */
public class TestDataGenerator {

	/** The Constant upper. */
	private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/** The Constant lower. */
	private static final String lower = upper.toLowerCase(Locale.ROOT);

	/** The Constant digits. */
	private static final String digits = "0123456789";

	/** The Constant alphanum. */
	private static final String alphanum = upper + lower + digits;

	/** The Constant symbols. */
	private static final char[] symbols = alphanum.toCharArray();

	/** The Constant random. */
	private static final Random random = ThreadLocalRandom.current();

	/**
	 * Generate prs data from vehicle.
	 *
	 * @param bom the bom
	 * @return the list
	 */
	public static List<PartRelationshipWithInfos> generatePrsDataFromVehicle(BOM bom) {
		final List<PartRelationshipWithInfos> result = new ArrayList<>();

		result.add(PartRelationshipSampleData.bomToPri(bom, 100));

		return result;
	}

	/**
	 * Gen int.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static int genInt(int min, int max) {
		final int result = 0;

		return result;
	}

	/**
	 * Gen string.
	 *
	 * @param len the len
	 * @return the string
	 */
	public static String genString(int len) {
		String result = "";

		for (int i = 0; i < len; i++) {
			result += randChar();
		}

		return result;
	}

	/**
	 * Gen string.
	 *
	 * @param prefix the prefix
	 * @param len    the len
	 * @return the string
	 */
	public static String genString(String prefix, int len) {
		String result = prefix;

		result += genString(len - result.length());

		return result;
	}

	/**
	 * Gen VIN.
	 *
	 * @param prefix the prefix
	 * @return the string
	 */
	public static String genVIN(String prefix) {
		String result = prefix;

		result += genString(17 - result.length());

		return result.toUpperCase();
	}

	/**
	 * Gets the all company roles.
	 *
	 * @return the all company roles
	 */
	public static List<MemberCompanyRole> getAllCompanyRoles() {
		final List<MemberCompanyRole> result = new ArrayList<>();

		for (final MemberCompanyRole role : MemberCompanyRole.values()) {
			result.add(role);
		}

		return result;
	}

	/**
	 * Rand char.
	 *
	 * @return the char
	 */
	public static char randChar() {
		final int i = random.nextInt(symbols.length);
		final char r = symbols[i];
		return r;
	}

}
