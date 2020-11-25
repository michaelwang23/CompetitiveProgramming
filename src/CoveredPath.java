import java.util.*;
public class CoveredPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        Integer v1 = Integer.parseInt(firstLine.split(" ")[0]);
        Integer v2 = Integer.parseInt(firstLine.split(" ")[1]);
        String secondLine = in.nextLine();
        Integer time = Integer.parseInt(secondLine.split(" ")[0]);
        Integer speedChange = Integer.parseInt(secondLine.split(" ")[1]);
        int[][] dp = new int[time][2000];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][v1] = v1;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] >= 0) {
                    for (int k = 0; k <= speedChange; k++) {
                        dp[i + 1][j + k] = Math.max(dp[i + 1][j + k], dp[i][j] + j + k);
                        if (j >= k) {
                            dp[i + 1][j - k] = Math.max(dp[i + 1][j - k], dp[i][j] + j - k);
                        }
                    }
                }
            }
        }
        System.out.println(dp[time - 1][v2]);
    }
}
