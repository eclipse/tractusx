/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.dsc;

import net.catenax.semantics.framework.config.ConnectorCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * A spring configuration condition that
 * evaluates the usage of the fraunhofer ids connector and
 * provides a framework for further connector types
 */
@Configuration
@Import({HttpClientConfiguration.class})
public class DscConfigurationCondition implements Condition {

    public static String FH_IDS_CONNECTOR_TYPE = "dsc";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean cond=FH_IDS_CONNECTOR_TYPE.equals(ConnectorCondition.getConnectorType(context));
        return cond;
    }
}