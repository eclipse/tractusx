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

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.catenax.partsrelationshipservice.dtos.PartsTreeView.AS_MAINTAINED;
import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;


public class GetPartsTreeByVinIntegrationTests extends PrsIntegrationTestsBase {

    private static final String PATH = "/api/v0.1/vins/{vin}/partsTree";
    private static final String SAMPLE_VIN = "YS3DD78N4X7055320";
    private static final String VIN = "vin";
    private static final String VIEW = "view";
    private static final String DEPTH = "depth";
    private static final String ASPECT = "aspect";

    @Test
    public void getPartsTreeByVin_maintainedView_success() {
        var response =
                given()
                        .pathParam(VIN, SAMPLE_VIN)
                        .queryParam(VIEW, AS_MAINTAINED)
                        .when()
                        .get(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expected.sampleVinPartTree());
    }

    @Test
    public void getPartsTreeByVin_notExistingVIN_returns404() {
        given()
                .pathParam(VIN, "not-existing-vin")
                .queryParam(VIEW, AS_MAINTAINED)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getPartsTreeByVin_noView_returns400() {
        given()
                .pathParam(VIN, SAMPLE_VIN)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getPartsTreeByVin_invalidView_returns400() {
        given()
                .pathParam(VIN, SAMPLE_VIN)
                .queryParam(VIEW, "not-valid")
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getPartsTreeByVin_exceedMaxDepth_returns400() {
        var maxDepth = configuration.getPartsTreeMaxDepth();
        given()
                .pathParam(VIN, SAMPLE_VIN)
                .queryParam(VIEW, AS_MAINTAINED)
                .queryParam(DEPTH, maxDepth + 1)
                .when()
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getPartsTreeByVin_directChildren_success() {
        var response =
                given()
                        .pathParam(VIN, SAMPLE_VIN)
                        .queryParam(VIEW, AS_MAINTAINED)
                        .queryParam(DEPTH, 1)
                        .when()
                        .get(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expected.sampleVinDirectChildren());
    }

    @Test
    public void getPartsTreeByVin_grandChildren_success() {
        var response =
                given()
                        .pathParam(VIN, SAMPLE_VIN)
                        .queryParam(VIEW, AS_MAINTAINED)
                        .queryParam(DEPTH, 2)
                        .when()
                        .get(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expected.sampleVinGrandChildren());
    }

    @Test
    public void getPartsTreeByVin_withCEAspect_success() {
        var response =
                given()
                        .pathParam(VIN, SAMPLE_VIN)
                        .queryParam(VIEW, AS_MAINTAINED)
                        .queryParam(ASPECT, "CE")
                        .when()
                        .get(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expected.sampleVinPartTreeWithAspects());
    }
}