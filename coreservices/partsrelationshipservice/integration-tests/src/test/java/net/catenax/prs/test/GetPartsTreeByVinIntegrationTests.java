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


public class GetPartsTreeByVinIntegrationTests extends PrsIntegrationTestsBase {

    private static final String PATH = "/api/v0.1/vins/{vin}/partsTree";
    private static final String VIN = "BMWOVCDI21L5DYEUU";

    @Test
    public void getPartsTreeByVin() throws Exception {
        var objectMapper = new ObjectMapper();
        var expected = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("response_1631610272167.json"), PartRelationshipsWithInfos.class);

        var response =
            given()
                .pathParam("vin", VIN)
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
    public void getPartsTreeByVin_notExistingVIN_returns404() {
        given()
            .pathParam("vin", "not-existing-vin")
            .queryParam("view", AS_MAINTAINED)
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getPartsTreeByVin_noView_returns400() {
        given()
            .pathParam("vin", VIN)
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getPartsTreeByVin_invalidView_returns400() {
        given()
            .pathParam("vin", VIN)
            .queryParam("view", "not-valid")
        .when()
            .get(PATH)
        .then()
            .assertThat()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}