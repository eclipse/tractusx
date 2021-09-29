package net.catenax.prs.services;

import com.catenax.partsrelationshipservice.dtos.PartRelationshipsWithInfos;
import net.catenax.prs.controllers.ApiErrors;
import net.catenax.prs.entities.EntitiesMother;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.exceptions.EntityNotFoundException;
import net.catenax.prs.repositories.PartAttributeRepository;
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import net.catenax.prs.requests.PartsTreeByVinRequest;
import net.catenax.prs.requests.RequestMother;
import net.catenax.prs.testing.DtoMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PartsTreeQueryByVinServiceTest {

    @Mock
    PartsTreeQueryService queryService;
    @Mock
    PartAttributeRepository attributeRepository;
    @InjectMocks
    PartsTreeQueryByVinService sut;

    EntitiesMother generate = new EntitiesMother();
    PartIdEntityPart car1 = generate.partId();
    PartIdEntityPart car2 = generate.partId();

    RequestMother generateRequest = new RequestMother();
    PartsTreeByObjectIdRequest requestForCar1 = generateRequest.byObjectId(car1);
    PartsTreeByVinRequest requestForCar1Vin = generateRequest.byVin(car1.getObjectIDManufacturer());

    DtoMother generateDto = new DtoMother();
    PartRelationshipsWithInfos resultDto = generateDto.partRelationshipsWithInfos();

    @Test
    public void getPartsTreeWithNoMatch() {
        assertThatThrownBy(() -> sut.getPartsTree(requestForCar1Vin))
                .isInstanceOf(EntityNotFoundException.class)
                        .hasMessageContaining(MessageFormat.format(ApiErrors.VEHICLE_NOT_FOUND_BY_VIN, requestForCar1Vin.getVin()));
        verifyNoInteractions(queryService);
    }

    @Test
    public void getPartsTreeWithOneMatch() {
        testGetPartsTree(car1);
    }

    /**
     * If the search returns multiple cars with matching VIN (and different OneIds), return the parts
     * tree for the first matching car (based on query sort order).
     */
    @Test
    public void getPartsTreeWithTwoMatches() {
        testGetPartsTree(car1, car2);
    }

    private void testGetPartsTree(PartIdEntityPart... partIdsMatchingVinSearch) {
        // Arrange
        when(
                attributeRepository.findAll(any(), any(Sort.class)))
                .thenReturn(Arrays.stream(partIdsMatchingVinSearch).map(v -> generate.partTypeName(v)).collect(Collectors.toList()));

        when(queryService
                .getPartsTree(requestForCar1))
                .thenReturn(resultDto);

        // Act
        var response = sut.getPartsTree(requestForCar1Vin);

        // Assert
        assertThat(response).isEqualTo(resultDto);
    }
}