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
package net.catenax.semantics.registry.model.support;

import org.springframework.dao.DuplicateKeyException;

import java.util.Locale;
import java.util.regex.Pattern;

public class DatabaseExceptionTranslation {

    private static final String DEFAULT_DUPLICATE_KEY_MESSAGE = "An entity for the given id does already exist.";

    private static final Pattern SUBMODEL = Pattern.compile("(SUBMODEL_SHELL_AK_01)|(ON.*SUBMODEL)");
    private static final Pattern SHELL = Pattern.compile("(SHELL_AK_01)|(ON.*SHELL)");

    public static String translate(DuplicateKeyException exception){
        String message = exception.getMessage();
        if(message == null ){
            return DEFAULT_DUPLICATE_KEY_MESSAGE;
        }

        String upperCaseMessage=message.toUpperCase();

        if(SUBMODEL.matcher(upperCaseMessage).find()) {
            return "A SubmodelDescriptor with the given identification does already exists for this AssetAdministrationShell.";
        }

        if(SHELL.matcher(upperCaseMessage).find()) {
            return "An AssetAdministrationShell for the given identification does already exists.";
        }

        return DEFAULT_DUPLICATE_KEY_MESSAGE;
    }
}
