import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromptUtilsTest {

    private final PromptUtils promptUtils = new PromptUtils();

    @DisplayName("promptDouble 메소드는 사용자로부터 숫자를 입력받아 반환한다")
    @Test
    void promptDouble() {
        systemIn("3\n");
        double result = promptUtils.promptDouble(new Scanner(System.in), "계산할 숫자를 입력하세요:");
        assertEquals(3, result);
    }

    @DisplayName("promptOperator 메소드는 사용자로부터 연산자를 입력받아 반환한다")
    @Test
    void promptOperator() {
        systemIn("+\n");
        String result = promptUtils.promptOperator(new Scanner(System.in));
        assertEquals("+", result);
    }

    @DisplayName("promptDouble 메소드는 사용자로부터 잘못된 입력을 받으면 오류 메시지를 출력한다")
    @Test
    void promptDoubleWithInvalidInput() {
        systemIn("abc\n3\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        double result = promptUtils.promptDouble(new Scanner(System.in), "계산할 숫자를 입력하세요:");
        assertTrue(outContent.toString().contains("적절한 숫자를 입력해주세요."));
        assertEquals(3, result);
    }

    @DisplayName("promptOperator 메소드는 사용자로부터 잘못된 입력을 받으면 오류 메시지를 출력한다")
    @Test
    void promptOperatorWithInvalidInput() {
        systemIn("%\n+\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String result = promptUtils.promptOperator(new Scanner(System.in));
        assertTrue(outContent.toString().contains("적절한 연산자를 입력해주세요. (+, -, *, / 중 하나)"));
        assertEquals("+", result);
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}