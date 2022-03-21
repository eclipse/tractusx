/*
 * Copyright (c) 2022 Bosch Software Innovations GmbH. All rights reserved.
 */

package net.catenax.semantics.hub;

import net.catenax.semantics.hub.domain.ModelPackageUrn;

public class ModelPackageNotFoundException extends RuntimeException {
   public ModelPackageNotFoundException( final ModelPackageUrn urn ) {
      super( String.format( "Model package with urn [%s] not found.", urn ) );
   }
}
