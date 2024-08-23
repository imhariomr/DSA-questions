import java.util.*;

public class checkValidShuffle {

    public static boolean checkValidShuffle(String s1, String s2, String shuffle) {

        if (s1.length() + s2.length() != shuffle.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < shuffle.length(); i++) {
            if (hm.containsKey(shuffle.charAt(i))) {
                hm.put(shuffle.charAt(i), hm.get(shuffle.charAt(i)) - 1);

                if (hm.get(shuffle.charAt(i)) == 0) {
                    hm.remove(shuffle.charAt(i));
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = new String(sc.nextLine());
        String str2 = new String(sc.nextLine());

        String shuffle = new String(sc.nextLine());

        System.out.println(checkValidShuffle(str1, str2, shuffle));
    }
}