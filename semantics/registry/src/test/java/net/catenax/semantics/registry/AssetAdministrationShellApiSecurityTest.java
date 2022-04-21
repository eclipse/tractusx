/*
 * Copyright (c) 2021-2022 Robert Bosch Manufacturing Solutions GmbH
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *  This class contains test to verify Authentication and RBAC based Authorization for all API endpoints.
 *  Every API endpoint is tested explicitly.
 */
public class AssetAdministrationShellApiSecurityTest extends AbstractAssetAdministrationShellApi {

    @Nested
    @DisplayName("Authentication Tests")
    class SecurityTests {
        @Test
        public void testWithoutAuthenticationTokenProvidedExpectUnauthorized() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isUnauthorized());
        }

        @Test
        public void testWithAuthenticationTokenProvidedExpectUnauthorized() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isUnauthorized());
        }

        @Test
        public void testWithInvalidAuthenticationTokenConfigurationExpectUnauthorized() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.withoutResourceAccess())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.withoutRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());
        }

    }

    @Nested
    @DisplayName("Shell Authorization Test")
    class ShellCrudTest {
        String shellId;

        @BeforeEach
        public void before() throws Exception{
            ObjectNode shell = createShell();
            performShellCreateRequest(toJson(shell));
            shellId = getId(shell);
        }

        @Test
        public void testRbacForGetAll() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    // test with wrong role
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

        @Test
        public void testRbacForGetById() throws Exception {
            // get shell by id
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId )
                                    .accept(MediaType.APPLICATION_JSON)
                                    // test with wrong role
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId )
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

        @Test
        public void testRbacForCreate() throws Exception {
            ObjectNode shellPayloadForPost = createShell();
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayloadForPost))
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH, toJson(shellPayloadForPost) )
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayloadForPost))
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated());
        }

        @Test
        public void testRbacForUpdate() throws Exception {
            ObjectNode shellPayloadForUpdate = createShell()
                    .put("identification", shellId);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SHELL_BASE_PATH, shellId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayloadForUpdate))
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());


            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SHELL_BASE_PATH, shellId )
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayloadForUpdate))
                                    .with(jwtTokenFactory.updateTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

        }

        @Test
        public void testRbacForDelete() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId )
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId )
                                    // test with wrong role
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

    }

    @Nested
    @DisplayName("Submodel Descriptor Authorization Test")
    class SubmodelDescriptorCrudTests {
       private String shellId;
       private String submodelId;

       @BeforeEach
       public void before() throws Exception{
           ObjectNode shell = createShell();
           performShellCreateRequest(toJson(shell));

           ObjectNode submodel = createSubmodel("submodelIdPrefix");
           performSubmodelCreateRequest(toJson(submodel), getId(shell));

           shellId = getId(shell);
           submodelId = getId(submodel);
       }


       @Test
       public void testRbacForGetAll() throws Exception {
           mvc.perform(
                           MockMvcRequestBuilders
                                   .get(SUB_MODEL_BASE_PATH,  shellId )
                                   .accept(MediaType.APPLICATION_JSON)
                                   // test with wrong role
                                   .with(jwtTokenFactory.addTwin())
                   )
                   .andDo(MockMvcResultHandlers.print())
                   .andExpect(status().isForbidden());

           mvc.perform(
                           MockMvcRequestBuilders
                                   .get(SUB_MODEL_BASE_PATH,  shellId )
                                   .accept(MediaType.APPLICATION_JSON)
                                   .with(jwtTokenFactory.readTwin())
                   )
                   .andDo(MockMvcResultHandlers.print())
                   .andExpect(status().isOk());
       }

        @Test
        public void testRbacForGetById() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId )
                                    .accept(MediaType.APPLICATION_JSON)
                                    // test with wrong role
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId )
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

        @Test
        public void testRbacForCreate() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SUB_MODEL_BASE_PATH, shellId )
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(createSubmodel("exampleSubmodel")))
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SUB_MODEL_BASE_PATH, shellId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(createSubmodel("exampleSubmodel")))
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated());
        }

        @Test
        public void testRbacForUpdate() throws Exception {
            ObjectNode submodelToUpdate = createSubmodel("1231")
                    .put("identification", submodelId);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId )
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(submodelToUpdate))
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(submodelToUpdate))
                                    .with(jwtTokenFactory.updateTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

        @Test
        public void testRbacForDelete() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    // test with wrong role
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

    }

    @Nested
    @DisplayName("SpecificAssetIds Crud Test")
    class SpecificAssetIdsCrudTest {
        String shellId;

        @BeforeEach
        public void before() throws Exception{
            ObjectNode shell = createShell();
            performShellCreateRequest(toJson(shell));
            shellId = getId(shell);
        }

        @Test
        public void testRbacForGet() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

        @Test
        public void testRbacForCreate() throws Exception {
            ArrayNode specificAssetIds = emptyArrayNode()
                    .add(specificAssetId("key1", "value1"))
                    .add(specificAssetId("key2", "value2"));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(specificAssetIds))
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(specificAssetIds))
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated());
        }

        @Test
        public void testRbacForDelete() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }
    }

    @Nested
    @DisplayName("Lookup Authorization Test")
    class LookupTest {

        @Test
        public void testRbacForLookupByAssetIds() throws Exception {
            ArrayNode specificAssetIds = emptyArrayNode().add(specificAssetId("abc", "123"));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds",  toJson(specificAssetIds))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds",  toJson(specificAssetIds))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

    }

    @Nested
    @DisplayName("Custom AAS API Authorization Tests")
    class CustomAASApiTest {

        @Test
        public void testRbacCreateShellInBatch() throws Exception {
            ObjectNode shell = createShell();
            ArrayNode batchShellBody = emptyArrayNode().add(shell);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwtTokenFactory.addTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated());
        }

        @Test
        public void testRbacForFindShellsWithAnyMatch() throws Exception {
            JsonNode anyMatchLookupPayload = mapper.createObjectNode().set("query", mapper.createObjectNode()
                    .set("assetIds", emptyArrayNode().add(specificAssetId("abc", "123")))
            );
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(LOOKUP_SHELL_BASE_PATH + "/query")
                                    .content(toJson(anyMatchLookupPayload))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(LOOKUP_SHELL_BASE_PATH + "/query")
                                    .content(toJson(anyMatchLookupPayload))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }

        @Test
        public void testRbacForFetchShellsByIds() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/fetch")
                                    .content(toJson(emptyArrayNode()))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.deleteTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isForbidden());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/fetch")
                                    .content(toJson(emptyArrayNode()))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.readTwin())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.items", hasSize(0)));
        }

    }
}
