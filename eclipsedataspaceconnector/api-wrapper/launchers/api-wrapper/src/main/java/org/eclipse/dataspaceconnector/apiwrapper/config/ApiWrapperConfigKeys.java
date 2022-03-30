package org.eclipse.dataspaceconnector.apiwrapper.config;

import org.eclipse.dataspaceconnector.spi.EdcSetting;

public final class ApiWrapperConfigKeys {

    @EdcSetting(required = true)
    public static final String CONSUMER_EDC_URL = "wrapper.consumer.edc.url";

    @EdcSetting
    public static final String CONSUMER_EDC_APIKEY_NAME = "wrapper.consumer.edc.apikey.name";

    @EdcSetting
    public static final String CONSUMER_EDC_APIKEY_VALUE = "wrapper.consumer.edc.apikey.value";

    @EdcSetting
    public static final String BASIC_AUTH = "wrapper.auth.basic";

    private ApiWrapperConfigKeys() {}
}
