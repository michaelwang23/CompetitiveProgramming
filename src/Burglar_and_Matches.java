import java.util.*;
public class Burglar_and_Matches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxMatches = in.nextInt();
        int containers = in.nextInt();
        int[][] matches = new int[containers][2];
        for (int i = 0; i < containers; i++) {
            matches[i] = new int[] {in.nextInt(), in.nextInt()};
        }
        Arrays.sort(matches, (a,b) -> b[1] - a[1]);
//        show2DArr(matches);

        int ret = 0;
        int index = 0;
        while (maxMatches > 0 && index < matches.length) {
            int amountOfMatches = matches[index][0];
            int eachMatch = matches[index][1];
            if (amountOfMatches < maxMatches) {
                maxMatches -= amountOfMatches;
                ret += eachMatch * amountOfMatches;
            } else {
                ret += (maxMatches * eachMatch);
                maxMatches = 0;
            }
            index++;
        }

        System.out.println(ret);

    }

    private static void show2DArr(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
