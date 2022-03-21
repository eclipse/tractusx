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
package net.catenax.semantics.registry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catenax.semantics.aas.registry.model.IdentifierKeyValuePair;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This converter is required so that Spring is able to convert query parameters to custom objects.
 */
@Component
public class IdentifierKeyValuePairConverter implements Converter<String, List<IdentifierKeyValuePair>> {

    private final ObjectMapper objectMapper;

    IdentifierKeyValuePairConverter(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public List<IdentifierKeyValuePair> convert(String source) {
        try {
            String processedSource = removeLineBreaks(source);
            return objectMapper.readValue(processedSource, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * SwaggerUI does weired encoding for user added items.
     * This method that SwaggerUI requests for lookups work.
     */
    private static String removeLineBreaks(String source){
        return StringEscapeUtils
                .unescapeJava(source).replace("\n", "").replace("\r", "")
                .replace("\"{", "{")
                .replace("}\"", "}");
    }
}
