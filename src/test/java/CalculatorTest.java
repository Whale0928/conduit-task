import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("두개의 인자를 더할 수 있다.")
    void add() {
        // given
        double a = 1;
        double b = 2;
        double expected = 3;
        // when
        double result = calculator.calculate(a, "+", b);
        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("두개의 인자를 뺄 수 있다.")
    void subtract() {
        // given
        double a = 3;
        double b = 2;
        double expected = 1;
        // when
        double result = calculator.calculate(a, "-", b);
        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("두개의 인자를 곱할 수 있다.")
    void multiply() {
        // given
        double a = 3;
        double b = 2;
        double expected = 6;
        // when
        double result = calculator.calculate(a, "*", b);
        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("두개의 인자를 나눌 수 있다.")
    void divide() {
        // given
        double a = 6;
        double b = 2;
        double expected = 3;
        // when
        double result = calculator.calculate(a, "/", b);
        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("0으로 나누면 ArithmeticException이 발생한다.")
    void divideByZero() {
        // given
        double a = 6;
        double b = 0;
        // when
        // then
        ArithmeticException exception = org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate(a, "/", b));
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());
    }
}