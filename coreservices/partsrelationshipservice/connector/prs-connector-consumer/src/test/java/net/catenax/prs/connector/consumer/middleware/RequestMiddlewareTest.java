package net.catenax.prs.connector.consumer.middleware;

import com.github.javafaker.Faker;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.engine.path.PathImpl.createPathFromString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RequestMiddlewareTest {

    @Mock
    Monitor monitor;

    @Mock
    Validator validator;

    @InjectMocks
    RequestMiddleware sut;

    Object payload = new Object();
    Faker faker = new Faker();
    Response.Status status = faker.options().option(Response.Status.class);
    RuntimeException exception = new RuntimeException(faker.lorem().sentence());
    private ConstraintViolation<Object> violation1 = mock(ConstraintViolation.class);
    private ConstraintViolation<Object> violation2 = mock(ConstraintViolation.class);

    @Test
    void invoke_OnSuccess_ReturnsResponse() {
        // Act
        var result = sut.chain().invoke(() -> Response.status(status).build());

        // Assert
        assertThat(result.getStatus()).isEqualTo(status.getStatusCode());
    }

    @Test
    void invoke_OnException_ReturnsErrorResponse() {
        // Act
        var result = sut.chain().invoke(() -> {
            throw exception;
        });

        // Assert
        assertThat(result.getStatus()).isEqualTo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        verify(monitor).warning("Server error: " + exception.getMessage(), exception);
    }

    @Test
    void validateAndInvoke_OnSuccess_ReturnsResponse() {
        // Act
        var result = sut.chain()
                .validate(payload)
                .invoke(() -> Response.status(status).build());

        // Assert
        assertThat(result.getStatus()).isEqualTo(status.getStatusCode());
    }

    @Test
    void validateAndInvoke_OnViolation_ReturnsErrorResponse() {
        // Arrange
        when(violation1.getPropertyPath()).thenReturn(createPathFromString("aaa"));
        when(violation1.getMessage()).thenReturn("bbb");
        when(violation2.getPropertyPath()).thenReturn(createPathFromString("ccc"));
        when(violation2.getMessage()).thenReturn("ddd");
        // use LinkedHashSet for deterministic ordering
        when(validator.validate(payload)).thenReturn(new LinkedHashSet<>(List.of(violation1, violation2)));

        // Act
        var result = sut.chain()
                .validate(payload)
                .invoke(() -> Response.status(status).build());

        // Assert
        assertThat(result.getStatus()).isEqualTo(Response.Status.BAD_REQUEST.getStatusCode());
        String message = "Validation failed:\n- aaa bbb\n- ccc ddd\n";
        assertThat(result.getEntity()).isEqualTo(message);
        verify(monitor).warning(message);
    }
}