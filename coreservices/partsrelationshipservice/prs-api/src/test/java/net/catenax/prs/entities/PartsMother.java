package net.catenax.prs.entities;

import com.github.javafaker.Faker;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

/**
 * Object Mother to generate fake domain data for testing.
 * <p>
 * Static methods are not used so that state can be later introduced to generate more complex scenarios.
 *
 * @see * <a href="https://martinfowler.com/bliki/ObjectMother.html">https://martinfowler.com/bliki/ObjectMother.html</a>
 */
public class PartsMother {
    /**
     * JavaFaker instance used to generate random data.
     */
    public final Faker faker = new Faker();

    /**
     * Generate a {@link PartRelationshipEntity} linking two parts,
     * with a {@link PartRelationshipEntity#getUploadDateTime()} equal to the current time
     * and a random {@link PartRelationshipEntityKey#getPartRelationshipListId()}.
     *
     * @param parentId parent in the relationship.
     * @param childId  child in the relationship.
     * @return a {@link PartRelationshipEntity} linking {@code parentId} to {@code childId}.
     */
    public PartRelationshipEntity partRelationship(PartIdEntityPart parentId, PartIdEntityPart childId) {
        return PartRelationshipEntity.builder()
                .key(partRelationshipKey(parentId, childId))
                .uploadDateTime(now())
                .build();
    }

    /**
     * Generate a {@link PartRelationshipEntityKey} linking two parts,
     * with a random {@link PartRelationshipEntityKey#getPartRelationshipListId()}.
     *
     * @param parentId parent in the relationship.
     * @param childId  child in the relationship.
     * @return a {@link PartRelationshipEntityKey} linking {@code parentId} to {@code childId}.
     */
    public PartRelationshipEntityKey partRelationshipKey(PartIdEntityPart parentId, PartIdEntityPart childId) {
        return PartRelationshipEntityKey.builder()
                .childId(childId)
                .parentId(parentId)
                .partRelationshipListId(randomUUID())
                .build();
    }

    /**
     * Generate a {@link PartIdEntityPart} linking two parts,
     * with random values for {@link PartIdEntityPart#getOneIDManufacturer()}
     * and {@link PartIdEntityPart#getObjectIDManufacturer()}.
     * <p>
     * Example: {@code PartIdEntityPart(oneIDManufacturer=Stiedemann Inc, objectIDManufacturer=ypiu9wzwuka1ov03)}.
     *
     * @return a {@link PartIdEntityPart} with random identifiers.
     */
    public PartIdEntityPart partId() {
        return PartIdEntityPart.builder()
                .oneIDManufacturer(faker.company().name())
                .objectIDManufacturer(faker.lorem().characters(10, 20))
                .build();
    }
}
