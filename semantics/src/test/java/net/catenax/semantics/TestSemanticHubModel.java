//
// Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//

package net.catenax.semantics;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.apache.jena.rdf.model.Model;

import io.openmanufacturing.sds.aspectmetamodel.KnownVersion;

/**
 * Tests related to the semantic hub aspect model
 */
public class TestSemanticHubModel extends BaseSemanticModelTest {

   String TEST_NAMESPACE = "net.catena_x.semantics.hub";
   String TEST_NAMESPACE_VERSION = "0.0.42";

   /**
    * performs the actual semantic hub model test
    */
    @ParameterizedTest
    @MethodSource( value = "allVersions" )
    public void testSemanticHubSuccess( final KnownVersion metaModelVersion ) {
       Model semanticHubModel=loadModel( "src/main/resources/models", "SemanticHub", metaModelVersion );
       checkValidity(semanticHubModel, metaModelVersion );
    }


}
