/*
 * Copyright (c) 2022 Robert Bosch Manufacturing Solutions GmbH
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

package net.catenax.semantics.hub;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.jena.fuseki.main.FusekiServer;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdfconnection.RDFConnectionRemote;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

import net.catenax.semantics.hub.bamm.BammHelper;
import net.catenax.semantics.hub.persistence.PersistenceLayer;
import net.catenax.semantics.hub.persistence.triplestore.SdsSdk;
import net.catenax.semantics.hub.persistence.triplestore.TripleStorePersistence;

@Configuration
@EnableConfigurationProperties( TripleStoreProperties.class )
public class TripleStoreConfiguration {

   @Bean
   public AspectModelService aspectModelService( final PersistenceLayer persistenceLayer ) {
      return new AspectModelService( persistenceLayer, new BammHelper() );
   }

   @Bean
   public PersistenceLayer tripleStorePersistence( final RDFConnectionRemoteBuilder rdfConnectionRemoteBuilder ) {
      return new TripleStorePersistence( rdfConnectionRemoteBuilder, new SdsSdk() );
   }

   /**
    * Embedded Fuseki triple store for local dev and tests.
    */
   @ConditionalOnProperty( prefix = "hub.triple-store.embedded", name = "enabled", havingValue = "true",
                           matchIfMissing = false )
   @Bean( destroyMethod = "stop" )
   public FusekiServer fusekiServer( final TripleStoreProperties properties ) {
      final TripleStoreProperties.EmbeddedTripleStore embedded = properties.getEmbedded();
      return FusekiServer.create().port( embedded.getPort() )
                         .add( embedded.getDefaultDataset(), DatasetFactory.create() )
                         .verbose( true )
                         .contextPath( embedded.getContextPath() )
                         .enableStats( true )
                         .enableCors( true )
                         .build().start();
   }

   @Bean
   public RDFConnectionRemoteBuilder rdfConnectionBuilder( final TripleStoreProperties properties ) {
      if ( properties.getEmbedded().isEnabled() ) {
         return RDFConnectionRemote.create().destination( localDestination( properties.getEmbedded() ) );
      }
      Credentials credentials = new UsernamePasswordCredentials( properties.getUsername(), properties.getPassword() );
      BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
      credentialsProvider.setCredentials( AuthScope.ANY, credentials );
      return RDFConnectionRemote
            .create()
            .httpClient( HttpClients.custom().setDefaultCredentialsProvider( credentialsProvider ).build() )
            .destination( properties.getBaseUrl().toString() )
            .queryEndpoint( properties.getQueryEndpoint() )
            .updateEndpoint( properties.getUpdateEndpoint() );
   }

   private static String localDestination( final TripleStoreProperties.EmbeddedTripleStore embedded ) {
      final int port = embedded.getPort() == 0 ? SocketUtils.findAvailableTcpPort() : embedded.getPort();
      return "http://localhost:" + port + embedded.getContextPath() + embedded.getDefaultDataset();
   }
}
