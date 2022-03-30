/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.proxy;

import lombok.Data;

import java.util.Map;

/**
 * configuration properties of the aas proxy
 */
@Data
public class ConfigurationData {
    protected String proxyUrl;
    protected String registryUrl;
    protected String wrapperUrl;
    protected Map<String, ConversionSubmodel> idConversions;
}
