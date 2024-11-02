import exceptions.InterestCalculateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterestCalculatorTest {

    InterestCalculator interestCalculator;

    static Stream<Arguments> interestParameters() {
        return Stream.of(
                Arguments.of(1000.00, 0.05, 1, 50.00),
                Arguments.of(100.00, 0.1, 2, 20.00));
    }

    // Method that generates invalid test cases (to test exception handling)
    static Stream<Arguments> invalidInterestParameters() {
        return Stream.of(
                Arguments.of(-1000.00, 0.05, 1),   // negative principal
                Arguments.of(1000.00, 0.05, -1)    // negative term
        );
    }

    @BeforeEach
    void init() {
        interestCalculator = new InterestCalculator();
    }

    @ParameterizedTest
    @MethodSource("invalidInterestParameters")
    void interestAccrualExceptionTest(double principal, double rate, double term) {
        assertThrows(InterestCalculateException.class, () -> {
            interestCalculator.calculateInterest(principal, rate, term);
        }, "Exception");
    }

    @ParameterizedTest
    @MethodSource("interestParameters")
    void interestAccrualTest(double principal, double rate, double term, double expectedInterest) {

        // wnen
        double actualInterest = interestCalculator.calculateInterest(principal, rate, term);

        // then
        assertEquals(expectedInterest, actualInterest, 0.01);
    }
}
