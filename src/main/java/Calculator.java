public class Calculator {
    public double calculate(double value1, String operatorSymbol, double value2) {
        Operation operation = Operation.fromSymbol(operatorSymbol);
        return operation.apply(value1, value2);
    }
}
