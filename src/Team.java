import java.util.*;
public class Team {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer num = Integer.parseInt(in.nextLine());
        int ret = 0;
        for (int i = 0; i < num; i++) {
            String[] input = in.nextLine().split(" ");
            int count = 0;
            for (String inp : input) {
                count += inp.equals("1") ? 1 : 0;
            }
            if (count >= 2) {
                ret += 1;
            }
        }
        System.out.println(ret);
    }
}
