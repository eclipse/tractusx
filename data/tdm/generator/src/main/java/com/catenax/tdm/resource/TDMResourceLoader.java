/*
 *
 */
package com.catenax.tdm.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class TDMResourceLoader.
 */
public class TDMResourceLoader {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(TDMResourceLoader.class);
	private static boolean CACHE_ENABLED = true;
	private static final Map<String, String> CACHE = new HashMap<String, String>();
	
	public static void flushCache() {
		CACHE.clear();
	}

	/**
	 * Load resource.
	 *
	 * @param path the path
	 * @return the input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static InputStream loadResource(String path) throws IOException {
		try {
			final ResourceLoader loader = new DefaultResourceLoader();
			String resourceName = "classpath:" + path;			
			final Resource resource = loader.getResource(resourceName);
			if(resource.exists()) {
				final InputStream in = resource.getInputStream(); // FileInputStream(file);
				return in;
			} else {
				return null;
			}
		} catch (final IOException e) {
			// log.debug(e.getMessage());
			throw e;
		}
	}

	/**
	 * Resource to string.
	 *
	 * @param path the path
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String resourceToString(String path) throws IOException {
		String result = "";
		
		if(CACHE_ENABLED && CACHE.containsKey(path)) {
			result = CACHE.get(path);
		} else {
			final InputStream in = loadResource(path);
			if(in == null) {
				throw new IOException("Resource '" + path + "' does not exist");
			}
	
			final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			final StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
	
			result = out.toString();
			if(CACHE_ENABLED) {
				CACHE.put(path, result);
			}
		}

		return result;
	}

}
