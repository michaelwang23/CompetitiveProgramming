package Div2B;

import java.util.*;
public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        int[] inDegree = new int[3];
        for (int i = 0; i < 3; i++) {
            String line = in.nextLine();
            Character first = line.charAt(0);
            Character second = line.charAt(2);
            if (line.charAt(1) == '>') {
                adjList.putIfAbsent(second, new ArrayList<>());
                adjList.get(second).add(first);
                inDegree[first - 'A']++;
            } else {
                adjList.putIfAbsent(first, new ArrayList<>());
                adjList.get(first).add(second);
                inDegree[second - 'A']++;
            }
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.add((char) ('A' + i));
            }
        }
        String ret = "";
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            ret += Character.toString(c);
            List<Character> dests = adjList.getOrDefault(c, new ArrayList<>());
            for (Character dest : dests) {
                inDegree[dest - 'A']--;
                if (inDegree[dest - 'A'] == 0) {
                    stack.add(dest);
                }
            }
        }

        System.out.println(ret.length() == 3 ? ret : "Impossible");

    }
}
