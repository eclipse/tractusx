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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance( TestInstance.Lifecycle.PER_CLASS )
@DirtiesContext( classMode = DirtiesContext.ClassMode.AFTER_CLASS )
public class ModelsApiSecurityTest extends AbstractModelsApiTest {

    @Test
    public void testWithAuthenticationTokenProvidedExpectUnauthorized() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/models", UUID.randomUUID())
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testWithInvalidAuthenticationTokenConfigurationExpectUnauthorized() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/models", UUID.randomUUID())
                                .accept(MediaType.APPLICATION_JSON)
                                .with(jwtTokenFactory.withoutResourceAccess())
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());

        mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/models", UUID.randomUUID())
                                .accept(MediaType.APPLICATION_JSON)
                                .with(jwtTokenFactory.withoutRoles())
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void testReadSemanticModelExpectForbidden() throws Exception {
        String url = "/api/v1/models/urn:bamm:net.catenax.security.a:1.0.0#Test";
        verifyReadIsForbiddenForUrl(url);
        verifyReadIsForbiddenForUrl( url + "/file");
        verifyReadIsForbiddenForUrl( url + "/diagram");
        verifyReadIsForbiddenForUrl( url + "/documentation");
        verifyReadIsForbiddenForUrl( url + "/json-schema");
        verifyReadIsForbiddenForUrl( url + "/openapi");
        verifyReadIsForbiddenForUrl( url + "/example-payload");
    }

    private void verifyReadIsForbiddenForUrl(String url) throws Exception{
        mvc.perform(MockMvcRequestBuilders.get( url)
                        .accept( MediaType.APPLICATION_JSON )
                        .with(jwtTokenFactory.updateModel())
                )
                .andDo( MockMvcResultHandlers.print() )
                .andExpect( status().isForbidden() );
    }

   @Test
   public void testAddSemanticModelExpectForbidden() throws Exception {
       mvc.perform(MockMvcRequestBuilders.post( "/api/v1/models" )
                   .accept( MediaType.APPLICATION_JSON )
                   .contentType( MediaType.APPLICATION_JSON )
                   .content( TestUtils.createValidModelRequest("urn:bamm:net.catenax.security.a:1.0.0#" )   )
                   .with(jwtTokenFactory.readModel())
               )
               .andDo( MockMvcResultHandlers.print() )
               .andExpect( status().isForbidden() );
   }

    @Test
    public void testUpdateSemanticModelExpectForbidden() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put( "/api/v1/models" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( TestUtils.createValidModelRequest("urn:bamm:net.catenax.security.a:1.0.0#" )   )
                        .with(jwtTokenFactory.addModel())
                )
                .andDo( MockMvcResultHandlers.print() )
                .andExpect( status().isForbidden() );
    }

    @Test
    public void testDeleteSemanticModelExpectForbidden() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete( "/api/v1/models/urn:bamm:net.catenax.security.a:1.0.0#Test" )
                        .accept( MediaType.APPLICATION_JSON )
                        .with(jwtTokenFactory.readModel())
                )
                .andDo( MockMvcResultHandlers.print() )
                .andExpect( status().isForbidden() );
    }



}
