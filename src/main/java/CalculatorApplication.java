import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        PromptUtils promptUtils = new PromptUtils();

        Scanner scanner = new Scanner(System.in);

        double value1 = promptUtils.promptDouble(scanner, "계산할 첫 번째 숫자를 입력하세요:");
        String operatorSymbol = promptUtils.promptOperator(scanner);
        double value2 = promptUtils.promptDouble(scanner, "계산할 두 번째 숫자를 입력하세요:");

        Calculator calculator = new Calculator();
        try {
            double result = calculator.calculate(value1, operatorSymbol, value2);
            System.out.print("계산 결과는: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }


}
