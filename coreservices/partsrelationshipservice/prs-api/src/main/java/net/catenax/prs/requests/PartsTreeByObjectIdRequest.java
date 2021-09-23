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
import lombok.Builder;
import lombok.Value;
import net.catenax.prs.controllers.PrsController;

import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;

/**
 * Parameter object for {@link PrsController#getPartsTree(PartsTreeByObjectIdRequest)} REST operation.
 */
@Value
@SuppressWarnings({"PMD.CommentRequired", "PMD.CommentDefaultAccessModifier", "PMD.DefaultPackage"})
public class PartsTreeByObjectIdRequest extends PartsTreeRequestBase {

    @NotBlank
    @Parameter(description = "Readable ID of manufacturer including plant", in = PATH, required = true)
    String oneIDManufacturer;

    @NotBlank
    @Parameter(description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer", in = PATH, required = true)
    String objectIDManufacturer;

    /**
     * Generate a new instance of a {@link PartsTreeByObjectIdRequest}.
     * <p>
     * Use {@link #builder()} instead.
     *
     * @param oneIDManufacturer    see {@link #getOneIDManufacturer()}
     * @param objectIDManufacturer see {@link #getObjectIDManufacturer()}
     * @param view                 see {@link #getView()}
     * @param aspect               see {@link #getAspect()}
     * @param depth                see {@link #getDepth()}
     */
    @Builder
    public PartsTreeByObjectIdRequest(final String oneIDManufacturer, final String objectIDManufacturer, final PartsTreeView view, final String aspect, final Integer depth) {
        super(view, aspect, depth);
        this.oneIDManufacturer = oneIDManufacturer;
        this.objectIDManufacturer = objectIDManufacturer;
    }
}
