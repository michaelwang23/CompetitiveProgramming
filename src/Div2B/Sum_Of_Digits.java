package Div2B;

import java.util.*;
public class Sum_Of_Digits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String val = in.nextLine();
        int times = 0;
        while (val.length() > 1) {
            val = getSumDigits(val);
            times++;
        }
        System.out.println(times);
    }

    private static String getSumDigits(String str) {
        long ret = 0;
        for (int i = 0; i < str.length(); i++) {
            ret += str.charAt(i) - '0';
        }
        return Long.toString(ret);
    }
}
