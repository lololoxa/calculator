public class Calculator {
    public static int getResult(String operation, int num1, int num2) {
        switch (operation) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("деление на ноль");
                }
                return (num1 / num2);
            default:
                throw new IllegalStateException("неизвестная операция");
        }
    }

}