import java.util.*;
public class Jeff_and_Periods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer>[] arr = new ArrayList[100001];
        int len = in.nextInt();

        for (int i = 0; i < len; i++) {
            int val = in.nextInt();
            if (arr[val] == null) {
                arr[val] = new ArrayList<>();
            }
            arr[val].add(i);
        }

        List<Integer[]> ret = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            if (arr[i].size() == 1) {
                ret.add(new Integer[] {i, 0});
            } else if (arr[i].size() > 1) {
                int diff = arr[i].get(1) - arr[i].get(0);
                boolean good = true;
                for (int k = 1; k < arr[i].size(); k++) {
                    good &= diff == arr[i].get(k) - arr[i].get(k - 1);
                }
                if (good) {
                    ret.add(new Integer[]{i, diff});
                }
            }
        }

        System.out.println(ret.size());
        for (Integer[] e : ret) {
            System.out.println(e[0] + " " + e[1]);
        }


    }
}
