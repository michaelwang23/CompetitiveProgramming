import java.util.*;
public class Mashmokh_and_ACM {
    public static void main(String[] args) {
        long inf = (long) (Math.pow(10, 9) + 7);
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int k = Integer.parseInt(firstLine.split(" ")[1]);
        long[][] dp = new long[k + 1][n + 1];
        for (int col = 0; col < dp[0].length; col++) {
            dp[1][col] = 1;
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int v = j; v <= n; v += j) {
                    dp[i + 1][v] = (dp[i + 1][v] + dp[i][j]) % inf;
                }
            }
        }

//        printArr(dp);
        long ret = 0;
        for (int i = 1; i < dp[0].length; i++) {
            ret += dp[k][i];
            ret %= inf;
        }

        System.out.println(ret);


    }

    private static void printArr(long[][] dp) {
        for (long[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
