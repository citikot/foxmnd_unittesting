import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorClientTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorClient calculatorClient;

    @Test
    void testPerformAdditionCallsAddOnce() {
        // given

        double a = 5.0;
        double b = 3.0;
        double expectedSum = 8.0;

        // when

        when(calculatorService.add(anyDouble(), anyDouble())).thenReturn(expectedSum);

        double result = calculatorClient.performAddition(a, b);

        // then

        assertEquals(expectedSum, result);
        verify(calculatorService, times(1)).add(a, b);  // Verify add() is called with specific values
        verify(calculatorService, times(1)).add(anyDouble(), anyDouble()); // Verify add() is called with any integer args

    }
}
