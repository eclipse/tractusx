//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import net.catenax.prs.PrsApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the springdoc OpenAPI generator.
 */
@Configuration
@RequiredArgsConstructor
public class OpenApiConfiguration {
    /**
     * PRS configuration settings.
     */
    private final PrsConfiguration prsConfiguration;

    /**
     * Factory for generated Open API definition.
     *
     * @return Generated Open API configuration.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .addServersItem(new Server()
                .url(prsConfiguration.getApiUrl().toString())
            )
            .info(new Info()
                .title("Catena-X Parts Relationship Service")
                .version(PrsApplication.API_VERSION)
                .description("API to retrieve parts tree information.")
            );
    }
}
