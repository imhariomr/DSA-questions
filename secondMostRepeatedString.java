import java.util.*;

public class secondMostRepeatedString {

    public static String secondMostRepeatedString(String[] str) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            hm.put(str[i], hm.getOrDefault(str[i], 0) + 1);
        }

        int value = 0;

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (String st : hm.keySet()) {

            value = hm.get(st);
            if (value > firstMax) {
                secondMax = firstMax;
                firstMax = value;
            } else if (value < firstMax && value > secondMax) {
                secondMax = value;
            }
        }
        for (String st : hm.keySet()) {
            value = hm.get(st);
            if (value == secondMax) {
                return st;
            }
        }

        return "";
    }

    public static void main(String[] args) {

        String[] str = { "geek", "for", "geek", "for", "geek", "aaa" };
        String ans = secondMostRepeatedString(str);

        System.out.println(ans);
    }
}
