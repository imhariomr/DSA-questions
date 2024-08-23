import java.util.*;

public class duplicateCharacters {

    public static boolean checkDuplicate(String str) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i : hm.values()) {
            if (i >= 2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(checkDuplicate(str));
    }
}