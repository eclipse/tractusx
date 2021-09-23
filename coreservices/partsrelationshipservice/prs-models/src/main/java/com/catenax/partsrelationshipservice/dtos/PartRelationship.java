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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

/*** API type for a relationship between two parts. */
@Schema(description = "Link between two parts.")
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = PartRelationship.PartRelationshipBuilder.class)
@SuppressWarnings("PMD.CommentRequired")
public class PartRelationship {
    @NotNull
    @Schema(description = "Unique part identifier of the parent in the relationship.")
    private PartId parent;

    @NotNull
    @Schema(description = "Unique part identifier of the child in the relationship.")
    private PartId child;
}
