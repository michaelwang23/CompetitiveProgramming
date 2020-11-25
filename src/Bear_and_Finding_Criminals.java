import java.util.*;
public class Bear_and_Finding_Criminals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cities = in.nextInt();
        int index = in.nextInt() - 1;
        int[] arr = new int[cities];
        int criminals = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        if (arr[index] == 1) {
            criminals++;
        }
        for (int i = 1; i < 100; i++) {
            int left = index - i;
            int right = index + i;
            boolean leftBound = left >= 0;
            boolean rightBound = right < arr.length;
            if (!leftBound && !rightBound) {
                break;
            }
            if (leftBound && rightBound) {
                //both left and right inside cities
                if (arr[left] == 1 && arr[right] == 1) {
                    criminals += 2;
                }
            }
            if (!leftBound && rightBound && arr[right] == 1) {
                criminals++;
            }
            if (!rightBound && leftBound && arr[left] == 1) {
                criminals++;
            }
        }
        System.out.println(criminals);
    }
}
