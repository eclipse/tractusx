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

package net.catenax.semantics.hub;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.openmanufacturing.sds.aspectmodel.resolver.services.VersionedModel;
import io.openmanufacturing.sds.aspectmodel.validation.report.ValidationReport;
import io.openmanufacturing.sds.metamodel.Aspect;
import io.vavr.control.Try;
import net.catenax.semantics.hub.api.ModelsApiDelegate;
import net.catenax.semantics.hub.bamm.BammHelper;
import net.catenax.semantics.hub.model.Model;
import net.catenax.semantics.hub.model.NewModel;
import net.catenax.semantics.hub.persistence.PersistenceLayer;


@Service
public class ModelsService implements ModelsApiDelegate {
    @Autowired
    PersistenceLayer ps;

    @Autowired
    BammHelper bamm;

    @Override
    public ResponseEntity<List<Model>> getModelList(Integer pageSize, Integer page, String namespaceFilter,
            String nameFilter, Boolean isPrivate, String type) {

        List<Model> list = ps.getModels(isPrivate, namespaceFilter, nameFilter, type, page, pageSize);

        return new ResponseEntity<List<Model>>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Model> getModelById(String modelId) {
        Model model = ps.getModel(modelId);

        if (model == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Model>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Model> createModelWithId(NewModel newModel) {
        Try<VersionedModel> model = bamm.loadBammModel(newModel.getModel());

        if(model.isFailure()) {
            return new ResponseEntity(model.getCause().getMessage(), HttpStatus.BAD_REQUEST);
        }

        ValidationReport validation = bamm.validateModel(model);

        if(!validation.conforms()) {
            return new ResponseEntity(validation.getValidationErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        Try<Aspect> aspect = bamm.getAspectFromVersionedModel(model.get());

        if(aspect.isFailure()) {
            return new ResponseEntity(aspect.getCause().getMessage(), HttpStatus.BAD_REQUEST);
        }

        Aspect bammAspect = aspect.get();

        Model resultingModel = ps.insertNewModel(newModel, bammAspect.getAspectModelUrn().get().toString(), bammAspect.getAspectModelUrn().get().getVersion(), bammAspect.getName());

        return new ResponseEntity<>(resultingModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<org.springframework.core.io.Resource> getModelDiagram(String modelId) {
        Optional<String> modelDefinition = ps.getModelDefinition(modelId);

        if(!modelDefinition.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Try<VersionedModel> versionedModel = bamm.loadBammModel(modelDefinition.get());

        if(!versionedModel.isSuccess()) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        byte[] pngBytes = bamm.generatePng(versionedModel.get());
        
        if(pngBytes == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity(pngBytes, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> getModelJsonSchema(String modelId) {
        Optional<String> modelDefinition = ps.getModelDefinition(modelId);

        if(modelDefinition.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Try<VersionedModel> versionedModel = bamm.loadBammModel(modelDefinition.get());

        if(versionedModel.isFailure()) {
            return new ResponseEntity(versionedModel.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Try<Aspect> aspect = bamm.getAspectFromVersionedModel(versionedModel.get());

        if(aspect.isFailure()) {
            return new ResponseEntity(aspect.getCause().getMessage(), HttpStatus.BAD_REQUEST);
        }

        Aspect bammAspect = aspect.get();

        JsonNode json = bamm.getJsonSchema(bammAspect);

        return new ResponseEntity(json, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> getModelDocu(String modelId) {
        Optional<String> modelDefinition = ps.getModelDefinition(modelId);

        if(!modelDefinition.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Try<VersionedModel> versionedModel = bamm.loadBammModel(modelDefinition.get());

        if(versionedModel.isFailure()) {
            return new ResponseEntity(versionedModel.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Try<byte[]> docuResult = bamm.getHtmlDocu(versionedModel.get());
        if(docuResult.isFailure()) {
            return new ResponseEntity(docuResult.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity(docuResult.get(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> getModelFile(String modelId) {
        Optional<String> modelDefinition = ps.getModelDefinition(modelId);

        if(!modelDefinition.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(modelDefinition.get(), HttpStatus.OK);

    }
}
