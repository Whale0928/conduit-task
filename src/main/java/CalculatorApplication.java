public class CalculatorApplication {
    public static void main(String[] args) {
        PromptUtils promptUtils = new PromptUtils();
        Calculator calculator = new Calculator();

        try {
            InputObject inputObject = promptUtils.inputPrompt();
            double result = calculator.calculate(inputObject);
            System.out.print("계산 결과는: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
