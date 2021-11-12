//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.mappers;

import lombok.RequiredArgsConstructor;
import net.catenax.prs.dtos.Aspect;
import net.catenax.prs.dtos.PartId;
import net.catenax.prs.dtos.PartInfo;
import net.catenax.prs.dtos.PartRelationship;
import net.catenax.prs.dtos.PartRelationshipsWithInfos;
import net.catenax.prs.entities.PartAspectEntity;
import net.catenax.prs.entities.PartAttributeEntity;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartRelationshipEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * Mapper from entities to {@link PartRelationshipsWithInfos} DTO.
 */
@Component
@RequiredArgsConstructor
public class PartRelationshipEntityListToDtoMapper {
    /**
     * Mapper from {@link PartAspectEntity} entity to {@link Aspect} DTO.
     */
    private final PartAspectEntityToDtoMapper aspectMapper;
    /**
     * Mapper from {@link PartRelationshipEntity} entity to {@link PartRelationship} DTO.
     */
    private final PartRelationshipEntityToDtoMapper relationshipMapper;
    /**
     * Mapper from {@link PartIdEntityPart} entity to {@link PartId} DTO.
     */
    private final PartIdEntityPartToDtoMapper idMapper;

    /**
     * Map entities into a {@link PartRelationshipsWithInfos} DTO.
     *
     * @param source     collection of {@link PartRelationshipEntity}
     *                   to be mapped into {@link PartRelationshipsWithInfos#getRelationships()}.
     * @param allPartIds collection of {@link PartIdEntityPart}
     *                   to be mapped into {@link PartRelationshipsWithInfos#getPartInfos()}.
     * @param attributes collection of {@link PartAttributeEntity}
     *                   to be mapped into {@link PartInfo#getPartTypeName()}.
     * @param aspects    collection of {@link PartAspectEntity}
     *                   to be mapped into {@link PartInfo#getAspects()}.
     * @return DTO containing data from the entities. Guaranteed to be not {@literal null}.
     */
    public PartRelationshipsWithInfos toPartRelationshipsWithInfos(final Collection<PartRelationshipEntity> source, final Collection<PartIdEntityPart> allPartIds, final Collection<PartAttributeEntity> attributes, final Collection<PartAspectEntity> aspects) {
        final var attributeIndex = attributes.stream().collect(Collectors.groupingBy(t -> t.getKey().getPartId()));
        final var aspectIndex = aspects.stream().collect(Collectors.groupingBy(t -> t.getKey().getPartId()));

        // Remove ids without any attribute information
        // This case happens when a children node belongs to a different partition than the parent node
        final Collection<PartIdEntityPart> sourceForPartInfos = allPartIds.stream().filter(attributeIndex::containsKey).collect(Collectors.toList());

        return PartRelationshipsWithInfos.builder()
                .withRelationships(mapToList(source, relationshipMapper::toPartRelationship))
                .withPartInfos(mapToList(sourceForPartInfos, toPartInfoFactory(attributeIndex, aspectIndex)))
                .build();
    }

    private Function<PartIdEntityPart, PartInfo> toPartInfoFactory(
            final Map<PartIdEntityPart, List<PartAttributeEntity>> attributeIndex,
            final Map<PartIdEntityPart, List<PartAspectEntity>> aspectIndex
    ) {
        return source -> PartInfo.builder()
                .withPart(idMapper.toPartId(source))
                .withAspects(mapToList(aspectIndex.getOrDefault(source, emptyList()), aspectMapper::toAspect))
                .withPartTypeName(Optional.ofNullable(attributeIndex.get(source)).map(t -> t.get(0).getValue()).orElse(null))
                .build();
    }

    private static <S, T> List<T> mapToList(final Collection<S> source, final Function<S, T> map) {
        return source.stream().map(map).collect(Collectors.toList());
    }
}
