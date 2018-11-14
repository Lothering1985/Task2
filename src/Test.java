import java.util.Random;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {


        int[][] array = {{1, 0, -3, 4}, {0, 0, -2, 3}, {0, 1, 0,10}, {0, -1, -1, 1}};

        int[][] matrixMovedZero = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrixMovedZero[i][j] = array[i][j];
            }
        }
        for (int i = 0; i < matrixMovedZero.length; i++) {
            for (int k = matrixMovedZero.length - 1; k >= 0; k--) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (matrixMovedZero[i][j] == 0) {
                        int temp = matrixMovedZero[i][j];
                        matrixMovedZero[i][j] = matrixMovedZero[i][j + 1];
                        matrixMovedZero[i][j + 1] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(matrixMovedZero));


//                int[][]  z = new int[][]{{1,2,3},{4,5,6},{7,8,9},};
//
//                System.out.println(Arrays.deepToString(z));
//                System.arraycopy(z,1,z,2,1);
//                z = Arrays.copyOf(z,2);
//                System.out.println(Arrays.deepToString(z));

        /*System.out.println(Arrays.deepToString(array));
        System.arraycopy(array,2,array,1,2);
        array=Arrays.copyOf(array,3);
        System.out.println(Arrays.deepToString(array));*/
    }
    }



