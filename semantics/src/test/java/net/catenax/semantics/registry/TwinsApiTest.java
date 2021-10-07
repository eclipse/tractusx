/*
 * Copyright (c) 2021 Robert Bosch Manufacturing Solutions GmbH
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

package net.catenax.semantics.registry;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TwinsApiTest {

   @Autowired
   private MockMvc mockMvc;

   private final BasicJsonTester json = new BasicJsonTester( getClass() );

   @Test
   public void testGetTwinsExpect200() throws Exception {
      this.mockMvc.perform( get( "/api/v1/twins" ) )
                  .andDo( print() )
                  .andExpect( status().isOk() )
                  .andExpect( jsonPath( "$.items" ).exists() )
                  .andExpect( jsonPath( "$.totalItems" ).exists() );
   }

   @Test
   public void testDeleteTwinByNotExistingIdExpect404() throws Exception {
      this.mockMvc.perform( delete( "/api/v1/twins/{twinId}", UUID.randomUUID() ) )
                  .andDo( print() )
                  .andExpect( status().isNotFound() );
   }

   @Test
   public void testCreateTwinWithInvalidLocalIdentifierExpect400() throws Exception {
      final var body = json.from( "invalid_twin_missing_localidentifier.json" ).getJson();
      this.mockMvc.perform( post( "/api/v1/twins" ).content( body )
                                            .contentType( MediaType.APPLICATION_JSON ) )
                  .andDo( print() )
                  .andExpect( status().isBadRequest() )
                  .andExpect( jsonPath( "$.error.path" ).value( "/api/v1/twins" ) )
                  .andExpect( jsonPath( "$.error.message" ).value( "Validation failed." ) )
                  .andExpect( jsonPath( "$.error.details['localIdentifiers[0].value']" ).exists() );
   }

   @Test
   public void testCreateValidTwinExpect200() throws Exception {
      final var body = json.from( "valid_twin.json" ).getJson();
      this.mockMvc.perform( post( "/api/v1/twins" ).content( body )
                                            .contentType( MediaType.APPLICATION_JSON ) )
                  .andDo( print() )
                  .andExpect( status().isOk() )
                  .andExpect( jsonPath( "$.id" ).exists() );
   }

   @Test
   public void testGetTwinByIdExpect200() throws Exception {
      final var body = json.from( "valid_twin.json" ).getJson();
      final var twinsResponse = this.mockMvc.perform( post( "/api/v1/twins" ).content( body )
                                                                      .contentType( MediaType.APPLICATION_JSON ) )
                                            .andExpect( status().isOk() )
                                            .andExpect( jsonPath( "$.id" ).exists() )
                                            .andReturn().getResponse().getContentAsString();
      final var twinId = JsonPath.read( twinsResponse, "$.id" );
      this.mockMvc.perform( get( "/api/v1/twins/{twinId}", twinId ) )
                  .andDo( print() )
                  .andExpect( status().isOk() )
                  .andExpect( jsonPath( "$.id" ).value( twinId ) );
   }

   @Test
   public void testGetTwinByLocalIdentifierExpect200() throws Exception {
      final var body = json.from( "valid_twin_with_real_values.json" ).getJson();
      final var twinsResponse = this.mockMvc.perform( post( "/api/v1/twins" ).content( body )
                                                                      .contentType( MediaType.APPLICATION_JSON ) )
                                            .andExpect( status().isOk() )
                                            .andExpect( jsonPath( "$.id" ).exists() )
                                            .andReturn().getResponse().getContentAsString();
      final var twinId = JsonPath.read( twinsResponse, "$.id" );
      final var key = "VIN";
      final var value = "WXFFJDKF10DFJA";

      this.mockMvc
            .perform( get( "/api/v1/twins/?key={key}&value={value}", key, value ) )
            .andDo( print() )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$.items", hasSize( 1 ) ) )
            .andExpect( jsonPath( "$.items[0].id" ).value( twinId ) )
            .andExpect( jsonPath( "$.items[0].manufacturer" ).value( "Manufacturer XYZ" ) )
            .andExpect( jsonPath( "$.items[0].description" ).value( "This is a test twin." ) )
            .andExpect( jsonPath( "$.items[0].localIdentifiers[0].key" ).value( key ) )
            .andExpect( jsonPath( "$.items[0].localIdentifiers[0].value" ).value( value ) )
            .andExpect( jsonPath( "$.items[0].aspects[0].httpEndpoints[0].method" ).value( "POST" ) )
            .andExpect(
                  jsonPath( "$.items[0].aspects[0].httpEndpoints[0].url" ).value( "https://testaspect.com/data" ) )
            .andExpect( jsonPath( "$.items[0].aspects[0].modelReference.urn" ).value(
                  "urn:bamm:io.openmanufacturing:1.0.0:TestAspect" ) );
   }
}
