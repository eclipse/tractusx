/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * A Spring Web Interceptor to save all authorization tokens for routing to delegation
 */
@RequiredArgsConstructor
public class TokenIncomingInterceptor implements AsyncHandlerInterceptor {

    private final TokenWrapper tokenWrapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        ArrayList<String> tokenList=new ArrayList();
        for(Enumeration<String> tokens=request.getHeaders(TokenWrapper.AUTHORIZATION_HEADER);tokens.hasMoreElements();) {
            tokenList.add(tokens.nextElement());
        }
        tokenWrapper.setToken(tokenList);
        return true;
    }
}