package net.catenax.prs.connector.parameters;

import com.github.javafaker.Faker;
import jakarta.validation.Validator;
import net.catenax.prs.connector.testing.ValidatorUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static net.catenax.prs.connector.testing.SetOfConstraintViolationsAssertions.assertThat;


class GetStatusParametersTest {

    private static final String EMPTY = "";
    static Validator validator = ValidatorUtils.createValidator();

    static Faker faker = new Faker();

    String requestId = faker.lorem().characters();
    GetStatusParameters sut = new GetStatusParameters(requestId);

    @ParameterizedTest(name = "{0}")
    @MethodSource("mutators")
    void validate(String testName, Consumer<GetStatusParameters> mutator, String expectedViolationPath) {
        mutator.accept(sut);
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
                args("valid", x -> {
                }, null),

                args("requestId not null", b -> b.setRequestId(null), "requestId"),
                args("requestId not blank", b -> b.setRequestId(blank()), "requestId"),
                args("requestId not empty", b -> b.setRequestId(EMPTY), "requestId"),
                args("requestId max 10000 [1]", b -> b.setRequestId(faker.lorem().characters(10001)), "requestId"),
                args("requestId max 10000 [2]", b -> b.setRequestId(faker.lorem().characters(10001, 100000)), "requestId")
        );
    }

    private static Arguments args(String testName,
                                  Consumer<GetStatusParameters> mutator,
                                  String expectedViolationPath) {
        return Arguments.of(testName, mutator, expectedViolationPath);
    }

    private static String blank() {
        return faker.regexify("\\s+");
    }
}
