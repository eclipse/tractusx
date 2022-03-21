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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the models filter api with different filter combinations.
 * The Fuseki Server is cleared with @DirtiesContext and ensures test runs on a fresh Fuseki Server.
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
@DirtiesContext( classMode = DirtiesContext.ClassMode.AFTER_CLASS )
public class ModelsApiPaginationTest {

   @Autowired
   private MockMvc mvc;

   @Test
   public void testGetModelsWithPaginationExpectSuccess() throws Exception {
      List<String> prefixes = List.of(
              "urn:bamm:net.catenax.pagination.a:1.0.0#",
              "urn:bamm:net.catenax.pagination.b:1.0.0#",
              "urn:bamm:net.catenax.pagination.c:1.0.0#",
              "urn:bamm:net.catenax.pagination.d:1.0.0#"
      );

      prefixes.forEach(urnPrefix -> {
         try {
            mvc.perform(post( TestUtils.createValidModelRequest(urnPrefix, "DRAFT")  ))
                    .andDo( MockMvcResultHandlers.print() )
                    .andExpect( status().isOk() );
         } catch (Exception e) {
           throw new RuntimeException(e);
         }
      });


      mvc.perform(
                      MockMvcRequestBuilders.get( "/api/v1/models" )
                              .accept( MediaType.APPLICATION_JSON )
                              .with(jwt())
              )
        .andDo( MockMvcResultHandlers.print() )
        .andExpect( jsonPath( "$.items" ).isArray() )
        .andExpect( jsonPath( "$.items[*]", hasSize(4) ) )
        .andExpect( jsonPath( "$.totalItems", equalTo(4) ) )
        .andExpect( jsonPath( "$.totalPages", equalTo(1) ) )
        .andExpect( jsonPath( "$.itemCount", equalTo( 4) ) )
        .andExpect( status().isOk() );

      mvc.perform(
                      MockMvcRequestBuilders.get( "/api/v1/models?pageSize=2&page=0" )
                              .accept( MediaType.APPLICATION_JSON )
                              .with(jwt())
              )
              .andDo( MockMvcResultHandlers.print() )
              .andExpect( jsonPath( "$.items" ).isArray() )
              .andExpect( jsonPath( "$.items[*]", hasSize(2) ) )
              .andExpect( jsonPath( "$.items[*].urn", hasItems( toMovementUrn(prefixes.get(0)), toMovementUrn(prefixes.get(1)) ) ) )
              .andExpect( jsonPath( "$.items[*].version", hasItem( "1.0.0" ) ) )
              .andExpect( jsonPath( "$.items[*].name", hasItem( "Movement" ) ) )
              .andExpect( jsonPath( "$.items[*].type", hasItem( "BAMM" ) ) )
              .andExpect( jsonPath( "$.items[*].status", hasItem( "DRAFT" ) ) )
              .andExpect( jsonPath( "$.totalItems", equalTo(4) ) )
              .andExpect( jsonPath( "$.totalPages", equalTo(2) ) )
              .andExpect( jsonPath( "$.itemCount", equalTo( 2 ) ) )
              .andExpect( status().isOk() );

      mvc.perform(
                      MockMvcRequestBuilders.get( "/api/v1/models?pageSize=2&page=1" )
                              .accept( MediaType.APPLICATION_JSON )
                              .with(jwt())
              )
              .andDo( MockMvcResultHandlers.print() )
              .andExpect( jsonPath( "$.items" ).isArray() )
              .andExpect( jsonPath( "$.items[*]", hasSize(2) ) )
              .andExpect( jsonPath( "$.items[*].urn", hasItems( toMovementUrn(prefixes.get(2)), toMovementUrn(prefixes.get(3) ) ) ))
              .andExpect( jsonPath( "$.items[*].version", hasItem( "1.0.0" ) ) )
              .andExpect( jsonPath( "$.items[*].name", hasItem( "Movement" ) ) )
              .andExpect( jsonPath( "$.items[*].type", hasItem( "BAMM" ) ) )
              .andExpect( jsonPath( "$.items[*].status", hasItem( "DRAFT" ) ) )
              .andExpect( jsonPath( "$.totalItems", equalTo(4) ) )
              .andExpect( jsonPath( "$.totalPages", equalTo(2) ) )
              .andExpect( jsonPath( "$.itemCount", equalTo( 2 ) ) )
              .andExpect( status().isOk() );

      mvc.perform(
                      MockMvcRequestBuilders.get( "/api/v1/models?pageSize=1&page=3" )
                              .accept( MediaType.APPLICATION_JSON )
                              .with(jwt())
              )
              .andDo( MockMvcResultHandlers.print() )
              .andExpect( jsonPath( "$.items" ).isArray() )
              .andExpect( jsonPath( "$.items[*]", hasSize(1) ) )
              .andExpect( jsonPath( "$.items[*].urn", hasItems( toMovementUrn(prefixes.get(2) ) ) ))
              .andExpect( jsonPath( "$.items[*].version", hasItem( "1.0.0" ) ) )
              .andExpect( jsonPath( "$.items[*].name", hasItem( "Movement" ) ) )
              .andExpect( jsonPath( "$.items[*].type", hasItem( "BAMM" ) ) )
              .andExpect( jsonPath( "$.items[*].status", hasItem( "DRAFT" ) ) )
              .andExpect( jsonPath( "$.totalItems", equalTo(4) ) )
              .andExpect( jsonPath( "$.totalPages", equalTo(4) ) )
              .andExpect( jsonPath( "$.itemCount", equalTo( 1 ) ) )
              .andExpect( status().isOk() );

      mvc.perform(
                      MockMvcRequestBuilders.get( "/api/v1/models?pageSize=3" )
                              .accept( MediaType.APPLICATION_JSON )
                              .with(jwt())
              )
              .andDo( MockMvcResultHandlers.print() )
              .andExpect( jsonPath( "$.items" ).isArray() )
              .andExpect( jsonPath( "$.items[*]", hasSize(3) ) )
              .andExpect( jsonPath( "$.items[*].urn", hasItems( toMovementUrn(prefixes.get(0)),
                      toMovementUrn(prefixes.get(1)),
                      toMovementUrn(prefixes.get(2)) ) ) )
              .andExpect( jsonPath( "$.items[*].version", hasItem( "1.0.0" ) ) )
              .andExpect( jsonPath( "$.items[*].name", hasItem( "Movement" ) ) )
              .andExpect( jsonPath( "$.items[*].type", hasItem( "BAMM" ) ) )
              .andExpect( jsonPath( "$.items[*].status", hasItem( "DRAFT" ) ) )
              .andExpect( jsonPath( "$.totalItems", equalTo(4) ) )
              .andExpect( jsonPath( "$.totalPages", equalTo(2) ) )
              .andExpect( jsonPath( "$.itemCount", equalTo( 3 ) ) )
              .andExpect( status().isOk() );
   }

   private MockHttpServletRequestBuilder post(String payload ) {
      return MockMvcRequestBuilders.post( "/api/v1/models" )
              .accept( MediaType.APPLICATION_JSON )
              .contentType( MediaType.APPLICATION_JSON )
              .content( payload )
              .with(jwt());
   }

   private static String toMovementUrn(String urn){
      return urn + "Movement";
   }

}
