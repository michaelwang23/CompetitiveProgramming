import java.util.*;
public class Vanya_and_Fence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int friends = in.nextInt();
        int height = in.nextInt();
        int num = 0;
        for (int i = 0; i < friends; i++) {
            int friendHeight = in.nextInt();
            if (friendHeight > height) {
                num += 2;
            } else {
                num++;
            }
        }
        System.out.println(num);
    }
}
