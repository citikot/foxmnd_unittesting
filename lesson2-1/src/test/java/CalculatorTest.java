import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Nested
    class AdditionSubtractionTests {

        @Test
        @DisplayName("Success Add")
        @Disabled
        void testSuccessfulAddMethod() {

            //given
            double a = 124.1;
            double b = 125.9;

            // when
            double result = calculator.add(a, b);

            // then
            assertEquals(250, result);
        }

        @Test
        @DisplayName("Unsuccessful Add")
        void testUnsuccessfulAddMethod() {

            //given
            double a = 124.1;
            double b = 125.9;

            // when
            double result = calculator.add(a, b);

            // then
            assertNotEquals(260, result);
        }

        @Test
        @DisplayName("Success Sub")
        void testSuccessfulSubMethod() {

            //given
            double a = 124.1;
            double b = 122.1;

            // when
            double result = calculator.sub(a, b);

            // then
            // Intentional error
            assertEquals(3, result);
        }

        @Test
        @DisplayName("Unsuccessful Sub")
        void testUnsuccessfulSubMethod() {

            //given
            double a = 124.1;
            double b = 122.1;

            // when
            double result = calculator.sub(a, b);

            // then
            assertNotEquals(3, result);
        }
    }

    @Nested
    class MultiplicationDivisionTests {

        @Test
        @DisplayName("Success Mul")
        void testSuccessfulMulMethod() {

            //given
            double a = 5.5;
            double b = 4.0;

            // when
            double result = calculator.mul(a, b);

            // then
            assertEquals(22.0, result);
        }

        @Test
        @DisplayName("Unsuccessful Mul")
        void testUnsuccessfulMulMethod() {

            //given
            double a = 5.5;
            double b = 4;

            // when
            double result = calculator.mul(a, b);

            // then
            assertNotEquals(25.0, result);
        }

        @Test
        @DisplayName("Success Div")
        void testSuccessfulDivMethod() {

            //given
            double a = 24.0;
            double b = 4.0;

            // when
            double result = calculator.div(a, b);

            // then
            assertEquals(6.0, result);
        }

        @Test
        @DisplayName("Unsuccessful Div")
        void testUnsuccessfulDivMethod() {

            //given
            double a = 24.0;
            double b = 4.0;

            // when
            double result = calculator.mul(a, b);

            // then
            assertNotEquals(8.0, result);
        }

        @Test
        @DisplayName("Divide by zero gives infinity as result")
        void testDivisionByZeroMethod() {

            //given
            double a = 24.0;
            double b = 0;

            // when
            double result = calculator.div(a, b);

            // then
            assertTrue(Double.isInfinite(result), "Divide by zero gives infinity as result");
        }
    }
}