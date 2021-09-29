//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.controllers;

/**
 * Helper class contains all Api Errors as reusable constants.
 */
public class ApiErrors {
    public static final String INVALID_ARGUMENTS = "Invalid Arguments.";
    public static final String INVALID_DEPTH = "Invalid Depth.";
    public static final String PARTS_TREE_VIEW_NOT_NULL = "Must not be null, provide either AS_BUILT or AS_MAINTAINED.";
    public static final String PARTS_TREE_VIEW_MUST_MATCH_ENUM = "Must be either AS_BUILT or AS_MAINTAINED.";
    public static final String PARTS_TREE_MIN_DEPTH = "Depth should be at least 1.";
    public static final String PARTS_TREE_MAX_DEPTH = "Depth should not be more than {0}";
    public static final String VEHICLE_NOT_FOUND_BY_VIN = "Vehicle not found by VIN {0}";
}
