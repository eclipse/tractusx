//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.controllers;

import com.catenax.partsrelationshipservice.dtos.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import net.catenax.prs.exceptions.MaxDepthTooLargeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * API Exception Handler.
 */
@Slf4j
@ControllerAdvice
public class PrsExceptionHandler {

    /**
     * Handler for max depth too large exception
     * @param ex see {@link MaxDepthTooLargeException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(MaxDepthTooLargeException.class)
    public ResponseEntity<ErrorResponse> handleMaxDepthTooLarge(final MaxDepthTooLargeException ex) {
        log.info(ex.getClass().getName(), ex);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .withStatusCode(HttpStatus.BAD_REQUEST)
                        .withMessage("Provided value for depth argument was too large")
                        .withErrors(List.of(ex.getMessage())).build());

    }

    /**
     * Handler for spring BindException
     * @param ex see {@link BindException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(final BindException ex) {
        log.info(ex.getClass().getName(), ex);

        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .forEachOrdered(errors::add);

        ex.getBindingResult().getGlobalErrors()
                .stream()
                .map(e -> e.getObjectName() + ": " + e.getDefaultMessage())
                .forEachOrdered(errors::add);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .withStatusCode(HttpStatus.BAD_REQUEST)
                        .withMessage("Invalid Arguments")
                        .withErrors(errors).build());
    }

    /**
     * Handler for javax constraint violation exception
     * @param ex see {@link ConstraintViolationException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(final ConstraintViolationException ex) {
        log.info(ex.getClass().getName(), ex);

        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(e -> e.getRootBeanClass().getName() + " " + e.getPropertyPath() + ": " + e.getMessage())
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .withStatusCode(HttpStatus.BAD_REQUEST)
                        .withMessage(ex.getMessage())
                        .withErrors(errors).build());
    }

    /**
     * Catcher for all unhandled exceptions
     * @param ex see {@link Exception}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(final Exception ex) {
        log.error(ex.getClass().getName(), ex);
        // Exception error message is not returned in response to prevent leak of a possible sensitive information.
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .withStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .withMessage("Error Occurred")
                        .withErrors(new ArrayList<>()).build());
    }


}
