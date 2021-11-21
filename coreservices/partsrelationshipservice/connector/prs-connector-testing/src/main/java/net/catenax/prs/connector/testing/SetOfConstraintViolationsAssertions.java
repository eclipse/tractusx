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

import jakarta.validation.ConstraintViolation;
import org.assertj.core.api.AbstractAssert;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AssertJ custom assertions for {@link Set} of {@link ConstraintViolation}s.
 *
 * @see <a href="Custom Assertions">https://assertj.github.io/doc/#assertj-core-custom-assertions</a>
 */
@SuppressWarnings("PMD.LinguisticNaming")
public final class SetOfConstraintViolationsAssertions extends AbstractAssert<SetOfConstraintViolationsAssertions, Set<? extends ConstraintViolation>> {

    private SetOfConstraintViolationsAssertions(final Set<? extends ConstraintViolation> actual) {
        super(actual, SetOfConstraintViolationsAssertions.class);
    }

    /**
     * Create assertion for {@link Set} of {@link ConstraintViolation}s.
     *
     * @param actual the actual value.
     * @return the created assertion object.
     */
    public static SetOfConstraintViolationsAssertions assertThat(final Set<? extends ConstraintViolation> actual) {
        return new SetOfConstraintViolationsAssertions(actual);
    }

    /**
     * Verifies that the actual {@link Set} of {@link ConstraintViolation}s contains a violation
     * for the given path.
     *
     * @param path the given violation path.
     * @return {@code this} assertion object.
     * @throws NullPointerException if the given path is {@code null}.
     * @throws AssertionError       if the actual {@link Set} of {@link ConstraintViolation}s
     *                              is {@code null}.
     * @throws AssertionError       if the actual {@link Set} of {@link ConstraintViolation}s
     *                              does not contain a violation with the given path.
     */
    public SetOfConstraintViolationsAssertions hasViolationWithPath(final String path) {
        isNotNull();

        // check condition
        if (!containsViolationWithPath(actual, path)) {
            failWithMessage("There was no violation with path <%s>. Violation paths: <%s>", path, summary());
        }

        return this;
    }

    /**
     * Verifies that the actual {@link Set} of {@link ConstraintViolation}s contains no violations.
     *
     * @return {@code this} assertion object.
     * @throws AssertionError if the actual {@link Set} of {@link ConstraintViolation}s is {@code null}.
     * @throws AssertionError if the actual {@link Set} of {@link ConstraintViolation}s
     *                        contains any violations.
     */
    public SetOfConstraintViolationsAssertions hasNoViolations() {
        isNotNull();

        if (!actual.isEmpty()) {
            failWithMessage("Expecting no violations, but there are %s violations. Violation paths: %s", actual.size(), summary());
        }

        return this;
    }

    private boolean containsViolationWithPath(final Set<? extends ConstraintViolation> violations, final String path) {
        return violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals(path));
    }

    private List<String> summary() {
        return actual.stream()
                .map(violation -> violation.getPropertyPath().toString())
                .collect(Collectors.toList());
    }
}
