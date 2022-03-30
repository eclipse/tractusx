package net.catenax.semantics.framework.idconversion;


public interface IdConversion {

    QualifiedConversionOutput convert(QualifiedConversionInput input);
    ConversionOutput convert(ConversionInput input);

}
