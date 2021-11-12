//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.systemtest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;


/**
 * System tests that verify the interaction between Consumer and Provider connectors.
 * <p>
 * The current implementation expects the Provider to be a singleton pod.
 *
 * @see <a href="https://confluence.catena-x.net/display/ARTI/MTPDC+Testing">MTPDC Testing</a>
 */
@Tag("SystemTests")
public class ConnectorSystemTests {

    private static final String baseURI = System.getProperty("ConnectorProviderBaseURI", "https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com");
    private static final String namespace = System.getProperty("ConnectorProviderK8sNamespace", "prs-connectors");
    private static final String pod = System.getProperty("ConnectorProviderK8sPod", "prs-connector-provider-0");

    @Test
    public void downloadFile() throws Exception {

        // Arrange

        var payload = UUID.randomUUID().toString();

        // Create source file on Provider pod, to be copied to destination file
        var createSourceFile = runOnProviderPod(
                "sh",
                "-c",
                "echo " + payload + " > /tmp/copy/source/test-document.txt"
        );
        int exitCode = createSourceFile.waitFor();
        assertThat(exitCode)
                .as("kubectl command failed")
                .isEqualTo(0);

        // Act

        // Send query to Consumer connector, to perform file copy on Provider
        var destFile = "/tmp/copy/dest/" + UUID.randomUUID();
        Map<String, String> params = new HashMap<>();
        params.put("filename", "test-document");
        params.put("connectorAddress", baseURI + "/prs-connector-provider");
        params.put("destinationPath", destFile);

        RestAssured.baseURI = baseURI + "/prs-connector-consumer";
        var requestId =
                given()
                        .contentType("application/json")
                        .body(params)
                .when()
                        .post("/api/file")
                .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract().asString();

        // An ID is returned, for polling
        assertThat(requestId).isNotBlank();

        // Assert

        // Expect the destination file to appear on the Provider pod
        await()
                .atMost(Duration.ofSeconds(30))
                .untilAsserted(() -> {
                    var exec = runOnProviderPod("cat", destFile);
                    try (InputStream inputStream = exec.getInputStream()) {
                        assertThat(inputStream).hasContent(payload);
                    }
                    exec.waitFor();
                });
    }

    private Process runOnProviderPod(String... command) throws IOException {
        var l = new ArrayList<>(Arrays.asList(
                "kubectl",
                "exec",
                "-n",
                namespace,
                pod,
                "--"));
        l.addAll(Arrays.asList(command));
        return new ProcessBuilder()
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .command(l)
                .start();
    }
}
