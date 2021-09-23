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

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.catenax.semantics.hub.api.ModelsApiDelegate;
import net.catenax.semantics.hub.model.Model;
import net.catenax.semantics.hub.model.Model.TypeEnum;
@Service
public class ModelsService implements ModelsApiDelegate {
    @Override
    public ResponseEntity<List<Model>> getModelList(String namespaceFilter,
        String nameFilter,
        Boolean isPublic,
        String type,
        Integer pageSize,
        Integer page) {

        Model exampleModel = new Model();
        exampleModel.setPublisher("ME");
        exampleModel.setId("1");
        exampleModel.setName("Aspect");
        exampleModel.setVersion("1.0.0");
        exampleModel.setPrivate(true);
        exampleModel.setType(TypeEnum.BAMM);
    

        ArrayList<Model> list = new ArrayList<>();

        list.add(exampleModel);
        
        return new ResponseEntity<List<Model>>(list, HttpStatus.OK);
    }
}
