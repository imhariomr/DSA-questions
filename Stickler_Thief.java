import java.util.*;

public class Stickler_Thief {

    public static int solve(int n, int arr[], int i, int dp[]) {
        if (i > n) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int inclu = solve(n, arr, i + 2, dp) + arr[i];
        int exclu = solve(n, arr, i + 1, dp);

        dp[i] = Math.max(inclu, exclu);

        return dp[i];
    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 6, 5, 5, 7, 4 };
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        int ans = solve(n, arr, 0, dp);
        System.out.println(ans);
    }
}
