/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * represents a contract configuration
 */
@Data
public class Contract {
    private UUID id;
    private String uri;
    private String description;
    private String consumer;
    private OffsetDateTime start = OffsetDateTime.now();
    private OffsetDateTime end = OffsetDateTime.of(LocalDateTime.of(2999, 1, 1, 0, 0, 0), ZoneOffset.UTC);
    private Map<String, ContractRule> rules = new HashMap<>();
    private String payload;
}
