package net.catenax.prs.testing;

import com.catenax.partsrelationshipservice.dtos.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

/**
 * Base class for Object Mother to generate fake DTO data for testing.
 *
 * @see <a href="https://martinfowler.com/bliki/ObjectMother.html">
 * https://martinfowler.com/bliki/ObjectMother.html</a>
 */
public class BaseDtoMother {

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing provided data.
     *
     * @param relationships list of {@link PartRelationship}.
     * @param partInfos     list of {@link PartInfo}.
     * @return a {@link PartRelationshipsWithInfos} containing
     * the provided {@code relationships} and {@code partInfos}.
     */
    public PartRelationshipsWithInfos partRelationshipsWithInfos(final List<PartRelationship> relationships, final List<PartInfo> partInfos) {
        return PartRelationshipsWithInfos.builder()
                .withRelationships(relationships)
                .withPartInfos(partInfos)
                .build();
    }

    /**
     * Generate a {@link PartRelationship} linking two parts.
     *
     * @param parentId parent in the relationship.
     * @param childId  child in the relationship.
     * @return a {@link PartRelationship} linking {@code parentId} to {@code childId}.
     */
    public PartRelationship partRelationship(final PartId parentId, final PartId childId) {
        return PartRelationship.builder()
                .withParent(parentId)
                .withChild(childId)
                .build();
    }

    /**
     * Generate a {@link PartId}
     * with random values for {@link PartId#getOneIDManufacturer()}
     * and {@link PartId#getObjectIDManufacturer()}.
     * <p>
     * Example: {@code PartId(oneIDManufacturer=Stiedemann Inc, objectIDManufacturer=ypiu9wzwuka1ov03)}.
     *
     * @return a {@link PartId} with random identifiers.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public PartId partId(String companyName, String objectIDManufacturer) {
        return PartId.builder()
                .withOneIDManufacturer(companyName)
                .withObjectIDManufacturer(objectIDManufacturer)
                .build();
    }

    /**
     * Generate a {@link Aspect}
     * with random values for {@link Aspect#getName()}
     * and {@link Aspect#getUrl()}.
     * <p>
     * Example: {@code Aspect(name=nihil, url=www.lincoln-smith.co)}.
     *
     * @return a {@link Aspect} with random data.
     */
    public Aspect partAspect(String aspectName, String url) {
        return Aspect.builder()
                .withName(aspectName)
                .withUrl(url)
                .build();
    }

    /**
     * Generate a {@link PartInfo} containing provided data.
     *
     * @param partId       part identifier.
     * @param partTypeName part type name.
     * @param aspectOrNull optional aspect to be included in the result. May be {@literal null}.
     * @return a {@link PartInfo} containing the provided {@code partId} and optionally {@code aspect}.
     */
    public PartInfo partInfo(final PartId partId, final String partTypeName, final Aspect aspectOrNull) {
        return PartInfo.builder()
                .withPart(partId)
                .withPartTypeName(partTypeName)
                .withAspects(Optional.ofNullable(aspectOrNull).map(Collections::singletonList).orElse(emptyList()))
                .build();
    }
}
