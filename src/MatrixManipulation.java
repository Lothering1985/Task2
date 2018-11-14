import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixManipulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер матрицы");
        int matrixsize = input.nextInt();
        int[][] matrix = new int[matrixsize][matrixsize];
        Random random = new Random();
        System.out.println("Original");
        for (int i = 0; i < matrixsize; i++) {
            for (int j = 0; j < matrixsize; j++) {
                matrix[i][j] = (random.nextInt(matrixsize * 2) - matrixsize);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] matrixSortedRow = new int[matrixsize][matrixsize];
        for (int i = 0; i < matrixsize; i++) {
            for (int j = 0; j < matrixsize; j++) {
                matrixSortedRow[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrixSortedRow.length; i++) {
            for (int k = matrixSortedRow.length - 1; k >= 0; k--) {
                for (int j = 0; j < matrixSortedRow.length - 1; j++) {
                    if (matrixSortedRow[i][j] > matrixSortedRow[i][j + 1]) {
                        int temp = matrixSortedRow[i][j];
                        matrixSortedRow[i][j] = matrixSortedRow[i][j + 1];
                        matrixSortedRow[i][j + 1] = temp;
                    }
                }
            }
        }
        System.out.println("Sorted");
        printMatrix(matrixSortedRow);

        int[][] matrixMoved = new int[matrixsize][matrixsize];
        for (int i = 0; i < matrixsize; i++) {
            for (int j = 0; j < matrixsize; j++) {
                matrixMoved[i][j] = matrix[i][j];
            }
        }
        System.out.println("Введите размер сдвига");
        int step = input.nextInt();
        moveRight(matrixMoved, step);
        System.out.println("Moved");
        printMatrix(matrixMoved);
        System.out.println();
        System.out.println("Кусок по возрастанию");
        System.out.println(Arrays.toString(longestGrowUp(flatArray(matrix))));
        int[] sum = new int[matrixsize];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum[j] = sunBetween(matrix, j);
            }
        }
        System.out.println("Суммы между положительными");
        System.out.println(Arrays.toString(sum));

        System.out.println();
        int[][] matrixTransp = new int[matrixsize][matrixsize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixTransp[i][j] = matrix[j][matrix.length - i - 1];
            }
        }
        System.out.println("Transposed");
        printMatrix(matrixTransp);
        System.out.println();

        int[][] substractedAveragemMrix = new int[matrixsize][matrixsize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                substractedAveragemMrix[i][j] = matrix[i][j] - rowAverage(matrix, i);
            }
        }
        System.out.println("После вычитания среднего арифметического");
        printMatrix(substractedAveragemMrix);
        System.out.println();

        int[][] matrixMovedZero = new int[matrixsize][matrixsize];
        for (int i = 0; i < matrixsize; i++) {
            for (int j = 0; j < matrixsize; j++) {
                matrixMovedZero[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrixMovedZero.length; i++) {
            for (int k = matrixMovedZero.length - 1; k >= 0; k--) {
                for (int j = 0; j < matrixMovedZero.length - 1; j++) {
                    if (matrixMovedZero[i][j] == 0) {
                        int temp = matrixMovedZero[i][j];
                        matrixMovedZero[i][j] = matrixMovedZero[i][j + 1];
                        matrixMovedZero[i][j + 1] = temp;
                    }
                }
            }
        }
        printMatrix(matrixMovedZero);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void moveRight(int[][] array, int positions) {
        int size = array.length;
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < positions; i++) {
                int temp = array[k][size - 1];

                for (int j = size - 1; j > 0; j--) {
                    array[k][j] = array[k][j - 1];
                }

                array[k][i] = temp;
            }

        }
    }

    static int[] flatArray(int[][] matrix) {
        int k = 0;
        int[] array = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array[k] = matrix[i][j];
                k++;
            }
        }
        return array;
    }

    static int[] longestGrowUp(int array[]) {
        int[] temp = new int[array.length];
        int[] result = new int[array.length];
        int templength = 1;
        int length = 0;
        int tempIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                temp[tempIndex] = array[i];
                tempIndex++;
                templength++;
            } else {
                if (templength >= length) {
                    temp[tempIndex] = array[i];
                    result = temp;
                    length = templength + 1;

                }
                tempIndex = 0;
                templength = 1;

            }


        }
        return result;
    }

    static int posFirst(int[][] array, int row) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                if (array[row][i] > 0) {
                    result = i;
                    count++;
                }
            }
        }
        return result;
    }

    static int posSecond(int[][] array, int row) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count <= 1) {
                if (array[row][i] > 0) {
                    result = i;
                    count++;
                }
            }
        }
        return result;
    }

    static int sunBetween(int[][] array, int row) {
        int sum = 0;
        int beginSt = posFirst(array, row);
        int endSt = posSecond(array, row);
        for (int i = beginSt + 1; i < endSt; i++) {
            sum = sum + array[row][i];
        }
        return sum;
    }

    static int rowAverage(int[][] array, int row) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[row][i];
        }
        return sum / array.length;
    }

}

