import java.util.*;
public class Chocolate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        int[] arr = new int[len];
        String second = in.nextLine();
        String[] split = second.split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ones.add(i);
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
        long ret = 1;
        if (ones.size() == 0) {
            ret = 0;
        }
        for (int i = 0; i < ones.size() - 1; i++) {
            if (ones.get(i) == ones.get(i + 1)) {
                continue;
            }
            ret *= (ones.get(i + 1) - ones.get(i));
        }
        System.out.println(ret);


    }
}
