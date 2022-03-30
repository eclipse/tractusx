/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework;

import net.catenax.semantics.framework.config.Contract;
import net.catenax.semantics.framework.config.Offer;

/**
 * Interface to any IDS Connector. Basically, the IdsConntector (Control Plane) should sit
 * between the (Data Plane API) Controllers and the actual
 * backend (Internal API) controllers.
 */
public interface IdsConnector {

    /**
     * gets or creates a particular contract
     * @param title of the contract
     * @return contract as created/found
     */
    Contract getOrCreateContract(String title) throws StatusException;

    /**
     * Gets or creates a particular offer
     * in the attached ids connector
     * @param title name of the offer
     * @return offer as created/found
     */
    Offer getOrCreateOffer(String title) throws StatusException;

    /**
     * presents a self-description of the associated ids
     * connector
     * @return an object describing the associated connector
     */
    Object getSelfDescription() throws StatusException;

    /**
     * performs an internalized request
     * @param request
     * @return response
     */
    IdsResponse perform(IdsRequest request);
}
