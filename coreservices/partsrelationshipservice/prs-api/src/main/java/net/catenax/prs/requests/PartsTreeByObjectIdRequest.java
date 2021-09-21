//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.requests;

import com.catenax.partsrelationshipservice.dtos.PartsTreeView;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;

/**
 * Parameter object for getPartsTreeByVin REST operation.
 */
@Value
@Builder(toBuilder = true)
@AllArgsConstructor
@SuppressWarnings("PMD.CommentRequired")
public class PartsTreeByObjectIdRequest {

    @NotBlank
    @Parameter(description = "Readable ID of manufacturer including plant", in = PATH, required = true)
    String oneIDManufacturer;

    @NotBlank
    @Parameter(description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer", in = PATH, required = true)
    String objectIDManufacturer;

    @NotNull
    @Parameter(description = "PartsTree View to retrieve", required = true)
    PartsTreeView view;

    @Parameter(description = "Aspect information to add to the returned tree", example = "CE")
    String aspect;

    @Parameter(description = "Max depth of the returned tree, if empty max depth is returned")
    Integer depth;

    /**
     * @return The aspect to add to the response
     */
    public Optional<String> getAspect() {
        return Optional.of(aspect);
    }

    /**
     * @return The depth of the parts tree
     */
    public Optional<Integer> getDepth() {
        return Optional.of(depth);
    }
}
