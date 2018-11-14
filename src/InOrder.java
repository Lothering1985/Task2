import java.util.Scanner;
public class InOrder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String s = "";
        int v, count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            v = scn.nextInt();
            String strNumberIncom = Integer.toString(v);
            for (int j = 0; j < strNumberIncom.length() - 1; j++) {
                if (strNumberIncom.length() == j + 1) {
                    if (strNumberIncom.charAt(strNumberIncom.length()) > strNumberIncom.charAt(strNumberIncom.length() + 1))
                        count++;
                } else if (strNumberIncom.charAt(j - 1) < strNumberIncom.charAt(j)) ++count;
            }
            if (count == strNumberIncom.length() - 2) s = s + v + " ";
        }
        System.out.println(s);
        scn.close();
    }
}
