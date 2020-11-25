import java.util.*;
public class LectureSleep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        Integer n = Integer.parseInt(firstLine.split(" ")[0]);
        Integer k = Integer.parseInt(firstLine.split(" ")[1]);
        String[] theorems = in.nextLine().split(" ");
        String[] awake = in.nextLine().split(" ");

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        int[] inclusiveSum = new int[n];

        int sum = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int a = Integer.parseInt(theorems[i]);
            int b = Integer.parseInt(awake[i]);
            sum += a * b;
            prefixSum[i] = sum;
        }
        sum = 0;
        for (int i = suffixSum.length - 1; i >= 0; i--) {
            int a = Integer.parseInt(theorems[i]);
            int b = Integer.parseInt(awake[i]);
            sum += a * b;
            suffixSum[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < inclusiveSum.length; i++) {
            sum += Integer.parseInt(theorems[i]);
            inclusiveSum[i] = sum;
        }
        System.out.println(Arrays.toString(prefixSum));
        System.out.println(Arrays.toString(suffixSum));
        System.out.println(Arrays.toString(inclusiveSum));
        int ret = 0;
        for (int i = 0; i <= n - k; i++) {
            int localSum = 0;
            int before = i - 1;
            int start = i;
            int end = i + k;
            if (before >= 0) {
                localSum += prefixSum[before];
            }
            if (end <= n - 1) {
                localSum += suffixSum[end];
            }
            if (before < 0) {
                localSum += inclusiveSum[i + k - 1];
            } else {
                localSum += inclusiveSum[i + k - 1] - inclusiveSum[i - 1];
            }
            ret = Math.max(localSum, ret);
        }
        System.out.println(ret);
    }
}
