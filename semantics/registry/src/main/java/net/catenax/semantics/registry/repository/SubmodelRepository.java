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
package net.catenax.semantics.registry.repository;

import net.catenax.semantics.registry.model.Submodel;
import net.catenax.semantics.registry.model.projection.SubmodelMinimal;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubmodelRepository extends CrudRepository<Submodel, UUID> {

    Optional<Submodel> findByShellIdAndIdExternal(UUID shellId, String externalId);

    @Query("select s.id from submodel s where s.fk_shell_id = :shellId and s.id_external = :externalId")
    Optional<SubmodelMinimal> findMinimalRepresentationByShellIdAndIdExternal(UUID shellId, String externalId);
}
