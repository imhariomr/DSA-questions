import java.util.*;

public class editDistance {

    public static int editDistance(String str1, String str2, int i, int j, int dp[][]) {
        if (i == str1.length() - 1) {
            return str2.length() - j;
        }

        if (j == str2.length() - 1) {
            return str1.length() - i;
        }

        int ans = 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return editDistance(str1, str2, i + 1, j + 1, dp);
        } else {
            // insert
            int insert = 1 + editDistance(str1, str2, i, j + 1, dp);

            // delete
            int delete = 1 + editDistance(str1, str2, i + 1, j, dp);

            // replace
            int replace = 1 + editDistance(str1, str2, i + 1, j + 1, dp);

            ans = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = editDistance(str1, str2, 0, 0, dp);

        System.out.println(ans);
    }
}
