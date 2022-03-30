/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.shell;

import net.catenax.semantics.framework.aas.ApiClient;
import net.catenax.semantics.framework.aas.model.Descriptor;

import java.util.List;

import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-07T08:24:08.813915300+01:00[Europe/Berlin]")public interface DescriptorInterfaceApi extends ApiClient.Api {

  /**
   * Returns the self-describing information of a network resource (Descriptor)
   * 
   * @return List&lt;Descriptor&gt;
   */
  @RequestLine("GET /descriptor")
  @Headers({
      "Accept: application/json",
  })
  List<Descriptor> getDescriptor();
}
