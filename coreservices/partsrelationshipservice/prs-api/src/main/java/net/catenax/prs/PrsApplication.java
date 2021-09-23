//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Application entry point.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class PrsApplication {

    /** The PRS API version. */
    public static final String API_VERSION = "v0.1";

    /** The URL prefix for PRS API URLs. */
    public static final String API_PREFIX = "api/" + API_VERSION;

    /**
     * Entry point.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(PrsApplication.class, args);
    }

}
