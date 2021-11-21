package net.catenax.prs.connector.consumer.controller;

import com.github.javafaker.Faker;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;
import net.catenax.prs.connector.consumer.middleware.RequestMiddleware;
import net.catenax.prs.connector.consumer.service.ConsumerService;
import net.catenax.prs.connector.parameters.GetStatusParameters;
import net.catenax.prs.connector.requests.FileRequest;
import org.eclipse.dataspaceconnector.monitor.ConsoleMonitor;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.transfer.TransferInitiateResponse;
import org.eclipse.dataspaceconnector.spi.transfer.response.ResponseStatus;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferProcessStates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsumerApiControllerTests {

    Validator validator = mock(Validator.class);

    @Spy
    Monitor monitor = new ConsoleMonitor();

    @Mock
    ConsumerService service;

    @Spy
    RequestMiddleware middleware = new RequestMiddleware(monitor, validator);

    @InjectMocks
    ConsumerApiController controller;

    Faker faker = new Faker();

    GetStatusParameters parameters = new GetStatusParameters(UUID.randomUUID().toString());

    TransferProcessStates status = faker.options().option(TransferProcessStates.class);

    FileRequest fileRequest = FileRequest.builder()
            .connectorAddress(faker.internet().url())
            .destinationPath(faker.file().fileName())
            .build();

    TransferInitiateResponse transferResponse = TransferInitiateResponse.Builder.newInstance()
            .id(faker.lorem().characters())
            .status(faker.options().option(ResponseStatus.class)).build();

    private ConstraintViolation<GetStatusParameters> getStatusViolation = mock(ConstraintViolation.class);
   
    private ConstraintViolation<FileRequest> fileRequestViolation = mock(ConstraintViolation.class);

    @Test
    public void checkHealth_Returns() {
        assertThat(controller.checkHealth()).isEqualTo("I'm alive!");
    }

    @Test
    public void initiateTransfer_WhenFailure_ReturnsError() {
        // Act
        var response = controller.initiateTransfer(fileRequest);
        // Assert
        assertThat(response.getStatus()).isEqualTo(500);
        assertThat(response.getEntity()).isNull();
    }

    @Test
    public void initiateTransfer_WhenSuccess_ReturnsTransferId() {
        // Arrange
        when(service.initiateTransfer(fileRequest)).thenReturn(Optional.of(transferResponse));
        // Act
        var response = controller.initiateTransfer(fileRequest);
        // Assert
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getEntity()).isEqualTo(transferResponse.getId());
    }

    @Test
    public void initiate_OnValidationFailure_ReturnsError() {
        // Arrange
        when(validator.validate(fileRequest)).thenReturn(Set.of(fileRequestViolation));
        // Act
        var response = controller.initiateTransfer(fileRequest);
        // Assert
        assertThat(response.getStatus()).isEqualTo(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void getStatus_WhenNotFound_ReturnsNotFound() {
        // Act
        var response = controller.getStatus(parameters);
        // Assert
        assertThat(response.getStatus()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void getStatus_WhenSuccess_ReturnsStatus() {
        // Arrange
        when(service.getStatus(parameters.getRequestId())).thenReturn(Optional.of(status));
        // Act
        var response = controller.getStatus(parameters);
        // Assert
        assertThat(response.getEntity()).isEqualTo(status.name());
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void getStatus_OnValidationFailure_ReturnsError() {
        // Arrange
        when(validator.validate(parameters)).thenReturn(Set.of(getStatusViolation));
        // Act
        var response = controller.getStatus(parameters);
        // Assert
        assertThat(response.getStatus()).isEqualTo(Response.Status.BAD_REQUEST.getStatusCode());
    }
}
