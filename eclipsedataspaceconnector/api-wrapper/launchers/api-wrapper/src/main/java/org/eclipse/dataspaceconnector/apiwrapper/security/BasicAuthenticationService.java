package org.eclipse.dataspaceconnector.apiwrapper.security;

import org.eclipse.dataspaceconnector.api.auth.AuthenticationService;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class BasicAuthenticationService implements AuthenticationService {

    private final Base64.Decoder b64Decoder;
    private final Monitor monitor;
    private final Map<String, String> users;

    public BasicAuthenticationService(Monitor monitor, Map<String, String> users) {
        this.monitor = monitor;
        this.users = users;
        this.b64Decoder = Base64.getDecoder();
    }

    @Override
    public boolean isAuthenticated(Map<String, List<String>> map) {
        var authHeader = map.get("Authorization");

        if (authHeader == null || authHeader.isEmpty()) {
            monitor.debug("No authentication header specified");
            return false;
        }

        var separatedAuthHeader = authHeader.get(0).split(" ");

        if (separatedAuthHeader.length != 2) {
            throw new IllegalArgumentException("Authorization header format is not supported");
        }

        var authCredentials = new String(b64Decoder.decode(separatedAuthHeader[1])).split(":");

        if (authCredentials.length != 2) {
            throw new IllegalArgumentException("Authorization header format is not supported");
        }

        var username = authCredentials[0];
        var password = authCredentials[1];
        var password4Username = users.get(username);

        if (password4Username == null || !password4Username.equals(password)) {
            monitor.debug("Basic auth user could not be found or password wrong");
            return false;
        }

        return true;
    }
}
