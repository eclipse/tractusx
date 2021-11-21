//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static net.catenax.prs.dtos.ValidationConstants.INPUT_FIELD_MAX_LENGTH;
import static net.catenax.prs.dtos.ValidationConstants.INPUT_FIELD_MIN_LENGTH;

/**
 * Parameter object for
 * getPartsTree
 * REST operation.
 */
@Value
@Jacksonized // Makes the class deserializable using lombok builder.
@Builder(toBuilder = true)
public class PartsTreeByObjectIdRequest {

    /**
     * Readable ID of manufacturer including plant.
     */
    @NotBlank
    @Size(min = INPUT_FIELD_MIN_LENGTH, max = INPUT_FIELD_MAX_LENGTH)
    private String oneIDManufacturer;

    /**
     * Unique identifier of a single, unique physical (sub)component/part/batch,
     * given by its manufacturer.
     */
    @NotBlank
    @Size(min = INPUT_FIELD_MIN_LENGTH, max = INPUT_FIELD_MAX_LENGTH)
    private String objectIDManufacturer;

    /**
     * PartsTree View to retrieve.
     */
    @NotBlank
    @Size(min = INPUT_FIELD_MIN_LENGTH, max = INPUT_FIELD_MAX_LENGTH)
    private final String view;

    /**
     * Aspect information to add to the returned tree. May be {@literal null}.
     */
    @Size(max = INPUT_FIELD_MAX_LENGTH)
    @Pattern(regexp = "^(?!\\s*$).+", message = "must not be blank")
    private final String aspect;

    /**
     * Max depth of the returned tree, if {@literal null}, max depth is returned. May be {@literal null}.
     */
    @Min(1)
    private final Integer depth;
}
