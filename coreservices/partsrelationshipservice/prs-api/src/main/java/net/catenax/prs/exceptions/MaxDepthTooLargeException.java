//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.exceptions;

import net.catenax.prs.configuration.PrsConfiguration;
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import net.catenax.prs.requests.PartsTreeByVinRequest;

/**
 * Exception thrown by the service when the {@link PartsTreeByObjectIdRequest#getDepth()}
 * or {@link PartsTreeByVinRequest#getDepth()} parameter is larger than
 * {@link PrsConfiguration#getPartsTreeMaxDepth()}.
 */
public class MaxDepthTooLargeException extends RuntimeException {
    /**
     * Generate a new instance of a {@link MaxDepthTooLargeException}
     * @param message Exception message.
     */
    public MaxDepthTooLargeException(final String message) {
        super(message);
    }
}
