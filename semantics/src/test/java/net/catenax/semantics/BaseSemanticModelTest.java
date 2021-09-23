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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFLanguages;
import org.apache.log4j.Logger;

import io.openmanufacturing.sds.aspectmetamodel.KnownVersion;

/**
 * Tests related to the semantic hub aspect model
 */
public class BaseSemanticModelTest {

    String TEST_NAMESPACE = "net.catena_x.semantics.test";
    String TEST_NAMESPACE_VERSION = "0.0.42";

    Map<KnownVersion, Model> metaModel = new HashMap<>();

    Logger logger=Logger.getLogger(getClass());

   /**
    * creates a model from a given description file input stream
    * @arg input stream to the model definition in RDF format
    * @return model
    */
    public Model createModel( InputStream input ) {
      Model model = ModelFactory.createDefaultModel();
      model.read( input, "", RDFLanguages.TURTLE.getName() );
      return model;
    }

    /**
    * creates a model from a given URL
    * @arg url which hints to the model description in RDF format
    * @return model
    */
    public Model createModel( URL input ) {
      try {
         return createModel( input.openStream() );
      } catch ( final IOException exception ) {
         throw new RuntimeException( exception );
      }
    }


    /** 
     * create a model from a classpath resource 
     * @arg resource path to the resource
     * @return created model, empty if resource cannot be found
     */
    public Model createModel( String resource ) {
      URL resourceUrl = getClass().getClassLoader().getResource( resource );
      if(resourceUrl != null ) {
         return createModel( resourceUrl );
      } else {
         return ModelFactory.createDefaultModel();
      }
    }

    /**
     * create a model from a set of resources
     * @param resources list of resources
     * @return model
     */
    public Model createModel( List<String> resources ) {
      Model model = ModelFactory.createDefaultModel();
      for(String resource : resources) {
         model.add(createModel(resource));
      }
      return model;
    }

    /**
     * loads BAMM into memory
     */
    Model loadBAMM( final KnownVersion version ) {
        return createModel( List.of(
              "bamm/meta-model/" + version.toVersionString() + "/aspect-meta-model-definitions.ttl",
              "bamm/meta-model/" + version.toVersionString() + "/type-conversions.ttl",
              "bamm/characteristic/" + version.toVersionString() + "/characteristic-definitions.ttl",
              "bamm/characteristic/" + version.toVersionString() + "/characteristic-instances.ttl",
              "bamm/entity/" + version.toVersionString() + "/TimeSeriesEntity.ttl",
              "bamm/unit/" + version.toVersionString() + "/units.ttl",
              "bamm/entity/" + version.toVersionString() + "/ThreeDimensionalPosition.ttl"
        ) );
     }
  
    /** 
     * get or load BAMM into memory
     */
    protected Model getBAMM( final KnownVersion version ) {
       if ( metaModel.get( version ) != null ) {
          return metaModel.get( version );
       }
       final Model result = loadBAMM( version );
       metaModel.put( version, result );
       return result;
    }
     
   /**
    * load a BAMM-supported model
    */
   protected Model loadModel( final String path, final String ttlDefinition, final KnownVersion knownVersion ) {
    final Model model = createModel( String
          .format( "%s/%s/%s/%s/%s.ttl", knownVersion.toString().toLowerCase(), path, TEST_NAMESPACE,
                TEST_NAMESPACE_VERSION, ttlDefinition ) );
    model.add( getBAMM( knownVersion ) );
    return model;
   }

   /** prodce a stream of BAMM versions to test with */
   protected static Stream<KnownVersion> allVersions() {
    return KnownVersion.getVersions().stream().dropWhile( KnownVersion.BAMM_1_0_0::isNewerThan );
   }

    /** 
     * check the validity of a given model definition 
     * TODO this needs to be reasonably replaced.
     */
    protected void checkValidity( final Model model, final KnownVersion testedVersion ) {
      logger.warn("Validity checks in semantic git sunit tests currently disabled. Ignoring model validity.");  
    }

}
