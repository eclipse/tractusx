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
import net.catenax.prs.requests.PartsTreeRequest;
import net.catenax.prs.requests.VinPartsTreeRequest;
import net.catenax.prs.util.StubResourcesHelper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.stereotype.Service;

/**
 * Service for retrieving parts tree.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PartsTreeQueryService {
    /**
     * Temporary helper for serving stubbed resources.
     */
    private final StubResourcesHelper stubResourcesHelper;

    /**
     * Get a PartsTree for a VIN
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    public PartRelationshipsWithInfos getPartsTree(final @ParameterObject VinPartsTreeRequest request) {
        return stubResourcesHelper.getStubbedPartsTreeData();
    }

    /**
     * Get a PartsTree for a part
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    public PartRelationshipsWithInfos getPartsTree(PartsTreeRequest request) {
        return null;
    }
}
