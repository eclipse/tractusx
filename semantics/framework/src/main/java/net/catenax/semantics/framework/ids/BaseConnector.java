package net.catenax.semantics.framework.ids;

import lombok.RequiredArgsConstructor;
import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class BaseConnector<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> implements IdsConnector {

    final protected Config<Cmd,O,Ct,Co, T> configurationData;
    final protected List<BackendAdapter> adapters;
    final protected List<Transformer> transformers;

    /**
     * sets the given error message into an accepted media type response
     * @param errorMessage
     * @param realResponse
     * @param accepts
     */
    protected void setError(String errorMessage,BaseIdsMessage realResponse, String accepts) {
        if(accepts!=null) {
            if (accepts.contains("text/xml")) {
                realResponse.setMediaType("text/xml");
                realResponse.setPayload("<Error>" + errorMessage + "</Error>");
            } else if (accepts.contains("applicaton/xml")) {
                realResponse.setMediaType("application/xml");
                realResponse.setPayload("<Error>" + errorMessage + "</Error>");
            } else if (accepts.contains("text/html")) {
                realResponse.setMediaType("text/html");
                realResponse.setPayload("<html><body><h1>Error</h1><p>" + errorMessage + "</p></body></html>");
            } else if (accepts.contains("application/json")) {
                realResponse.setMediaType("application/json");
                realResponse.setPayload("{ \"error\":\"" + errorMessage + "\" }");
            }
            return;
        }
    }

    /**
     * when the service start it may read its config
     * and automatically publish stuff
     */
    @PostConstruct
    public void setup() throws StatusException {
        if (configurationData.isRegisterOnStart()) {
            for(Map.Entry<String,O> offer : configurationData.getOffers().entrySet()) {
                getOrCreateOffer(offer.getKey());
            }
            for(Map.Entry<String,Co> contract: configurationData.getContracts().entrySet()) {
                getOrCreateContract(contract.getKey());
            }
        }
    }

    @Override
    public IdsResponse perform(IdsRequest request) {
        BaseIdsResponse response=new BaseIdsResponse();
        NowFutureIdsMessage future=new NowFutureIdsMessage();
        response.setMessage(future);
        BaseIdsMessage realResponse=new BaseIdsMessage();
        future.setMessage(realResponse);

        String protocol=request.getProtocol();
        String model=request.getModel();
        String accepts=request.getAccepts();

        String os = request.getOffer();
        if(os!=null) {
            Offer o = configurationData.getOffers().get(os);
            if (o == null) {
                response.setStatus(404);
                setError("Offer " + request.getOffer() + " not found", realResponse, request.getAccepts());
                return response;
            } else {
                Representation r = o.getRepresentations().
                        get(request.getRepresentation());
                if (r == null) {
                    response.setStatus(404);
                    setError("Representation " + request.getRepresentation() + " not found in offer " + request.getOffer(),
                            realResponse, request.getAccepts());
                    return response;
                } else {
                    model=r.getModel();
                    if(accepts!=null && !accepts.contains("*/*") && !accepts.contains(r.getMediaType())) {
                        response.setStatus(415);
                        setError("Mediatype "+r.getMediaType()+ "of representation " + request.getRepresentation() + " in offer " + request.getOffer(),
                                realResponse, request.getAccepts());
                        return response;
                    }
                    accepts=r.getMediaType();
                    Artifact a = r.getArtifacts().get(request.getArtifact());
                    if (a == null) {
                        response.setStatus(404);
                        setError("Artifact "+ request.getArtifact()+ " not found in representation " + request.getRepresentation() + " in offer " + request.getOffer(),
                                realResponse, request.getAccepts());
                        return response;
                    } else {
                        request.setCommand(a.getCommand());
                        protocol=a.getProtocol();
                    }
                }
            }
        }

        for(BackendAdapter backend : adapters) {
            if (backend.getProtocol().equals(protocol)) {
                try {
                    IdsMessage adapterResult = backend.perform(request,model);
                    for (Transformer transformer : transformers) {
                        if (transformer.canHandle(adapterResult, request, model)) {
                            future.setMessage(transformer.transform(adapterResult, request, model));
                            return response;
                        }
                    }
                    response.setStatus(415);
                    setError("Could not find a transformator from media type " + adapterResult.getMediaType() + " and model " + adapterResult.getModel() + " into media types " + request.getAccepts() + " and model " + model, realResponse, request.getAccepts());
                } catch (StatusException e) {
                    response.setStatus(e.getStatus());
                    setError(e.getMessage(), realResponse, request.getAccepts());
                }
                return response;
            }
        }
        response.setStatus(415);
        setError("Could not find an adapter for protocol "+request.getProtocol(),realResponse,request.getAccepts());
        return response;
    }

}
