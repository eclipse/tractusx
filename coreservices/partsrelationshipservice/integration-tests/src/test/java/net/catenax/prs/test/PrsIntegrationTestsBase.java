package net.catenax.prs.test;

import io.restassured.RestAssured;
import net.catenax.prs.PrsApplication;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(classes = {PrsApplication.class}, webEnvironment = RANDOM_PORT)
public class PrsIntegrationTestsBase {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUpClass(){
        RestAssured.port = port;
    }

}