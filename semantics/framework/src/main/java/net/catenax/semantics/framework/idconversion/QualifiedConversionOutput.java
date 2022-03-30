package net.catenax.semantics.framework.idconversion;

import lombok.Data;
import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;

import java.util.List;

@Data
public class QualifiedConversionOutput {
    private List<IdentifierKeyValuePair> identifiers;
}
