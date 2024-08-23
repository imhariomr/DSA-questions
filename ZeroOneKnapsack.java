import java.util.*;

public class ZeroOneKnapsack {

    public static int solve(int dp[][], int values[], int weight[], int index, int capacity) {
        if (index == 0) {
            if (weight[index] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int include = 0;
        if (weight[index] <= capacity) {
            include = values[index] + solve(dp, values, weight, index - 1, capacity - weight[index]);
        }

        int exclude = 0 + solve(dp, values, weight, index - 1, capacity);

        dp[index][capacity] = Math.max(include, exclude);

        return dp[index][capacity];
    }

    public static void main(String[] args) {
        int capacity = 4;
        int values[] = { 1, 2, 3 };
        int weight[] = { 4, 5, 1 };

        int dp[][] = new int[values.length][capacity + 1];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(dp, values, weight, values.length - 1, capacity);
        System.out.println(ans);
    }
}
