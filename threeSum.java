import java.util.*;

public class threeSum {

    public static int threeSum(int arr[], int n, int target) {

        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = n - 1;

            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];
                if (sum < target) {
                    count += (high - low);
                    low++;
                } else {
                    high--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int sum = 12;
        int arr[] = { 5, 1, 3, 4, 7 };

        System.out.println(threeSum(arr, n, sum));
    }
}