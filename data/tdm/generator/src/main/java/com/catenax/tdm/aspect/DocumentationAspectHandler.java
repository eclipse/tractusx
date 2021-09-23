package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.model.v1.DocumentClassificationCharacteristic;
import com.catenax.tdm.model.v1.DocumentClassificationCharacteristicInner;
import com.catenax.tdm.model.v1.DocumentIdCharacteristic;
import com.catenax.tdm.model.v1.DocumentIdCharacteristicInner;
import com.catenax.tdm.model.v1.DocumentVersions;
import com.catenax.tdm.model.v1.DocumentVersionsInner;
import com.catenax.tdm.model.v1.Documents;
import com.catenax.tdm.model.v1.DocumentsInner;
import com.catenax.tdm.model.v1.Material;
import com.catenax.tdm.model.v1.ReferenceElementSet;
import com.catenax.tdm.model.v1.Role;
import com.catenax.tdm.model.v1.StatusValueCharacteristic;

public class DocumentationAspectHandler implements AspectHandler<Documents> {

	@Override
	public List<Documents> retrieveAspect(String oneID, String partUniqueID) {
		List<Documents> list = new ArrayList<Documents>();
		
		Documents result = new Documents();
		
		DocumentsInner di = this.generateDocument();		
		result.add(di);
		
		list.add(result);

		return list;
	}
	
	private DocumentsInner generateDocument() {
		DocumentsInner di = new DocumentsInner();
		
		DocumentClassificationCharacteristic classification = new DocumentClassificationCharacteristic();
		DocumentClassificationCharacteristicInner c = new DocumentClassificationCharacteristicInner();
		
		//TODO: add classifications
		
		classification.add(c);
		di.setDocumentClassifications(classification);
		
		ReferenceElementSet res = new ReferenceElementSet();
		//TODO: add strings
		di.setDocumentEntities(res);
		
		DocumentIdCharacteristic did = new DocumentIdCharacteristic();
		DocumentIdCharacteristicInner didi = new DocumentIdCharacteristicInner();
		
		didi.setDocumentDomainId("");
		didi.setIsPrimary(true);
		didi.setValueId("");
		
		did.add(didi);
		di.setDocumentId(did);
		
		DocumentVersions versions = new DocumentVersions();
		DocumentVersionsInner version = new DocumentVersionsInner();
		
		version.setDate("");
		version.setDocumentVersionId("");
		version.setOrganizationName(TestDataFactory.getInstance().getBusinessName());
		version.setOrganizationOfficialName(version.getOrganizationName());
		version.setRole(Role.AUTHOR);
		
		versions.add(version);
		di.setDocumentVersions(versions);
		
		return di;
	}

}