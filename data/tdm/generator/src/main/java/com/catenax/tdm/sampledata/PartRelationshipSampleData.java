/*
 *
 */
package com.catenax.tdm.sampledata;

import com.catenax.tdm.BOM;
import com.catenax.tdm.aspect.AspectFactory;
import com.catenax.tdm.model.v1.Aspect;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartRelationship;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;

// TODO: Auto-generated Javadoc
/**
 * The Class PartRelationshipSampleData.
 */
public class PartRelationshipSampleData {

	/** The prs part info. */
	public static boolean PRS_PART_INFO = true;

	/** The prs part relationship. */
	public static boolean PRS_PART_RELATIONSHIP = true;

	/**
	 * Bom to pri.
	 *
	 * @param bom   the bom
	 * @param depth the depth
	 * @return the part relationship with infos
	 */
	public static PartRelationshipWithInfos bomToPri(BOM bom, int depth) {
		final BOM.PartRelation rel = bom.getTopLevelRelation();
		if (rel != null) {
			final PartRelationshipWithInfos prsInfo = partRelationToPri(rel, depth);

			final PartInfo partInfo = enrichAspects(rel.getParent());
			prsInfo.addPartInfosItem(partInfo);

			return prsInfo;
		}
		return null;
	}

	/**
	 * Enrich aspects.
	 *
	 * @param partInfo the part info
	 * @return the part info
	 */
	private static PartInfo enrichAspects(PartInfo partInfo) {
		for (final String aspect : AspectFactory.getAspects()) {
			final String aspectName = aspect.toUpperCase();
			final Aspect a = new Aspect();
			a.setName(aspectName);
			a.setUrl(AspectFactory.getAspectURL() + aspectName + "/" + partInfo.getPart().getOneIDManufacturer() + "/"
					+ partInfo.getPart().getObjectIDManufacturer());
			partInfo.addAspectsItem(a);
		}
		return partInfo;
	}

	/**
	 * Merge pri.
	 *
	 * @param prs1 the prs 1
	 * @param prs2 the prs 2
	 * @return the part relationship with infos
	 */
	private static PartRelationshipWithInfos mergePri(PartRelationshipWithInfos prs1, PartRelationshipWithInfos prs2) {
		final PartRelationshipWithInfos prsInfo = new PartRelationshipWithInfos();

		if (prs1.getPartInfos() != null) {
			for (final PartInfo pi : prs1.getPartInfos()) {
				prsInfo.addPartInfosItem(pi);
			}
		}

		if (prs2.getPartInfos() != null) {
			for (final PartInfo pi : prs2.getPartInfos()) {
				prsInfo.addPartInfosItem(pi);
			}
		}

		if (prs1.getRelationships() != null) {
			for (final PartRelationship pr : prs1.getRelationships()) {
				prsInfo.addRelationshipsItem(pr);
			}
		}

		if (prs2.getRelationships() != null) {
			for (final PartRelationship pr : prs2.getRelationships()) {
				prsInfo.addRelationshipsItem(pr);
			}
		}

		return prsInfo;
	}

	/**
	 * Part relation to pri.
	 *
	 * @param rel   the rel
	 * @param depth the depth
	 * @return the part relationship with infos
	 */
	private static PartRelationshipWithInfos partRelationToPri(BOM.PartRelation rel, int depth) {
		PartRelationshipWithInfos prsInfo = new PartRelationshipWithInfos();

		if (rel != null) {
			final PartInfo parent = rel.getParent();
			final PartId parentId = parent.getPart();

			for (final BOM.PartRelation child : rel.getChildren()) {
				final PartInfo partInfoChild = enrichAspects(child.getParent());
				prsInfo.addPartInfosItem(partInfoChild);

				final PartRelationship pRel = new PartRelationship();

				pRel.setParent(parentId);
				pRel.setChild(child.getParent().getPart());

				prsInfo.addRelationshipsItem(pRel);

				final PartRelationshipWithInfos prsChildInfo = partRelationToPri(child, depth - 1);
				prsInfo = mergePri(prsInfo, prsChildInfo);
			}
		}

		return prsInfo;
	}

}
