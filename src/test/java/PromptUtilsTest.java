import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromptUtilsTest {

    private final PromptUtils promptUtils = new PromptUtils();

    @DisplayName("promptDouble 메소드는 사용자로부터 숫자를 입력받아 반환한다")
    @Test
    void promptDouble() {

        systemIn("3");

        double result = promptUtils.promptDouble("계산할 숫자를 입력하세요:");

        assertEquals(3, result);
    }

    @DisplayName("promptOperator 메소드는 사용자로부터 연산자를 입력받아 반환한다")
    @Test
    void promptOperator() {
        systemIn("+\n");
        String result = promptUtils.promptOperator();
        assertEquals("+", result);
    }

    @DisplayName("promptDouble 메소드는 사용자로부터 잘못된 입력을 받으면 오류 메시지를 출력한다")
    @Test
    void promptDoubleWithInvalidInput() {
        systemIn("abc\n3\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        double result = promptUtils.promptDouble("계산할 숫자를 입력하세요:");
        assertTrue(outContent.toString().contains("적절한 숫자를 입력해주세요."));
        assertEquals(3, result);
    }

    @DisplayName("promptOperator 메소드는 사용자로부터 잘못된 입력을 받으면 오류 메시지를 출력한다")
    @Test
    void promptOperatorWithInvalidInput() {
        systemIn("%\n+\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String result = promptUtils.promptOperator();
        assertTrue(outContent.toString().contains("적절한 연산자를 입력해주세요. (+, -, *, / , cos , sin 중 하나)"));
        assertEquals("+", result);
    }

    @DisplayName("isCosOrSin 메소드는 cos 또는 sin 연산자를 입력받으면 true를 반환한다")
    @Test
    void isCosOrSin() {
        assertTrue(promptUtils.isCosOrSin("cos"));
        assertTrue(promptUtils.isCosOrSin("sin"));
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}