import java.util.Arrays;
import java.util.Scanner;

public class OrderLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            intArray[i] = in.nextInt();
        }

        for (int i = intArray.length; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (getValueLength(intArray[j]) < getValueLength(intArray[j+1])) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
    public static int getValueLength(int value) {
        String temporary = String.valueOf(value);
        char[] valueASChar = temporary.toCharArray();
        return valueASChar.length;
    }
}
