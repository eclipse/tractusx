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
import net.catenax.prs.annotations.ValueOfEnum;
import net.catenax.prs.controllers.ApiErrors;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

/**
 * Base for {@code getPartsTreeBy*} parameter objects.
 */
@RequiredArgsConstructor
@SuppressWarnings({"PMD.CommentRequired", "PMD.AbstractClassWithoutAbstractMethod"})
abstract class PartsTreeRequestBase {
    @NotNull(message = ApiErrors.PARTS_TREE_VIEW_NOT_NULL)
    @ValueOfEnum(enumClass = PartsTreeView.class, message = ApiErrors.PARTS_TREE_VIEW_MUST_MATCH_ENUM)
    @Parameter(description = "PartsTree View to retrieve", in = QUERY, required = true, schema = @Schema(implementation = PartsTreeView.class))
    protected final String view;

    @Nullable
    @Parameter(description = "Aspect information to add to the returned tree", in = QUERY, example = "CE", schema = @Schema(implementation = String.class))
    protected final String aspect;

    @Nullable
    @Min(value = 1, message = ApiErrors.PARTS_TREE_MIN_DEPTH)
    @Parameter(description = "Max depth of the returned tree, if empty max depth is returned", in = QUERY, schema = @Schema(implementation = Integer.class, minimum = "1"))
    protected final Integer depth;

    public PartsTreeView getView() {
        return PartsTreeView.valueOf(view);
    }

    public Optional<String> getAspect() {
        return Optional.ofNullable(aspect);
    }

    public Optional<Integer> getDepth() {
        return Optional.ofNullable(depth);
    }
}
