//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.consumer.transfer;

import lombok.RequiredArgsConstructor;
import net.catenax.prs.connector.annotations.ExcludeFromCodeCoverageGeneratedReport;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.ProvisionedResource;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.StatusChecker;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferProcess;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * Status checked responsible for providing a file transfer status.
 */
@SuppressWarnings("PMD.GuardLogStatement") // Monitor doesn't offer guard statements
@ExcludeFromCodeCoverageGeneratedReport
@RequiredArgsConstructor
public class FileStatusChecker implements StatusChecker {

    /**
     * Logger.
     */
    private final Monitor monitor;

    @Override
    public boolean isComplete(final TransferProcess transferProcess, final List<ProvisionedResource> list) {
        final boolean exists = getDestinationFile(transferProcess).exists();
        if (exists) {
            monitor.info("FileStatusChecker detected completed transfer process");
        }
        return exists;
    }

    private File getDestinationFile(final TransferProcess transferProcess) {
        final var destination = transferProcess.getDataRequest().getProperties().get("prs-destination-path");
        final var destinationPath = Path.of(destination);

        final File file = destinationPath.toFile();
        if (file.exists() && file.isDirectory()) {
            final var source = transferProcess.getDataRequest().getDataEntry().getCatalogEntry().getAddress();
            final var sourceFileName = source.getProperty("filename");
            return Path.of(destinationPath.toString(), sourceFileName).toFile();
        }

        return file;
    }
}
