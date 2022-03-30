/*
Copyright (c) 2021-2022 T-Systems International GmbH
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.edc;

import net.catenax.semantics.framework.config.ConnectorCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * A spring configuration condition that
 * evaluates the usage of the EDC ids connector
 */
@Configuration
public class EdcConfigurationCondition implements Condition {

    public static String EDC_IDS_CONNECTOR_TYPE = "edc";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return EDC_IDS_CONNECTOR_TYPE.equals(ConnectorCondition.getConnectorType(context));
    }
}
