/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.aas.api;

import net.catenax.semantics.framework.aas.EncodingUtils;
import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptor;
import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptorCollection;
import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;
import net.catenax.semantics.framework.aas.model.SubmodelDescriptor;
import net.catenax.semantics.framework.aas.ApiClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

/**
 * Interface to the AAS Registry Profile of Catena-X (Companion to the AAS Server Profile).
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T18:11:20.840352600+01:00[Europe/Berlin]")public interface RegistryAndDiscoveryInterfaceApi extends ApiClient.Api {

  /**
   * Deletes all Asset identifier key-value-pair linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /lookup/shells/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteAllAssetLinksById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /registry/shell-descriptors/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteAssetAdministrationShellDescriptorById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Deletes a Submodel Descriptor, i.e. de-registers a submodel
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteSubmodelDescriptorById(@Param("aasIdentifier") String aasIdentifier, @Param("submodelIdentifier") String submodelIdentifier);
  /**
   * Returns all Asset Administration Shell Descriptors
   * 
   * @param page  (optional, default to 0)
   * @param pageSize  (optional, default to 10)
   * @return AssetAdministrationShellDescriptorCollection
   */
  @RequestLine("GET /registry/shell-descriptors?page={page}&pageSize={pageSize}")
  @Headers({
      "Accept: application/json",
  })
  AssetAdministrationShellDescriptorCollection getAllAssetAdministrationShellDescriptors(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

  /**
   * Returns all Asset Administration Shell Descriptors
   * 
   * Note, this is equivalent to the other <code>getAllAssetAdministrationShellDescriptors</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAssetAdministrationShellDescriptorsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page -  (optional, default to 0)</li>
   *   <li>pageSize -  (optional, default to 10)</li>
   *   </ul>
   * @return AssetAdministrationShellDescriptorCollection

   */
  @RequestLine("GET /registry/shell-descriptors?page={page}&pageSize={pageSize}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  AssetAdministrationShellDescriptorCollection getAllAssetAdministrationShellDescriptors(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllAssetAdministrationShellDescriptors</code> method in a fluent style.
   */
  public static class GetAllAssetAdministrationShellDescriptorsQueryParams extends HashMap<String, Object> {
    public GetAllAssetAdministrationShellDescriptorsQueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAssetAdministrationShellDescriptorsQueryParams pageSize(final Integer value) {
      put("pageSize", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns a list of Asset Administration Shell ids based on Asset identifier key-value-pairs
   * 
   * @param assetIds The key-value-pair of an Asset identifier (optional)
   * @return List&lt;String&gt;
   */
  @RequestLine("GET /lookup/shells?assetIds={assetIds}")
  @Headers({
      "Accept: application/json",
  })
  List<String> getAllAssetAdministrationShellIdsByAssetLink(@Param("assetIds") List<IdentifierKeyValuePair> assetIds);

  /**
   * Returns a list of Asset Administration Shell ids based on Asset identifier key-value-pairs
   * 
   * Note, this is equivalent to the other <code>getAllAssetAdministrationShellIdsByAssetLink</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAssetAdministrationShellIdsByAssetLinkQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>assetIds - The key-value-pair of an Asset identifier (optional)</li>
   *   </ul>
   * @return List&lt;String&gt;

   */
  @RequestLine("GET /lookup/shells?assetIds={assetIds}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<String> getAllAssetAdministrationShellIdsByAssetLink(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllAssetAdministrationShellIdsByAssetLink</code> method in a fluent style.
   */
  public static class GetAllAssetAdministrationShellIdsByAssetLinkQueryParams extends HashMap<String, Object> {
    public GetAllAssetAdministrationShellIdsByAssetLinkQueryParams assetIds(final List<IdentifierKeyValuePair> value) {
      put("assetIds", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }
  /**
   * Returns a list of Asset identifier key-value-pairs based on an Asset Administration Shell id to edit discoverable content
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return List&lt;IdentifierKeyValuePair&gt;
   */
  @RequestLine("GET /lookup/shells/{aasIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  List<IdentifierKeyValuePair> getAllAssetLinksById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Returns all Submodel Descriptors
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return List&lt;SubmodelDescriptor&gt;
   */
  @RequestLine("GET /registry/shell-descriptors/{aasIdentifier}/submodel-descriptors")
  @Headers({
      "Accept: application/json",
  })
  List<SubmodelDescriptor> getAllSubmodelDescriptors(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Returns a specific Asset Administration Shell Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return AssetAdministrationShellDescriptor
   */
  @RequestLine("GET /registry/shell-descriptors/{aasIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  AssetAdministrationShellDescriptor getAssetAdministrationShellDescriptorById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Returns a specific Submodel Descriptor
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   * @return SubmodelDescriptor
   */
  @RequestLine("GET /registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  SubmodelDescriptor getSubmodelDescriptorById(@Param("aasIdentifier") String aasIdentifier, @Param("submodelIdentifier") String submodelIdentifier);
  /**
   * Creates all Asset identifier key-value-pair linked to an Asset Administration Shell to edit discoverable content
   * 
   * @param body Asset identifier key-value-pairs (required)
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return List&lt;IdentifierKeyValuePair&gt;
   */
  @RequestLine("POST /lookup/shells/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  List<IdentifierKeyValuePair> postAllAssetLinksById(List<IdentifierKeyValuePair> body, @Param("aasIdentifier") String aasIdentifier);
  /**
   * Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS
   * 
   * @param body Asset Administration Shell Descriptor object (required)
   * @return AssetAdministrationShellDescriptor
   */
  @RequestLine("POST /registry/shell-descriptors")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  AssetAdministrationShellDescriptor postAssetAdministrationShellDescriptor(AssetAdministrationShellDescriptor body);
  /**
   * Creates a new Submodel Descriptor, i.e. registers a submodel
   * 
   * @param body Submodel Descriptor object (required)
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return SubmodelDescriptor
   */
  @RequestLine("POST /registry/shell-descriptors/{aasIdentifier}/submodel-descriptors")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmodelDescriptor postSubmodelDescriptor(SubmodelDescriptor body, @Param("aasIdentifier") String aasIdentifier);
  /**
   * Updates an existing Asset Administration Shell Descriptor
   * 
   * @param body Asset Administration Shell Descriptor object (required)
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("PUT /registry/shell-descriptors/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putAssetAdministrationShellDescriptorById(AssetAdministrationShellDescriptor body, @Param("aasIdentifier") String aasIdentifier);
  /**
   * Updates an existing Submodel Descriptor
   * 
   * @param body Submodel Descriptor object (required)
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @param submodelIdentifier The Submodel’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("PUT /registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putSubmodelDescriptorById(SubmodelDescriptor body, @Param("aasIdentifier") String aasIdentifier, @Param("submodelIdentifier") String submodelIdentifier);
}
