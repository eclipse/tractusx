package net.catenax.prs.repositories;

import com.github.javafaker.Faker;
import net.catenax.prs.entities.PartIdEntityPart;
import net.catenax.prs.entities.PartRelationshipEntity;
import net.catenax.prs.entities.PartsMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static net.catenax.prs.testing.TestUtil.DATABASE_TESTCONTAINER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestPropertySource(properties = {
        DATABASE_TESTCONTAINER,
        "spring.jpa.hibernate.ddl-auto=validate",
})
public class PartRelationshipRepositoryTests {
    @Autowired
    PartRelationshipRepository repository;

    @Autowired
    TestEntityManager entityManager;

    PartsMother generate = new PartsMother();

    Faker faker = new Faker();

    /**
     * Parts with {@literal A} in their names form the BOM of {@link #carA}.
     */
    PartIdEntityPart carA = generate.partId();
    PartIdEntityPart gearboxA = generate.partId();
    PartIdEntityPart gearwheelA1 = generate.partId();
    PartIdEntityPart gearwheelA2 = generate.partId();
    PartIdEntityPart screwA1 = generate.partId();
    /**
     * A part that has the same OneID as {@link #gearboxA} , but a different ObjectID, and belongs to another car.
     * Used to test that the query matches not only on ObjectID.
     */
    PartIdEntityPart gearboxB = generate.partId().toBuilder().oneIDManufacturer(gearboxA.getOneIDManufacturer()).build();
    PartIdEntityPart gearwheelB = generate.partId();

    /**
     * A part that has the same ObjectID as {@link #gearboxA} but a different OneID, and belongs to another car.
     * Used to test that the query matches not only on OneID.
     */
    PartIdEntityPart gearboxC = generate.partId().toBuilder().objectIDManufacturer(gearboxA.getObjectIDManufacturer()).build();
    PartIdEntityPart gearwheelC = generate.partId();

    PartRelationshipEntity carA_gearboxA = generate.partRelationship(carA, gearboxA);
    PartRelationshipEntity gearboxA_gearwheelA1 = generate.partRelationship(gearboxA, gearwheelA1);
    PartRelationshipEntity gearboxA_gearwheelA2 = generate.partRelationship(gearboxA, gearwheelA2);
    PartRelationshipEntity gearboxB_gearwheelB = generate.partRelationship(gearboxB, gearwheelB);
    PartRelationshipEntity gearboxC_gearwheelC = generate.partRelationship(gearboxC, gearwheelC);
    PartRelationshipEntity gearwheelA1_screwA1 = generate.partRelationship(gearwheelA1, screwA1);

    @Test
    @DisplayName("The parts tree returns all entities under a vehicle-level part, and no others")
    void getPartsTreeForCarReturnsRelatedEntities() {
        // Arrange
        persistCarABom();

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(carA);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        carA_gearboxA,
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2,
                        gearwheelA1_screwA1);
    }

    @Test
    @DisplayName("The parts tree returns all entities under a component-level part, and no others")
    void getPartsTreeForComponentReturnsRelatedEntities() {
        // Arrange
        persistCarABom();

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(gearboxA);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2,
                        gearwheelA1_screwA1);
    }

    @Test
    @DisplayName("The parts tree retrieval only fetches part with matching OneID and ObjectID")
    void getPartsTreeDoesNotReturnPartsWithOtherOneIdOrObjectId() {
        // Arrange
        persistCarABom();
        // Add entities that would mistakenly end up in the BOM of carA if join fields are wrong
        entityManager.persist(gearboxB_gearwheelB);
        entityManager.persist(gearboxC_gearwheelC);

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(carA);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        carA_gearboxA,
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2,
                        gearwheelA1_screwA1);
    }

    @DisplayName("The maxDepth argument must be strictly positive")
    @ParameterizedTest(name = "For example, maxDepth {0} is not supported")
    @ValueSource(ints = {-1, -4, 0})
    void getPartsTreeWithInvalidMaxDepth(int maxDepth) {
        // The repository doesn't provide data validation, so no exception is thrown.
        // See https://stackoverflow.com/questions/52914198
        assertThat(getPartsTree(carA, maxDepth)).isEmpty();
    }

    @Test
    @DisplayName("If maxDepth=1, retrieves only direct relations of the queried part")
    void getPartsTreeWithMaxDepth1() {
        // Arrange
        persistCarABom();

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(gearboxA, 1);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        gearboxA_gearwheelA1, gearboxA_gearwheelA2);
    }

    @Test
    @DisplayName("If maxDepth=2, retrieves only two levels of relations")
    void getPartsTreeWithMaxDepth2() {
        // Arrange
        persistCarABom();

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(carA, 2);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        carA_gearboxA,
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2);
    }

    @Test
    @DisplayName("A cycle of length 0 in the data doesn't yield a crash or duplicates")
    void getPartsTreeWithCycleOfLength0() {
        testCycle(gearboxA, gearboxA);
    }

    @Test
    @DisplayName("A cycle of length 1 in the data doesn't yield a crash or duplicates")
    void getPartsTreeWithCycleOfLength1() {
        testCycle(gearboxA, carA);
    }

    @Test
    @DisplayName("A cycle of length 2 in the data doesn't yield a crash or duplicates")
    void getPartsTreeWithCycleOfLength2() {
        testCycle(gearwheelA1, carA);
    }

    @Test
    @DisplayName("A diamond shape (A->B->C, A->D->C) in the data doesn't yield duplicates")
    void testDiamond() {
        persistCarABom();
        PartIdEntityPart gearbox2 = generate.partId();
        PartRelationshipEntity carA_gearbox2 = generate.partRelationship(carA, gearbox2);
        PartRelationshipEntity gearbox2_gearwheelA1 = generate.partRelationship(gearbox2, gearwheelA1);
        entityManager.persist(carA_gearbox2);
        entityManager.persist(gearbox2_gearwheelA1);

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(carA);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        carA_gearboxA,
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2,
                        gearwheelA1_screwA1,
                        carA_gearbox2,
                        gearbox2_gearwheelA1);
    }

    private void persistCarABom() {
        entityManager.persist(carA_gearboxA);
        entityManager.persist(gearboxA_gearwheelA1);
        entityManager.persist(gearboxA_gearwheelA2);
        entityManager.persist(gearwheelA1_screwA1);
    }

    private List<PartRelationshipEntity> getPartsTree(PartIdEntityPart partId) {
        return getPartsTree(
                partId,
                faker.number().numberBetween(10, 1000));
    }

    private List<PartRelationshipEntity> getPartsTree(PartIdEntityPart partId, int maxDepth) {
        entityManager.flush();
        List<PartRelationshipEntity> partsTree = repository.getPartsTree(
                partId.getOneIDManufacturer(),
                partId.getObjectIDManufacturer(),
                maxDepth);
        assertThat(partsTree).doesNotHaveDuplicates();
        return partsTree;
    }

    private void testCycle(PartIdEntityPart parent, PartIdEntityPart child) {
        persistCarABom();

        PartRelationshipEntity cycleEdge = generate.partRelationship(parent, child);
        entityManager.persist(cycleEdge);

        // Act
        List<PartRelationshipEntity> partsTree = getPartsTree(carA);

        // Assert
        assertThat(partsTree)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        carA_gearboxA,
                        gearboxA_gearwheelA1,
                        gearboxA_gearwheelA2,
                        gearwheelA1_screwA1,
                        cycleEdge);
    }
}
