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

package net.catenax.semantics;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenAPIDocumentationConfig {

   ApiInfo apiInfo() {
      return new ApiInfoBuilder()
            .title( "Semantics Layer APIs" )
            .description(
                  "The API of the Semantics Layer Services." )
            .license( "" )
            .licenseUrl( "http://unlicense.org" )
            .termsOfServiceUrl( "" )
            .version( "0.0.1" )
            .contact( new Contact( "", "", "" ) )
            .build();
   }

   @Bean
   public Docket customImplementation(
         final ServletContext servletContext,
         @Value( "${openapi.semantics-layer.base-path:}" ) final String basePath ) {
      return new Docket( DocumentationType.SWAGGER_2 )
            .select()
            .apis( RequestHandlerSelectors.basePackage( "net.catenax.semantics" ) )
            .build()
            .pathProvider( new BasePathAwareRelativePathProvider( servletContext, basePath ) )
            .directModelSubstitute( java.time.LocalDate.class, java.sql.Date.class )
            .directModelSubstitute( java.time.OffsetDateTime.class, java.util.Date.class )
            .apiInfo( apiInfo() );
   }

   class BasePathAwareRelativePathProvider extends RelativePathProvider {
      private final String basePath;

      public BasePathAwareRelativePathProvider( final ServletContext servletContext, final String basePath ) {
         super( servletContext );
         this.basePath = basePath;
      }

      @Override
      protected String applicationPath() {
         return Paths.removeAdjacentForwardSlashes(
               UriComponentsBuilder.fromPath( super.applicationPath() ).path( basePath ).build().toString() );
      }

      @Override
      public String getOperationPath( final String operationPath ) {
         final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath( "/" );
         return Paths.removeAdjacentForwardSlashes(
               uriComponentsBuilder.path( operationPath.replaceFirst( "^" + basePath, "" ) ).build().toString() );
      }
   }
}