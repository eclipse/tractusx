package net.catenax.prs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.nio.file.Files;

import static java.nio.charset.StandardCharsets.UTF_8;
import static net.catenax.prs.testing.TestUtil.DATABASE_TESTCONTAINER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = NONE)
@TestPropertySource(properties = DATABASE_TESTCONTAINER)
class PrsApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void generatedOpenApiMatchesContract() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api-docs.yaml",
                String.class))
                .isEqualTo(Files.readString(new File("../api/prs-v0.1.yaml").toPath(), UTF_8), port);
    }
}
