//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.repositories;

import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartRelationshipEntity;
import net.catenax.prs.entities.PartRelationshipEntityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPA Repository for managing {@link PartRelationshipEntity} objects.
 */
public interface PartRelationshipRepository extends JpaRepository<PartRelationshipEntity, PartRelationshipEntityKey> {
    /**
     * Call stored procedure to recursively retrieve the parts tree from a given part.
     *
     * @param oneIDManufacturer    see {@link PartIdEntityPart#getOneIDManufacturer()}.
     * @param objectIDManufacturer see {@link PartIdEntityPart#getObjectIDManufacturer()}.
     * @param maxDepth             maximum depth to traverse the tree.
     * @return edges in the parts tree below the given part.
     */
    @Query(nativeQuery = true, value = "SELECT * FROM get_parts_tree(:oneIDManufacturer, :objectIDManufacturer, :maxDepth)")
    List<PartRelationshipEntity> getPartsTree(
        String oneIDManufacturer,
        String objectIDManufacturer,
        int maxDepth);
}

