/*
 * Copyright (c) 2022 Robert Bosch Manufacturing Solutions GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.catenax.semantics.hub;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;

public class TestUtils {

   private static final String MODELS_ROOT_PATH = "net/catenax/semantics/hub/persistence/models/";
   public static final String TRACEABILITY_MODEL_PATH = MODELS_ROOT_PATH + "Traceability.ttl";
   public static final String MODEL_WITH_REFERENCE_TO_TRACEABILITY_MODEL_PATH =
         MODELS_ROOT_PATH + "ModelWithReferenceToTraceability.ttl";
   public static final String PRODUCT_USAGE_MODEL_PATH = MODELS_ROOT_PATH + "ProductUsage.ttl";
   public static final String PRODUCT_USAGE_DETAIL_MODEL_PATH = MODELS_ROOT_PATH + "ProductUsageDetail.ttl";

   public static final String VEHICLE_WITH_NOT_AVAILABLE_EXTERNAL_REFERENCE =
         MODELS_ROOT_PATH + "VehicleWithNotAvailableExternalReference.ttl";

   private static final String MODEL_FOR_API_TESTS = MODELS_ROOT_PATH + "ValidModelForApiTests.ttl";

   public static String loadModelFromResources( String resourceName ) throws IOException {
      return IOUtils.resourceToString( resourceName, StandardCharsets.UTF_8, TestUtils.class.getClassLoader() );
   }

   public static String createNewModelRequestJson( String model, String status ) {
      return String.format( "{\n"
            + "  \"model\": \"%s\",\n"
            + "  \"status\": \"%s\",\n"
            + "  \"type\": \"BAMM\"\n"
            + "}", StringEscapeUtils.escapeJava( model ), status );
   }

   public static String createValidModelRequest( String urn, String status ) {
      String model;
      try {
         model = loadModelFromResources(MODEL_FOR_API_TESTS).replace("{{URN_PREFIX}}", urn);
      } catch (IOException e) {
         throw new RuntimeException("Failed to load file");
      }
      return String.format( "{\n"
              + "  \"model\": \"%s\",\n"
              + "  \"status\": \"%s\",\n"
              + "  \"type\": \"BAMM\"\n"
              + "}", StringEscapeUtils.escapeJava( model ), status );
   }
}
