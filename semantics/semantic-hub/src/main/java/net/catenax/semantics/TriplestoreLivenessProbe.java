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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import net.catenax.semantics.hub.persistence.PersistenceLayer;

@Component
public class TriplestoreLivenessProbe implements HealthIndicator {
    private PersistenceLayer pl;

    public TriplestoreLivenessProbe(PersistenceLayer pl) {
        this.pl = pl;
    }

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Health health() {
        try {
            if(pl.echo()) {
                return Health.up().build();
            }
            return Health.down().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Health.down().build();
        }
    }
}
