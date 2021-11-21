//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.dtos;


import net.catenax.prs.annotations.ExcludeFromCodeCoverageGeneratedReport;

/**
 * Helper class contains dto attributes validations as reusable constants.
 */
@ExcludeFromCodeCoverageGeneratedReport
public class ValidationConstants {
    /**
     * Minimum length limit for an input field.
     */
    public static final int INPUT_FIELD_MIN_LENGTH = 1;
    /**
     * Maximum length limit for an input field.
     * 10000 is chosen as a high enough value to protect api against very large inputs.
     */
    public static final int INPUT_FIELD_MAX_LENGTH = 10_000;
    /**
     * Minimum number of relationships in update request.
     */
    public static final int RELATIONSHIP_UPDATE_LIST_MIN_SIZE = 1;
    /**
     * Maximum number of relationships in update request.
     */
    public static final int RELATIONSHIP_UPDATE_LIST_MAX_SIZE = 1000;
    /**
     * Minimum number of aspects in update request.
     */
    public static final int ASPECT_UPDATE_LIST_MIN_SIZE = 1;
    /**
     * Maximum number of aspects in update request.
     */
    public static final int ASPECT_UPDATE_LIST_MAX_SIZE = 1000;
}
