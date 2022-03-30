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
import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface AssetAdministrationShellRepositoryInterfaceApi extends ApiClient.Api {

  /**
   * Deletes an Asset Administration Shell
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /shells/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteAssetAdministrationShellById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Returns all Asset Administration Shells
   * 
   * @param assetIds The key-value-pair of an Asset identifier (optional)
   * @param idShort The Asset Administration Shell’s IdShort (optional)
   * @return List&lt;AssetAdministrationShell&gt;
   */
  @RequestLine("GET /shells?assetIds={assetIds}&idShort={idShort}")
  @Headers({
      "Accept: application/json",
  })
  List<AssetAdministrationShell> getAllAssetAdministrationShells(@Param("assetIds") List<IdentifierKeyValuePair> assetIds, @Param("idShort") String idShort);

  /**
   * Returns all Asset Administration Shells
   * 
   * Note, this is equivalent to the other <code>getAllAssetAdministrationShells</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAssetAdministrationShellsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>assetIds - The key-value-pair of an Asset identifier (optional)</li>
   *   <li>idShort - The Asset Administration Shell’s IdShort (optional)</li>
   *   </ul>
   * @return List&lt;AssetAdministrationShell&gt;

   */
  @RequestLine("GET /shells?assetIds={assetIds}&idShort={idShort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<AssetAdministrationShell> getAllAssetAdministrationShells(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllAssetAdministrationShells</code> method in a fluent style.
   */
  public static class GetAllAssetAdministrationShellsQueryParams extends HashMap<String, Object> {
    public GetAllAssetAdministrationShellsQueryParams assetIds(final List<IdentifierKeyValuePair> value) {
      put("assetIds", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAssetAdministrationShellsQueryParams idShort(final String value) {
      put("idShort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns a specific Asset Administration Shell
   * 
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   * @return AssetAdministrationShell
   */
  @RequestLine("GET /shells/{aasIdentifier}")
  @Headers({
      "Accept: application/json",
  })
  AssetAdministrationShell getAssetAdministrationShellById(@Param("aasIdentifier") String aasIdentifier);
  /**
   * Creates a new Asset Administration Shell
   * 
   * @param body Asset Administration Shell object (required)
   * @return AssetAdministrationShell
   */
  @RequestLine("POST /shells")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  AssetAdministrationShell postAssetAdministrationShell(AssetAdministrationShell body);
  /**
   * Updates an existing Asset Administration Shell
   * 
   * @param body Asset Administration Shell object (required)
   * @param aasIdentifier The Asset Administration Shell’s unique id (BASE64-URL-encoded) (required)
   */
  @RequestLine("PUT /shells/{aasIdentifier}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putAssetAdministrationShellById(AssetAdministrationShell body, @Param("aasIdentifier") String aasIdentifier);
}
