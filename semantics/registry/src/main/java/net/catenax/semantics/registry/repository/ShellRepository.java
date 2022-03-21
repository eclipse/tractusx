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

import net.catenax.semantics.registry.model.Shell;
import net.catenax.semantics.registry.model.projection.ShellMinimal;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ShellRepository extends PagingAndSortingRepository<Shell, UUID>{
    Optional<Shell> findByIdExternal(String idExternal);

    @Query("select s.id, s.created_date from shell s where s.id_external = :idExternal")
    Optional<ShellMinimal> findMinimalRepresentationByIdExternal(String idExternal);

    /**
     * Returns external shell ids for the given keyValueCombinations.
     * Only external shell ids that match all keyValueCombinations are returned.
     *
     * To be able to properly index the key and value conditions, the query does not use any functions.
     * Computed indexes cannot be created for mutable functions like CONCAT in Postgres.
     *
     * @param keyValueCombinations the keys values to search for as tuples
     * @param keyValueCombinationsSize the size of the key value combinations
     * @return external shell ids for the given keys and values
     */
    @Query(
            "select s.id_external from shell s where s.id in (" +
                    "select si.fk_shell_id from shell_identifier si " +
                    "join (values :keyValueCombinations ) as t (input_key,input_value) " +
                    "ON si.namespace = input_key AND si.identifier = input_value " +
                    "group by si.fk_shell_id " +
                    "having count(*) = :keyValueCombinationsSize " +
            ")"
    )
    List<String> findExternalShellIdsByIdentifiers(@Param("keyValueCombinations") List<String[]> keyValueCombinations,
                                                   @Param("keyValueCombinationsSize") int keyValueCombinationsSize);
}
