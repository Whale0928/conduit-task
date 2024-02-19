import java.util.Scanner;

public class PromptUtils {


    public InputObject inputPrompt() {
        double value1 = promptDouble("계산할 첫 번째 숫자를 입력하세요:");
        String operatorSymbol = promptOperator();

        if (isCosOrSin(operatorSymbol)) {
            return new InputObject(value1, operatorSymbol);
        }

        double value2 = promptDouble("계산할 두 번째 숫자를 입력하세요:");

        return new InputObject(value1, operatorSymbol, value2);
    }

    public double promptDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("적절한 숫자를 입력해주세요.");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextDouble();
    }

    public String promptOperator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("연산자(+ , - , * , / , cos , sin)를 입력하세요:");
        String operator = scanner.nextLine();

        while (!Operation.isOperator(operator)) { //적합한 연산자인지 확인
            System.out.print("적절한 연산자를 입력해주세요. (+, -, *, / , cos , sin 중 하나)");
            scanner.reset();
            operator = scanner.nextLine();
        }

        return operator;
    }

    public boolean isCosOrSin(String operator) {
        return operator.equals("sin") || operator.equals("cos");
    }
}
