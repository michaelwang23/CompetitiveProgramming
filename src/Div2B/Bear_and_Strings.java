package Div2B;

import java.util.*;
public class Bear_and_Strings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int ret = 0;
        for (int i = 0; i < word.length(); i++) {
            int find = word.substring(i).indexOf("bear");
            if (find > -1) {
                ret += word.substring(i).length() - find - 4 + 1;
            }
        }

        System.out.println(ret);

    }

}
