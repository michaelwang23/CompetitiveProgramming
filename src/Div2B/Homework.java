package Div2B;

import java.util.*;
public class Homework {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int delete = Integer.parseInt(in.nextLine());
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (pq.contains(c)) {
                continue;
            }
            pq.add(c);
        }

        while (delete > 0 && map.keySet().size() > 0) {
            Character c = pq.poll();
            if (map.get(c) <= delete) {
                delete -= map.get(c);
                map.remove(c);
            } else {
                break;
            }
        }

        String ret = "";
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                ret += Character.toString(word.charAt(i));
            }
        }
        System.out.println(map.keySet().size());
        System.out.println(ret);
    }
}
