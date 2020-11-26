package Div2B;

import java.util.*;
public class I_O_U {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] debt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), c = in.nextInt();
            debt[u] -= c;
            debt[v] += c;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (debt[i] > 0) {
                ans += debt[i];
            }
        }
        System.out.println(ans);
    }
}

