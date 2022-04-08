/*
 * Copyright (c) 2021-2022 Robert Bosch Manufacturing Solutions GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.catenax.semantics.registry;

import com.nimbusds.jose.shaded.json.JSONArray;
import net.catenax.semantics.AuthorizationEvaluator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;

public class JwtTokenFactory {

    private String publicClientId;

    public JwtTokenFactory(String publicClientId){
        this.publicClientId = publicClientId;
    }

    private RequestPostProcessor authenticationWithRoles(String ... roles){
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("sub", "user")
                .claim("resource_access", Map.of(publicClientId, Map.of("roles", toJsonArray(roles) )))
                .build();
        Collection<GrantedAuthority> authorities = Collections.emptyList();
        return authentication(new JwtAuthenticationToken(jwt, authorities));
    }

    private static JSONArray toJsonArray(String ... elements){
        JSONArray jsonArray = new JSONArray();
        for (String element : elements){
            jsonArray.appendElement(element);
        }
        return jsonArray;
    }



    public RequestPostProcessor allRoles(){
        return authenticationWithRoles(
                AuthorizationEvaluator.Roles.ROLE_VIEW_DIGITAL_TWIN,
                AuthorizationEvaluator.Roles.ROLE_ADD_DIGITAL_TWIN,
                AuthorizationEvaluator.Roles.ROLE_UPDATE_DIGITAL_TWIN,
                AuthorizationEvaluator.Roles.ROLE_DELETE_DIGITAL_TWIN
        );
    }

    public RequestPostProcessor readTwin(){
        return authenticationWithRoles(AuthorizationEvaluator.Roles.ROLE_VIEW_DIGITAL_TWIN);
    }

    public RequestPostProcessor addTwin(){
        return authenticationWithRoles(AuthorizationEvaluator.Roles.ROLE_ADD_DIGITAL_TWIN);
    }

    public RequestPostProcessor updateTwin(){
        return authenticationWithRoles(AuthorizationEvaluator.Roles.ROLE_UPDATE_DIGITAL_TWIN);
    }

    public RequestPostProcessor deleteTwin(){
        return authenticationWithRoles(AuthorizationEvaluator.Roles.ROLE_DELETE_DIGITAL_TWIN);
    }

    public RequestPostProcessor withoutResourceAccess(){
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("sub", "user")
                .build();
        Collection<GrantedAuthority> authorities = Collections.emptyList();
        return authentication(new JwtAuthenticationToken(jwt, authorities));
    }

    public RequestPostProcessor withoutRoles(){
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("sub", "user")
                .claim("resource_access", Map.of(publicClientId, new HashMap<String, String>()))
                .build();
        Collection<GrantedAuthority> authorities = Collections.emptyList();
        return authentication(new JwtAuthenticationToken(jwt, authorities));
    }

}
