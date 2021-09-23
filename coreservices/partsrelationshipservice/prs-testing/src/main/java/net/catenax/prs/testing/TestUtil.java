//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.testing;

import org.springframework.test.context.TestPropertySource;

/**
 * Utilities and constants for tests.
 */
public class TestUtil {
    /**
     * A {@link TestPropertySource} to load a PostgreSQL test container.
     *
     * @see <a href="https://www.testcontainers.org">https://www.testcontainers.org</a>
     */
    public static final String DATABASE_TESTCONTAINER = "spring.datasource.url=jdbc:tc:postgresql:11.13-alpine:///prs";
}
