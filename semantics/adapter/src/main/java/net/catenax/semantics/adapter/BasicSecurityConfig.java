/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.List;
import java.util.Map;

/**
 * Basic authentication and authorization scheme
 */
@Profile("basic")
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    protected final ConfigurationData config;

    @Override
    public void configure(WebSecurity web) {
        web.debug(config.getSecurity().isDebug());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests((authorize) -> {
                            authorize
                                    .antMatchers(HttpMethod.OPTIONS).permitAll();
                            for (Map.Entry<String, List<String>> filter : config.getSecurity().getFilters().entrySet()) {
                                var matcher = authorize.regexMatchers(filter.getKey());
                                List<String> roles=filter.getValue();
                                if(roles.contains("ANONYMOUS")) {
                                    matcher.permitAll();
                                } else if(roles.contains("AUTHENTICATED")) {
                                    matcher.authenticated();
                                } else {
                                    matcher.hasAnyRole(roles.toArray(new String[]{}));
                                }
                            }
                        });
        httpSecurity.httpBasic(withDefaults());
        httpSecurity.csrf().disable();
    }

    /**
     * Bean setting up an default admin.
     *
     * @return The password encoder.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();
        config.getSecurity().getUsers().entrySet().forEach( userSpec -> {
            var user= User.withDefaultPasswordEncoder();
            user=user.username(userSpec.getKey());
            user=user.password(userSpec.getValue().getPassword());
            user=user.roles(userSpec.getValue().getRoles().toArray(new String[]{}));
            manager.createUser(user.build());
        });
        return manager;
    }
}
