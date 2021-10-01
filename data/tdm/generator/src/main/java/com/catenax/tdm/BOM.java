/*
 *
 */
package com.catenax.tdm;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.PartInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class BOM.
 */
public class BOM {

	/**
	 * The Class PartRelation.
	 */
	public static class PartRelation {

		/** The parent. */
		protected PartInfo parent = null;

		/** The children. */
		protected List<PartRelation> children = new ArrayList<>();

		/**
		 * Instantiates a new part relation.
		 *
		 * @param parent   the parent
		 * @param children the children
		 */
		public PartRelation(PartInfo parent, List<PartRelation> children) {
			this.parent = parent;
			for (final PartRelation c : children) {
				this.children.add(c);
			}
		}

		/**
		 * Instantiates a new part relation.
		 *
		 * @param parent   the parent
		 * @param children the children
		 */
		public PartRelation(PartInfo parent, PartRelation... children) {
			this.parent = parent;
			for (final PartRelation c : children) {
				this.children.add(c);
			}
		}

		/**
		 * Gets the children.
		 *
		 * @return the children
		 */
		public List<PartRelation> getChildren() {
			return this.children;
		}

		/**
		 * Gets the parent.
		 *
		 * @return the parent
		 */
		public PartInfo getParent() {
			return this.parent;
		}
	}

	/** The top level. */
	private PartRelation topLevel = null;

	/**
	 * Instantiates a new bom.
	 */
	public BOM() {

	}

	/**
	 * Instantiates a new bom.
	 *
	 * @param topLevel the top level
	 */
	public BOM(PartRelation topLevel) {
		this.topLevel = topLevel;
	}

	/**
	 * Gets the top level relation.
	 *
	 * @return the top level relation
	 */
	public PartRelation getTopLevelRelation() {
		return topLevel;
	}

	/**
	 * Sets the top level relation.
	 *
	 * @param rel the new top level relation
	 */
	public void setTopLevelRelation(PartRelation rel) {
		this.topLevel = rel;
	}

}
