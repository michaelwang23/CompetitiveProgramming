package Div2B;

import java.util.*;
public class Petya_and_Countryside {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int ret = 0;
        int[] arr = new int[len];
        boolean[] checked = new boolean[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int[] flowLeft = new int[len];
        int[] flowRight = new int[len];

        for (int i = 1; i < flowLeft.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                flowLeft[i] = 1 + flowLeft[i - 1];
            }
        }

        for (int i = flowRight.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                flowRight[i] = 1 + flowRight[i + 1];
            }
        }

//        System.out.println(Arrays.toString(flowLeft));
//        System.out.println(Arrays.toString(flowRight));

        for (int i = 0; i < len; i++) {
            ret = Math.max(ret, flowLeft[i] + flowRight[i]);
        }

        System.out.println(ret + 1);

    }
}
