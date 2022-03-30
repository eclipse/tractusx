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
import net.catenax.semantics.framework.aas.model.Submodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface SubmodelRepositoryInterfaceApi extends ApiClient.Api {

  /**
   * Deletes a Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /submodels/{submodelIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteSubmodelById(@Param("submodelIdentifier") String submodelIdentifier);
  /**
   * Returns all Submodels
   * 
   * @param semanticId The value of the semantic id reference (BASE64-URL-encoded) (optional)
   * @param idShort The Submodel’s idShort (optional)
   * @return List&lt;Submodel&gt;
   */
  @RequestLine("GET /submodels?semanticId={semanticId}&idShort={idShort}")
  @Headers({
      "Accept: application/json",
  })
  List<Submodel> getAllSubmodels(@Param("semanticId") String semanticId, @Param("idShort") String idShort);

  /**
   * Returns all Submodels
   * 
   * Note, this is equivalent to the other <code>getAllSubmodels</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSubmodelsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>semanticId - The value of the semantic id reference (BASE64-URL-encoded) (optional)</li>
   *   <li>idShort - The Submodel’s idShort (optional)</li>
   *   </ul>
   * @return List&lt;Submodel&gt;

   */
  @RequestLine("GET /submodels?semanticId={semanticId}&idShort={idShort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<Submodel> getAllSubmodels(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllSubmodels</code> method in a fluent style.
   */
  public static class GetAllSubmodelsQueryParams extends HashMap<String, Object> {
    public GetAllSubmodelsQueryParams semanticId(final String value) {
      put("semanticId", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSubmodelsQueryParams idShort(final String value) {
      put("idShort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   * @return Submodel
   */
  @RequestLine("GET /submodels/{submodelIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  Submodel getSubmodelById(@Param("submodelIdentifier") String submodelIdentifier);
  /**
   * Creates a new Submodel
   * 
   * @param body Submodel object (required)
   * @return Submodel
   */
  @RequestLine("POST /submodels")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  Submodel postSubmodel(Submodel body);
  /**
   * Creates a new or updates an existing Submodel
   * 
   * @param body Submodel object (required)
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   * @return Submodel
   */
  @RequestLine("PUT /submodels/{submodelIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  Submodel putSubmodelById(Submodel body, @Param("submodelIdentifier") String submodelIdentifier);
}
