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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.DataSource;

/**
 * spring configuration of the framework tests
 */
@Configuration
@ComponentScan(basePackages = {"net.catenax.semantics.framework"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern="net\\.catenax\\.semantics\\.framework\\.aas\\..*") })
public class FrameworkConfiguration extends MockConfiguration {

    @Bean
    @Override
    public Config<Command, Offer, Catalog, Contract, Transformation> getConfigurationData() {
        return super.getConfigurationData();
    }

    @Bean
    @Override
    public TokenOutgoingInterceptor getInterceptor() {
        return super.getInterceptor();
    }

    @Bean
    @Override
    public DataSource getDataSource() {
        return super.getDataSource();
    }

    @Bean
    public IdsConnector getConnector() {
        return super.getConnector();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return super.getObjectMapper();
    }
}
