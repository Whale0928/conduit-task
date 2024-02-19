public class Calculator {

    public double calculate(InputObject inputObject) {

        Operation symbol = inputObject.operatorSymbol;

        if (Operation.isUnary(symbol.getSymbol())) {
            return symbol.apply(inputObject.value1);
        } else {
            return symbol.apply(inputObject.value1, inputObject.value2);
        }
    }
}
