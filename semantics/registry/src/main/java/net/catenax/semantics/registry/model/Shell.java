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
package net.catenax.semantics.registry.model;


import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Value
@With
public class Shell {
    @Id
    UUID id;
    String idExternal;
    String idShort;

    @MappedCollection(idColumn = "fk_shell_id")
    Set<ShellIdentifier> identifiers;

    @MappedCollection(idColumn = "fk_shell_id")
    Set<ShellDescription> descriptions;

    @MappedCollection(idColumn = "fk_shell_id")
    Set<Submodel> submodels;

    @CreatedDate
    Instant createdDate;

    @LastModifiedDate
    Instant lastModifiedDate;

}
