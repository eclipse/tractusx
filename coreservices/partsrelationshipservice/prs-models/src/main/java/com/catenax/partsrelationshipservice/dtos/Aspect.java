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
import javax.validation.constraints.NotNull;
import java.net.URL;

/*** API type for aspect name/url entry. */
@Schema(description = "Aspect location data")
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = Aspect.AspectBuilder.class)
@SuppressWarnings("PMD.CommentRequired")
public class Aspect {
    @NotBlank
    @Schema(description = "Aspect name", example = "CE")
    private String name;

    @NotNull
    @Schema(description = "URL location of aspect data", example = "http://aspects-url/CE")
    private URL url;
}
