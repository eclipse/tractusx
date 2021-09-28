//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.services;

import com.catenax.partsrelationshipservice.dtos.PartRelationshipsWithInfos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.prs.configuration.PrsConfiguration;
import net.catenax.prs.entities.PartAspectEntity;
import net.catenax.prs.entities.PartAttributeEntity;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartRelationshipEntity;
import net.catenax.prs.exceptions.MaxDepthTooLargeException;
import net.catenax.prs.mappers.PartRelationshipEntityListToDtoMapper;
import net.catenax.prs.repositories.PartAspectRepository;
import net.catenax.prs.repositories.PartAttributeRepository;
import net.catenax.prs.repositories.PartRelationshipRepository;
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service for retrieving parts tree.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PartsTreeQueryService {
    /**
     * Repository for retrieving {@link PartRelationshipEntity} data.
     */
    private final PartRelationshipRepository relationshipRepository;
    /**
     * Repository for retrieving {@link PartAspectEntity} data.
     */
    private final PartAspectRepository aspectRepository;
    /**
     * Repository for retrieving {@link PartAttributeEntity} data.
     */
    private final PartAttributeRepository attributeRepository;
    /**
     * Mapper from entities to {@link PartRelationshipsWithInfos} DTO.
     */
    private final PartRelationshipEntityListToDtoMapper mapper;
    /**
     * PRS configuration settings.
     */
    private final PrsConfiguration configuration;

    /**
     * Get a parts tree for a {@link PartsTreeByObjectIdRequest}.
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    public PartRelationshipsWithInfos getPartsTree(final PartsTreeByObjectIdRequest request) {
        final var depth = request.getDepth().orElse(configuration.getPartsTreeMaxDepth());
        if (depth > configuration.getPartsTreeMaxDepth()) {
            throw new MaxDepthTooLargeException("Depth should not be more than " + configuration.getPartsTreeMaxDepth());
        }
        final var tree = relationshipRepository.getPartsTree(
                request.getOneIDManufacturer(),
                request.getObjectIDManufacturer(),
                depth);

        final var allIds = getAllIds(tree);

        final var typeNames = attributeRepository.findAllBy(allIds, PrsConfiguration.PART_TYPE_NAME_ATTRIBUTE_NAME);
        final var aspects = request.getAspect()
                .map(aspect -> aspectRepository.findAllBy(allIds, aspect))
                .orElseGet(Collections::emptyList);
        return mapper.toPartRelationshipsWithInfos(tree, allIds, typeNames, aspects);
    }

    private Set<PartIdEntityPart> getAllIds(final Collection<PartRelationshipEntity> tree) {
        final var allIds = tree.stream().map(e -> e.getKey().getParentId()).collect(Collectors.toSet());
        // forEachOrdered guarantees non-concurrent execution
        tree.stream().map(e -> e.getKey().getChildId()).forEachOrdered(allIds::add);
        return allIds;
    }
}
