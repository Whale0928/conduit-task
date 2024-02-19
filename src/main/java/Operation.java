import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Operation implements Operator {
    ADD("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    },


    SIN("sin") {
        @Override
        public double apply(double x) {
            return Math.sin(x);
        }
    },
    COS("cos") {
        @Override
        public double apply(double x) {
            return Math.cos(x);
        }
    };

    private final String symbol;

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("적합하지 않은 기호입니다. : " + symbol);
    }

    /**
     * enum에 있는 연산자인지 확인
     */
    public static boolean isOperator(String operator) {
        return Arrays.stream(values())
                .anyMatch(op -> op.getSymbol().equals(operator));
    }

    /**
     * 단일 연산값 대상인지 확인
     */
    public static boolean isUnary(String operator) {
        return operator.equals(SIN.getSymbol()) || operator.equals(COS.getSymbol());
    }
}
