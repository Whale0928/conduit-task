import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OperationTest {

    @DisplayName("덧셈 연산을 할 때 올바른 결과를 반환한다")
    @Test
    void addOperation() {
        assertEquals(5, Operation.ADD.apply(2, 3));
    }

    @DisplayName("뺄셈 연산을 할 때 올바른 결과를 반환한다")
    @Test
    void subtractOperation() {
        assertEquals(-1, Operation.SUBTRACT.apply(2, 3));
    }

    @DisplayName("곱셈 연산을 할 때 올바른 결과를 반환한다")
    @Test
    void multiplyOperation() {
        assertEquals(6, Operation.MULTIPLY.apply(2, 3));
    }

    @DisplayName("나눗셈 연산을 할 때 올바른 결과를 반환한다")
    @Test
    void divideOperation() {
        assertEquals(2, Operation.DIVIDE.apply(6, 3));
    }

    @DisplayName("0으로 나누려고 할 때 ArithmeticException을 던진다")
    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> Operation.DIVIDE.apply(6, 0));
    }

    @DisplayName("기호로부터 연산을 생성할 때 올바른 연산을 반환한다")
    @Test
    void fromSymbol() {
        assertEquals(Operation.ADD, Operation.fromSymbol("+"));
        assertEquals(Operation.SUBTRACT, Operation.fromSymbol("-"));
        assertEquals(Operation.MULTIPLY, Operation.fromSymbol("*"));
        assertEquals(Operation.DIVIDE, Operation.fromSymbol("/"));
    }

    @DisplayName("적합하지 않은 기호로부터 연산을 생성하려고 할 때 IllegalArgumentException을 던진다")
    @Test
    void fromInvalidSymbolThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Operation.fromSymbol("%"));
    }

    @DisplayName("sin 연산을 할 때 올바른 결과를 반환한다")
    @Test
    void sinOperation() {
        assertEquals(Math.sin(45.0), Operation.SIN.apply(45.0));
    }

    @DisplayName("옯바른 연산자를 입력했을 때 true를 반환한다")
    @Test
    void isOperator() {
        assertTrue(Operation.isOperator("+"));
        assertTrue(Operation.isOperator("-"));
        assertTrue(Operation.isOperator("*"));
        assertTrue(Operation.isOperator("/"));
        assertTrue(Operation.isOperator("cos"));
        assertTrue(Operation.isOperator("sin"));
    }
}