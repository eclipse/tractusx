/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.transformers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.semantics.framework.IdsMessage;
import net.catenax.semantics.framework.IdsRequest;
import net.catenax.semantics.framework.StatusException;
import net.catenax.semantics.framework.Transformer;
import org.springframework.stereotype.Service;
import net.catenax.semantics.framework.config.*;
import net.catenax.semantics.framework.*;
import java.util.Map;

/**
 * a default transformer that does not do anything
 * as long as the specifications fit.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class IdentityTransformer<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> implements Transformer {

    /**
     * needs a configuration
     */
    protected final Config<Cmd, O, Ct, Co,T> configuration;

    @Override
    public boolean canHandle(IdsMessage incoming, IdsRequest request, String targetModel) {
        boolean accepted="*/*".equals(request.getAccepts()) || request.getAccepts().contains(incoming.getMediaType());
        boolean sameSemantics=targetModel.equals(incoming.getModel());
        log.debug("identity transformation check wrt media type was "+accepted+" and wrt semantic model was"+sameSemantics);
        return accepted && sameSemantics;
    }

    @Override
    public IdsMessage transform(IdsMessage incoming, IdsRequest request, String targetModel) throws StatusException {
        BaseIdsMessage result=new BaseIdsMessage();
        result.setMediaType(incoming.getMediaType());
        result.setModel(incoming.getModel());
        String oldPayload=incoming.getPayload();
        for (Map.Entry<String, String> params : configuration.getTransformationParameters().entrySet()) {
            oldPayload=oldPayload.replace("${"+params.getKey()+"}",params.getValue());
        }
        result.setPayload(oldPayload);
        return result;
    }
}
