public class RomanNumberConverter {
    private static final int[] ArabicNumbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] RomanNumerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            System.out.println("число должно быть в диапазоне между 1 и 3999");
        }
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < ArabicNumbers.length; i++) {
            while (number >= ArabicNumbers[i]) {
//                обновляет значение объекта, который вызвал метод
                roman.append(RomanNumerals[i]);
                number -= ArabicNumbers[i];
            }
        }
        return roman.toString();
    }


    public int romanToArabic(String roman) {
        roman = roman.toUpperCase();
        int result = 0;
        int i = 0;
        while (i < roman.length()) {
//            вернуть символ из строки по индексу
            char letter = roman.charAt(i);
            int number = letterToNumeber(letter);

            if (number < 0) {
                System.out.println("неизвестное римское число");

            }
            i++;
            if (i == roman.length()) {
                result += number;
            } else {
                int nextNumber = letterToNumeber(roman.charAt(i));
                if (nextNumber > number) {
                    result += (nextNumber - number);
                    i++;
                } else {
                    result += number;
                }
            }

        }
        return result;
    }

    public String convertResult(boolean isRoman, int result) {
        if (arabicToRoman(result)) {
            return isRoman;
        } else return String.valueOf(result);
    }

    private static int letterToNumeber(char letter) {
        return switch (letter) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }
}
