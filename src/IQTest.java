import java.util.*;
public class IQTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            map.putIfAbsent(val % 2, new ArrayList());
            map.get(val % 2).add(i + 1);
        }
        if (map.get(0).size() == 1) {
            System.out.println(map.get(0).get(0));
        } else {
            System.out.println(map.get(1).get(0));
        }
    }
}
