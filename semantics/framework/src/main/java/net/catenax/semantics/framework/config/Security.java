/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.framework.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * represents security configuration.
 */
@Data
public class Security {
    private boolean debug=false;
    private Map<String,User> users=new HashMap<>();
    private Map<String,List<String>> filters=new HashMap<>();
}