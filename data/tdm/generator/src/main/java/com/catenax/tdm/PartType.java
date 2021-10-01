/*
 *
 */
package com.catenax.tdm;

// TODO: Auto-generated Javadoc
/**
 * The Enum PartType.
 */
public enum PartType {

	/** The vehicle. */
	VEHICLE("vehicle"),
	/** The gearbox. */
	GEARBOX("gearbox"),
	/** The hvs. */
	HVS("hvs"),
	/** The hvb module. */
	HVB_MODULE("hvb module"),
	/** The hvb cell. */
	HVB_CELL("hvb cell"),
	/** The sump. */
	SUMP("sump"),

	/** The adhesive. */
	ADHESIVE("adhesive"),
	/** The material. */
	MATERIAL("material");

	/** The part type. */
	private String partType = null;

	/**
	 * Instantiates a new part type.
	 *
	 * @param pType the type
	 */
	PartType(String pType) {
		this.partType = pType;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.partType;
	}

}
