package net.catenax.semantics.registry.mapper;

import net.catenax.semantics.aas.registry.model.*;
import net.catenax.semantics.registry.model.*;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

public class ShellMapperTest {
    private final ShellMapper mapper = new ShellMapperImpl(new SubmodelMapperImpl());

    @Test
    public void testMapFromApiExpectSuccess() {
        AssetAdministrationShellDescriptor aas = createCompleteAasDescriptor();

        Shell shell = mapper.fromApiDto(aas);
        assertThat(shell.getIdExternal()).isEqualTo(aas.getIdentification());
        assertThat(shell.getIdShort()).isEqualTo(aas.getIdShort());

        List<Tuple> expectedIdentifiers = new ArrayList<>(List.of(toIdentifierTuples(aas.getSpecificAssetIds())));
        expectedIdentifiers.add(tuple(ShellIdentifier.GLOBAL_ASSET_ID_KEY, aas.getGlobalAssetId().getValue().get(0)));
        assertThat(shell.getIdentifiers())
                .extracting("key", "value")
                .containsExactlyInAnyOrder(expectedIdentifiers.toArray(new Tuple[0]));

        assertThat(shell.getDescriptions())
                .extracting("language", "text")
                .contains(toDescriptionTuples(aas.getDescription()));


        assertThat(shell.getSubmodels()).hasSize(1);

        SubmodelDescriptor submodelDescriptor = aas.getSubmodelDescriptors().stream().findFirst().get();
        Endpoint endpoint = submodelDescriptor.getEndpoints().stream().findFirst().get();
        String semanticId = submodelDescriptor.getSemanticId().getValue().stream().findFirst().get();
        ProtocolInformation protocolInformation = endpoint.getProtocolInformation();

        Submodel submodel = shell.getSubmodels().stream().findFirst().get();
        SubmodelEndpoint submodelEndpoint = submodel.getEndpoints().stream().findFirst().get();


        assertThat(submodel.getIdExternal()).isEqualTo(submodelDescriptor.getIdentification());
        assertThat(submodel.getIdShort()).isEqualTo(submodelDescriptor.getIdShort());
        assertThat(submodel.getSemanticId()).isEqualTo(semanticId);

        assertThat(submodelDescriptor.getSemanticId().getValue().stream().findFirst().get()).isEqualTo(submodel.getSemanticId());

        assertThat(submodelEndpoint.getInterfaceName()).isEqualTo(endpoint.getInterface());


        assertThat(submodelEndpoint.getInterfaceName()).isEqualTo(endpoint.getInterface());
        assertThat(submodelEndpoint.getEndpointProtocol()).isEqualTo(protocolInformation.getEndpointProtocol());
        assertThat(submodelEndpoint.getEndpointProtocolVersion()).isEqualTo(protocolInformation.getEndpointProtocolVersion());
        assertThat(submodelEndpoint.getSubProtocol()).isEqualTo(protocolInformation.getSubprotocol());
        assertThat(submodelEndpoint.getSubProtocolBody()).isEqualTo(protocolInformation.getSubprotocolBody());
        assertThat(submodelEndpoint.getSubProtocolBodyEncoding()).isEqualTo(protocolInformation.getSubprotocolBodyEncoding());
    }

    @Test
    public void testMapToApiExpectSuccess() {
        Shell shell = createCompleteShell();
        AssetAdministrationShellDescriptor aas = mapper.toApiDto(shell);
        assertThat(aas.getIdentification()).isEqualTo(shell.getIdExternal());
        assertThat(aas.getIdShort()).isEqualTo(shell.getIdShort());

        String expectedGlobalAssetId  = shell.getIdentifiers().stream()
                .filter(shellIdentifier -> ShellIdentifier.GLOBAL_ASSET_ID_KEY.equals(shellIdentifier.getKey()))
                .map(ShellIdentifier::getValue).findFirst().get();
        assertThat(aas.getGlobalAssetId().getValue().get(0)).isEqualTo(expectedGlobalAssetId);

        Set<ShellIdentifier> expectedIdentifiersSet = shell.getIdentifiers().stream()
                .filter(shellIdentifier -> !ShellIdentifier.GLOBAL_ASSET_ID_KEY.equals(shellIdentifier.getKey()))
                        .collect(Collectors.toSet());

        assertThat(aas.getSpecificAssetIds())
                .extracting("key", "value")
                .containsExactly(createTuplesForShellIdentifier(expectedIdentifiersSet));

        assertThat(aas.getDescription())
                .extracting("language", "text")
                .contains(createTuplesForShellDescriptionTuples(shell.getDescriptions()));

        assertThat(aas.getSubmodelDescriptors()).hasSize(1);
        SubmodelDescriptor apiSubmodelDescriptor = aas.getSubmodelDescriptors().get(0);

        // submodel mappings
        Submodel submodel = shell.getSubmodels().stream().findFirst().get();
        SubmodelEndpoint submodelEndpoint = submodel.getEndpoints().stream().findFirst().get();
        assertThat(apiSubmodelDescriptor.getIdentification()).isEqualTo(submodel.getIdExternal());
        assertThat(apiSubmodelDescriptor.getIdShort()).isEqualTo(submodel.getIdShort());

        assertThat(apiSubmodelDescriptor.getDescription())
                .extracting("language", "text")
                .contains(createTuplesForSubmodelDescriptionTuples(submodel.getDescriptions()));

        assertThat(apiSubmodelDescriptor.getEndpoints()).hasSize(1);
        Endpoint apiSubmodelEndpoint = apiSubmodelDescriptor.getEndpoints().stream().findFirst().get();

        ProtocolInformation apiProtocolInformation = apiSubmodelEndpoint.getProtocolInformation();
        assertThat(apiSubmodelEndpoint.getInterface()).isEqualTo(submodelEndpoint.getInterfaceName());
        assertThat(apiProtocolInformation.getEndpointProtocol()).isEqualTo(submodelEndpoint.getEndpointProtocol());
        assertThat(apiProtocolInformation.getEndpointProtocolVersion()).isEqualTo(submodelEndpoint.getEndpointProtocolVersion());
        assertThat(apiProtocolInformation.getSubprotocol()).isEqualTo(submodelEndpoint.getSubProtocol());
        assertThat(apiProtocolInformation.getSubprotocolBody()).isEqualTo(submodelEndpoint.getSubProtocolBody());
        assertThat(apiProtocolInformation.getSubprotocolBodyEncoding()).isEqualTo(submodelEndpoint.getSubProtocolBodyEncoding());
    }

    private Shell createCompleteShell() {
        ShellIdentifier shellIdentifier1 = new ShellIdentifier(UUID.randomUUID(), "key1", "value1", false,null);
        ShellIdentifier shellIdentifier2 = new ShellIdentifier(UUID.randomUUID(), "key1", "value1", false,null);
        ShellIdentifier shellIdentifier3 = new ShellIdentifier(UUID.randomUUID(), ShellIdentifier.GLOBAL_ASSET_ID_KEY, "exampleGlobalAssetId", false,null);
        Set<ShellIdentifier> shellIdentifiers = Set.of(shellIdentifier1, shellIdentifier2, shellIdentifier3);

        ShellDescription shellDescription1 = new ShellDescription(UUID.randomUUID(), "en", "example description1");
        ShellDescription shellDescription2 = new ShellDescription(UUID.randomUUID(), "de", "exampleDescription2");

        Set<ShellDescription> shellDescriptions = Set.of(shellDescription1, shellDescription2);


        Submodel submodel = new Submodel(UUID.randomUUID(),
                "submodelIdExternal",
                "submodelIdShort", "submodelSemanticId",
                Set.of(new SubmodelDescription(UUID.randomUUID(), "en", "example submodel description")),
                Set.of(new SubmodelEndpoint(UUID.randomUUID(), "interfaceExample",
                        "endpointAddressExample", "endpointProtocolExample",
                        "endpointProtocolVersionExample", "subProtocolExample"
                        , "subProtocolBodyExample", "subProtocolEncodingExample"
                )),
                null
        );

        return new Shell(UUID.randomUUID(), "idExternalExample", "idShortExample",
                shellIdentifiers, shellDescriptions, Set.of(submodel), null, null);
    }


    private AssetAdministrationShellDescriptor createCompleteAasDescriptor() {
        AssetAdministrationShellDescriptor aas = new AssetAdministrationShellDescriptor();
        aas.setIdentification("identificationExample");
        aas.setIdShort("idShortExample");

        Reference globalAssetId = new Reference();
        globalAssetId.setValue(List.of("globalAssetIdExample"));
        aas.setGlobalAssetId(globalAssetId);

        IdentifierKeyValuePair identifier1 = new IdentifierKeyValuePair();
        identifier1.setKey("identifier1KeyExample");
        identifier1.setValue("identifier1ValueExample");

        IdentifierKeyValuePair identifier2 = new IdentifierKeyValuePair();
        identifier2.setKey("identifier2KeyExample");
        identifier2.setValue("identifier2ValueExample");
        aas.setSpecificAssetIds(List.of(identifier1, identifier2));

        LangString description1 = new LangString();
        description1.setLanguage("de");
        description1.setText("this is an example description1");

        LangString description2 = new LangString();
        description2.setLanguage("en");
        description2.setText("this is an example for description2");
        aas.setDescription(List.of(description1, description2));


        ProtocolInformation protocolInformation = new ProtocolInformation();
        protocolInformation.setEndpointProtocol("endpointProtocolExample");
        protocolInformation.setEndpointAddress("endpointAddressExample");
        protocolInformation.setEndpointProtocolVersion("endpointProtocolVersionExample");
        protocolInformation.setSubprotocol("subprotocolExample");
        protocolInformation.setSubprotocolBody("subprotocolBodyExample");
        protocolInformation.setSubprotocolBodyEncoding("subprotocolBodyExample");
        Endpoint endpoint = new Endpoint();
        endpoint.setInterface("interfaceNameExample");
        endpoint.setProtocolInformation(protocolInformation);

        Reference reference = new Reference();
        reference.setValue(List.of("semanticIdExample"));
        SubmodelDescriptor submodelDescriptor = new SubmodelDescriptor();
        submodelDescriptor.setIdentification("identificationExample");
        submodelDescriptor.setIdShort("idShortExample");
        submodelDescriptor.setSemanticId(reference);
        submodelDescriptor.setDescription(List.of(description1, description2));
        submodelDescriptor.setEndpoints(List.of(endpoint));
        aas.setSubmodelDescriptors(List.of(submodelDescriptor));
        return aas;
    }

    private Tuple[] createTuplesForShellIdentifier(Set<ShellIdentifier> identifiers) {
        return identifiers.stream()
                .map(identifier -> tuple(identifier.getKey(), identifier.getValue()))
                .toArray(Tuple[]::new);
    }

    private Tuple[] createTuplesForShellDescriptionTuples(Set<ShellDescription> descriptions) {
        return descriptions.stream()
                .map(description -> tuple(description.getLanguage(), description.getText()))
                .toArray(Tuple[]::new);
    }

    private Tuple[] createTuplesForSubmodelDescriptionTuples(Set<SubmodelDescription> descriptions) {
        return descriptions.stream()
                .map(description -> tuple(description.getLanguage(), description.getText()))
                .toArray(Tuple[]::new);
    }

    private Tuple[] toIdentifierTuples(List<IdentifierKeyValuePair> identifiers) {
        return identifiers.stream()
                .map(identifier -> tuple(identifier.getKey(), identifier.getValue()))
                .toArray(Tuple[]::new);
    }

    private Tuple[] toDescriptionTuples(List<LangString> descriptions) {
        return descriptions.stream()
                .map(description -> tuple(description.getLanguage(), description.getText()))
                .toArray(Tuple[]::new);
    }
}
