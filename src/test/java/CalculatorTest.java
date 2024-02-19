import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("단항 연산을 할 때 올바른 결과를 반환한다")
    void testCalculateUnaryOperation() {
        InputObject input = new InputObject(45.0, "sin");
        double result = calculator.calculate(input);
        assertEquals(Math.sin(45.0), result);
    }

    @Test
    @DisplayName("이항 연산을 할 때 올바른 결과를 반환한다")
    void testCalculateBinaryOperation() {
        InputObject input = new InputObject(5.0, "+", 3.0);
        double result = calculator.calculate(input);
        assertEquals(8.0, result);
    }
}