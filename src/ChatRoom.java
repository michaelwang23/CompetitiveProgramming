import java.util.*;
public class ChatRoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String master = "hello";
        for (int i = 0; i < input.length(); i++) {
            if (master.charAt(0) == input.charAt(i)) {
                master = master.substring(1);
            }
            if (master.length() == 0) {
                break;
            }
        }
        if (master.length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
