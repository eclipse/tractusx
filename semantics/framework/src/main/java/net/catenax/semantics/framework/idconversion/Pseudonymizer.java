package net.catenax.semantics.framework.idconversion;

import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;

import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.stream.Collectors;

public class Pseudonymizer implements IdConversion {
    private static int hash2=Pseudonymizer.class.getCanonicalName().hashCode();

    @Override
    public QualifiedConversionOutput convert(final QualifiedConversionInput input) {
        QualifiedConversionOutput output= new QualifiedConversionOutput();
        output.setIdentifiers(input.getIdentifiers().stream().map( identifier -> {
            IdentifierKeyValuePair pseudonym=new IdentifierKeyValuePair();
            pseudonym.setKey(input.getTargetDomain());
            UUID pseudoUUID = getUuid(identifier.getKey(),identifier.getValue(),input.getTargetDomain());
            pseudonym.setValue(pseudoUUID.toString());
            return pseudonym;
        }).collect(Collectors.toList()));
        return output;
    }

    private UUID getUuid(String key, String value, String target) {
        int hash1= key.hashCode();
        int hash4= value.hashCode();
        int hash3= target.hashCode();

        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        byte[] buffer=new byte[16];
        bb.putInt(hash1);
        bb.putInt(hash2);
        bb.putInt(hash3);
        bb.putInt(hash4);
        UUID pseudoUUID= UUID.nameUUIDFromBytes(bb.array());
        return pseudoUUID;
    }

    @Override
    public ConversionOutput convert(ConversionInput input) {
        ConversionOutput output= new ConversionOutput();
        QualifiedListOfIdentifiers outputIds=new QualifiedListOfIdentifiers();
        output.setIdentifiers(outputIds);
        outputIds.setKey(input.getTargetDomain());
        String sourceDomain=input.getIdentifiers().getKey();
        outputIds.setValues( input.getIdentifiers().getValues().stream().map(
                identifier -> {
                    return getUuid(sourceDomain,identifier,input.getTargetDomain()).toString();
                }
        ).collect(Collectors.toList()));
        return output;
    }
}
