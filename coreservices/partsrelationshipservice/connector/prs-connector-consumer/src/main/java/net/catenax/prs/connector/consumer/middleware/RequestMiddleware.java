//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.consumer.middleware;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static java.lang.String.format;

/**
 * Middleware for logging service exceptions.
 * <p>
 * Since the EDC framework does not currently allow extending the Jersey web server
 * with middleware, this middleware is used below the controller layer.
 */
@RequiredArgsConstructor
@SuppressWarnings("PMD.GuardLogStatement") // Monitor doesn't offer guard statements
public class RequestMiddleware {

    /**
     * Logger.
     */
    private final Monitor monitor;

    /**
     * Validator for request payloads.
     */
    private final Validator validator;

    /**
     * Start a chain of operations for validating and performing requests.
     *
     * @return the instance for call chaining.
     */
    public OngoingChain chain() {
        return new OngoingChain();
    }

    /**
     * Chain of operations to be performed by the middleware.
     */
    public class OngoingChain {
        /**
         * Accumulated validation violations.
         */
        private final Set<ConstraintViolation<?>> violations = new LinkedHashSet<>();

        /**
         * Validate the given request payload. The invocation passed to {@literal invoke}
         * will not be performed if validation fails.
         *
         * @param payload entity to validate.
         * @param <T>     entity type to validate.
         * @return the instance for call chaining.
         */
        public <T> OngoingChain validate(final T payload) {
            violations.addAll(validator.validate(payload));
            return this;
        }

        /**
         * Invoke a service operation, processing any uncaught {@link RuntimeException}s.
         * <p>
         * In case of {@link RuntimeException}s, an {@link Status#INTERNAL_SERVER_ERROR} response
         * is returned.
         * <p>
         * The operation will not be invoked if {@link #validate(Object)} has
         * been called previously on this chain, and validation failures are
         * encountered. In that case, a {@link Status#BAD_REQUEST} response
         * is returned instead.
         *
         * @param supplier service operation
         * @return response from {@literal supplier}, or error response
         */
        public Response invoke(final Supplier<Response> supplier) {
            if (!violations.isEmpty()) {
                final var message = "Validation failed:\n"
                        + violations.stream()
                        .map(v -> format("- %s %s\n", v.getPropertyPath(), v.getMessage()))
                        .collect(Collectors.joining());
                monitor.warning(message);
                return Response.status(BAD_REQUEST)
                        .entity(message)
                        .build();
            }

            return doInvoke(supplier);
        }

        @SuppressWarnings("PMD.AvoidCatchingGenericException")
        private Response doInvoke(final Supplier<Response> supplier) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                monitor.warning("Server error: " + e.getMessage(), e);
                return Response.status(INTERNAL_SERVER_ERROR)
                        .build();
            }
        }
    }
}
