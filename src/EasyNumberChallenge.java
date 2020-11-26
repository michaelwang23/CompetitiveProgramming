import java.util.*;
public class EasyNumberChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        long mod = (long) Math.pow(2, 30);
        long[] arr = new long[a * b * c + 1];
        long ret = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += i) {
                arr[j]++;
            }
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    ret += arr[i * j * k];
                    ret %= mod;
                }
            }
        }

        System.out.println(ret);

    }
}
