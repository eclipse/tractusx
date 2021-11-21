package net.catenax.prs.connector.requests;

import com.github.javafaker.Faker;
import jakarta.validation.Validator;
import net.catenax.prs.connector.requests.PartsTreeByObjectIdRequest.PartsTreeByObjectIdRequestBuilder;
import net.catenax.prs.connector.testing.ValidatorUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static net.catenax.prs.connector.requests.RequestMother.blank;
import static net.catenax.prs.connector.testing.SetOfConstraintViolationsAssertions.assertThat;


class PartsTreeByObjectIdRequestTest {

    private static final String EMPTY = "";
    static Validator validator = ValidatorUtils.createValidator();

    static Faker faker = new Faker();

    PartsTreeByObjectIdRequest sut = RequestMother.generateApiRequest();

    @ParameterizedTest(name = "{0}")
    @MethodSource("mutators")
    void validate(String testName, UnaryOperator<PartsTreeByObjectIdRequestBuilder> mutator, String expectedViolationPath) {
        sut = mutator.apply(sut.toBuilder()).build();
        // Act
        var response = validator.validate(sut);
        // Assert
        if (expectedViolationPath != null) {
            assertThat(response).hasViolationWithPath(expectedViolationPath);
        } else {
            assertThat(response).hasNoViolations();
        }
    }

    static Stream<Arguments> mutators() {
        return Stream.of(
                args("valid", identity(), null),

                args("oneIDManufacturer not null", b -> b.oneIDManufacturer(null), "oneIDManufacturer"),
                args("oneIDManufacturer not blank", b -> b.oneIDManufacturer(blank()), "oneIDManufacturer"),
                args("oneIDManufacturer not empty", b -> b.oneIDManufacturer(EMPTY), "oneIDManufacturer"),
                args("oneIDManufacturer max 10000 [1]", b -> b.oneIDManufacturer(faker.lorem().characters(10001)), "oneIDManufacturer"),
                args("oneIDManufacturer max 10000 [2]", b -> b.oneIDManufacturer(faker.lorem().characters(10001, 100000)), "oneIDManufacturer"),

                args("objectIDManufacturer not null", b -> b.objectIDManufacturer(null), "objectIDManufacturer"),
                args("objectIDManufacturer not blank", b -> b.objectIDManufacturer(blank()), "objectIDManufacturer"),
                args("objectIDManufacturer not empty", b -> b.objectIDManufacturer(EMPTY), "objectIDManufacturer"),
                args("objectIDManufacturer max 10000 [1]", b -> b.objectIDManufacturer(faker.lorem().characters(10001)), "objectIDManufacturer"),
                args("objectIDManufacturer max 10000 [2]", b -> b.objectIDManufacturer(faker.lorem().characters(10001, 100000)), "objectIDManufacturer"),

                args("view not null", b -> b.view(null), "view"),
                args("view not blank", b -> b.view(blank()), "view"),
                args("view not empty", b -> b.view(EMPTY), "view"),
                args("view max 10000 [1]", b -> b.view(faker.lorem().characters(10001)), "view"),
                args("view max 10000 [2]", b -> b.view(faker.lorem().characters(10001, 100000)), "view"),

                args("aspect may be null", b -> b.aspect(null), null),
                args("aspect may not be blank", b -> b.aspect(blank()), "aspect"),
                args("aspect may not be empty", b -> b.aspect(EMPTY), "aspect"),
                args("aspect max 10000 [1]", b -> b.aspect(faker.lorem().characters(10001)), "aspect"),
                args("aspect max 10000 [2]", b -> b.aspect(faker.lorem().characters(10001, 100000)), "aspect"),

                args("depth may be null", b -> b.depth(null), null),
                args("depth not 0", b -> b.depth(0), "depth"),
                args("depth not -1", b -> b.depth(-1), "depth"),
                args("depth not negative", b -> b.depth(faker.number().numberBetween(Integer.MIN_VALUE, -1)), "depth")
        );
    }

    private static Arguments args(String testName,
                                  UnaryOperator<PartsTreeByObjectIdRequestBuilder> mutator,
                                  String expectedViolationPath) {
        return Arguments.of(testName, mutator, expectedViolationPath);
    }
}
