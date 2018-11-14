import java.util.Arrays;
import java.util.Scanner;

public class AverageLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        int lengthSum=0;
        for (int i = 0; i < elementCount; i++) {
            intArray[i] = in.nextInt();
            lengthSum += getValueLength(intArray[i]);

        }
        int averageLength=lengthSum/elementCount;
        int[] lessAvarageLength=new int[elementCount] ;
        int element2Count=0;
        for (int i = 0; i < elementCount ; i++) {
            if (averageLength>getValueLength(intArray[i])) {
                lessAvarageLength[element2Count]=intArray[i];
                element2Count+=1;
            }

        }
        int[] result=new int [element2Count];
        for (int i = 0; i <element2Count ; i++) {
            result[i]=lessAvarageLength[i];
        }
        System.out.println(Arrays.toString(result));

    }
    public static int getValueLength(int value) {
        String temporary = String.valueOf(value);
        char[] valueASChar = temporary.toCharArray();
        return valueASChar.length;
    }
}
