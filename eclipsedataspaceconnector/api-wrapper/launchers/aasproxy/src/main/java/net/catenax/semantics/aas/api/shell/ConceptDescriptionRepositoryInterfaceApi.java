/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.shell;

import net.catenax.semantics.framework.aas.ApiClient;
import net.catenax.semantics.framework.aas.EncodingUtils;
import net.catenax.semantics.framework.aas.model.ConceptDescription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface ConceptDescriptionRepositoryInterfaceApi extends ApiClient.Api {

  /**
   * Deletes a Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /concept-descriptions/{cdIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteConceptDescriptionById(@Param("cdIdentifier") String cdIdentifier);
  /**
   * Returns all Concept Descriptions
   * 
   * @param idShort The Concept Description’s IdShort (optional)
   * @param isCaseOf IsCaseOf reference (BASE64-URL-encoded) (optional)
   * @param dataSpecificationRef DataSpecification reference (BASE64-URL-encoded) (optional)
   * @return List&lt;ConceptDescription&gt;
   */
  @RequestLine("GET /concept-descriptions?idShort={idShort}&isCaseOf={isCaseOf}&dataSpecificationRef={dataSpecificationRef}")
  @Headers({
      "Accept: application/json",
  })
  List<ConceptDescription> getAllConceptDescriptions(@Param("idShort") String idShort, @Param("isCaseOf") String isCaseOf, @Param("dataSpecificationRef") String dataSpecificationRef);

  /**
   * Returns all Concept Descriptions
   * 
   * Note, this is equivalent to the other <code>getAllConceptDescriptions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConceptDescriptionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idShort - The Concept Description’s IdShort (optional)</li>
   *   <li>isCaseOf - IsCaseOf reference (BASE64-URL-encoded) (optional)</li>
   *   <li>dataSpecificationRef - DataSpecification reference (BASE64-URL-encoded) (optional)</li>
   *   </ul>
   * @return List&lt;ConceptDescription&gt;

   */
  @RequestLine("GET /concept-descriptions?idShort={idShort}&isCaseOf={isCaseOf}&dataSpecificationRef={dataSpecificationRef}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<ConceptDescription> getAllConceptDescriptions(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllConceptDescriptions</code> method in a fluent style.
   */
  public static class GetAllConceptDescriptionsQueryParams extends HashMap<String, Object> {
    public GetAllConceptDescriptionsQueryParams idShort(final String value) {
      put("idShort", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConceptDescriptionsQueryParams isCaseOf(final String value) {
      put("isCaseOf", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConceptDescriptionsQueryParams dataSpecificationRef(final String value) {
      put("dataSpecificationRef", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns a specific Concept Description
   * 
   * @param cdIdentifier The Concept Description’s unique id (BASE64-URL-encoded) (required)
   * @return ConceptDescription
   */
  @RequestLine("GET /concept-descriptions/{cdIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  ConceptDescription getConceptDescriptionById(@Param("cdIdentifier") String cdIdentifier);
  /**
   * Creates a new Concept Description
   * 
   * @param body Concept Description object (required)
   * @return ConceptDescription
   */
  @RequestLine("POST /concept-descriptions")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  ConceptDescription postConceptDescription(ConceptDescription body);
  /**
   * Updates an existing Concept Description
   * 
   * @param body Concept Description object (required)
   * @param cdIdentifier The Concept Description’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("PUT /concept-descriptions/{cdIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putConceptDescriptionById(ConceptDescription body, @Param("cdIdentifier") String cdIdentifier);
}
