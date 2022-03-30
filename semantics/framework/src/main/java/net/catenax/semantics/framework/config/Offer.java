/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Data;

/**
 * represents a configured offer
 */
@Data
public class Offer {
    private UUID id;
    private String uri;
    private String description;
    private List<String> keywords;
    private String license;
    private String language;
    private String paymentMethod = "FREE";
    private String catalog;
    private String contract;
    private Map<String, Representation> representations = new HashMap<>();
    private String payload;
    private String user;
}
