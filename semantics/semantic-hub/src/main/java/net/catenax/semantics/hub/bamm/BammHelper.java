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

package net.catenax.semantics.hub.bamm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.CharStreams;

import org.apache.jena.rdf.model.Model;
import org.springframework.stereotype.Component;

import io.openmanufacturing.sds.aspectmodel.generator.diagram.AspectModelDiagramGenerator;
import io.openmanufacturing.sds.aspectmodel.generator.diagram.AspectModelDiagramGenerator.Format;
import io.openmanufacturing.sds.aspectmodel.generator.docu.AspectModelDocumentationGenerator;
import io.openmanufacturing.sds.aspectmodel.generator.docu.AspectModelDocumentationGenerator.HtmlGenerationOption;
import io.openmanufacturing.sds.aspectmodel.generator.json.AspectModelJsonPayloadGenerator;
import io.openmanufacturing.sds.aspectmodel.generator.jsonschema.AspectModelJsonSchemaGenerator;
import io.openmanufacturing.sds.aspectmodel.generator.openapi.AspectModelOpenApiGenerator;
import io.openmanufacturing.sds.aspectmodel.resolver.AspectModelResolver;
import io.openmanufacturing.sds.aspectmodel.resolver.services.TurtleLoader;
import io.openmanufacturing.sds.aspectmodel.resolver.services.VersionedModel;
import io.openmanufacturing.sds.aspectmodel.urn.AspectModelUrn;
import io.openmanufacturing.sds.aspectmodel.validation.report.ValidationReport;
import io.openmanufacturing.sds.aspectmodel.validation.services.AspectModelValidator;
import io.openmanufacturing.sds.metamodel.Aspect;
import io.openmanufacturing.sds.metamodel.loader.AspectModelLoader;
import io.vavr.control.Try;

@Component
public class BammHelper {
    public Try<VersionedModel> loadBammModel(String ttl) {
        InputStream targetStream = new ByteArrayInputStream(ttl.getBytes());

        Try<Model> model = TurtleLoader.loadTurtle(targetStream);

        StaticResolutionStrategy resolutionStrategy = new StaticResolutionStrategy(model);


        AspectModelUrn startUrn = AspectModelUrn
            .fromUrn( "urn:bamm:net.catenax:1.0.0#Aspect" );

            
        AspectModelResolver resolver = new AspectModelResolver();

        Try<VersionedModel> versionedModel = resolver.resolveAspectModel(resolutionStrategy, startUrn);

        if(resolutionStrategy.getResolvementCounter() > 1) {
            return Try.failure(new ResolutionException("The definition must be self contained!"));
        }

        return versionedModel;
    }

    public Try<Aspect> getAspectFromVersionedModel(VersionedModel versionedModel) {

        return AspectModelLoader.fromVersionedModel(versionedModel);
    }

    public ValidationReport validateModel(Try<VersionedModel> model) {
        final AspectModelValidator validator = new AspectModelValidator();
        final ValidationReport validationReport = validator.validate(model);

        return validationReport;
    }

    public byte[] generatePng(VersionedModel versionedModel) {
        final AspectModelDiagramGenerator generator = new AspectModelDiagramGenerator(versionedModel);
            
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            generator.generateDiagram(Format.PNG, Locale.ENGLISH, output);

            final byte[] bytes = output.toByteArray();
            
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    public JsonNode getJsonSchema(Aspect aspect) {
        AspectModelJsonSchemaGenerator jsonSchemaGenerator = new AspectModelJsonSchemaGenerator();

        JsonNode json = jsonSchemaGenerator.apply(aspect);

        return json;
    }

    public Try<byte[]> getHtmlDocu(VersionedModel versionedModel) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        AspectModelDocumentationGenerator documentationGenerator = new AspectModelDocumentationGenerator(versionedModel);

        Map<AspectModelDocumentationGenerator.HtmlGenerationOption, String> options = new HashMap();

        try {
            InputStream ompCSS = getClass().getResourceAsStream("/catena-template.css");
            String defaultCSS = CharStreams.toString(new InputStreamReader(ompCSS));

            options.put(HtmlGenerationOption.STYLESHEET, defaultCSS);
        } catch (IOException e) {
            return Try.failure(e);
        }


        try {
            documentationGenerator.generate((String a) -> {
                return output;
            }, options);

            return Try.success(output.toByteArray());
        } catch (IOException e) {
            return Try.failure(e);
        }
    }

    public String getOpenApiDefinitionJson(Aspect aspect, String baseUrl) {
        AspectModelOpenApiGenerator openApiGenerator = new AspectModelOpenApiGenerator();

        JsonNode resultJson = openApiGenerator.applyForJson(aspect, true, baseUrl, Optional.empty(), Optional.empty(), false, Optional.empty());

        return resultJson.toString();
    }

    public Try<String> getExamplePayloadJson(Aspect aspect) {
        AspectModelJsonPayloadGenerator payloadGenerator = new AspectModelJsonPayloadGenerator(aspect);

        return Try.of(payloadGenerator::generateJson);
    }
}
