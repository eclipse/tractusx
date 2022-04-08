package net.catenax.semantics;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Validated
@ConfigurationProperties(prefix = "registry")
public class RegistryProperties {

    private final Idm idm = new Idm();

    /**
     * Properties for Identity Management system
     */
    @Data
    @NotNull
    public static class Idm {
        /**
         * The public client id used for the redirect urls.
         */
        @NotEmpty(message = "public client id must not be empty")
        private String publicClientId;
    }
}
