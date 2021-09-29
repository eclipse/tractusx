package net.catenax.prs.requests;

import com.catenax.partsrelationshipservice.dtos.PartsTreeView;
import com.github.javafaker.Faker;
import net.catenax.prs.entities.EntitiesMother;
import net.catenax.prs.entities.PartIdEntityPart;

public class RequestMother {
    /**
     * JavaFaker instance used to generate random data.
     */
    private final Faker faker = new Faker();

    private final EntitiesMother generate = new EntitiesMother();

    public PartsTreeByVinRequest byVin(String vin) {
        return PartsTreeByVinRequest.builder()
                .vin(vin)
                .view(faker.options().option(PartsTreeView.class).name())
                .build();
    }

    public PartsTreeByObjectIdRequest byObjectId(PartIdEntityPart partId) {
        return PartsTreeByObjectIdRequest.builder()
                .oneIDManufacturer(partId.getOneIDManufacturer())
                .objectIDManufacturer(partId.getObjectIDManufacturer())
                .view(faker.options().option(PartsTreeView.class).name())
                .build();
    }

    public PartsTreeByObjectIdRequest byObjectId() {
        return byObjectId(generate.partId());
    }
}
