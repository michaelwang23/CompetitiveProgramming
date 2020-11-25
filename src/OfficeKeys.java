import java.util.*;
public class OfficeKeys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int p = Integer.parseInt(firstLine[2]);
        String[] secondLine = in.nextLine().split(" ");
        int[] positions = new int[secondLine.length];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = Integer.parseInt(secondLine[i]);
        }
        String[] thirdLine = in.nextLine().split(" ");
        int[] keys = new int[thirdLine.length];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = Integer.parseInt(thirdLine[i]);
        }
        Arrays.sort(positions);
        Arrays.sort(keys);
        int[][] dp = new int[k + 1][n + 1];
        int inf = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = inf;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                int cost = Math.abs(positions[j] - keys[i]) + Math.abs(keys[i] - p);
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                if (j < n) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], Math.max(dp[i][j], cost));
                }
            }
        }
//        printArr(dp);
        System.out.println(dp[k][n]);
    }

    private static void printArr(int[][] dp) {
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
