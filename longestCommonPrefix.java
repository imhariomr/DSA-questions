import java.util.*;

public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] str) {
        int n = str.length;

        if (n == 0) {
            return "";
        }

        if (n == 1) {
            return str[0];
        }

        Arrays.sort(str);

        int minlen = Math.min(str[0].length(), str[n - 1].length());
        int i = 0;
        while (i < minlen && str[0].charAt(i) == str[n - 1].charAt(i)) {
            i++;
        }

        String prefix = str[0].substring(0, i);

        return prefix;
    }

    public static void main(String[] args) {
        String[] str = { "apple", "ape", "april" };
        System.out.println(longestCommonPrefix(str));
    }
}
