import java.util.Scanner;

public class GetResult {

    final RomanNumberConverter converter = new RomanNumberConverter();
    private boolean isRoman = false;
    String[] expression;

    GetResult() {
        getExpression();
    }


    public int getNum1() {
        try {
            return Integer.parseInt(expression[0]);
        } catch (NumberFormatException e) {
            isRoman = true;
            return converter.romanToArabic(expression[0]);
        }
    }

    public int getNum2() {
        if (isRoman) {
            return converter.romanToArabic(expression[2]);
        } else {
            try {
                return Integer.parseInt(expression[2]);
            } catch (NumberFormatException e) {
                System.out.println("римское чило в неримской записи");
            }
        }
    }

    public String getOperation() {
        return expression[1];
    }

    public boolean isRoman() {
        return isRoman;
    }

    private void getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите пример, допустим 2 + 2");

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            System.out.println("недопустимый формат записи. должно быть два числа и математическая операция");
        }
        String operator = parts[1];
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            System.out.println("неизвестная математическая операция. допустима одна из +, -, *, /");
        }

        expression = parts;
    }
}