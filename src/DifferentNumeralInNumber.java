import java.util.Scanner;

public class DifferentNumeralInNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            intArray[i] = in.nextInt();
        }
        int UniqeNumeral = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (UniqeNumeral == 0) {
                String temp = String.valueOf(intArray[i]);
                char[] number = temp.toCharArray();
                if (number.length == countUniqeNumber(number)) {
                    UniqeNumeral = intArray[i];
                }
            }
        }
        System.out.println("Different numerals " + UniqeNumeral);
    }

    static int calculateCountOfNumber(char[] value) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[0] == value[i]) {
                count++;
            }
        }
        return count;
    }

    static char[] excludeNumberFromArray(char[] value) {
        int count = calculateCountOfNumber(value);
        char[] result = new char[value.length - count];
        int j = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[0] != value[i]) {
                result[j] = value[i];
                j++;
            }
        }
        return result;
    }

    static int countUniqeNumber(char[] value) {
        int count = 0;
        char[] temporary = value;
        do {
            temporary = excludeNumberFromArray(temporary);
            count++;
        } while (temporary.length != 0);
        return count;
    }
}
