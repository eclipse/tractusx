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
import net.catenax.prs.controllers.ApiErrors;
import net.catenax.prs.entities.PartAttributeEntity;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartInformationKey;
import net.catenax.prs.exceptions.EntityNotFoundException;
import net.catenax.prs.repositories.PartAttributeRepository;
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import net.catenax.prs.requests.PartsTreeByVinRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.function.Function;

/**
 * Service for retrieving parts tree by VIN.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PartsTreeQueryByVinService {
    /**
     * Service for retrieving parts tree.
     */
    private final PartsTreeQueryService queryService;
    /**
     * Repository for retrieving {@link PartAttributeEntity} data.
     */
    private final PartAttributeRepository attributeRepository;
    /**
     * Sort expression to sort by OneId.
     */
    private static final Sort.TypedSort<String> SORTED_BY_ONEID = Sort.sort(PartAttributeEntity.class).by((Function<PartAttributeEntity, String>) a -> a.getKey().getPartId().getOneIDManufacturer());

    /**
     * Get a parts tree for a {@link PartsTreeByVinRequest}.
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    public PartRelationshipsWithInfos getPartsTree(final PartsTreeByVinRequest request) {

        // Find vehicle, i.e. part with attribute partTypeName="Vehicle" and objectId=VIN
        final var vin = request.getVin();
        final var searchFilter = Example.of(
                PartAttributeEntity.builder()
                        .key(getPartInformationKey(vin))
                        .value(PrsConfiguration.VEHICLE_ATTRIBUTE_VALUE).build());
        final var vehicles = attributeRepository.findAll(searchFilter, SORTED_BY_ONEID);
        if (vehicles.isEmpty()) {
            throw new EntityNotFoundException(MessageFormat.format(ApiErrors.VEHICLE_NOT_FOUND_BY_VIN, request.getVin()));
        }
        final var moreThanOneMatch = vehicles.size() > 1;
        if (moreThanOneMatch) {
            log.warn("Multiple OneIDs match VIN");
        }
        final var vehicle = vehicles.get(0).getKey().getPartId();
        return queryService.getPartsTree(PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer(vehicle.getOneIDManufacturer())
                .objectIDManufacturer(vehicle.getObjectIDManufacturer())
                .aspect(request.getAspect().orElse(null))
                .depth(request.getDepth().orElse(null))
                .build());
    }

    private static PartInformationKey getPartInformationKey(final String vin) {
        return PartInformationKey.builder()
                .partId(getPartId(vin))
                .name(PrsConfiguration.PART_TYPE_NAME_ATTRIBUTE_NAME)
                .build();
    }

    private static PartIdEntityPart getPartId(final String vin) {
        return PartIdEntityPart.builder()
                .objectIDManufacturer(vin)
                .build();
    }
}
