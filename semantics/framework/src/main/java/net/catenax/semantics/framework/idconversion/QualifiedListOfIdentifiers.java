package net.catenax.semantics.framework.idconversion;

import lombok.Data;

import java.util.List;

@Data
public class QualifiedListOfIdentifiers {

    private String key;

    private List<String> values;
}
