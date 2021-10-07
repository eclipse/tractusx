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

package net.catenax.semantics.hub.persistence;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import net.catenax.semantics.hub.model.Model;
import net.catenax.semantics.hub.model.NewModel;
import net.catenax.semantics.hub.persistence.mapper.SemanticModelMapper;
import net.catenax.semantics.hub.persistence.model.ModelEntity;


@Component
public class RDBMSPersistence implements PersistenceLayer {
    @Autowired
    SemanticModelMapper mapper;

    @Autowired
    ModelRepository mr;

    @Override
    public List<Model> getModels(@Nullable Boolean isPrivate, String namespaceFilter, String nameFilter, @Nullable String type, int page, int pageSize) {
        Pageable pageOptions = PageRequest.of(page, pageSize);

        Page<ModelEntity> result = mr.filterModels(isPrivate, nameFilter, namespaceFilter, type, pageOptions);

        List<Model> modelList = mapper.modelEntityListToModelDtoList(result.toList());

        return modelList;
    }

    @Override
    public Model getModel(String modelId) {
        Optional<ModelEntity> result = mr.findById(modelId);

        if(!result.isPresent()) {
            return null;
        }

        Model model = mapper.modelEntityToModelDto(result.get());
        return model;
    }

    @Override
    public Optional<String> getModelDefinition(String modelId) {
        Optional<ModelEntity> result = mr.findById(modelId);

        if(!result.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(result.get().getModelDefinition());
    }

    @Override 
    public Model insertNewModel(NewModel newModel, String id, String version, String name) {
        ModelEntity modelEntity = mapper.newModelToModelEntity(newModel);
        modelEntity.setId(id);
        modelEntity.setName(name);
        modelEntity.setVersion(version);

        mr.save(modelEntity);
        mr.flush();

        return mapper.modelEntityToModelDto(modelEntity);
    }
}
