//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package org.eclipse.dataspaceconnector.extensions.api;

import org.eclipse.dataspaceconnector.extensions.annotations.ExcludeFromCodeCoverageGeneratedReport;
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
@SuppressWarnings({"PMD.CommentRequired", "PMD.GuardLogStatement"})
@ExcludeFromCodeCoverageGeneratedReport
public class FileStatusChecker implements StatusChecker {

    // Removed BeanMembersShouldSerialize rule because Monitor is final,
    // so adding transient will not have any impact.
    @SuppressWarnings({"PMD.BeanMembersShouldSerialize"})
    private final Monitor monitor;

    /**
     * FileStatusChecker constructor
     * @param monitor Logger
     */
    public FileStatusChecker(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public boolean isComplete(final TransferProcess transferProcess, final List<ProvisionedResource> list) {
        final boolean exists = getDestinationFile(transferProcess).exists();
        if (exists) {
            monitor.info("FileStatusChecker detected completed transfer process");
        }
        return exists;
    }

    private File getDestinationFile(final TransferProcess transferProcess) {
        final var destination = transferProcess.getDataRequest().getDataDestination();
        final var destinationPath = Path.of(destination.getProperty("path"));

        final File file = destinationPath.toFile();
        if (file.exists() && file.isDirectory()) {
            final var source = transferProcess.getDataRequest().getDataEntry().getCatalogEntry().getAddress();
            final var sourceFileName = source.getProperty("filename");
            return Path.of(destinationPath.toString(), sourceFileName).toFile();
        }

        return file;
    }
}
