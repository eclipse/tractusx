package net.catenax.semantics.registry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AssetAdministrationShellApiTest {


    private static final String SHELL_BASE_PATH = "/registry/shell-descriptors";
    private static final String SINGLE_SHELL_BASE_PATH = "/registry/shell-descriptors/{shellIdentifier}";
    private static final String LOOKUP_SHELL_BASE_PATH = "/lookup/shells";
    private static final String SINGLE_LOOKUP_SHELL_BASE_PATH = "/lookup/shells/{shellIdentifier}";
    private static final String SUB_MODEL_BASE_PATH = "/registry/shell-descriptors/{shellIdentifier}/submodel-descriptors";
    private static final String SINGLE_SUB_MODEL_BASE_PATH = "/registry/shell-descriptors/{shellIdentifier}/submodel-descriptors/{submodelIdentifier}";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Nested
    @DisplayName("Security tests")
    class SecurityTests {
        @Test
        public void testWithoutAuthenticationTokenProvidedExpectForbidden() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isUnauthorized());
        }

        @Test
        public void testWithAuthenticationTokenProvidedExpectSuccess() throws Exception {
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, UUID.randomUUID())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    @DisplayName("Shell CRUD API")
    class ShellAPITests {


        @Test
        public void testCreateShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));

            ObjectNode onlyRequiredFieldsShell = createBaseIdPayload("exampleId", "exampleShortId");
            performShellCreateRequest(toJson(onlyRequiredFieldsShell));
        }

        @Test
        public void testCreateShellWithExistingIdExpectBadRequest() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(shellPayload))
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.error.message", is("An AssetAdministrationShell for the given identification does already exists.")));
        }

        @Test
        public void testGetShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound());
        }

        @Test
        public void testGetAllShellsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SHELL_BASE_PATH)
                                    .queryParam("pageSize", "100")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
            ObjectNode shellPayload = createShell(false);
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .content(toJson(createShell(false)))
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier shellIdthatdoesnotexists not found")));
        }

        @Test
        public void testUpdateShellWithDifferentIdInPayloadExpectPathIdIsTaken() throws Exception {
            ObjectNode shellPayload = createShell(false);
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
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(expectedShellAfterUpdate)));
        }

        @Test
        public void testDeleteShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
        }

        @Test
        public void testDeleteShellExpectNotFound() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(toJson(shellPayload)));
        }
    }

    @Nested
    @DisplayName("Local-Global Behaviour")
    class LocalGlobalTests {

        @Test
        public void testCreateShellExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(true);
            performShellCreateRequest(toJson(shellPayload));
            ArrayNode multipleAssetIdParam = emptyArrayNode()
                    .add(specificAssetId("exampleShellIdPrefix#", "exampleGlobalAssetId"));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(multipleAssetIdParam))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)));
            String shellId = getId(shellPayload);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());
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
                                    .with(jwt())
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
            ObjectNode shellPayload = createShell(false);
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
                                    .with(jwt())
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
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));
        }

        @Test
        public void testGetSpecificAssetIdsExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_LOOKUP_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
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
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SHELL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.submodelDescriptors", hasSize(3)))
                    .andExpect(jsonPath("$.submodelDescriptors[*].identification", hasItem(getId(submodel))));
        }

        @Test
        public void testCreateSubmodelWithExistingIdExpectBadRequest() throws Exception {
            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            JsonNode existingSubmodel = shellPayload.get("submodelDescriptors").get(0);
            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SUB_MODEL_BASE_PATH, shellId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(existingSubmodel))
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.error.message", is("A SubmodelDescriptor with the given identification does already exists for this AssetAdministrationShell.")));
        }

        @Test
        public void testUpdateSubModelExpectSuccess() throws Exception {
            ObjectNode shellPayload = createShell(false);
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));


            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            // verify submodel is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Submodel for identifier notexistingsubmodel not found.")));
        }

        @Test
        public void testUpdateSubmodelWithDifferentIdInPayloadExpectPathIdIsTaken() throws Exception {
            ObjectNode shellPayload = createShell(false);
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
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(toJson(expectedShellAfterUpdate)));
        }

        @Test
        public void testDeleteSubmodelExpectSuccess() throws Exception {

            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);

            ObjectNode submodel = createSubmodel(uuid("submodelExample"));
            performSubmodelCreateRequest(toJson(submodel), shellId);
            String submodelId = getId(submodel);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNoContent());

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(SINGLE_SUB_MODEL_BASE_PATH, shellId, submodelId)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error.message", is("Shell for identifier notexistingshell not found")));


            ObjectNode shellPayload = createShell(false);
            performShellCreateRequest(toJson(shellPayload));
            String shellId = getId(shellPayload);
            // verify submodel is missing
            mvc.perform(
                            MockMvcRequestBuilders
                                    .delete(SINGLE_SUB_MODEL_BASE_PATH, shellId, "notexistingsubmodel")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
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
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$" ).isArray());
        }

        @Test
        public void testFindExternalShellIdsBySpecificAssetIdsExpectSuccess() throws Exception {

            ObjectNode commonAssetId = specificAssetId("commonAssetIdKey", "commonAssetIdValue");
            // first shell
            ObjectNode firstShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            firstShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId("findExternalShellIdQueryKey_2", "value_2"))
                    .add(specificAssetId("findExternalShellIdQueryKey_2_1", "value_2_1"))
                    .add(commonAssetId));
            performShellCreateRequest(toJson(firstShellPayload));

            // second shell
            ObjectNode secondShellPayload = createBaseIdPayload("sampleForQuery", "idShortSampleForQuery");
            secondShellPayload.set("specificAssetIds", emptyArrayNode()
                    .add(specificAssetId("findExternalShellIdQueryKey_3", "value_3"))
                    .add(specificAssetId("findExternalShellIdQueryKey_3_1", "value_3_1"))
                    .add(commonAssetId));
            performShellCreateRequest(toJson(secondShellPayload));

            // Test first shell match with all specific assetIds
            ArrayNode allSpecificAssetIdsForFirstShell = emptyArrayNode()
                    .add(specificAssetId("findExternalShellIdQueryKey_2", "value_2"))
                    .add(specificAssetId("findExternalShellIdQueryKey_2_1", "value_2_1"))
                    .add(commonAssetId);

            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(allSpecificAssetIdsForFirstShell))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    // ensure that only three results match
                    .andExpect(jsonPath("$", contains(getId(firstShellPayload))));

            // Test first shell match with single assetId
            ArrayNode oneAssetIdForFirstShell = emptyArrayNode()
                    .add(specificAssetId("findExternalShellIdQueryKey_2", "value_2"));
            mvc.perform(
                            MockMvcRequestBuilders
                                    .get(LOOKUP_SHELL_BASE_PATH)
                                    .queryParam("assetIds", toJson(oneAssetIdForFirstShell))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .with(jwt())
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
                                    .with(jwt())
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

            String globalAssetId = "globalAssetIdForSampleQuery";
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
                                    .with(jwt())
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
                                    .with(jwt())
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
            ObjectNode shell = createShell(false);

            JsonNode identification = shell.get("identification");
            ArrayNode batchShellBody = emptyArrayNode().add(shell).add(createShell(false)
                    // create duplicate
                    .set("identification", identification));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwt())
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
            ArrayNode batchShellBody = emptyArrayNode().add(createShell(false))
                                .add(createShell(false))
                                .add(createShell(false))
                                .add(createShell(false))
                                .add(createShell(false));

            mvc.perform(
                            MockMvcRequestBuilders
                                    .post(SHELL_BASE_PATH + "/batch")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(toJson(batchShellBody))
                                    .with(jwt())
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$", hasSize(5)));
        }

    }


    private String getId(ObjectNode payload) {
        return payload.get("identification").textValue();
    }

    private void performSubmodelCreateRequest(String payload, String shellIdentifier) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .post(SUB_MODEL_BASE_PATH, shellIdentifier)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payload)
                                .with(jwt())
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(content().json(payload));
    }

    /**
     * calls create and checks result for identity
     * @param payload
     * @throws Exception
     */
    private void performShellCreateRequest(String payload) throws Exception {
        performShellCreateRequest(payload,payload);
    }

    /**
     * performs create and checks result for expections
     * @param payload
     * @param expectation
     * @throws Exception
     */
    private void performShellCreateRequest(String payload, String expectation) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .post(SHELL_BASE_PATH)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payload)
                                .with(jwt())
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(content().json(expectation));
    }


    private ObjectNode createShell( boolean global ) throws JsonProcessingException {
        ObjectNode shellPayload = createBaseIdPayload("exampleShellIdPrefix", "exampleShellShortId");
        shellPayload.set("description", emptyArrayNode()
                .add(createDescription("en", "this is an example description"))
                .add(createDescription("de", "das ist ein beispiel")));

        String globalId="exampleGlobalAssetId";
        if(global) {
            globalId="exampleShellIdPrefix#"+globalId;
        }
        shellPayload.set("globalAssetId", mapper.createObjectNode()
                .set("value", emptyArrayNode().add(globalId) ));

        shellPayload.set("specificAssetIds", emptyArrayNode()
                .add(specificAssetId("vin1", "valueforvin1"))
                .add(specificAssetId("enginenumber1", "enginenumber1")));

        shellPayload.set("submodelDescriptors", emptyArrayNode()
                .add(createSubmodel("submodel_external1"))
                .add(createSubmodel("submodel_external2")));
        return shellPayload;
    }

    private ObjectNode createSubmodel(String submodelIdPrefix) throws JsonProcessingException {
        ObjectNode submodelPayload = createBaseIdPayload(submodelIdPrefix, "exampleSubModelShortId");
        submodelPayload.set("description", emptyArrayNode()
                .add(createDescription("en", "this is an example submodel description"))
                .add(createDescription("de", "das ist ein Beispiel submodel")));
        submodelPayload.set("endpoints", emptyArrayNode()
                .add(createEndpoint()));
        submodelPayload.set("semanticId", createSemanticId());
        return submodelPayload;
    }

    private static String uuid(String prefix) {
        return prefix + "#" + UUID.randomUUID();
    }


    private ArrayNode emptyArrayNode() {
        return mapper.createArrayNode();
    }

    private ObjectNode createBaseIdPayload(String idPrefix, String idShort) throws JsonProcessingException {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("identification", uuid(idPrefix));
        objectNode.put("idShort", idShort);
        return objectNode;
    }

    private ObjectNode createDescription(String language, String text) {
        ObjectNode description = mapper.createObjectNode();
        description.put("language", language);
        description.put("text", text);
        return description;
    }

    private ObjectNode createGlobalAssetId(String value) {
        ObjectNode semanticId = mapper.createObjectNode();
        semanticId.set("value", emptyArrayNode().add(value) );
        return semanticId;
    }

    private ObjectNode specificAssetId(String key, String value) {
        ObjectNode specificAssetId = mapper.createObjectNode();
        specificAssetId.put("key", key);
        specificAssetId.put("value", value);
        return specificAssetId;
    }

    private ObjectNode createSemanticId() {
        ObjectNode semanticId = mapper.createObjectNode();
        semanticId.set("value", emptyArrayNode().add("urn:net.catenax.vehicle:1.0.0#Parts"));
        return semanticId;
    }




    private ObjectNode createEndpoint() {
        ObjectNode endpoint = mapper.createObjectNode();
        endpoint.put("interface", "interfaceName");
        endpoint.set("protocolInformation", mapper.createObjectNode()
                .put("endpointAddress", "https://catena-xsubmodel-vechile.net/path")
                .put("endpointProtocol", "https")
                .put("subprotocol", "Mca1uf1")
                .put("subprotocolBody", "Mafz1")
                .put("subprotocolBodyEncoding", "Fj1092ufj")
        );
        return endpoint;
    }

    private String toJson(JsonNode jsonNode) throws JsonProcessingException {
        return mapper.writeValueAsString(jsonNode);
    }

    private String toJson(ObjectNode objectNode) throws JsonProcessingException {
        return mapper.writeValueAsString(objectNode);
    }

    private String toJson(ArrayNode objectNode) throws JsonProcessingException {
        return mapper.writeValueAsString(objectNode);
    }


}
