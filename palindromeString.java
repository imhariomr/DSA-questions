import java.util.*;

public class palindromeString {

    public static Boolean checkPalindrome(StringBuilder sb) {

        int start = 0;
        int end = sb.length() - 1;

        while (start < end) {

            if (sb.charAt(start) != sb.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());

        System.err.println(checkPalindrome(sb));
    }
}
