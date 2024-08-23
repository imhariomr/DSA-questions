import java.util.*;

public class makePalindromeString {

    public static void count(String str) {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        int cnt = 0;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                cnt++;
                j--;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        count(str);
    }
}
