//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * JPA embeddable entity part representing a part identifier.
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString // safe on this entity as it has no relationships
public class PartIdEntityPart implements Serializable {

    /**
     * Readable ID of manufacturer including plant.
     */
    @NotEmpty
    private String oneIDManufacturer;

    /**
     * Unique identifier of a single, unique physical (sub)component/part/batch,
     * given by its manufacturer.
     * For a vehicle, the Vehicle Identification Number (VIN).
     */
    @NotEmpty
    private String objectIDManufacturer;
}
