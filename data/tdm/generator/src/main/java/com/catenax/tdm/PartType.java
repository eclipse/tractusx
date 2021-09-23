package com.catenax.tdm;

public enum PartType {
	VEHICLE("Vehicle"),
	GEARBOX("Gearbox"),
	HVS("HVS"),
	HVB_MODULE("HVB Module"),
	HVB_CELL("HVB Cell"),
	SUMP("Sump"),
	GLUE("Glue")
	;
	
	private String partType = null;
	PartType(String pType) {
		this.partType = pType;
	}
	@Override
	public String toString() {
		return this.partType;
	}

}
