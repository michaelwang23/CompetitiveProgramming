import java.util.*;
public class TheatreSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);
        long a = Long.parseLong(input[2]);
        long q1 = (n % a == 0) ? n / a : n / a + 1;
        long q2 = (m % a == 0) ? m / a : m / a + 1;
        System.out.println(q1 * q2);
    }
}
