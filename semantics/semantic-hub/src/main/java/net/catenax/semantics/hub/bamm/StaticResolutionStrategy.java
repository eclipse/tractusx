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

package net.catenax.semantics.hub.bamm;

import org.apache.jena.rdf.model.Model;

import io.openmanufacturing.sds.aspectmodel.resolver.AbstractResolutionStrategy;
import io.openmanufacturing.sds.aspectmodel.urn.AspectModelUrn;
import io.vavr.control.Try;

public class StaticResolutionStrategy extends AbstractResolutionStrategy {
    private int counter;
    private final Try<Model> model;

    public StaticResolutionStrategy(Try<Model> model) {
        this.model = model;
    }

    @Override
    public Try<Model> apply(AspectModelUrn t) {
        counter++;
        
        return this.model;
    }

    public int getResolvementCounter() {
        return counter;
    }
}
