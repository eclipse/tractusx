/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.proxy;

import feign.Client;
import feign.Feign;
import lombok.Data;
import net.catenax.semantics.framework.aas.api.RegistryAndDiscoveryInterfaceApi;
import net.catenax.semantics.framework.auth.TokenIncomingInterceptor;
import net.catenax.semantics.framework.auth.TokenOutgoingInterceptor;
import net.catenax.semantics.framework.auth.TokenWrapper;
import net.catenax.semantics.framework.aas.ApiClient;
import net.catenax.semantics.framework.helpers.NaiveSSLSocketFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Main AAS Proxy Application
 * TODO make sure openapi description is correct, referrer-header should give us a hint.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"net.catenax.semantics.framework.aas","net.catenax.semantics.aas","net.catenax.semantics.framework.auth", "org.openapitools.configuration"},
        excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="net\\.catenax\\.semantics\\.framework\\.aas\\.api\\.server\\.AssetIdentifierApiController"))
//@ImportResource({"classpath*:saynomore.lmx"})
@Data
public class Application {

    /**
     * enable ubiquitous CORS when accessed locally
     * @return a webmvc configurer which enables CORS
     */
    @Bean
    public WebMvcConfigurer configurer(ApplicationContext context) {
        TokenIncomingInterceptor interceptor=context.getBean(TokenIncomingInterceptor.class);

        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(interceptor);
            }
        };
    }

    @Bean
    public TokenIncomingInterceptor bearerTokenIncomingInterceptor(ApplicationContext context) {
        return new TokenIncomingInterceptor(context.getBean(TokenWrapper.class));
    }

    @Bean
    public TokenOutgoingInterceptor bearerTokenOutgoingInterceptor(ApplicationContext context) {
        return new TokenOutgoingInterceptor(context.getBean(TokenWrapper.class));
    }

    @Bean
    @ConfigurationProperties(prefix="aasproxy")
    public ConfigurationData getConfiguration() {
        return new ConfigurationData();
    }

    @Bean
    public RegistryAndDiscoveryInterfaceApi remoteRegistry(ApplicationContext context)  {
        Feign.Builder builder=context.getBean(Feign.Builder.class);
        ConfigurationData config=context.getBean(ConfigurationData.class);
        return builder.target(RegistryAndDiscoveryInterfaceApi.class,config.getRegistryUrl());
    }

    @Bean
    public Feign.Builder feignBuilder(ApplicationContext context) throws NoSuchAlgorithmException, KeyManagementException {
        ConfigurationData config=context.getBean(ConfigurationData.class);
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(config.getRegistryUrl());
        NaiveSSLSocketFactory naiveSSLSocketFactory = new NaiveSSLSocketFactory("localhost");

        Client client=null;

        String proxyHost=System.getProperty("http.proxyHost");

        if(proxyHost!=null && !proxyHost.isEmpty()) {
            boolean noProxy = false;
            for (String noProxyHost : System.getProperty("http.nonProxyHosts","localhost").split("\\|")) {
                noProxy = noProxy || config.getRegistryUrl().contains(noProxyHost.replace("*",""));
            }
            if (!noProxy) {
                client = new Client.Proxied(naiveSSLSocketFactory, null, new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress(proxyHost, Integer.parseInt(System.getProperty("http.proxyPort","80")))));
            }
        }

        if(client==null) {
            client = new Client.Default(naiveSSLSocketFactory,null);
        }
        Feign.Builder feignBuilder = apiClient.getFeignBuilder();
        TokenOutgoingInterceptor interceptor=context.getBean(TokenOutgoingInterceptor.class);
        feignBuilder.client(client)
                .requestInterceptor(interceptor);
        return feignBuilder;
    }

    /**
     * entry point if started as an app
     * @param args command line
     */
    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

}
