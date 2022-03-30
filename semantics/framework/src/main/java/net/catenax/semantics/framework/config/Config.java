/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import java.util.List;
import java.util.Map;

/**
 * represents a (part) of a configuration file, such as a spring boot yml.
 */
public interface Config<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> {
    Security getSecurity();
    String getConnectorType();
    String getConnectorUrl();
    String getConnectorId();
    String getServiceUrl();
    String getAdapterUrl();
    String getPortalUrl();
    String getConnectorUser();
    String getConnectorPassword();
    String getPublisher();
    /**
     * determines the callback method to access artifacts
     */
    String getCallbackPattern();

    String getServiceName();
    boolean isOfferOnStart();
    boolean isRegisterOnStart();

    Map<String, Ct> getCatalogs();
    Map<String, Co> getContracts();
    Map<String, O> getOffers();
    Map<String, Cmd> getCommands();
    Map<String,T> getTransformations();
    Map<String,String> getTransformationParameters();
    List<TwinSource> getTwinSources();
}
