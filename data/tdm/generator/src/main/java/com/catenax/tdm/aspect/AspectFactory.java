package com.catenax.tdm.aspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.catenax.tdm.api.Config;

public class AspectFactory {
	
	private static final Map<String, AspectHandler<Object>> HANDLERS = new HashMap<String, AspectHandler<Object>>();
	
	public static String getAspectURL() {
		String result = Config.BASE_URL + "/catena-x/tdm/aspect/";
		
		return result;
	}
	
	public static Set<String> getAspects() {
		return HANDLERS.keySet();
	}
	
	static {
		AspectHandler PI_HANDLER = new PartIdAspectHandler();
		HANDLERS.put("partid", PI_HANDLER);
		
		AspectHandler DOC_HANDLER = new DocumentationAspectHandler();
		HANDLERS.put("documentation", DOC_HANDLER);
		
		AspectHandler MAT_HANDLER = new MaterialAspectHandler();
		HANDLERS.put("material", MAT_HANDLER);
		
		AspectHandler RET_HANDLER = new ReturnRequestAspectHandler();
		HANDLERS.put("returnrequest", RET_HANDLER);
		
		AspectHandler PU_HANDLER = new ProductUsageAspectHandler();
		HANDLERS.put("productusage", PU_HANDLER);
		
		AspectHandler PD_HANDLER = new ProductDescriptionAspectHandler();
		HANDLERS.put("productdescription", PD_HANDLER);
		
		AspectHandler TD_HANDLER = new TechnicalDataAspectHandler();
		HANDLERS.put("technicaldata", TD_HANDLER);
	}
	
	public static AspectHandler<Object> createHandlerForAspect(String aspect) {
		AspectHandler<Object> result = null;
		
		if(HANDLERS.containsKey(aspect.toLowerCase())) {
			result = HANDLERS.get(aspect.toLowerCase());
		} else {			
			throw new RuntimeException("Unknown Aspect '" + aspect + "'");
		}
		
		return result;
	}
	
	public static List<Object> resolve(String aspect, String oneID, String partUniqueID) {
		return createHandlerForAspect(aspect).retrieveAspect(oneID, partUniqueID);
	}

}
