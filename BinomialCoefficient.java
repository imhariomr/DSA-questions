import java.util.*;

public class BinomialCoefficient {

    public static int solve(int dp[], int n, int r) {
        if (r > n) {
            return 0;
        }

        if ((n - r) < r)
            r = n - r;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[r];
    }

    public static void main(String[] args) {
        int n = 3;
        int r = 2;

        int dp[] = new int[r + 1];
        dp[0] = 1;
        int ans = solve(dp, n, r);
        System.out.println(ans);
    }
}
