package com.catenax.tdm.sampledata;

import com.catenax.tdm.BOM;
import com.catenax.tdm.aspect.AspectFactory;
import com.catenax.tdm.model.v1.Aspect;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartRelationship;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;

public class PartRelationshipSampleData {

	public static boolean PRS_PART_INFO = true;
	public static boolean PRS_PART_RELATIONSHIP = true;

	public static PartRelationshipWithInfos bomToPri(BOM bom, int depth) {
		BOM.PartRelation rel = bom.getTopLevelRelation();
		if (rel != null) {
			PartRelationshipWithInfos prsInfo = partRelationToPri(rel, depth);

			PartInfo partInfo = enrichAspects(rel.getParent());
			prsInfo.addPartInfosItem(partInfo);

			return prsInfo;
		}
		return null;
	}

	private static PartRelationshipWithInfos partRelationToPri(BOM.PartRelation rel, int depth) {
		PartRelationshipWithInfos prsInfo = new PartRelationshipWithInfos();

		if (rel != null) {
			PartInfo parent = rel.getParent();
			PartId parentId = parent.getPart();

			for (BOM.PartRelation child : rel.getChildren()) {
				PartInfo partInfoChild = enrichAspects(child.getParent());
				prsInfo.addPartInfosItem(partInfoChild);

				PartRelationship pRel = new PartRelationship();

				pRel.setParent(parentId);
				pRel.setChild(child.getParent().getPart());

				prsInfo.addRelationshipsItem(pRel);

				PartRelationshipWithInfos prsChildInfo = partRelationToPri(child, depth - 1);
				prsInfo = mergePri(prsInfo, prsChildInfo);
			}
		}

		return prsInfo;
	}

	private static PartInfo enrichAspects(PartInfo partInfo) {
		for (String aspect : AspectFactory.getAspects()) {
			String aspectName = aspect.toUpperCase();
			Aspect a = new Aspect();
			a.setName(aspectName);
			a.setUrl(AspectFactory.getAspectURL() + aspectName + "/" + partInfo.getPart().getOneIDManufacturer() + "/"
					+ partInfo.getPart().getObjectIDManufacturer());
			partInfo.addAspectsItem(a);
		}
		return partInfo;
	}

	private static PartRelationshipWithInfos mergePri(PartRelationshipWithInfos prs1, PartRelationshipWithInfos prs2) {
		PartRelationshipWithInfos prsInfo = new PartRelationshipWithInfos();

		if (prs1.getPartInfos() != null) {
			for (PartInfo pi : prs1.getPartInfos()) {
				prsInfo.addPartInfosItem(pi);
			}
		}

		if (prs2.getPartInfos() != null) {
			for (PartInfo pi : prs2.getPartInfos()) {
				prsInfo.addPartInfosItem(pi);
			}
		}

		if (prs1.getRelationships() != null) {
			for (PartRelationship pr : prs1.getRelationships()) {
				prsInfo.addRelationshipsItem(pr);
			}
		}

		if (prs2.getRelationships() != null) {
			for (PartRelationship pr : prs2.getRelationships()) {
				prsInfo.addRelationshipsItem(pr);
			}
		}

		return prsInfo;
	}

}
