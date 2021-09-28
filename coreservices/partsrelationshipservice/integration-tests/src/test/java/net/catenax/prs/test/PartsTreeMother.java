package net.catenax.prs.test;

import com.catenax.partsrelationshipservice.dtos.*;
import net.catenax.prs.testing.BaseDtoMother;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Object Mother to generate data for integration tests.
 *
 * @see <a href="https://martinfowler.com/bliki/ObjectMother.html">
 * https://martinfowler.com/bliki/ObjectMother.html</a>
 */
public class PartsTreeMother {

    private static final String BOSCH_ONE_ID = "BOSCH";
    private static final String ZF_ONE_ID = "ZF";
    private static final String SCHAEFFLER_ONE_ID = "SCHAEFFLER";
    private static final String BMW_ONE_ID = "BMW MUC";
    private static final String OBJECT_ID_GEARBOX = "I88HJHS45";
    private static final String OBJECT_ID_GEARWHEEL = "THYSFGG";
    private static final String OBJECT_ID_GEARWHEELPIN_1 = "PLFVTZL";
    private static final String OBJECT_ID_GEARWHEELPIN_2 = "CHOQAST";
    private static final String OBJECT_ID_BEARING = "D47055319";
    private static final String GEARWHEELPIN = "gearwheelpin";
    private static final String GEARWHEEL = "gearwheel";
    private static final String GEARBOX = "gearbox";
    private static final String VEHICLE = "Vehicle";
    private static final String BEARING = "bearing";
    private static final String VIN = "YS3DD78N4X7055320";
    private static final String ASPECT_CE = "CE";

    private final PartId vehiclePartId = vehiclePartId();
    private final PartId bearingPartId = bearingPartId();
    private final PartId gearboxPartId = gearboxPartId();
    private final PartId gearwheelPartId = gearwheelPartId();
    private final PartId gearwheelpinPartId1 = gearwheelpinPartId1();
    private final PartId gearwheelpinPartId2 = gearwheelpinPartId2();

    /**
     * Base mother object that generates test data.
     */
    private final BaseDtoMother base = new BaseDtoMother();

    private final List<PartRelationship> gearboxDirectChildren = List.of(partRelationship(gearboxPartId, gearwheelPartId));

    private final List<PartRelationship> gearboxPartsTree = List.of(
            partRelationship(gearboxPartId, gearwheelPartId),
            partRelationship(gearwheelPartId, gearwheelpinPartId1),
            partRelationship(gearwheelpinPartId1, gearwheelpinPartId2));

    private final List<PartRelationship> vehicleDirectChildren = List.of(
            partRelationship(vehiclePartId, gearboxPartId),
            partRelationship(vehiclePartId, bearingPartId)
    );
    private final List<PartRelationship> vehiclePartsTree = Stream.concat(
                    vehicleDirectChildren.stream(), gearboxPartsTree.stream())
            .collect(Collectors.toList());

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed part tree of gearbox without aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed part tree of gearbox without aspects.
     */
    public PartRelationshipsWithInfos sampleGearboxPartTree() {

        return partRelationshipsWithInfos(
                gearboxPartsTree,
                List.of(partInfo(gearboxPartId, GEARBOX),
                        partInfo(gearwheelPartId, GEARWHEEL),
                        partInfo(gearwheelpinPartId1, GEARWHEELPIN),
                        partInfo(gearwheelpinPartId2, GEARWHEELPIN)));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed part tree of gearbox with aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed part tree of gearbox with aspects.
     */
    public PartRelationshipsWithInfos sampleGearboxPartTreeWithAspects() {
        return partRelationshipsWithInfos(
                gearboxPartsTree,
                List.of(partInfo(gearboxPartId, GEARBOX, bmwAspect()),
                        partInfo(gearwheelPartId, GEARWHEEL, boschAspect()),
                        partInfo(gearwheelpinPartId1, GEARWHEELPIN, boschAspect()),
                        partInfo(gearwheelpinPartId2, GEARWHEELPIN, boschAspect())));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed data of gearbox direct children without aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed data of gearbox direct children without aspects.
     */
    public PartRelationshipsWithInfos sampleGearboxDirectChildren() {
        return partRelationshipsWithInfos(
                gearboxDirectChildren,
                List.of(partInfo(gearboxPartId, GEARBOX),
                        partInfo(gearwheelPartId, GEARWHEEL)));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed part tree of vehicle without aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed part tree of vehicle without aspects.
     */
    public PartRelationshipsWithInfos sampleVinPartTree() {

        return partRelationshipsWithInfos(
                vehiclePartsTree,
                List.of(partInfo(vehiclePartId, VEHICLE),
                        partInfo(bearingPartId, BEARING),
                        partInfo(gearboxPartId, GEARBOX),
                        partInfo(gearwheelPartId, GEARWHEEL),
                        partInfo(gearwheelpinPartId1, GEARWHEELPIN),
                        partInfo(gearwheelpinPartId2, GEARWHEELPIN)));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed part tree of vehicle with aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed part tree of vehicle with aspects.
     */
    public PartRelationshipsWithInfos sampleVinPartTreeWithAspects() {
        return partRelationshipsWithInfos(
                vehiclePartsTree,
                List.of(partInfo(vehiclePartId, VEHICLE, bmwAspect()),
                        partInfo(bearingPartId, BEARING, schaefflerAspect()),
                        partInfo(gearboxPartId, GEARBOX, bmwAspect()),
                        partInfo(gearwheelPartId, GEARWHEEL, boschAspect()),
                        partInfo(gearwheelpinPartId1, GEARWHEELPIN, boschAspect()),
                        partInfo(gearwheelpinPartId2, GEARWHEELPIN, boschAspect())));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed data of vehicle direct children without aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed data of vehicle direct children without aspects.
     */
    public PartRelationshipsWithInfos sampleVinDirectChildren() {
        return partRelationshipsWithInfos(
                vehicleDirectChildren,
                List.of(partInfo(vehiclePartId, VEHICLE),
                        partInfo(bearingPartId, BEARING),
                        partInfo(gearboxPartId, GEARBOX)));
    }

    /**
     * Generate a {@link PartRelationshipsWithInfos} containing fixed data of vehicle children and grandchildren without aspects.
     *
     * @return a {@link PartRelationshipsWithInfos} containing fixed data of vehicle children and grandchildren without aspects.
     */
    public PartRelationshipsWithInfos sampleVinGrandChildren() {
        return partRelationshipsWithInfos(
                Stream.concat(vehicleDirectChildren.stream(), gearboxDirectChildren.stream()).collect(Collectors.toList()),
                List.of(partInfo(vehiclePartId, VEHICLE),
                        partInfo(bearingPartId, BEARING),
                        partInfo(gearboxPartId, GEARBOX),
                        partInfo(gearwheelPartId, GEARWHEEL)));
    }

    private PartRelationshipsWithInfos partRelationshipsWithInfos(List<PartRelationship> relationships, List<PartInfo> infos) {
        return base.partRelationshipsWithInfos(relationships, infos);
    }

    private PartRelationship partRelationship(PartId parent, PartId child) {
        return base.partRelationship(parent, child);
    }

    private PartId vehiclePartId() {
        return base.partId(BMW_ONE_ID, VIN);
    }

    private PartId bearingPartId() {
        return base.partId(SCHAEFFLER_ONE_ID, OBJECT_ID_BEARING);
    }

    private PartId gearboxPartId() {
        return base.partId(ZF_ONE_ID, OBJECT_ID_GEARBOX);
    }

    private PartId gearwheelPartId() {
        return base.partId(BOSCH_ONE_ID, OBJECT_ID_GEARWHEEL);
    }

    private PartId gearwheelpinPartId1() {
        return base.partId(BOSCH_ONE_ID, OBJECT_ID_GEARWHEELPIN_1);
    }

    private PartId gearwheelpinPartId2() {
        return base.partId(BOSCH_ONE_ID, OBJECT_ID_GEARWHEELPIN_2);
    }

    private String aspectUrl(String name) {
        return "http://aspect-" + name + "/CE/1234";
    }

    private Aspect bmwAspect() {
        return base.partAspect(ASPECT_CE, aspectUrl("BMW"));
    }

    private Aspect boschAspect() {
        return base.partAspect(ASPECT_CE, aspectUrl(BOSCH_ONE_ID));
    }

    private Aspect schaefflerAspect() {
        return base.partAspect(ASPECT_CE, aspectUrl(SCHAEFFLER_ONE_ID));
    }

    private PartInfo partInfo(final PartId partId, final String partTypeName, final Aspect aspectOrNull) {
        return base.partInfo(partId, partTypeName, aspectOrNull);
    }

    private PartInfo partInfo(final PartId partId, final String partTypeName) {
        return base.partInfo(partId, partTypeName, null);
    }
}
