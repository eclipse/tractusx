//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.util;

import com.catenax.partsrelationshipservice.dtos.PartRelationshipsWithInfos;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.catenax.prs.annotations.ExcludeFromCodeCoverageGeneratedReport;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Temporary helper for serving stubbed resources.
 */
@Component
@ExcludeFromCodeCoverageGeneratedReport
public class StubResourcesHelper {
    /**
     * JSON object mapper.
     */
    private final transient ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Get stubbed parts tree data.
     *
     * @return stubbed parts tree data.
     */
    @SuppressWarnings({"PMD.AvoidThrowingRawExceptionTypes", "PMD.AvoidCatchingGenericException"})
    @SuppressFBWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE", justification = "False positive")
    public PartRelationshipsWithInfos getStubbedPartsTreeData() {
        try (
            var stubData = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("response_1631610272167.json")) {
            return objectMapper.readValue(stubData, PartRelationshipsWithInfos.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
