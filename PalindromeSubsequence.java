import java.util.*;

public class PalindromeSubsequence {
    public static int countPalindromeSubsequence(String str) {

        int n = str.length();
        Boolean[][] dp = new Boolean[n][n];
        int count = 0;
        for (int diff = 0; diff < n; diff++) {

            for (int i = 0, j = diff; j < n; i++, j++) {
                if (diff == 0) {
                    dp[i][j] = true;
                } else if (diff == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(countPalindromeSubsequence(str));
    }
}
