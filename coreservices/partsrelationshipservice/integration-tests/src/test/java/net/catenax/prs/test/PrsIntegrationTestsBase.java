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

import io.restassured.RestAssured;
import net.catenax.prs.PrsApplication;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import static net.catenax.prs.testing.TestUtil.DATABASE_TESTCONTAINER;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@TestPropertySource(properties = DATABASE_TESTCONTAINER)
@SpringBootTest(classes = {PrsApplication.class}, webEnvironment = RANDOM_PORT)
public class PrsIntegrationTestsBase {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

}