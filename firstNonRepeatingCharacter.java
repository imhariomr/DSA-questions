import java.util.*;

public class firstNonRepeatingCharacter {
    public static void findNonRepeating(String str, HashMap<Character, Integer> hm, ArrayList<Character> list,
            Queue<Character> q) {

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.get(ch) > 1) {
                if (!q.isEmpty() && q.peek() == ch) {
                    q.poll();
                }
            } else {
                q.add(ch);
            }

            if (q.size() > 0) {
                list.add(q.peek());
            } else {
                list.add('#');
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        String str = "zz";
        HashMap<Character, Integer> hm = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        Queue<Character> q = new LinkedList<>();
        findNonRepeating(str, hm, list, q);
    }
}
