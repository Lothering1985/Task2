import java.util.Scanner;

public class OddInEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        int countEvenNumber=0;
        for (int i = 0; i < elementCount; i++) {
            if (intArray[i] % 2 == 0) {
                intArray[i] = in.nextInt();
                countEvenNumber++;
            }
        }
        int[] excludedOddArray = new int [countEvenNumber];
        int j=0;
        for (int i = 0; i < intArray.length ; i++) {
            if (intArray[i]!=0){
                excludedOddArray[j]=intArray[i];
                j++;
            }
        }
        int oddEqualEven=0;
        for (int i = 0; i <countEvenNumber ; i++) {
            if (oddEqualEven==0){String temp= String.valueOf(excludedOddArray[i]);
            char[] number=temp.toCharArray();
            if (countEvenNumeral(number)==countOddNumeral(number)&&countOddNumeral(number)!=0) {
                oddEqualEven=excludedOddArray[i];
            }
            }
        }
        System.out.println(oddEqualEven);

    }

    static int countOddNumeral (char[] number){
        int count=0;
        for (int i = 0; i < number.length; i++) {
            if (number[i]%2!=0){
                count++;
            }
        }
        return count;
    }
    static int countEvenNumeral (char[] number){
        int count=0;
        for (int i = 0; i < number.length; i++) {
            if (number[i]%2==0){
                count++;
            }
        }
        return count;
    }
}
