import java.util.*;

public class cutSegment {

    public static int solve(int dp[], int n, int x, int y, int z) {

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int a = solve(dp, n - x, x, y, z) + 1;
        int b = solve(dp, n - y, x, y, z) + 1;
        int c = solve(dp, n - z, x, y, z) + 1;

        dp[n] = Math.max(a, Math.max(b, c));

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4, x = 2, y = 1, z = 1;
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        int ans = solve(dp, n, x, y, z);

        if (ans < 0) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
