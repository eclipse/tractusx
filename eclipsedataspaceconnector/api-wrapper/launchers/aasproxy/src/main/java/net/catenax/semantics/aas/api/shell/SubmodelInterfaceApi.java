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
import net.catenax.semantics.framework.aas.model.OperationRequest;
import net.catenax.semantics.framework.aas.model.OperationResult;
import net.catenax.semantics.framework.aas.model.Submodel;
import net.catenax.semantics.framework.aas.model.SubmodelElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface SubmodelInterfaceApi extends ApiClient.Api {

  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   */
  @RequestLine("DELETE /submodel/submodel-elements/{idShortPath}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteSubmodelElementByPath(@Param("idShortPath") String idShortPath);
  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   * @return List&lt;SubmodelElement&gt;
   */
  @RequestLine("GET /submodel/submodel-elements?level={level}&content={content}&extent={extent}")
  @Headers({
      "Accept: application/json",
  })
  List<SubmodelElement> getAllSubmodelElements(@Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Returns all submodel elements including their hierarchy
   * 
   * Note, this is equivalent to the other <code>getAllSubmodelElements</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSubmodelElementsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>
   * @return List&lt;SubmodelElement&gt;

   */
  @RequestLine("GET /submodel/submodel-elements?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<SubmodelElement> getAllSubmodelElements(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAllSubmodelElements</code> method in a fluent style.
   */
  public static class GetAllSubmodelElementsQueryParams extends HashMap<String, Object> {
    public GetAllSubmodelElementsQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSubmodelElementsQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSubmodelElementsQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns the Operation result of an asynchronous invoked Operation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated), in this case an operation (required)
   * @param handleId The returned handle id of an operation’s asynchronous invocation used to request the current state of the operation’s execution (BASE64-URL-encoded) (required)
   * @param content  (optional, default to normal)
   * @return OperationResult
   */
  @RequestLine("GET /submodel/submodel-elements/{idShortPath}/operation-results/{handleId}?content={content}")
  @Headers({
      "Accept: application/json",
  })
  OperationResult getOperationAsyncResult(@Param("idShortPath") String idShortPath, @Param("handleId") String handleId, @Param("content") String content);

  /**
   * Returns the Operation result of an asynchronous invoked Operation
   * 
   * Note, this is equivalent to the other <code>getOperationAsyncResult</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetOperationAsyncResultQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param idShortPath IdShort path to the submodel element (dot-separated), in this case an operation (required)
   * @param handleId The returned handle id of an operation’s asynchronous invocation used to request the current state of the operation’s execution (BASE64-URL-encoded) (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>content -  (optional, default to normal)</li>
   *   </ul>
   * @return OperationResult

   */
  @RequestLine("GET /submodel/submodel-elements/{idShortPath}/operation-results/{handleId}?content={content}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  OperationResult getOperationAsyncResult(@Param("idShortPath") String idShortPath, @Param("handleId") String handleId, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getOperationAsyncResult</code> method in a fluent style.
   */
  public static class GetOperationAsyncResultQueryParams extends HashMap<String, Object> {
    public GetOperationAsyncResultQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns the Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   * @return Submodel
   */
  @RequestLine("GET /submodel?level={level}&content={content}&extent={extent}")
  @Headers({
      "Accept: application/json",
  })
  Submodel getSubmodel(@Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Returns the Submodel
   * 
   * Note, this is equivalent to the other <code>getSubmodel</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSubmodelQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>
   * @return Submodel

   */
  @RequestLine("GET /submodel?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  Submodel getSubmodel(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSubmodel</code> method in a fluent style.
   */
  public static class GetSubmodelQueryParams extends HashMap<String, Object> {
    public GetSubmodelQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public GetSubmodelQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public GetSubmodelQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   * @return SubmodelElement
   */
  @RequestLine("GET /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Accept: application/json",
  })
  SubmodelElement getSubmodelElementByPath(@Param("idShortPath") String idShortPath, @Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * Note, this is equivalent to the other <code>getSubmodelElementByPath</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSubmodelElementByPathQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>
   * @return SubmodelElement

   */
  @RequestLine("GET /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  SubmodelElement getSubmodelElementByPath(@Param("idShortPath") String idShortPath, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSubmodelElementByPath</code> method in a fluent style.
   */
  public static class GetSubmodelElementByPathQueryParams extends HashMap<String, Object> {
    public GetSubmodelElementByPathQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public GetSubmodelElementByPathQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public GetSubmodelElementByPathQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Synchronously or asynchronously invokes an Operation at a specified path
   * 
   * @param body Operation request object (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated), in this case an operation (required)
   * @param async Determines whether an operation invocation is performed asynchronously or synchronously (optional, default to false)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @return OperationResult
   */
  @RequestLine("POST /submodel/submodel-elements/{idShortPath}/invoke?async={async}&content={content}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  OperationResult invokeOperation(OperationRequest body, @Param("idShortPath") String idShortPath, @Param("async") Boolean async, @Param("content") String content);

  /**
   * Synchronously or asynchronously invokes an Operation at a specified path
   * 
   * Note, this is equivalent to the other <code>invokeOperation</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link InvokeOperationQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Operation request object (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated), in this case an operation (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>async - Determines whether an operation invocation is performed asynchronously or synchronously (optional, default to false)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   </ul>
   * @return OperationResult

   */
  @RequestLine("POST /submodel/submodel-elements/{idShortPath}/invoke?async={async}&content={content}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  OperationResult invokeOperation(OperationRequest body, @Param("idShortPath") String idShortPath, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>invokeOperation</code> method in a fluent style.
   */
  public static class InvokeOperationQueryParams extends HashMap<String, Object> {
    public InvokeOperationQueryParams async(final Boolean value) {
      put("async", EncodingUtils.encode(value));
      return this;
    }
    public InvokeOperationQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Creates a new submodel element
   * 
   * @param body Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   * @return SubmodelElement
   */
  @RequestLine("POST /submodel/submodel-elements?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmodelElement postSubmodelElement(SubmodelElement body, @Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Creates a new submodel element
   * 
   * Note, this is equivalent to the other <code>postSubmodelElement</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PostSubmodelElementQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Requested submodel element (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>
   * @return SubmodelElement

   */
  @RequestLine("POST /submodel/submodel-elements?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmodelElement postSubmodelElement(SubmodelElement body, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>postSubmodelElement</code> method in a fluent style.
   */
  public static class PostSubmodelElementQueryParams extends HashMap<String, Object> {
    public PostSubmodelElementQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public PostSubmodelElementQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public PostSubmodelElementQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param body Requested submodel element (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   * @return SubmodelElement
   */
  @RequestLine("POST /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmodelElement postSubmodelElementByPath(SubmodelElement body, @Param("idShortPath") String idShortPath, @Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * Note, this is equivalent to the other <code>postSubmodelElementByPath</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PostSubmodelElementByPathQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Requested submodel element (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>
   * @return SubmodelElement

   */
  @RequestLine("POST /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmodelElement postSubmodelElementByPath(SubmodelElement body, @Param("idShortPath") String idShortPath, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>postSubmodelElementByPath</code> method in a fluent style.
   */
  public static class PostSubmodelElementByPathQueryParams extends HashMap<String, Object> {
    public PostSubmodelElementByPathQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public PostSubmodelElementByPathQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public PostSubmodelElementByPathQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Updates the Submodel
   * 
   * @param body Submodel object (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   */
  @RequestLine("PUT /submodel?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putSubmodel(Submodel body, @Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Updates the Submodel
   * 
   * Note, this is equivalent to the other <code>putSubmodel</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PutSubmodelQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Submodel object (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>

   */
  @RequestLine("PUT /submodel?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
  })
  void putSubmodel(Submodel body, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>putSubmodel</code> method in a fluent style.
   */
  public static class PutSubmodelQueryParams extends HashMap<String, Object> {
    public PutSubmodelQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public PutSubmodelQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public PutSubmodelQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param body Requested submodel element (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param content Determines the request or response kind of the resource (optional, default to normal)
   * @param extent Determines to which extent the resource is being serialized (optional)
   */
  @RequestLine("PUT /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void putSubmodelElementByPath(SubmodelElement body, @Param("idShortPath") String idShortPath, @Param("level") String level, @Param("content") String content, @Param("extent") String extent);

  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * Note, this is equivalent to the other <code>putSubmodelElementByPath</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PutSubmodelElementByPathQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param body Requested submodel element (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>level - Determines the structural depth of the respective resource content (optional, default to deep)</li>
   *   <li>content - Determines the request or response kind of the resource (optional, default to normal)</li>
   *   <li>extent - Determines to which extent the resource is being serialized (optional)</li>
   *   </ul>

   */
  @RequestLine("PUT /submodel/submodel-elements/{idShortPath}?level={level}&content={content}&extent={extent}")
  @Headers({
      "Content-Type: application/json",
  })
  void putSubmodelElementByPath(SubmodelElement body, @Param("idShortPath") String idShortPath, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>putSubmodelElementByPath</code> method in a fluent style.
   */
  public static class PutSubmodelElementByPathQueryParams extends HashMap<String, Object> {
    public PutSubmodelElementByPathQueryParams level(final String value) {
      put("level", EncodingUtils.encode(value));
      return this;
    }
    public PutSubmodelElementByPathQueryParams content(final String value) {
      put("content", EncodingUtils.encode(value));
      return this;
    }
    public PutSubmodelElementByPathQueryParams extent(final String value) {
      put("extent", EncodingUtils.encode(value));
      return this;
    }
  }
}
