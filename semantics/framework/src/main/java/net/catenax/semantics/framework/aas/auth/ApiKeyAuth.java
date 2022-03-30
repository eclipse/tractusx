/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.aas.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ApiKeyAuth implements RequestInterceptor {
    private final String location;
    private final String paramName;

    private String apiKey;

    public ApiKeyAuth(String location, String paramName) {
        this.location = location;
        this.paramName = paramName;
    }

    public String getLocation() {
        return location;
    }

    public String getParamName() {
        return paramName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void apply(RequestTemplate template) {
        if ("query".equals(location)) {
            template.query(paramName, apiKey);
        } else if ("header".equals(location)) {
            template.header(paramName, apiKey);
        }
    }
}
