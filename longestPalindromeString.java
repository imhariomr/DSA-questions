import java.util.*;

public class longestPalindromeString {

    public static void print(StringBuilder str, int start, int end) {

        for (int i = start; i < end; i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void longestPalindrome(StringBuilder str) {
        int start = 0;
        int end = 1;

        int low, high;

        for (int i = 1; i < str.length(); i++) {

            low = i - 1;
            high = i;

            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {

                if (high - low + 1 > end) {
                    start = low;
                    end = high - low + 1;
                }

                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;

            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {

                if (high - low + 1 > end) {
                    start = low;
                    end = high - low + 1;
                }

                low--;
                high++;
            }
        }

        print(str, start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());

        longestPalindrome(sb);
    }
}
