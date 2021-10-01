/*
 *
 */
package com.catenax.tdm.sampledata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.catenax.tdm.resource.TDMResourceLoader;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Blueprint.
 */
@Validated
public class Blueprint {

	/**
	 * The Class BlueprintItem.
	 */
	@Validated
	public static class BlueprintItem {

		/** The bpn. */
		@JsonProperty("bpn")
		private String bpn = null;

		/** The part number. */
		@JsonProperty("partNumber")
		private String partNumber = null;

		/** The count. */
		@JsonProperty("count")
		private Integer count = 1;

		/** The part type. */
		@JsonProperty("partType")
		private String partType = null;

		/** The children. */
		@JsonProperty("children")
		private List<BlueprintItem> children = new ArrayList<>();

		/**
		 * Instantiates a new blueprint item.
		 */
		public BlueprintItem() {

		}

		/**
		 * Instantiates a new blueprint item.
		 *
		 * @param bpn        the bpn
		 * @param partNumber the part number
		 * @param partType   the part type
		 * @param count      the count
		 */
		public BlueprintItem(String bpn, String partNumber, String partType, Integer count) {
			this.bpn = bpn;
			this.partNumber = partNumber;
			this.partType = partType;
			this.count = count;
		}

		/**
		 * Gets the bpn.
		 *
		 * @return the bpn
		 */
		public String getBpn() {
			return bpn;
		}

		/**
		 * Gets the children.
		 *
		 * @return the children
		 */
		public List<BlueprintItem> getChildren() {
			return children;
		}

		/**
		 * Gets the count.
		 *
		 * @return the count
		 */
		public Integer getCount() {
			return count;
		}

		/**
		 * Gets the part number.
		 *
		 * @return the part number
		 */
		public String getPartNumber() {
			return partNumber;
		}

		/**
		 * Gets the part type.
		 *
		 * @return the part type
		 */
		public String getPartType() {
			return partType;
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
		 * Sets the children.
		 *
		 * @param children the new children
		 */
		public void setChildren(List<BlueprintItem> children) {
			this.children = children;
		}

		/**
		 * Sets the count.
		 *
		 * @param count the new count
		 */
		public void setCount(Integer count) {
			this.count = count;
		}

		/**
		 * Sets the part number.
		 *
		 * @param partNumber the new part number
		 */
		public void setPartNumber(String partNumber) {
			this.partNumber = partNumber;
		}

		/**
		 * Sets the part type.
		 *
		 * @param partType the new part type
		 */
		public void setPartType(String partType) {
			this.partType = partType;
		}

	}

	/**
	 * Load blueprint.
	 *
	 * @param bpn        the bpn
	 * @param partNumber the part number
	 * @return the blueprint
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Blueprint loadBlueprint(String bpn, String partNumber) throws IOException {
		final String resourceName = "testdata/blueprints/" + bpn.toUpperCase() + "_" + partNumber + ".json";
		final String bpStr = TDMResourceLoader.resourceToString(resourceName);
		final ObjectMapper om = new ObjectMapper();
		return om.readValue(bpStr, Blueprint.class);
	}

	/** The parent. */
	@JsonProperty("parent")
	private BlueprintItem parent = null;

	/**
	 * Instantiates a new blueprint.
	 */
	public Blueprint() {
		parent = new BlueprintItem();
	}

	/**
	 * Instantiates a new blueprint.
	 *
	 * @param parent the parent
	 */
	public Blueprint(BlueprintItem parent) {
		this.parent = parent;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public BlueprintItem getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(BlueprintItem parent) {
		this.parent = parent;
	}

}
