import java.util.*;

public class BitMaskDP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int inf = (int) Math.pow(10, 7);

        List<String> list = new ArrayList();

        for (int i = 0; i < num; i++) {
            list.add(in.nextLine());
        }
        int[][] dp = new int[num + 1][8];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], inf);
        }

        dp[0][0] = 0;
        for (int i = 0; i < num; i++) {
            String input = list.get(i);
            String[] strArr = input.split(" ");
            Integer cost = Integer.parseInt(strArr[0]);
            String str = strArr[1];
            int mask = findMask(str);
            for (int j = 0; j < 8; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                dp[i + 1][mask | j] = Math.min(dp[i + 1][mask | j], dp[i + 1][j] + cost);
            }
        }

        System.out.println(dp[num][7] == inf ? - 1 : dp[num][7]);

    }

    private static int findMask(String str) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('A', 4);
        map.put('B', 2);
        map.put('C', 1);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += map.get(str.charAt(i));
        }
        return count;
    }
}

