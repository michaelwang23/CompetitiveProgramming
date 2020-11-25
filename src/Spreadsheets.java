import java.util.*;
public class Spreadsheets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val = Integer.parseInt(in.nextLine());
        for (int i = 0; i < val; i++) {
            int len = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            System.out.println(drive(str));
        }
    }

    private static int drive(String str) {
        int times = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                List<String> strings = generateStrings(queue.poll());
                if (strings.size() == 0) {
                    return times;
                }
                for (String s : strings) {
                    queue.add(s);
                }
            }
            times++;
        }
        return times;
    }

    private static List<String> generateStrings(String str) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                //find a mismatch
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(i) != str.charAt(j)) {
                        ret.add(reverseString(str, i + 1, j));
                    }
                }
            }
        }
        return ret;
    }

    private static String reverseString(String str, int i, int j) {
        StringBuilder reversed = new StringBuilder(str.substring(i, j + 1));
        return str.substring(0, i) + reversed.reverse().toString() + str.substring(j + 1);
    }
}
