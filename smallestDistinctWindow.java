import java.util.*;

public class smallestDistinctWindow {

    public static void smallestDistinctWindow(String str) {

        HashSet<Character> s = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            s.add(str.charAt(i));
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.size();
        int ans = Integer.MAX_VALUE;

        while (i < str.length()) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            if (hm.size() == n) {
                while (hm.get(str.charAt(j)) > 1) {
                    hm.put(str.charAt(j), hm.get(str.charAt(j)) - 1);
                    j++;
                }
                ans = Math.min(ans, i - j + 1);
            }
            i++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str = "aaab";
        smallestDistinctWindow(str);
    }
}
