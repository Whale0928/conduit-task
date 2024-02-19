import lombok.Getter;

@Getter
public class InputObject {
    Double value1;
    Operation operatorSymbol;
    Double value2;

    public InputObject(Double value1, String operatorSymbol, Double value2) {
        this.value1 = value1;
        this.operatorSymbol = Operation.fromSymbol(operatorSymbol);
        this.value2 = value2;
    }

    /**
     * sin cos의 경우
     *
     * @param value1         the value 1
     * @param operatorSymbol the operator symbol
     */
    public InputObject(Double value1, String operatorSymbol) {
        this.value1 = value1;
        this.operatorSymbol = Operation.fromSymbol(operatorSymbol);
    }
}
