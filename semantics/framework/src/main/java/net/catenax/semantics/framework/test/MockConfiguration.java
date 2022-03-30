/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.test;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import net.catenax.semantics.framework.auth.TokenOutgoingInterceptor;
import net.catenax.semantics.framework.auth.TokenWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * helper to build mock configurations
 */
public class MockConfiguration {

    /**
     * @return a mock token wrapper and interceptor
     */
    public TokenOutgoingInterceptor getInterceptor() {
        TokenWrapper wrapper=new TokenWrapper();
        return new TokenOutgoingInterceptor(new TokenWrapper());
    }

    /**
     * @return a mock data source
     */
    public javax.sql.DataSource getDataSource() {
        return new MockDataSource();
    }

    /**
     * @return a default catalog
     */
    public Catalog getCatalog() {
        return new Catalog();
    }

    /**
     * @return sample offer
     */
    public Offer getOffer() {
        Offer offer=new Offer();
        offer.getRepresentations().put("sample-representation",getRepresentation());
        return offer;
    }

    /**
     * @return sample representation
     */
    public Representation getRepresentation() {
        Representation representation =  new Representation();
        representation.getArtifacts().put("sample-artifact",getArtifact());
        return representation;
    }

    /**
     * @return sample artifact
     */
    public Artifact getArtifact() {
        return new Artifact();
    }

    /**
     * @return a default config
     */
    public Config<Command, Offer, Catalog, Contract, Transformation> getConfigurationData() {
        ConfigurationData<Command, Offer, Catalog, Contract, Transformation> configurationData= new ConfigurationData<Command, Offer, Catalog, Contract, Transformation>();
        configurationData.setConnectorUser("user");
        configurationData.setConnectorPassword("password");
        configurationData.setConnectorUrl("http://localhost:4242");
        configurationData.setConnectorId("urn:connector:net.catenax.semantics#SampleConnector");
        configurationData.setPublisher("http://www.t-systems.com");
        configurationData.getCatalogs().put("urn:catalog:catenax",getCatalog());
        configurationData.getOffers().put("sample-offer",getOffer());
        return configurationData;
    }

    /**
     * @return a mock connector
     */
    public IdsConnector getConnector() {
        return new MockConnector();
    }

    /**
     * return mock object mapper
     * @return
     */
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}
