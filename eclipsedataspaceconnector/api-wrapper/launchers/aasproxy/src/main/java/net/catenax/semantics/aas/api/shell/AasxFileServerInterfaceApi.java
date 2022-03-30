/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.shell;

import java.io.File;

import net.catenax.semantics.framework.aas.ApiClient;
import net.catenax.semantics.framework.aas.EncodingUtils;
import net.catenax.semantics.framework.aas.model.PackageDescription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface AasxFileServerInterfaceApi extends ApiClient.Api {

  /**
   * Deletes a specific AASX package from the server
   * 
   * @param packageId The Package Id (BASE64-URL-encoded) (required)
   */
  @RequestLine("DELETE /packages/{packageId}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteAASXByPackageId(@Param("packageId") String packageId);
  /**
   * Returns a specific AASX package from the server
   * 
   * @param packageId The package Id (BASE64-URL-encoded) (required)
   * @return File
   */
  @RequestLine("GET /packages/{packageId}")
  @Headers({
      "Accept: application/asset-administration-shell-package",
  })
  File getAASXByPackageId(@Param("packageId") String packageId);
  /**
   * Returns a list of available AASX packages at the server
   * 
   * @param aasId The Asset Administration Shell’s unique id (BASE64-URL-encoded) (optional)
   * @return List&lt;PackageDescription&gt;
   */
  @RequestLine("GET /packages?aasId={aasId}")
  @Headers({
      "Accept: application/json",
  })
  List<PackageDescription> getAllAASXPackageIds(@Param("aasId") String aasId);

  /**
   * Returns a list of available AASX packages at the server
   * 
   * Note, this is equivalent to the other <code>getAllAASXPackageIds</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAASXPackageIdsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>aasId - The Asset Administration Shell’s unique id (BASE64-URL-encoded) (optional)</li>
   *   </ul>
   * @return List&lt;PackageDescription&gt;

   */
  @RequestLine("GET /packages?aasId={aasId}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<PackageDescription> getAllAASXPackageIds(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllAASXPackageIds</code> method in a fluent style.
   */
  public static class GetAllAASXPackageIdsQueryParams extends HashMap<String, Object> {
    public GetAllAASXPackageIdsQueryParams aasId(final String value) {
      put("aasId", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Stores the AASX package at the server
   * 
   * @param aasIds  (required)
   * @param file  (required)
   * @param fileName  (required)
   * @return PackageDescription
   */
  @RequestLine("POST /packages")
  @Headers({
      "Content-Type: multipart/form-data",
      "Accept: application/json",
  })
  PackageDescription postAASXPackage(@Param("aasIds") List<String> aasIds, @Param("file") File file, @Param("fileName") String fileName);
  /**
   * Updates the AASX package at the server
   * 
   * @param aasIds  (required)
   * @param file  (required)
   * @param fileName  (required)
   * @param packageId The Package Id (BASE64-URL-encoded) (required)
   */
  @RequestLine("PUT /packages/{packageId}")
  @Headers({
      "Content-Type: multipart/form-data",
      "Accept: */*",
  })
  void putAASXByPackageId(@Param("aasIds") List<String> aasIds, @Param("file") File file, @Param("fileName") String fileName, @Param("packageId") String packageId);
}
