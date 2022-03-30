/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.shell;

import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;
import net.catenax.semantics.framework.aas.ApiClient;
import net.catenax.semantics.framework.aas.EncodingUtils;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface AssetAdministrationShellSerializationInterfaceApi extends ApiClient.Api {

  /**
   * Returns an appropriate serialization based on the specified format (see SerializationFormat)
   * 
   * @param aasIds The Asset Administration Shells&#x27; unique ids (BASE64-URL-encoded) (required)
   * @param submodelIds The Submodels&#x27; unique ids (BASE64-URL-encoded) (required)
   * @param includeConceptDescriptions Include Concept Descriptions? (required)
   * @return File
   */
  @RequestLine("GET /serialization?aasIds={aasIds}&submodelIds={submodelIds}&includeConceptDescriptions={includeConceptDescriptions}")
  @Headers({
      "Accept: application/json",
  })
  File generateSerializationByIds(@Param("aasIds") List<String> aasIds, @Param("submodelIds") List<String> submodelIds, @Param("includeConceptDescriptions") Boolean includeConceptDescriptions);

  /**
   * Returns an appropriate serialization based on the specified format (see SerializationFormat)
   * 
   * Note, this is equivalent to the other <code>generateSerializationByIds</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GenerateSerializationByIdsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>aasIds - The Asset Administration Shells&#x27; unique ids (BASE64-URL-encoded) (required)</li>
   *   <li>submodelIds - The Submodels&#x27; unique ids (BASE64-URL-encoded) (required)</li>
   *   <li>includeConceptDescriptions - Include Concept Descriptions? (required)</li>
   *   </ul>
   * @return File

   */
  @RequestLine("GET /serialization?aasIds={aasIds}&submodelIds={submodelIds}&includeConceptDescriptions={includeConceptDescriptions}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  File generateSerializationByIds(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>generateSerializationByIds</code> method in a fluent style.
   */
  public static class GenerateSerializationByIdsQueryParams extends HashMap<String, Object> {
    public GenerateSerializationByIdsQueryParams aasIds(final List<String> value) {
      put("aasIds", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GenerateSerializationByIdsQueryParams submodelIds(final List<String> value) {
      put("submodelIds", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GenerateSerializationByIdsQueryParams includeConceptDescriptions(final Boolean value) {
      put("includeConceptDescriptions", EncodingUtils.encode(value));
      return this;
    }
  }
}
