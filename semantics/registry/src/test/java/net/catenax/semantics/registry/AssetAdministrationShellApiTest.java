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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AssetAdministrationShellApiTest extends AbstractAssetAdministrationShellApi {

    @Nested
    @DisplayName("Shell CRUD API")
    class ShellAPITests {


        @Test
        public void testCreateShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));

            ObjectNode onlyRequiredFieldsShell = createBaseIdPayload("exampleId", "exampleShortId");
            performShellCreateRequest(toJson(onlyRequiredFieldsShell));
        }

        @Test
        public void testCreateShellWithExistingIdExpectBadRequest() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayload))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.error.message", is("An AssetAdministrationShell for the given identification does already exists.")));
        }

        @Test
        public void testGetShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(shellPayload)));
        }

        @Test
        public void testGetShellExpectNotFound() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, "NotExistingShellId")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound());
        }

        @Test
        public void testGetAllShellsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SHELL_BASE_PATH)
                                    .queryParam("pageSize", "100")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.items").exists())
                    .andExpect(jsonPath("$.items[*].identification", hasItem(getId(shellPayload))))
                    .andExpect(jsonPath("$.totalItems", is(greaterThan(0))))
                    .andExpect(jsonPath("$.currentPage", is(0)))
                    .andExpect(jsonPath("$.totalPages", is(greaterThan(0))))
                    .andExpect(jsonPath("$.itemCount", is(greaterThan(0))));
        }

        @Test
        public void testUpdateShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));

            ObjectNode updateDescription = shellPayload.deepCopy();
            updateDescription.set("description", emptyArrayNode()
                    .add(createDescription("fr", "exampleFrtext")));
            String shellId = updateDescription.get("identification").textValue();
            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(updateDescription))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(updateDescription)));
        }


        @Test
        public void testUpdateShellExpectNotFound() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SHELL_BASE_PATH, "shellIdthatdoesnotexists")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(createShell()))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier shellIdthatdoesnotexists not found")));
        }

        @Test
        public void testUpdateShellWithDifferentIdInPayloadExpectPathIdIsTaken() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            // assigning a new identification to an existing shell must not be possible in an update
            ObjectNode updatedShell = shellPayload.deepCopy()
                    .put("identification", "newIdInUpdateRequest")
                    .put("idShort", "newIdShortInUpdateRequest");

            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(updatedShell))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            // verify that anything expect the identification can be updated
            ObjectNode expectedShellAfterUpdate = updatedShell
                    .deepCopy()
                    .put("identification", shellId);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(expectedShellAfterUpdate)));
        }

        @Test
        public void testDeleteShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

        @Test
        public void testDeleteShellExpectNotFound() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

        /**
         * It must be possible to create multiple specificAssetIds for the same key.
         */
        @Test
        public void testCreateShellWithSameSpecificAssetIdKeyButDifferentValuesExpectSuccess() throws Exception{
            ObjectNode shellPayload = createBaseIdPayload("example", "example");
            shellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId("WMI", "1234123"))
                    .add(specificAssetId("WMI", "fug01"))
            );
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayload))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(toJson(shellPayload)));
        }
    }

    @Nested
    @DisplayName("Shell SpecificAssetId CRUD API")
    class SpecificAssetIdAPITests {

        @Test
        public void testCreateSpecificAssetIdsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createBaseIdPayload("exampleShellId", "exampleIdShort");
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ArrayNode specificAssetIds = emptyArrayNode()
                    .add(specificAssetId("key1", "value1"))
                    .add(specificAssetId("key2", "value2"));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(specificAssetIds))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(toJson(specificAssetIds)));
        }


        /**
         * The API method for creation of specificAssetIds accepts an array of objects.
         * Invoking the API removes all existing specificAssetIds and adds the new ones.
         */
        @Test
        public void testCreateSpecificAssetIdsReplacesAllExistingSpecificAssetIdsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ArrayNode specificAssetIds = emptyArrayNode()
                    .add(specificAssetId("key1", "value1"))
                    .add(specificAssetId("key2", "value2"));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(specificAssetIds))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(toJson(specificAssetIds)));

            // verify that the shell payload does no longer contain the initial specificAssetIds that were provided at creation time
            ObjectNode expectedShellPayload = shellPayload.deepCopy().set("specificAssetIds", specificAssetIds);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(expectedShellPayload)));
        }

        @Test
        public void testCreateSpecificIdsExpectNotFound() throws Exception {
            ArrayNode specificAssetIds = emptyArrayNode()
                    .add(specificAssetId("key1", "value1"));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SINGLE_LOOKUP_SHELL_BASE_PATH, "notexistingshell")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(specificAssetIds))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));
        }

        @Test
        public void testGetSpecificAssetIdsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(shellPayload.get("specificAssetIds"))));
        }

        @Test
        public void testGetSpecificIdsExpectNotFound() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_LOOKUP_SHELL_BASE_PATH, "notexistingshell", "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));
        }
    }


    @Nested
    @DisplayName("Submodel CRUD API")
    class SubmodelApiTest {

        @Test
        public void testCreateSubmodelExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.submodelDescriptors", hasSize(3)))
                    .andExpect(jsonPath("$.submodelDescriptors[*].identification", hasItem(getId(submodel))));
        }

        @Test
        public void testCreateSubmodelWithExistingIdExpectBadRequest() throws Exception {
            ObjectNode shellPayload1 = createShell();
            performShellCreateRequest(toJson(shellPayload1));

            ObjectNode shellPayload2 = createShell();
            performShellCreateRequest(toJson(shellPayload2));

            // assign submodel with existing id to shellPayload1 to ensure global uniqueness
            String shellId = getId(shellPayload1);
            JsonNode existingSubmodel = shellPayload2.get("submodelDescriptors").get(0);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SUB_MODEL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(existingSubmodel))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.error.message", is("A SubmodelDescriptor with the given identification does already exists.")));
        }

        @Test
        public void testUpdateSubModelExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);
            String submodelId = getId(submodel);

            ObjectNode updatedSubmodel = submodel.deepCopy()
                    .put("idShort", "updatedSubmodelId").set("description", emptyArrayNode()
                            .add(createDescription("es", "spanish description")));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(updatedSubmodel))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(updatedSubmodel)));
        }

        @Test
        public void testUpdateSubmodelExpectNotFound() throws Exception {
            // verify shell is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, "notexistingshell", "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));


            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            // verify submodel is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Submodel for identifier notexistingsubmodel not found.")));
        }

        @Test
        public void testUpdateSubmodelWithDifferentIdInPayloadExpectPathIdIsTaken() throws Exception {
            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);
            String submodelId = getId(submodel);

            // assigning a new identification to an existing submodel must not be possible in an update
            ObjectNode updatedSubmodel = submodel.deepCopy()
                    .put("identification", "newIdInUpdateRequest")
                    .put("idShort", "newIdShortInUpdateRequest");

            mvc.perform(
                            MockMvcRequestBuilders
                                    .put(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(updatedSubmodel))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            // verify that anything expect the identification can be updated
            ObjectNode expectedShellAfterUpdate = updatedSubmodel
                    .deepCopy()
                    .put("identification", submodelId);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(expectedShellAfterUpdate)));
        }

        @Test
        public void testDeleteSubmodelExpectSuccess() throws Exception {

            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);
            String submodelId = getId(submodel);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound());
        }

        @Test
        public void testDeleteSubmodelExpectNotFound() throws Exception {
            // verify shell is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, "notexistingshell", "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));


            ObjectNode shellPayload = createShell();
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            // verify submodel is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Submodel for identifier notexistingsubmodel not found.")));
        }
    }

    @Nested
    @DisplayName("Shell Lookup Query API")
    class ShellLookupQueryAPI {

        @Test
        public void testLookUpApiWithInvalidQueryParameterExpectFailure() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", "{ invalid }")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.error.message", is("The provided parameters are invalid. assetIds={ invalid }")));
        }

        @Test
        public void testLookUpApiWithSwaggerUIEscapedQueryParameterExpectSuccess() throws Exception {
            String swaggerUIEscapedAssetIds = "[\"{\\n  \\\"key\\\": \\\"brakenumber\\\",\\n  \\\"value\\\": \\\"123f092\\\"\\n}\",{\"key\":\"globalAssetId\",\"value\":\"12397f2kf97df\"}]";
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", swaggerUIEscapedAssetIds)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$" ).isArray());
        }

        @Test
        public void testLookUpApiWithMultiParamIds() throws Exception {
            String assetId1 = "{\"key\": \"brakenumber\",\"value\": \"123f092\"}";
            String assetId2 = "{\"key\":\"globalAssetId\",\"value\":\"12397f2kf97df\"}";
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", assetId1)
                                    .queryParam("assetIds", assetId2)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$" ).isArray());
        }

        @Test
        public void testFindExternalShellIdsBySpecificAssetIdsExpectSuccess() throws Exception {
            // the keyPrefix ensures that this test can run against a persistent database multiple times
            String keyPrefix = UUID.randomUUID().toString();
            ObjectNode commonAssetId = specificAssetId(keyPrefix + "commonAssetIdKey", "commonAssetIdValue");
            // first shell
            ObjectNode firstShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            firstShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2", "value_2"))
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2_1", "value_2_1"))
                    .add(commonAssetId));
            performShellCreateRequest(toJson(firstShellPayload));

            // second shell
            ObjectNode secondShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            secondShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_3", "value_3"))
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_3_1", "value_3_1"))
                    .add(commonAssetId));
            performShellCreateRequest(toJson(secondShellPayload));

            // Test first shell match with all specific assetIds
            ArrayNode allSpecificAssetIdsForFirstShell = emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2", "value_2"))
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2_1", "value_2_1"))
                    .add(commonAssetId);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(allSpecificAssetIdsForFirstShell))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$", contains(getId(firstShellPayload))));

            // Test first shell match with single assetId
            ArrayNode oneAssetIdForFirstShell = emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2", "value_2"));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(oneAssetIdForFirstShell))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$", contains(getId(firstShellPayload))));

            // Test first and second shell match with common asssetId
            ArrayNode commonAssetIdBothShells = emptyArrayNode()
                    .add(commonAssetId);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(commonAssetIdBothShells))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$", containsInAnyOrder(getId(firstShellPayload), getId(secondShellPayload))));
        }

        @Test
        public void testFindExternalShellIdByGlobalAssetIdExpectSuccess() throws Exception {
            ObjectNode shellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");

            String globalAssetId = UUID.randomUUID().toString();
            shellPayload.set("globalAssetId", createGlobalAssetId(globalAssetId));
            performShellCreateRequest(toJson(shellPayload));

            // for lookup global asset id is handled as specificAssetIds
            ArrayNode globalAssetIdForSampleQuery = emptyArrayNode().add(
                specificAssetId("globalAssetId", globalAssetId)
            );
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(globalAssetIdForSampleQuery))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$",  contains(getId(shellPayload))));
        }

        @Test
        public void testFindExternalShellIdsWithoutProvidingQueryParametersExpectEmptyResult() throws Exception {
            // prepare the data set
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(0)));
        }
    }

    @Nested
    @DisplayName("Custom AAS API Tests")
    class CustomAASApiTest {

        @Test
        public void testCreateShellInBatchWithOneDuplicateExpectSuccess() throws Exception {
            ObjectNode shell = createShell();

            JsonNode identification = shell.get("identification");
            ArrayNode batchShellBody = emptyArrayNode().add(shell).add(createShell()
                    // create duplicate
                    .set("identification", identification));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].message", equalTo("AssetAdministrationShell successfully created.")))
                    .andExpect(jsonPath("$[0].identification", equalTo(identification.textValue())))
                    .andExpect(jsonPath("$[0].status", equalTo(200)))
                    .andExpect(jsonPath("$[1].message", equalTo("An AssetAdministrationShell for the given identification does already exists.")))
                    .andExpect(jsonPath("$[1].identification", equalTo(identification.textValue())))
                    .andExpect(jsonPath("$[1].status", equalTo(400)));
        }

        @Test
        public void testCreateShellInBatchExpectSuccess() throws Exception {
            ArrayNode batchShellBody = emptyArrayNode().add(createShell())
                                .add(createShell())
                                .add(createShell())
                                .add(createShell())
                                .add(createShell());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$", hasSize(5)));
        }

        @Test
        public void testFindExternalShellIdsBySpecificAssetIdsWithAnyMatchExpectSuccess() throws Exception {
            // the keyPrefix ensures that this test can run against a persistent database multiple times
            String keyPrefix = UUID.randomUUID().toString();
            ObjectNode commonAssetId = specificAssetId(keyPrefix + "commonAssetIdKey", "commonAssetIdValue");
            // first shell
            ObjectNode firstShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            firstShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_1", "value_1")));
            performShellCreateRequest(toJson(firstShellPayload));

            // second shell
            ObjectNode secondShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            secondShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2", "value_2")));
            performShellCreateRequest(toJson(secondShellPayload));

            // query to retrieve any match
            JsonNode anyMatchAueryByAssetIds = mapper.createObjectNode().set("query", mapper.createObjectNode()
                            .set("assetIds",  emptyArrayNode()
                                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_1", "value_1"))
                                    .add(specificAssetId(keyPrefix + "findExternalShellIdQueryKey_2", "value_2"))
                                    .add(commonAssetId))
                   );

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(LOOKUP_SHELL_BASE_PATH + "/query")
                                    .content(toJson(anyMatchAueryByAssetIds))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$", containsInAnyOrder(getId(firstShellPayload), getId(secondShellPayload))));
        }

        @Test
        public void testFetchShellsByNoIdentificationsExpectEmptyResult() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/fetch")
                                    .content(toJson(emptyArrayNode()))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.items", hasSize(0)));
        }

        @Test
        public void testFetchShellsByMultipleIdentificationsExpectSuccessExpectSuccess() throws Exception {

            ObjectNode shellPayload1 = createShell();
            performShellCreateRequest(toJson(shellPayload1));

            ObjectNode shellPayload2 = createShell();
            performShellCreateRequest(toJson(shellPayload2));

            ArrayNode fetchOneShellsById =  emptyArrayNode().add(getId(shellPayload1));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/fetch")
                                    .content(toJson(fetchOneShellsById))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.items", hasSize(1)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$.items[*].identification", hasItem(getId(shellPayload1))));


            ArrayNode fetchTwoShellsById =  emptyArrayNode()
                    .add(getId(shellPayload1))
                    .add(getId(shellPayload2));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/fetch")
                                    .content(toJson(fetchTwoShellsById))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .with(jwtTokenFactory.allRoles())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.items", hasSize(2)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$.items[*].identification",
                            hasItems(getId(shellPayload1), getId(shellPayload2)) ));
        }
    }

}
