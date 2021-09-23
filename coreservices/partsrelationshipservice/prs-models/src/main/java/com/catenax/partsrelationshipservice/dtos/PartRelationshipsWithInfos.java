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

import java.util.List;

/*** API type for query response type with relationships and part information. */
@Schema(description = "List of relationships with information about parts.")
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = PartRelationshipsWithInfos.PartRelationshipsWithInfosBuilder.class)
@SuppressWarnings("PMD.CommentRequired")
public class PartRelationshipsWithInfos {
    @Schema(description = "List of the relationships")
    private List<PartRelationship> relationships;

    @Schema(description = "List of part infos")
    private List<PartInfo> partInfos;
}
