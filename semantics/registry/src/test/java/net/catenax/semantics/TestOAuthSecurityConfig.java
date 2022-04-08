/*
 * Copyright (c) 2022 Robert Bosch Manufacturing Solutions GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.catenax.semantics;

import net.catenax.semantics.registry.JwtTokenFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import java.time.Instant;
import java.util.Map;

@TestConfiguration
public class TestOAuthSecurityConfig {

    /**
     * In tests the OAuth2 flow is mocked by Spring. The Spring Security test support directly creates the
     * authentication object in the SecurityContextHolder.
     *
     * This decoder is only required for being present in the application context due to Spring autoconfiguration.
     */
    @Bean
    public JwtDecoder jwtDecoder(){
        return token -> {
            throw new UnsupportedOperationException("The JwtDecoder must not be called in tests by Spring.");
        };
    }

    @Bean
    public JwtTokenFactory jwtTokenFactory(RegistryProperties registryProperties){
        return new JwtTokenFactory(registryProperties.getIdm().getPublicClientId());
    }
}
