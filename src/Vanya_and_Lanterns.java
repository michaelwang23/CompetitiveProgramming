import java.util.*;
public class Vanya_and_Lanterns {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            nums.add(in.nextInt());
        }
        Collections.sort(nums);
        double maxDiff = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            maxDiff = Math.max(maxDiff, nums.get(i + 1) - nums.get(i));
        }
        maxDiff = Math.max(maxDiff, nums.get(0) * 2);
        maxDiff = Math.max(maxDiff, (b - nums.get(nums.size() - 1)) * 2);
        System.out.println(maxDiff / 2);
    }
}
