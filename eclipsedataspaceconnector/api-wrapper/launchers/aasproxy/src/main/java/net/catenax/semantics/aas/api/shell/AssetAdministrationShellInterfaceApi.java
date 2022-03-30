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
import net.catenax.semantics.framework.aas.model.AssetAdministrationShell;
import net.catenax.semantics.framework.aas.model.AssetInformation;
import net.catenax.semantics.framework.aas.model.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface AssetAdministrationShellInterfaceApi extends ApiClient.Api {

  /**
   * Deletes the submodel reference from the Asset Administration Shell
   * 
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /aas/submodels/{submodelIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteSubmodelReferenceById(@Param("submodelIdentifier") String submodelIdentifier);
  /**
   * Returns all submodel references
   * 
   * @return List&lt;Reference&gt;
   */
  @RequestLine("GET /aas/submodels")
  @Headers({
      "Accept: application/json",
  })
  List<Reference> getAllSubmodelReferences();
  /**
   * Returns the Asset Administration Shell
   * 
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @return AssetAdministrationShell
   */
  @RequestLine("GET /aas?content={content}")
  @Headers({
      "Accept: application/json",
  })
  AssetAdministrationShell getAssetAdministrationShell(@Param("content") String content);

  /**
   * Returns the Asset Administration Shell
   * 
   * Note, this is equivalent to the other <code>getAssetAdministrationShell</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAssetAdministrationShellQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   </ul>
   * @return AssetAdministrationShell

   */
  @RequestLine("GET /aas?content={content}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  AssetAdministrationShell getAssetAdministrationShell(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAssetAdministrationShell</code> method in a fluent style.
   */
  public static class GetAssetAdministrationShellQueryParams extends HashMap<String, Object> {
    public GetAssetAdministrationShellQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns the Asset Information
   * 
   * @return AssetInformation
   */
  @RequestLine("GET /aas/asset-information")
  @Headers({
      "Accept: application/json",
  })
  AssetInformation getAssetInformation();
  /**
   * Creates a submodel reference at the Asset Administration Shell
   * 
   * @param body Reference to the Submodel (required)
   * @return Reference
   */
  @RequestLine("POST /aas/submodels")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  Reference postSubmodelReference(Reference body);
  /**
   * Updates the Asset Administration Shell
   * 
   * @param body Asset Administration Shell object (required)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   */
  @RequestLine("PUT /aas?content={content}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putAssetAdministrationShell(AssetAdministrationShell body, @Param("content") String content);

  /**
   * Updates the Asset Administration Shell
   * 
   * Note, this is equivalent to the other <code>putAssetAdministrationShell</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PutAssetAdministrationShellQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Asset Administration Shell object (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   </ul>

   */
  @RequestLine("PUT /aas?content={content}")
  @Headers({
      "Content-Type: application/json",
  })
  void putAssetAdministrationShell(AssetAdministrationShell body, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>putAssetAdministrationShell</code> method in a fluent style.
   */
  public static class PutAssetAdministrationShellQueryParams extends HashMap<String, Object> {
    public PutAssetAdministrationShellQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Updates the Asset Information
   * 
   * @param body Asset Information object (required)
   */
  @RequestLine("PUT /aas/asset-information")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putAssetInformation(AssetInformation body);
}
