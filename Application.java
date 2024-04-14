public class Application {
    public static void main(String[] args) {
        GetResult operation = new GetResult();
        RomanNumberConverter converter = new RomanNumberConverter();

        IsInRange.isInRange1To10(operation.getNum1());
        IsInRange.isInRange1To10(operation.getNum2());

        int rawResult = Calculator.getResult(
                operation.getOperation(),
                operation.getNum1(),
                operation.getNum2());

        System.out.println(converter.convertResult(
                operation.isRoman(),
                rawResult));
    }
}










