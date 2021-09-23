package com.catenax.tdm.aspect;

import java.util.List;

public interface AspectHandler<T> {
	
	public List<T> retrieveAspect(String oneID, String partUniqueID);

}
