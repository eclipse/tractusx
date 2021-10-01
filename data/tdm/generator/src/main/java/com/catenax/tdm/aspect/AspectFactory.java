/*
 *
 */
package com.catenax.tdm.aspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.api.Config;
import com.catenax.tdm.dao.QueueDao;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Aspect objects.
 */
public class AspectFactory {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AspectFactory.class);

	/** The Constant HANDLERS. */
	private static final Map<String, AspectHandler<Object>> HANDLERS = new HashMap<>();

	static {
		// AspectHandler PI_HANDLER = new PartIdAspectHandler();
		// HANDLERS.put("partid", PI_HANDLER);
		
		AspectHandler ALL_HANDLER = new AspectMappingHandler();
		HANDLERS.put("all", ALL_HANDLER);

		final AspectHandler DOC_HANDLER = new DocumentationAspectHandler();
		HANDLERS.put("documentation", DOC_HANDLER);

		final AspectHandler MAT_HANDLER = new MaterialAspectHandler();
		HANDLERS.put("material", MAT_HANDLER);

		final AspectHandler RET_HANDLER = new ReturnRequestAspectHandler();
		HANDLERS.put("returnrequest", RET_HANDLER);

		final AspectHandler PU_HANDLER = new ProductUsageAspectHandler();
		HANDLERS.put("productusage", PU_HANDLER);

		final AspectHandler PD_HANDLER = new ProductDescriptionAspectHandler();
		HANDLERS.put("productdescription", PD_HANDLER);

		final AspectHandler TD_HANDLER = new TechnicalDataAspectHandler();
		HANDLERS.put("technicaldata", TD_HANDLER);
	}

	/**
	 * Creates a new Aspect object.
	 *
	 * @param aspect the aspect
	 * @return the aspect handler< object>
	 */
	public static AspectHandler<Object> createHandlerForAspect(String aspect) {
		AspectHandler<Object> result = null;

		final String key = aspect.toLowerCase();
		if (HANDLERS.containsKey(key)) {
			result = HANDLERS.get(key);
		} else {
			log.error("Unknown Aspect '" + aspect + "'");
		}

		return result;
	}

	/**
	 * Gets the aspects.
	 *
	 * @return the aspects
	 */
	public static Set<String> getAspects() {
		return HANDLERS.keySet();
	}

	/**
	 * Gets the aspect URL.
	 *
	 * @return the aspect URL
	 */
	public static String getAspectURL() {
		final String result = Config.BASE_URL + "/catena-x/tdm/aspect/";

		return result;
	}

	/**
	 * Match key.
	 *
	 * @param bpn1      the bpn 1
	 * @param bpn2      the bpn 2
	 * @param serialNo1 the serial no 1
	 * @param serialNo2 the serial no 2
	 * @return true, if successful
	 */
	protected static boolean matchKey(String bpn1, String bpn2, String serialNo1, String serialNo2) {
		boolean result = true;

		if (bpn1.trim().length() > 0 && bpn2.trim().length() > 0) {
			// log.info("Match bpn: " + bpn1 + " == " + bpn2);
			result = bpn1.toLowerCase().equals(bpn2.toLowerCase());
		}

		if (result && serialNo1.trim().length() > 0 && serialNo2.trim().length() > 0) {
			// log.info("Match serialNo: " + serialNo1 + " == " + serialNo2);
			result = serialNo1.toLowerCase().equals(serialNo2.toLowerCase());
		}

		return result;
	}

	/**
	 * Resolve.
	 *
	 * @param aspect       the aspect
	 * @param oneID        the one ID
	 * @param partUniqueID the part unique ID
	 * @param dao          the dao
	 * @return the list
	 */
	public static List<Object> resolve(String aspect, String oneID, String partUniqueID, QueueDao dao) {
		return createHandlerForAspect(aspect).retrieveAspect(oneID, partUniqueID, dao);
	}

}
