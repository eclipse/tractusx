/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.test;

import net.catenax.semantics.framework.IdsConnector;
import net.catenax.semantics.framework.IdsRequest;
import net.catenax.semantics.framework.IdsResponse;
import net.catenax.semantics.framework.config.Contract;
import net.catenax.semantics.framework.config.Offer;

/**
 * mock ids connector for testing purposes
 */
public class MockConnector implements IdsConnector {
    @Override
    public Contract getOrCreateContract(String title) {
        return null;
    }

    @Override
    public Offer getOrCreateOffer(String title) {
        return null;
    }

    @Override
    public Object getSelfDescription() {
        return null;
    }

    @Override
    public IdsResponse perform(IdsRequest request) {
        return null;
    }
}
