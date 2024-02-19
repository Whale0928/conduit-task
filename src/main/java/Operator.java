public interface Operator {

    /**
     * 이항 연산의 경우
     */
    default double apply(double x, double y) {
        throw new UnsupportedOperationException("지원하지 않는 연산입니다.");
    }

    /**
     * sin cos의 경우
     */
    default double apply(double x) {
        throw new UnsupportedOperationException("지원하지 않는 연산입니다.");
    }
}