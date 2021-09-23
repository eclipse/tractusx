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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import net.catenax.prs.annotations.ExcludeFromCodeCoverageGeneratedReport;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Base for {@code getPartsTreeBy*} parameter objects.
 */
@RequiredArgsConstructor
@SuppressWarnings({"PMD.CommentRequired"})
class PartsTreeRequestBase {
    @NotNull
    @Parameter(description = "PartsTree View to retrieve", required = true)
    private final PartsTreeView view;

    @Nullable
    @Parameter(description = "Aspect information to add to the returned tree", example = "CE", schema = @Schema(implementation = String.class))
    private final String aspect;

    @Nullable
    @Parameter(description = "Max depth of the returned tree, if empty max depth is returned", schema = @Schema(implementation = Integer.class))
    private final Integer depth;

    public PartsTreeView getView() {
        return view;
    }

    @ExcludeFromCodeCoverageGeneratedReport
    public Optional<String> getAspect() {
        return Optional.ofNullable(aspect);
    }

    @ExcludeFromCodeCoverageGeneratedReport
    public Optional<Integer> getDepth() {
        return Optional.ofNullable(depth);
    }
}
