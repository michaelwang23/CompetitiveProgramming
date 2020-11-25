import java.util.*;
public class ThreeDisplays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        long numOfDisplays = Long.parseLong(firstLine);
        String[] secondLine = in.nextLine().split(" ");
        long[] fontSizes = new long[secondLine.length];
        for (int i = 0; i < fontSizes.length; i++) {
            fontSizes[i] = Long.parseLong(secondLine[i]);
        }
        String[] thirdLine = in.nextLine().split(" ");
        long[] costs = new long[thirdLine.length];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = Long.parseLong(thirdLine[i]);
        }

        long[][] dp = new long[3][fontSizes.length];
        long inf = (long) Math.pow(10, 17);
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], inf);
        }



        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = costs[i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (fontSizes[k] < fontSizes[j]) {
                        dp[i][j] = Math.min(dp[i - 1][k] + costs[j], dp[i][j]);
                    }
                }
            }
        }

//        printArr(dp);

        long ret = inf;
        for (int i = 0; i < dp[0].length; i++) {
            ret = Math.min(ret, dp[2][i]);
        }

        System.out.println(ret == inf ? -1 : ret);

    }

    private static void printArr(long[][] dp) {
        for (long[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
