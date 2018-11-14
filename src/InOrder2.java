import java.util.Arrays;
import java.util.Scanner;
public class InOrder2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        for (String i : str) {
            byte[] a = i.getBytes();
            byte[] b = i.getBytes();
            Arrays.sort(b);
            if (Arrays.equals(a, b)) {
                System.out.println(i);
                break;
            }
        }
    }
}
