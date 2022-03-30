package org.eclipse.dataspaceconnector.plane.backend;

import org.eclipse.dataspaceconnector.spi.WebService;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtensionContext;

public class BackendServiceExtension implements ServiceExtension {

    @Inject
    private WebService webService;

    @Override
    public String name() {
        return "Provider Backend Service";
    }

    @Override
    public void initialize(ServiceExtensionContext context) {
        Monitor monitor = context.getMonitor();
        webService.registerResource("default", new BackendServiceController(monitor));
    }
}
