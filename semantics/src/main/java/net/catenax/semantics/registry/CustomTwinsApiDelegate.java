/*
 * Copyright (c) 2021 Robert Bosch Manufacturing Solutions GmbH
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.catenax.semantics.registry.api.TwinsApiDelegate;
import net.catenax.semantics.registry.model.Aspect;
import net.catenax.semantics.registry.model.AspectCreate;
import net.catenax.semantics.registry.model.DigitalTwin;
import net.catenax.semantics.registry.model.DigitalTwinCollection;
import net.catenax.semantics.registry.model.DigitalTwinCreate;
import net.catenax.semantics.registry.model.HttpEndpoint;
import net.catenax.semantics.registry.model.HttpEndpointCreate;
import net.catenax.semantics.registry.model.LocalIdentifier;
import net.catenax.semantics.registry.model.LocalIdentifierCreate;

@Service
public class CustomTwinsApiDelegate implements TwinsApiDelegate {
   private final Map<String, DigitalTwin> digitalTwins = new ConcurrentHashMap<>();

   @Override
   public ResponseEntity<DigitalTwin> getTwinById( final String twinId ) {
      final var digitalTwin = digitalTwins.get( twinId );
      if ( null == digitalTwin ) {
         return ResponseEntity.notFound().build();
      }
      return new ResponseEntity<>( digitalTwin, HttpStatus.OK );
   }

   @Override
   public ResponseEntity<DigitalTwin> createTwin( final DigitalTwinCreate digitalTwinCreate ) {
      final var digitalTwin = toDigitalTwin( digitalTwinCreate );
      digitalTwins.put( digitalTwin.getId(), digitalTwin );
      return new ResponseEntity<>( digitalTwin, HttpStatus.OK );
   }

   @Override
   public ResponseEntity<Void> deleteTwinById( final String twinId ) {
      final var digitalTwin = digitalTwins.remove( twinId );
      if ( null == digitalTwin ) {
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.noContent().build();
   }

   @Override
   public ResponseEntity<DigitalTwinCollection> getTwinByQuery( final String key, final String value ) {
      final var twins = new ArrayList<>( digitalTwins.values() );

      if ( null == key || value == null ) {
         return new ResponseEntity<>( toDigitalTwinCollection( twins ), HttpStatus.OK );
      }
      final var twinsfilteredByLocalId = digitalTwins
            .values().stream()
            .filter( twin -> twin.getLocalIdentifiers()
                                 .stream()
                                 .anyMatch( id -> id.getKey().equals( key ) && id.getValue().equals( value ) )
            ).collect( Collectors.toList() );
      return new ResponseEntity<>( toDigitalTwinCollection( twinsfilteredByLocalId ), HttpStatus.OK );
   }

   private static DigitalTwinCollection toDigitalTwinCollection( final List<DigitalTwin> twins ) {
      return new DigitalTwinCollection()
            .items( twins )
            .itemCount( twins.size() )
            .currentPage( 0 )
            .totalPages( 0 )
            .totalItems( twins.size() );
   }

   private static DigitalTwin toDigitalTwin( final DigitalTwinCreate digitalTwinCreate ) {
      final var digitalTwin = new DigitalTwin();
      digitalTwin.id( uuid() );
      digitalTwin.aspects( toAspects( digitalTwinCreate.getAspects() ) );
      digitalTwin.setDescription( digitalTwinCreate.getDescription() );
      digitalTwin.setManufacturer( digitalTwinCreate.getManufacturer() );
      digitalTwin.setLocalIdentifiers( toLocalIdentifiers( digitalTwinCreate.getLocalIdentifiers() ) );
      return digitalTwin;
   }

   private static String uuid() {
      return UUID.randomUUID().toString();
   }

   private static List<LocalIdentifier> toLocalIdentifiers( final List<LocalIdentifierCreate> identifiersCreate ) {
      return identifiersCreate.stream()
                              .map( li -> new LocalIdentifier()
                                    .key( li.getKey() )
                                    .value( li.getValue() ) )
                              .collect( Collectors.toList() );
   }

   private static List<Aspect> toAspects( final List<AspectCreate> aspectsCreate ) {
      return aspectsCreate
            .stream()
            .map( as -> new Aspect().id( uuid() )
                                    .modelReference( as.getModelReference() )
                                    .httpEndpoints( toHttpEndpoints( as.getHttpEndpoints() ) ) )
            .collect( Collectors.toList() );
   }

   private static List<HttpEndpoint> toHttpEndpoints( final List<HttpEndpointCreate> httpEndpointsCreate ) {
      return httpEndpointsCreate.stream()
                                .map( ec -> new HttpEndpoint().id( uuid() )
                                                              .url( ec.getUrl() )
                                                              .method( ec.getMethod() ) )
                                .collect( Collectors.toList() );
   }
}
