package net.catenax.prs.connector.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import net.catenax.prs.client.ApiException;
import net.catenax.prs.client.api.PartsRelationshipServiceApi;
import net.catenax.prs.client.model.PartInfo;
import net.catenax.prs.client.model.PartRelationshipsWithInfos;
import net.catenax.prs.connector.requests.PartsTreeByObjectIdRequest;
import org.eclipse.dataspaceconnector.monitor.ConsoleMonitor;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.transfer.flow.DataFlowInitiateResponse;
import org.eclipse.dataspaceconnector.spi.transfer.response.ResponseStatus;
import org.eclipse.dataspaceconnector.spi.types.domain.metadata.DataEntry;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataAddress;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PartsRelationshipServiceApiToFileFlowControllerTest {

    @Spy
    Monitor monitor = new ConsoleMonitor();

    @Mock
    PartsRelationshipServiceApi client;

    @InjectMocks
    PartsRelationshipServiceApiToFileFlowController sut;

    Faker faker = new Faker();

    static final ObjectMapper MAPPER = new ObjectMapper();

    private File file;

    @BeforeEach
    public void setUp() throws Exception {
        Path tempFile = Files.createTempFile(null, null);
        file = tempFile.toFile();
    }

    @ParameterizedTest
    @CsvSource({
            "AzureStorage,true",
            "azurestorage,true",
            "AzureStorag,false",
            "dummy,false"
    })
    void canHandle(String type, boolean expected) {
        var dataRequest = DataRequest.Builder.newInstance()
                .dataDestination(DataAddress.Builder.newInstance()
                        .type(type)
                        .build())
                .build();
        assertThat(sut.canHandle(dataRequest)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "destination file exists: {0}")
    @ValueSource(booleans = {false, true})
    void initiateFlow(boolean destinationFileExists) throws Exception {
        if (!destinationFileExists) {
            assertThat(file.delete()).isTrue();
        }

        PartsTreeByObjectIdRequest request = generateApiRequest();

        PartRelationshipsWithInfos response = generateApiResponse();

        whenApiCalledWith(request)
                .thenReturn(response);

        String value = MAPPER.writeValueAsString(request);
        DataRequest dataRequest = generateDataRequest(file, value);

        assertThat(sut.initiateFlow(dataRequest))
                .usingRecursiveComparison()
                .isEqualTo(DataFlowInitiateResponse.OK);

        assertThat(MAPPER.readValue(file, PartRelationshipsWithInfos.class))
                .usingRecursiveComparison()
                .isEqualTo(response);
    }

    @Test
    void initiateFlow_WhenInvalidRequestPayload_Fail() throws Exception {
        var dataRequest = generateDataRequest(file, "{" + MAPPER.writeValueAsString(generateApiRequest()));

        assertThat(sut.initiateFlow(dataRequest))
                .hasFieldOrPropertyWithValue("status", ResponseStatus.FATAL_ERROR)
                .satisfies(c -> assertThat(c.getError()).startsWith("Error deserializing"));
    }

    @Test
    void initiateFlow_WhenApiCallFails_Fail() throws Exception {
        PartsTreeByObjectIdRequest request = generateApiRequest();

        var apiMessage = faker.lorem().sentence();
        whenApiCalledWith(request)
                .thenThrow(new ApiException(apiMessage));

        String value = MAPPER.writeValueAsString(request);
        DataRequest dataRequest = generateDataRequest(file, value);

        assertThat(sut.initiateFlow(dataRequest))
                .hasFieldOrPropertyWithValue("status", ResponseStatus.FATAL_ERROR)
                .hasFieldOrPropertyWithValue("error", "Error with API call: " + apiMessage);
    }

    @Test
    void initiateFlow_WhenApiCallReturnsInvalidPayload_Fail() throws Exception {
        PartsTreeByObjectIdRequest request = generateApiRequest();

        whenApiCalledWith(request)
                .thenReturn(mock(PartRelationshipsWithInfos.class));

        String value = MAPPER.writeValueAsString(request);
        DataRequest dataRequest = generateDataRequest(file, value);

        assertThat(sut.initiateFlow(dataRequest))
                .hasFieldOrPropertyWithValue("status", ResponseStatus.FATAL_ERROR)
                .satisfies(c -> assertThat(c.getError()).startsWith("Error serializing API response:"));
    }

    @Test
    void initiateFlow_WhenFileCantBeWritten_Fail() throws Exception {
        // create a directory with same name as destination file, to block file creation
        assertThat(file.delete()).isTrue();
        assertThat(file.mkdir()).isTrue();

        PartsTreeByObjectIdRequest request = generateApiRequest();

        var response = new PartRelationshipsWithInfos();

        whenApiCalledWith(request)
                .thenReturn(response);

        String value = MAPPER.writeValueAsString(request);
        DataRequest dataRequest = generateDataRequest(file, value);

        assertThat(sut.initiateFlow(dataRequest))
                .hasFieldOrPropertyWithValue("status", ResponseStatus.FATAL_ERROR)
                .satisfies(c -> assertThat(c.getError()).startsWith("Error writing file "));
    }

    private DataRequest generateDataRequest(File destinationFile, String requestParameters) {
        return DataRequest.Builder.newInstance()
                .id(UUID.randomUUID().toString()) // This is not relevant, thus can be random.
                .protocol("ids-rest") // Must be ids-rest.
                .connectorId("consumer")
                .dataEntry(DataEntry.Builder.newInstance()
                        .id("prs-request")
                        .policyId("use-eu")
                        .build())
                .dataDestination(DataAddress.Builder.newInstance()
                        .type("AzureStorage") // The provider uses this to select the correct DataFlowController.
                        .build())
                .properties(Map.of(
                        "prs-request-parameters", requestParameters,
                        "prs-destination-path", destinationFile.getAbsolutePath()
                ))
                .managedResources(true) // We do not need any provisioning.
                .build();
    }

    private PartsTreeByObjectIdRequest generateApiRequest() {
        return PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer(faker.lorem().characters())
                .objectIDManufacturer(faker.lorem().characters())
                .view(faker.lorem().word())
                .build();
    }

    private PartRelationshipsWithInfos generateApiResponse() {
        PartInfo partInfo = new PartInfo();
        partInfo.setPartTypeName(faker.lorem().word());
        var response = new PartRelationshipsWithInfos();
        response.setPartInfos(List.of(partInfo));
        return response;
    }

    private OngoingStubbing<PartRelationshipsWithInfos> whenApiCalledWith(PartsTreeByObjectIdRequest request) throws ApiException {
        return when(client.getPartsTreeByOneIdAndObjectId(request.getOneIDManufacturer(), request.getObjectIDManufacturer(),
                request.getView(), request.getAspect(), request.getDepth()));
    }

}