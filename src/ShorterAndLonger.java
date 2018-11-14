import java.util.Scanner;

public class ShorterAndLonger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            intArray[i] = in.nextInt();
        }

        int maxLength = 0;
        int minlength = Integer.MAX_VALUE;
        int maxValueLength = 0;
        int minValueLength = 0;
        for (int i = 0; i < intArray.length; i++) {
            String temp = String.valueOf(intArray[i]);
            char[] number = temp.toCharArray();
            if (number.length > maxLength) {
                maxLength = number.length;
                maxValueLength = intArray[i];

            }
            if (number.length < minlength) {
                minlength = number.length;
                minValueLength = intArray[i];
            }

        }
        System.out.println("Shorter is " + minValueLength + " with length " + minlength);
        System.out.println("Longer is " + maxValueLength + " with length " + maxLength);
        in.close();
    }
}
