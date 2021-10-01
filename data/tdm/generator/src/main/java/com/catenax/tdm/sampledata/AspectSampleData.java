/*
 *
 */
package com.catenax.tdm.sampledata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.TransactionQueue;
import com.catenax.tdm.model.v1.AspectMapping;
import com.catenax.tdm.model.v1.DocumentsInner;
import com.catenax.tdm.model.v1.Material;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.ProductDescription;
import com.catenax.tdm.model.v1.ProductUsage;
import com.catenax.tdm.model.v1.ReturnRequest;
import com.catenax.tdm.model.v1.TechnicalData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectSampleData.
 */
public class AspectSampleData {
	
	public static boolean CREATE_ASPECTS = true;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AspectSampleData.class);

	/** The part info. */
	private PartInfo partInfo = null;

	/** The aspect mapping. */
	private AspectMapping aspectMapping = null;

	/**
	 * Instantiates a new aspect sample data.
	 *
	 * @param pi the pi
	 */
	public AspectSampleData(PartInfo pi) {
		if(!CREATE_ASPECTS) {
			return;
		}
		
		this.partInfo = pi;

		log.info("Create aspects for: " + pi.getPart().getOneIDManufacturer() + "_"
				+ pi.getPart().getObjectIDManufacturer());
		
		String bpn = pi.getPart().getOneIDManufacturer();
		if(BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.containsKey(bpn)) {
			bpn = BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.get(bpn);
		}

		this.aspectMapping = new AspectMapping(this.partInfo.getPart());
		
		this.aspectMapping.setParentBpn(bpn);

		this.aspectMapping.getMaterial().addAll(this.createMaterial());

		this.aspectMapping.getDocuments().addAll(this.createDocuments());

		this.aspectMapping.getTechnicalData().addAll(this.createTechnicalData());

		this.aspectMapping.getReturnRequest().addAll(this.createReturnRequest());

		this.aspectMapping.getProductDescription().addAll(this.createProductDescription());

		this.aspectMapping.getProductUsage().addAll(this.createProductUsage());

		TransactionQueue.add(aspectMapping);
	}

	/**
	 * Instantiates a new aspect sample data.
	 *
	 * @param pi          the pi
	 * @param replacement the replacement
	 */
	public AspectSampleData(PartInfo pi, PartInfo replacement) {
		if(!CREATE_ASPECTS) {
			return;
		}
		
		this.partInfo = pi;

		log.info("Create aspects for: " + pi.getPart().getOneIDManufacturer() + "_"
				+ pi.getPart().getObjectIDManufacturer());
		
		String bpn = pi.getPart().getOneIDManufacturer();
		if(BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.containsKey(bpn)) {
			bpn = BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.get(bpn);
		}

		this.aspectMapping = new AspectMapping(replacement.getPart());
		
		this.aspectMapping.setParentBpn(bpn);

		this.aspectMapping.getMaterial().addAll(this.createMaterial());

		this.aspectMapping.getDocuments().addAll(this.createDocuments());

		this.aspectMapping.getTechnicalData().addAll(this.createTechnicalData());

		this.aspectMapping.getReturnRequest().addAll(this.createReturnRequest());

		this.aspectMapping.getProductDescription().addAll(this.createProductDescription());

		this.aspectMapping.getProductUsage().addAll(this.createProductUsage());

		TransactionQueue.add(aspectMapping);
	}

	/**
	 * Creates the documents.
	 *
	 * @return the list
	 */
	private List<DocumentsInner> createDocuments() {
		List<DocumentsInner> result = new ArrayList<>();

		try {
			final String content = resolveResource("documentation");

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<DocumentsInner>>() {
			});
			log.info("Documentation template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final DocumentsInner d : result) {
				TransactionQueue.addAll(d.getDocumentClassifications());
				TransactionQueue.addAll(d.getDocumentId());
				TransactionQueue.addAll(d.getDocumentVersions());
				TransactionQueue.add(d);
			}
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
		}

		return result;
	}

	/**
	 * Creates the material.
	 *
	 * @return the list
	 */
	private List<Material> createMaterial() {
		List<Material> result = new ArrayList<>();

		try {
			final String content = resolveResource("material");

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<Material>>() {
			});
			log.info("Material template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final Material m : result) {
				TransactionQueue.addAll(m.getMaterialDetails().getChemicalComposition());
				TransactionQueue.add(m.getMaterialDetails());
				TransactionQueue.add(m);
			}
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
		}

		return result;
	}

	/**
	 * Creates the product description.
	 *
	 * @return the list
	 */
	private List<ProductDescription> createProductDescription() {
		List<ProductDescription> result = new ArrayList<>();
		final Map<String, String> val = new HashMap<>();
		val.put("capmaxhvb",
				("" + (double) TestDataFactory.getInstance().getNumberBetween(9500, 10000) / 100).replaceAll(",", "."));
		val.put("capmaxhvc",
				("" + (double) TestDataFactory.getInstance().getNumberBetween(590, 610) / 100).replaceAll(",", "."));

		try {
			final String content = resolveResource("product_description", val);

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<ProductDescription>>() {
			});
			log.info("ProductDescription template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final ProductDescription p : result) {
				TransactionQueue.add(p.getPerformanceIndicator());
				TransactionQueue.add(p.getProductDimension());
				TransactionQueue.add(p);
			}
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
		}

		return result;
	}

	/**
	 * Creates the product usage.
	 *
	 * @return the list
	 */
	private List<ProductUsage> createProductUsage() {
		List<ProductUsage> result = new ArrayList<>();
		final Map<String, String> val = new HashMap<>();
		val.put("health", "" + TestDataFactory.getInstance().getNumberBetween(95, 100));
		val.put("charge", "" + TestDataFactory.getInstance().getNumberBetween(45, 55));
		val.put("hazard", "null");
		val.put("cycles", "0");
		val.put("cyclesplanned", "" + TestDataFactory.getInstance().getNumberBetween(1000, 1500));
		val.put("lifespan", "0");
		val.put("lifespanplanned", "" + TestDataFactory.getInstance().getNumberBetween(10, 15));
		val.put("mileage", "0");
		val.put("voltage", "" + TestDataFactory.getInstance().getNumberBetween(11, 13));

		try {
			final String content = resolveResource("product_usage", val);

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<ProductUsage>>() {
			});
			log.info("ProductUsage template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final ProductUsage p : result) {
				TransactionQueue.add(p);
			}

			log.info("productusage created for: " + this.partInfo.getPartTypeName());
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
			// log.error(e.getMessage());
		}

		return result;
	}

	/**
	 * Creates the return request.
	 *
	 * @return the list
	 */
	private List<ReturnRequest> createReturnRequest() {
		List<ReturnRequest> result = new ArrayList<>();
		try {
			final String content = resolveResource("return_request");

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<ReturnRequest>>() {
			});
			log.info("ReturnRequest template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final ReturnRequest r : result) {
				TransactionQueue.add(r);
			}
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates the technical data.
	 *
	 * @return the list
	 */
	private List<TechnicalData> createTechnicalData() {
		List<TechnicalData> result = new ArrayList<>();
		try {
			final String content = resolveResource("technical_data");

			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(content, new TypeReference<List<TechnicalData>>() {
			});
			log.info("TechnicalData template loaded for " + this.partInfo.getPart().getOneIDManufacturer() + "_"
					+ this.partInfo.getPart().getObjectIDManufacturer());// + ": " + content);

			for (final TechnicalData td : result) {
				TransactionQueue.add(td.getFurtherInformation());
				TransactionQueue.add(td.getGeneralInformation().getManufacturerLogo());
				TransactionQueue.addAll(td.getGeneralInformation().getProductImages());
				TransactionQueue.add(td.getGeneralInformation());
				TransactionQueue.addAll(td.getProductClassifications());
				TransactionQueue.add(td.getTechnicalProperties());
				TransactionQueue.add(td);
			}
		} catch (final IOException e) {
			// IGNORE: case ok
			// e.printStackTrace();
		}

		return result;
	}

	// ---

	/**
	 * Resolve resource.
	 *
	 * @param aspect the aspect
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private String resolveResource(String aspect) throws IOException {
		return PartSampleData.resolveResource(this.partInfo, aspect);
	}

	/**
	 * Resolve resource.
	 *
	 * @param aspect the aspect
	 * @param vals   the vals
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private String resolveResource(String aspect, Map<String, String> vals) throws IOException {
		return PartSampleData.resolveResource(this.partInfo, aspect, vals);
	}

}
