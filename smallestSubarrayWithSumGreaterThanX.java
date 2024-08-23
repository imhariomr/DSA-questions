import java.util.*;

public class smallestSubarrayWithSumGreaterThanX {

    public static int smallestSubarray(int arr[], int x) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        while (j < n) {

            while (sum <= x && j < n) {
                sum += arr[j];
                j++;
            }

            while (sum > x && i < j) {
                ans = Math.min(ans, j - i);
                sum -= arr[i++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, 0, 19 };
        int x = 51;

        int ans = smallestSubarray(arr, x);

        System.out.println(ans);
    }
}
