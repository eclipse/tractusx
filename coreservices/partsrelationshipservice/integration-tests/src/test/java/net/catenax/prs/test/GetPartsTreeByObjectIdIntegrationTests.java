//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.test;

import com.catenax.partsrelationshipservice.dtos.PartRelationshipsWithInfos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.catenax.partsrelationshipservice.dtos.PartsTreeView.AS_MAINTAINED;
import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.json;

public class GetPartsTreeByObjectIdIntegrationTests extends PrsIntegrationTestsBase {

    @Test
    public void getPartsTreeByObjectId() throws Exception {
        var objectMapper = new ObjectMapper();
        var expected = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("response_1631610272167.json"), PartRelationshipsWithInfos.class);

        var response =
            given()
                .pathParam("oneIDManufacturer", "OID_CX_0001_ZFGRP")
                .pathParam("objectIDManufacturer", "ZF3EZLMaP0LN5D8VU")
                .queryParam("view", AS_MAINTAINED)
            .when()
                .get("/api/v0.1/parts/{oneIDManufacturer}/{objectIDManufacturer}/partsTree")
            .then()
                .assertThat()
                    .statusCode(HttpStatus.OK.value())
            .extract().asString();

        assertThatJson(response).isEqualTo(json(expected));
    }

    @Test
    public void getPartsTreeByObjectId_noView_returns400() {
        given()
            .pathParam("oneIDManufacturer", "OID_CX_0001_ZFGRP")
            .pathParam("objectIDManufacturer", "ZF3EZLMaP0LN5D8VU")
        .when()
            .get("/api/v0.1/parts/{oneIDManufacturer}/{objectIDManufacturer}/partsTree")
        .then()
            .assertThat()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}