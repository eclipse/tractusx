package com.catenax.tdm;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.PartInfo;

public class BOM {

	public static class PartRelation {
		protected PartInfo parent = null;
		protected List<PartRelation> children = new ArrayList<PartRelation>();

		public PartRelation(PartInfo parent, PartRelation... children) {
			this.parent = parent;
			for (PartRelation c : children) {
				this.children.add(c);
			}
		}

		public PartInfo getParent() {
			return this.parent;
		}

		public List<PartRelation> getChildren() {
			return this.children;
		}
	}

	private PartRelation topLevel = null;
	
	public void setTopLevelRelation(PartRelation rel) {
		this.topLevel = rel;
	}

	public PartRelation getTopLevelRelation() {
		return topLevel;
	}

}
