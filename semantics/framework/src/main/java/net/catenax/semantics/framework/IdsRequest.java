/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework;

import lombok.Data;

import java.util.Map;
import java.util.Collection;

/**
 * a request that is internalized into the connector plane
 */
@Data
public class IdsRequest extends BaseIdsMessage implements IdsMessage {
    /**
     * which offer has been targetted
     */
    String offer;
    /**
     * which representation should be chosen
     */
    String representation;
    /**
     * which artifact is requested
     */
    String artifact;
    /**
     * an agreement/security token
     */
    Collection<String> securityToken;
    /**
     * the chain of calling connectors
     */
    String callingConnectors;
    /**
     * any assets with which the result of the request should be unioned
     */
    String unionArtifacts;
    /**
     * which data flow/backend should be called
     */
    String protocol;
    /**
     * the command to be called
     */
    String command;
    /**
     * additional parameters
     */
    Map<String,String> parameters;
    /**
     * which media types are accepted as a response
     */
    String accepts="";
}
