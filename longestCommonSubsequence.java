import java.util.*;

public class longestCommonSubsequence {

    public static int LCS(String str1, String str2, int[][] dp, int n, int m) {

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                ans = dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++)
            dp[0][i] = 0;
        for (int j = 0; j < m; j++)
            dp[j][0] = 0;

        int ans = LCS(str1, str2, dp, n, m);
        System.out.println(ans);
    }
}
