/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import java.io.*;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ExecutionException;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import org.springframework.stereotype.Service;

/**
 * this class maybe used to implement simple
 * data read APIs e.g. through a REST controller
 */
@Service
public class DownloadAdapter<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> extends BaseAdapter<Cmd,O,Ct,Co,T> {

    /**
     * delegate to super
     * @param configurationData to start with
     * @param connector to start with
     */
    public DownloadAdapter(Config<Cmd,O,Ct,Co,T> configurationData, IdsConnector connector) {
        super(configurationData);
        setIdsConnector(connector);
    }

    /**
     * downloads an xml-based source (file, statement, whatever)
     * @param method user to process download
     * @param response the outputstream to put the resource into
     * @param mediaType media type requested
     * @param params request parameters
     * @return the resulting media type of the data written to the response stream
     */
    public String download(String method, OutputStream response, String mediaType, Map<String,String> params) throws StatusException {
        IdsRequest request=new IdsRequest();
        request.setProtocol("HTTP");
        request.setCommand(method);
        request.setParameters(params);

        if(params.containsKey("protocol")) {
            request.setProtocol(params.get("protocol"));
        }
        if(params.containsKey("command")) {
            request.setCommand(params.get("command"));
        }
        if(params.containsKey("model")) {
            request.setModel(params.get("model"));
        }

        request.setAccepts(mediaType);
        request.setOffer(params.get("offer"));
        request.setRepresentation(params.get("representation"));
        request.setArtifact(params.get("artifact"));
        if(params.containsKey("catenax-agreement-token")) {
            request.setSecurityToken(List.of(params.get("catenax-agreement-token")));
        }
        request.setCallingConnectors(params.get("catenax-calling-connectors"));
        IdsResponse idsResponse= idsConnector.perform(request);

        try {
            IdsMessage responseMessage = idsResponse.getMessage().get();
            mediaType=responseMessage.getMediaType();
            if(responseMessage.getPayload()!=null) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response))) {
                    writer.write(responseMessage.getPayload());
                } catch (IOException e) {
                    throw new StatusException("Could not synchronize on IDS", e, 500);
                }
            }
        } catch(InterruptedException | ExecutionException e) {
            throw new StatusException("Could not synchronize on IDS",e,409);
        }

        return mediaType;
    }

}
