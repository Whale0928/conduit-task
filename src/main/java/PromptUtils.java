import java.util.Scanner;

public class PromptUtils {
    public double promptDouble(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("적절한 숫자를 입력해주세요.");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextDouble();
    }

    public String promptOperator(Scanner scanner) {
        System.out.print("연산자(+ , - , * , /)를 입력하세요:");
        String operator = scanner.next();
        while (!operator.matches("[+\\-*/]")) {
            System.out.print("적절한 연산자를 입력해주세요. (+, -, *, / 중 하나)");
            operator = scanner.next();
        }
        return operator;
    }
}
