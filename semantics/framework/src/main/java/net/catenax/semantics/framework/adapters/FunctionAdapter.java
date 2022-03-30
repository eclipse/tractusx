/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * An adapter wrapping an java function
 * @param <Cmd>
 * @param <O>
 * @param <Ct>
 * @param <Co>
 * @param <T>
 */
@Service
public class FunctionAdapter<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation>
        extends BaseAdapter<Cmd,O,Ct,Co,T> implements BackendAdapter {

    private final ObjectMapper mapper;

    @Override
    public String getProtocol() {
        return "FUNCTION";
    }

    public FunctionAdapter(Config<Cmd,O,Ct,Co,T> configurationData, ObjectMapper mapper) {
        super(configurationData);
        this.mapper=mapper;
    }

    @Override
    public IdsMessage perform(IdsRequest request, String model) throws StatusException {
        BaseIdsMessage response = new BaseIdsMessage();
        response.setMediaType("application/json");
        String functionTarget=request.getCommand();
        if(functionTarget.indexOf("#")<0) {
            throw new StatusException("Not a correct function command specification.",501);
        }
        String methodName=functionTarget.substring(functionTarget.indexOf("#")+1);
        String className=functionTarget.substring(0,functionTarget.length()-methodName.length()-1);
        try {
            Class function=getClass().getClassLoader().loadClass(className);
            for(Method method: function.getDeclaredMethods()) {
                if (methodName.equals(method.getName()) && method.getParameters().length == 1) {
                    try {
                        Object instance = function.getDeclaredConstructor().newInstance();
                        Object argument = mapper.readValue(request.getPayload(), method.getParameters()[0].getType());
                        Object result = method.invoke(instance, argument);
                        response.setPayload(mapper.writeValueAsString(result));
                        response.setModel(model);
                        return response;
                    } catch(JsonProcessingException e) {
                    }
                }
            }
        } catch(ClassNotFoundException e) {
            throw new StatusException("Invalid function class",501);
        } catch(NoSuchMethodException e) {
            throw new StatusException("Function class cannot be constructed",501);
        } catch(InvocationTargetException e) {
            throw new StatusException("Function did produce an error.",501);
        } catch(InstantiationException e) {
            throw new StatusException("Function could not be instaniated",501);
        } catch(IllegalAccessException e) {
            throw new StatusException("Function not accessible",501);
        }
        throw new StatusException("No suitable function/method found",501);
    }

}
