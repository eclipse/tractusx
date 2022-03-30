/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.adapter.test;

import net.catenax.semantics.framework.IdsConnector;
import net.catenax.semantics.framework.config.*;
import net.catenax.semantics.framework.dsc.DsConnector;
import net.catenax.semantics.framework.edc.EdcService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests setting up a default adapter wo special config
 */
@SpringBootTest
@ContextConfiguration(classes = { AdapterConfiguration.class })
class AdapterConfigurationTest {


	/**
	 * the actual test code is rather small ;-)
	 * @param context created spring context
	 */
	@Test
	public void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
		assertThat(context.getBean(IdsConnector.class)).isNotNull();
		assertThat(context.getBean(IdsConnector.class).getClass()).isEqualTo(DsConnector.class);
	}

}

