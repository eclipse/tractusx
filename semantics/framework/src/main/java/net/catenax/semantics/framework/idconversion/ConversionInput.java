package net.catenax.semantics.framework.idconversion;

import lombok.Data;

@Data
public class ConversionInput {
    private String targetDomain;

    private QualifiedListOfIdentifiers identifiers;
}


