/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.proxy;

import lombok.Data;
import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;

import java.util.List;

/**
 * configuration of an orga twin submodel
 * to convert URLs
 */
@Data
public class ConversionSubmodel {
    protected List<IdentifierKeyValuePair> orgaIdentifiers;
    protected String conversionSubmodel;
    protected String conversionSubmodelEntry;
    protected String targetDomain;
}
