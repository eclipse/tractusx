/*
 * Copyright (c) 2021-2022 Robert Bosch Manufacturing Solutions GmbH
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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Validated
@ConfigurationProperties(prefix = "hub.general")
public class GeneralProperties {

    private final Idm idm = new Idm();

    /**
     * Properties for Identity Management system
     */
    @Data
    @NotNull
    public static class Idm {
        /**
         * The public client id used for the redirect urls.
         */
        @NotEmpty(message = "public client id must not be empty")
        private String publicClientId;
    }

}
