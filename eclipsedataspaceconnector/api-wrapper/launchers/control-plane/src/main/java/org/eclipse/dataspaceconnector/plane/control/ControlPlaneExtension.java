package org.eclipse.dataspaceconnector.plane.control;

import org.eclipse.dataspaceconnector.dataloading.AssetLoader;
import org.eclipse.dataspaceconnector.spi.WebService;
import org.eclipse.dataspaceconnector.spi.contract.offer.store.ContractDefinitionStore;
import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtensionContext;
import org.eclipse.dataspaceconnector.spi.transfer.store.TransferProcessStore;
import org.eclipse.dataspaceconnector.spi.asset.AssetIndex;

public class ControlPlaneExtension implements ServiceExtension {
    @Inject
    private WebService webService;

    @Inject
    private AssetLoader assetLoader;

    @Inject
    private ContractDefinitionStore contractDefinitionStore;

    @Inject
    private TransferProcessStore transferProcessStore;

    @Inject
    private AssetIndex assetIndex;

    @Override
    public String name() {
        return "Control Plane";
    }

    @Override
    public void initialize(ServiceExtensionContext context) {
        webService.registerResource(new ControlPlaneController(context.getMonitor(), assetLoader, contractDefinitionStore, transferProcessStore, assetIndex));
    }
}
