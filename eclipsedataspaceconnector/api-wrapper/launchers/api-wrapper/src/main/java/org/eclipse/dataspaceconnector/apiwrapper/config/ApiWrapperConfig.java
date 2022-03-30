package org.eclipse.dataspaceconnector.apiwrapper.config;

import java.util.Collections;
import java.util.Map;

public class ApiWrapperConfig {

    private final String consumerEDCUrl;
    private final String consumerEdcApiKeyName;
    private final String consumerEdcApiKeyValue;
    private final Map<String, String> basicAuthUsers;

    public ApiWrapperConfig(String consumerEDCUrl, String consumerEdcApiKeyName, String consumerEdcApiKeyValue, Map<String, String> basicAuthUsers) {
        this.consumerEDCUrl = consumerEDCUrl;
        this.consumerEdcApiKeyName = consumerEdcApiKeyName;
        this.consumerEdcApiKeyValue = consumerEdcApiKeyValue;
        this.basicAuthUsers = basicAuthUsers;
    }

    public String getConsumerEDCUrl() {
        return consumerEDCUrl;
    }

    public String getConsumerEdcApiKeyName() {
        return consumerEdcApiKeyName;
    }

    public String getConsumerEdcApiKeyValue() {
        return consumerEdcApiKeyValue;
    }

    public Map<String, String> getBasicAuthUsers() {
        return basicAuthUsers;
    }

    public static final class Builder {
        private String consumerEdcUrl = null;
        private String consumerEdcApiKeyName = "X-Api-Key";
        private String consumerEdcApiKeyValue = "";
        private Map<String, String> basicAuthUsers = Collections.emptyMap();

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder consumerEdcUrl(String consumerEdcUrl) {
            this.consumerEdcUrl = consumerEdcUrl;
            return this;
        }

        public Builder consumerEdcApiKeyName(String consumerEdcApiKeyName) {
            this.consumerEdcApiKeyName = consumerEdcApiKeyName;
            return this;
        }

        public Builder consumerEdcApiKeyValue(String consumerEdcApiKeyValue) {
            this.consumerEdcApiKeyValue = consumerEdcApiKeyValue;
            return this;
        }

        public Builder basicAuthUsers(Map<String, String> basicAuthUsers) {
            this.basicAuthUsers = basicAuthUsers;
            return this;
        }

        public ApiWrapperConfig build() {
            return new ApiWrapperConfig(consumerEdcUrl, consumerEdcApiKeyName, consumerEdcApiKeyValue, basicAuthUsers);
        }
    }
}
