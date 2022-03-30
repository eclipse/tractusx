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

import org.springframework.core.convert.converter.Converter;
import net.catenax.semantics.aas.registry.model.IdentifierKeyValuePair;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * This converter is required so that Spring is able to convert array-style query parameters to custom objects.
 */
@Component
@RequiredArgsConstructor
public class IdentifierKeyValuePairArrayConverter implements Converter<String[], List<IdentifierKeyValuePair>> {

    private final IdentifierKeyValuePairConverter singleConverter;

    @Override
    public List<IdentifierKeyValuePair> convert(String[] source) {
        List<IdentifierKeyValuePair> result = new ArrayList<>(source.length);
        for (int count = 0; count < source.length; count++) {
            result.addAll(singleConverter.convert(source[count]));
        }
        return result;
    }
}
