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
package net.catenax.semantics.registry.mapper;

import com.google.common.base.Strings;
import net.catenax.semantics.aas.registry.model.AssetAdministrationShellDescriptor;
import net.catenax.semantics.aas.registry.model.IdentifierKeyValuePair;
import net.catenax.semantics.aas.registry.model.Reference;
import net.catenax.semantics.registry.model.Shell;
import net.catenax.semantics.registry.model.ShellIdentifier;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The globalAssetId of a AssetAdministrationShellDescriptor is the same as specificAssetIds from persistence point of view.
 * This class is responsible to map the globalAssetId to {@code ShellIdentifier} and in reverse order back to the API object.
 *
 */
public class ShellMapperCustomization {

    public static Shell globalAssetIdToShellIdentifier(AssetAdministrationShellDescriptor apiDto, Shell shell){
        Optional<ShellIdentifier> shellIdentifierOptional = extractGlobalAssetId(apiDto.getGlobalAssetId());
        if(shellIdentifierOptional.isEmpty()) {
            return shell;
        }
        ShellIdentifier shellIdentifier = shellIdentifierOptional.get();
        if(shell.getIdentifiers() == null){
            return shell.withIdentifiers(Set.of(shellIdentifier));
        }
        return shell.withIdentifiers( new HashSet<>(){{
            addAll( shell.getIdentifiers());
            add(shellIdentifier);
        }});
    }

    public static void shellIdentifierToGlobalAssetId(Shell shell, AssetAdministrationShellDescriptor apiDto) {
        Optional<Reference> globalAssetId = extractGlobalAssetId(shell.getIdentifiers());
        // there are no immutable objects for the generated ones, mapping to api objects is done in mutable way
        globalAssetId.ifPresent(apiDto::setGlobalAssetId);
    }

    public static void removeGlobalAssetIdIdentifier(Set<ShellIdentifier> shellIds, List<IdentifierKeyValuePair> apiDto){
        ShellIdentifier[] sis=shellIds.toArray(new ShellIdentifier[0]);
        for(int count=apiDto.size()-1;count>=0;count--) {
            IdentifierKeyValuePair kvp=apiDto.get(count);
            ShellIdentifier shellId=sis[count];
            if(shellId.isUnique() || ShellIdentifier.GLOBAL_ASSET_ID_KEY.equals(shellId.getKey())) {
                apiDto.remove(count);
            }
        }
    }

    private static Optional<Reference> extractGlobalAssetId(Set<ShellIdentifier> shellIdentifiers){
        if(shellIdentifiers == null || shellIdentifiers.isEmpty()){
            return Optional.empty();
        }
        Optional<String> globalAssetId = shellIdentifiers
                .stream()
                .filter(shellIdentifier -> shellIdentifier.isUnique() || ShellIdentifier.GLOBAL_ASSET_ID_KEY.equals(shellIdentifier.getKey()))
                .map(shellIdentifier -> {
                   if(ShellIdentifier.GLOBAL_ASSET_ID_KEY.equals(shellIdentifier.getKey())) {
                       return shellIdentifier.getValue();
                   }
                   return shellIdentifier.getKey()+shellIdentifier.getValue();
                }).findFirst();
        return globalAssetId.map(value -> {
            Reference reference = new Reference();
            reference.setValue(List.of(globalAssetId.get()));
            return reference;
        });
    }

    private static Optional<ShellIdentifier> extractGlobalAssetId(Reference globalAssetIdReference){
        if (globalAssetIdReference == null) {
            return Optional.empty();
        }
        List<String> value = globalAssetIdReference.getValue();
        if(value == null || value.isEmpty()){
            return Optional.empty();
        }
        String globalAssetId = value.get(0);
        if(Strings.isNullOrEmpty(globalAssetId)){
            return Optional.empty();
        }
        String namespace=ShellIdentifier.GLOBAL_ASSET_ID_KEY;
        if(globalAssetId.contains("#")) {
            int lastIndex=globalAssetId.lastIndexOf("#")+1;
            namespace=globalAssetId.substring(0,lastIndex);
            globalAssetId=globalAssetId.substring(lastIndex);
        }
        return Optional.of(new ShellIdentifier(null, namespace, globalAssetId, true,null));
    }

}
