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

package net.catenax.semantics.hub.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.catenax.semantics.hub.model.Model;
import net.catenax.semantics.hub.model.NewModel;
import net.catenax.semantics.hub.persistence.model.ModelEntity;

@Mapper(componentModel = "spring")
public interface SemanticModelMapper {
    
    Model modelEntityToModelDto(ModelEntity model);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "version", target = "version")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "_private", target = "_private")
    @Mapping(source = "type", target = "type")
    List<Model> modelEntityListToModelDtoList(List<ModelEntity> model);

    @Mapping(source = "private", target = "_private")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "model", target = "modelDefinition")
    ModelEntity newModelToModelEntity(NewModel model);
}
