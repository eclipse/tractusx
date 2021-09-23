//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package com.catenax.partsrelationshipservice.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

/*** API error response. */
@Schema(description = "Error response")
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
@SuppressWarnings("PMD.CommentRequired")
@SuppressFBWarnings(value = "UUF_UNUSED_FIELD", justification = "DTO, values are used by API clients.")
public class ErrorResponse {
    @Schema(description = "Error code")
    private HttpStatus statusCode;

    @Schema(description = "Error message")
    private String message;
}
