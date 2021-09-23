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

import javax.validation.constraints.NotBlank;

/*** API type for a part identifier. */
@Schema(description = "Unique part identifier")
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = PartId.PartIdBuilder.class)
@SuppressWarnings("PMD.CommentRequired")
public class PartId {
    @NotBlank
    @Schema(description = "Readable ID of manufacturer including plant")
    private String oneIDManufacturer;

    @NotBlank
    @Schema(description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer. For a vehicle, the Vehicle Identification Number (VIN).")
    private String objectIDManufacturer;
}
