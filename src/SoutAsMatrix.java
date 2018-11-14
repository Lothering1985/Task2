import java.util.Scanner;

public class SoutAsMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int elementCount = in.nextInt();
        int[] intArray = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            intArray[i] = in.nextInt();
        }
        int k=0;
        for (int i = 0; i < matrixSize(elementCount) ; i++) {
            for (int j = 0; j < matrixSize(elementCount); j++) {
                if (k<elementCount){
                System.out.print(intArray[k]);
                System.out.print(" ");
                k++;}else {

                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    static int matrixSize (int value){
        int j=0;
        for (int i = 0; i <value; i++) {
            if ((i*i)<value){
                j++;
            }
        }
        return (j);
    }
}
