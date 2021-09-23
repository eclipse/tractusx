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

    private static final String PATH = "/api/v0.1/parts/{oneIDManufacturer}/{objectIDManufacturer}/partsTree";
    private static final String VEHICLE_ONE_ID = "OID_CX_0001_ZFGRP";
    private static final String VEHICLE_OBJECT_ID = "ZF3EZLMaP0LN5D8VU";

    @Test
    public void getPartsTreeByObjectId() throws Exception {
        var objectMapper = new ObjectMapper();
        var expected = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("response_1631610272167.json"), PartRelationshipsWithInfos.class);

        var response =
            given()
                .pathParam("oneIDManufacturer", VEHICLE_ONE_ID)
                .pathParam("objectIDManufacturer", VEHICLE_OBJECT_ID)
                .queryParam("view", AS_MAINTAINED)
            .when()
                .get(PATH)
            .then()
                .assertThat()
                    .statusCode(HttpStatus.OK.value())
            .extract().asString();

        assertThatJson(response).isEqualTo(json(expected));
    }

    @Test
    public void getPartsTreeByObjectId_notExistingObjectid_returns404() {
        given()
            .pathParam("oneIDManufacturer", VEHICLE_ONE_ID)
            .pathParam("objectIDManufacturer", "not-existing-object-id")
            .queryParam("view", AS_MAINTAINED)
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getPartsTreeByObjectId_notExistingOneId_returns404() {
        given()
            .pathParam("oneIDManufacturer", "not-existing-one-id")
            .pathParam("objectIDManufacturer", VEHICLE_OBJECT_ID)
            .queryParam("view", AS_MAINTAINED)
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getPartsTreeByObjectId_noView_returns400() {
        given()
            .pathParam("oneIDManufacturer", VEHICLE_ONE_ID)
            .pathParam("objectIDManufacturer", VEHICLE_OBJECT_ID)
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}