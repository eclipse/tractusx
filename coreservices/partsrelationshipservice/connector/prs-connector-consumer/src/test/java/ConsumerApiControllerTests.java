import com.github.javafaker.Faker;
import jakarta.ws.rs.core.Response;
import org.eclipse.dataspaceconnector.extensions.api.ConsumerApiController;
import org.eclipse.dataspaceconnector.extensions.api.FileRequest;
import org.eclipse.dataspaceconnector.monitor.ConsoleMonitor;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.transfer.TransferInitiateResponse;
import org.eclipse.dataspaceconnector.spi.transfer.TransferProcessManager;
import org.eclipse.dataspaceconnector.spi.transfer.response.ResponseStatus;
import org.eclipse.dataspaceconnector.spi.transfer.store.TransferProcessStore;
import org.eclipse.dataspaceconnector.spi.types.domain.metadata.DataEntry;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataAddress;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataRequest;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferProcess;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferProcessStates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsumerApiControllerTests {

    @Spy
    Monitor monitor = new ConsoleMonitor();

    @Mock
    TransferProcessStore processStore;

    @Mock
    TransferProcessManager transferProcessManager;

    @InjectMocks
    ConsumerApiController controller;

    String processId = UUID.randomUUID().toString();

    Faker faker = new Faker();

    @Captor
    ArgumentCaptor<DataRequest> dataRequestCaptor;

    @Test
    public void checkHealth_Returns() {
        assertThat(controller.checkHealth()).isEqualTo("I'm alive!");
    }

    @Test
    public void getStatus_WhenProcessNotInStore_ReturnsNotFound() {
        //Act
        var response = controller.getStatus(processId);
        //Assert
        assertThat(response.getStatus()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void getStatus_WhenProcessInStore_ReturnsStatus() {
        //Arrange
        TransferProcess transferProcess = mock(TransferProcess.class);
        when(transferProcess.getState()).thenReturn(TransferProcessStates.PROVISIONING.code());
        when(processStore.find(anyString())).thenReturn(transferProcess);
        //Act
        var response = controller.getStatus(processId);
        //Assert
        assertThat(response.getEntity()).isEqualTo(TransferProcessStates.PROVISIONING.toString());
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void initiateTransfer_WhenFileRequestValid_ReturnsProcessId() {
        //Arrange
        FileRequest fileRequest = new FileRequest();
        fileRequest.setFilename(faker.file().fileName());
        fileRequest.setConnectorAddress(faker.internet().url());
        fileRequest.setDestinationPath(faker.file().fileName());

        var dataRequest = DataRequest.Builder.newInstance()
                .id(UUID.randomUUID().toString())
                .connectorAddress(fileRequest.getConnectorAddress())
                .protocol("ids-rest")
                .connectorId("consumer")
                .dataEntry(DataEntry.Builder.newInstance()
                        .id(fileRequest.getFilename())
                        .policyId("use-eu")
                        .build())
                .dataDestination(DataAddress.Builder.newInstance()
                        .type("File")
                        .property("path", fileRequest.getDestinationPath())
                        .build())
                .managedResources(false)
                .build();

        when(transferProcessManager.initiateConsumerRequest(any(DataRequest.class)))
                .thenReturn(TransferInitiateResponse.Builder.newInstance().id(UUID.randomUUID().toString()).status(ResponseStatus.OK).build());

        //Act
        var response = controller.initiateTransfer(fileRequest);
        //Assert
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        // Verify that initiateConsumerRequest got called with correct DataRequest input.
        verify(transferProcessManager).initiateConsumerRequest(dataRequestCaptor.capture());
        assertThat(dataRequestCaptor.getValue()).usingRecursiveComparison().ignoringFields("id").isEqualTo(dataRequest);
        assertThat(dataRequestCaptor.getValue().getId()).isNotBlank();
    }
}
