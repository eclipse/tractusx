package net.catenax.prs.repositories;

import com.github.javafaker.Faker;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartRelationshipEntity;
import net.catenax.prs.entities.PartsMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static net.catenax.prs.testing.TestUtil.DATABASE_TESTCONTAINER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestPropertySource(properties = {
        DATABASE_TESTCONTAINER,
        "spring.jpa.hibernate.ddl-auto=validate",
})
public class PartRelationshipRepositoryTests {
    @Autowired
    private PartRelationshipRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    private PartsMother generate = new PartsMother();

    private final Faker faker = new Faker();

    PartIdEntityPart car1 = generate.partId();
    PartIdEntityPart gearbox1 = generate.partId();
    PartIdEntityPart gearwheel1 = generate.partId();
    PartRelationshipEntity car1_gearbox1 = generate.partRelationship(car1, gearbox1);
    PartRelationshipEntity gearbox1_gearwheel1 = generate.partRelationship(gearbox1, gearwheel1);

    @Test
    void getPartsTreeReturnsRelatedEntities() {
        // Arrange
        entityManager.persist(car1_gearbox1);
        entityManager.persist(gearbox1_gearwheel1);

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(car1);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(car1_gearbox1, gearbox1_gearwheel1);
    }

    private List<PartRelationshipEntity> getPartsTree(PartIdEntityPart partId) {
        return repository.getPartsTree(
                partId.getOneIDManufacturer(),
                partId.getObjectIDManufacturer(),
                faker.number().numberBetween(10, 1000));
    }
}
