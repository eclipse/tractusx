/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * represents a (part) of a configuration file, such as a spring boot yml.
 */
@Data
public class ConfigurationData<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> implements Config<Cmd,O,Ct,Co,T> {
    private Security security;
    private String connectorType;
    private String connectorUrl;
    private String connectorId;
    private String serviceUrl;
    private String adapterUrl;
    private String portalUrl;
    private String connectorUser;
    private String connectorPassword;
    private String publisher;
    /**
     * determines the callback method to access artifacts
     */
    private String callbackPattern="%1$s/%2$s/download?offer=%3$s&representation=%4$s&artifact=%5$s";
    private String aasSchema="https://admin-shell.io/aas/API/AssetAdministrationShellDescriptor/1/0/RC02";
    private String serviceName = "adapter";
    private boolean offerOnStart=false;
    private boolean registerOnStart=false;

    private Map<String, Ct> catalogs = new HashMap<>();
    private Map<String, Co> contracts = new HashMap<>();
    private Map<String, O> offers=new HashMap<>();
    private Map<String, Cmd> commands=new HashMap<>();
    private Map<String,T> transformations=new HashMap<>();
    private Map<String,String> transformationParameters = new HashMap<>();
    private List<TwinSource> twinSources=new ArrayList<>();
}