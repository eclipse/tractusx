//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.testing;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

/**
 * Utility class for managing {@link Validator}s.
 */
public final class ValidatorUtils {

    private ValidatorUtils() {
    }

    /**
     * Create a {@link Validator}.
     *
     * @return a {@code Validator} instance.
     */
    public static Validator createValidator() {
        return Validation.byDefaultProvider()
                .configure()
                // to avoid adding an Expression Language implementation
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
    }
}
