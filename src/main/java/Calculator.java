public class Calculator {
    public double calculate(Double value1, String operatorSymbol, Double value2) {
        Operation operation = Operation.fromSymbol(operatorSymbol);
        return operation.apply(value1, value2);
    }
}
