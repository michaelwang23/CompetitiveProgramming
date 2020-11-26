import java.util.*;
public class Roma_and_Changing_Signs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = 100000;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (a < 0 && k != 0) {
                a *= -1;
                k--;
            }
            m = Math.min(m, a);
            b += a;
        }

        if (k % 2 == 1) {
            b -= 2 * m;
        }

        System.out.println(b);




    }


}
