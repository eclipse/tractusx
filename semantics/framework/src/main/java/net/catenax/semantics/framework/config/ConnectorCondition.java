/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import org.springframework.context.annotation.ConditionContext;

/**
 * use this code to implement connector-specific conditions
 */
public class ConnectorCondition {

    public static String DEFAULT_IDS_CONNECTOR_TYPE = "dsc";
    public static String CONNECTOR_TYPE_PROPERTY = "idsadapter.connectorType";

    public static String getConnectorType(ConditionContext context) {
        String res=context.getEnvironment().getProperty(CONNECTOR_TYPE_PROPERTY,DEFAULT_IDS_CONNECTOR_TYPE);
        return res;
    }

}
