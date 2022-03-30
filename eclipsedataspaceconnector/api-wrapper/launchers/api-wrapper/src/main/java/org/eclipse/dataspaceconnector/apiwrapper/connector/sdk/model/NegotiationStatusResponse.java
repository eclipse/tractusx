/*
 *  Copyright (c) 2022 Fraunhofer Institute for Software and Systems Engineering
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Fraunhofer Institute for Software and Systems Engineering - initial API and implementation
 *
 */

package org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.eclipse.dataspaceconnector.spi.types.domain.contract.negotiation.ContractNegotiation;

/**
 * Response for requesting the status of a {@link ContractNegotiation}.
 */
@JsonDeserialize(builder = NegotiationStatusResponse.Builder.class)
public class NegotiationStatusResponse {

    /**
     * Status of the {@link ContractNegotiation}.
     */
    private String status;

    /**
     * ID of the ContractAgreement associated with the ContractNegotiation. Null, if the
     * negotiation has not yet been completed successfully.
     */
    private String contractAgreementId;

    public String getStatus() {
        return status;
    }

    public String getContractAgreementId() {
        return contractAgreementId;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private final NegotiationStatusResponse negotiationStatusResponse;

        private Builder() {
            negotiationStatusResponse = new NegotiationStatusResponse();
        }

        @JsonCreator
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder status(String status) {
            negotiationStatusResponse.status = status;
            return this;
        }

        public Builder contractAgreementId(String contractAgreementId) {
            negotiationStatusResponse.contractAgreementId = contractAgreementId;
            return this;
        }

        public NegotiationStatusResponse build() {
            return negotiationStatusResponse;
        }
    }
}
