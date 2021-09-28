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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * API Exception Handler.
 */
@Slf4j
@ControllerAdvice
public class PrsExceptionHandler {

    /**
     * Handle Max Depth Too Large Error Scenario
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
     * Catcher for all unhandled exceptions
     * @param ex see {@link Exception}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorResponse> handleAll(final Exception ex) {
        log.error(ex.getClass().getName(), ex);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .withStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .withMessage("Error Occurred")
                        .withErrors(List.of(ex.getMessage())).build());
    }


}
