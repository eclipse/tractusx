/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.adapter.test;

import net.catenax.semantics.adapter.ConfigurationData;
import net.catenax.semantics.framework.config.*;
import net.catenax.semantics.framework.test.MockConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.*;

/**
 * test configuration
 */
@Configuration
@ComponentScan(basePackages = {"net.catenax.semantics.adapter", "net.catenax.semantics.framework"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern="net\\.catenax\\.semantics\\.framework\\.aas\\.api\\.proxy\\.AssetIdentifierApiController.*") })
public class AdapterConfiguration extends MockConfiguration {


}
