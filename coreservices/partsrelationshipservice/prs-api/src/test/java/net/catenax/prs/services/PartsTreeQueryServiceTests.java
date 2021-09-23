package net.catenax.prs.services;

import com.catenax.partsrelationshipservice.dtos.PartsTreeView;
import com.github.javafaker.Faker;
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import net.catenax.prs.requests.PartsTreeByVinRequest;
import net.catenax.prs.util.StubResourcesHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartsTreeQueryServiceTests {

    @Test
    public void getPartsTreeByVinShouldReturnResponse() {
        // Arrange
        var sut = new PartsTreeQueryService(new StubResourcesHelper());
        var faker = new Faker();
        var request = PartsTreeByVinRequest.builder()
                .vin("BMWOVCDI21L5DYEUU")
                .view(faker.options().option(PartsTreeView.class))
                .build();

        // Act
        var response = sut.getPartsTree(request);

        // Assert
        assertThat(response).isNotEmpty();
    }

    @Test
    public void getPartsTreeByVinShouldReturnEmptyResponse() {
        // Arrange
        var sut = new PartsTreeQueryService(new StubResourcesHelper());
        var faker = new Faker();
        var request = PartsTreeByVinRequest.builder()
            .vin(faker.lorem().word())
            .view(faker.options().option(PartsTreeView.class))
            .build();

        // Act
        var response = sut.getPartsTree(request);

        // Assert
        assertThat(response).isEmpty();
    }

    @Test
    public void getPartsTreebyObjectIdShouldReturnEmptyResponse() {
        // Arrange
        var sut = new PartsTreeQueryService(new StubResourcesHelper());
        var faker = new Faker();
        var request = PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer(faker.lorem().word())
                .objectIDManufacturer(faker.lorem().word())
                .view(faker.options().option(PartsTreeView.class))
                .build();

        // Act
        var response = sut.getPartsTree(request);

        // Assert
        assertThat(response).isEmpty();
    }

    @Test
    public void getPartsTreebyObjectIdShouldReturnResponse() {
        // Arrange
        var sut = new PartsTreeQueryService(new StubResourcesHelper());
        var faker = new Faker();
        var request = PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer("OID_CX_0001_ZFGRP")
                .objectIDManufacturer("ZF3EZLMaP0LN5D8VU")
                .view(faker.options().option(PartsTreeView.class))
                .build();

        // Act
        var response = sut.getPartsTree(request);

        // Assert
        assertThat(response).isNotEmpty();
    }
}