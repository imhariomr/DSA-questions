import java.util.*;

public class zeroSumSubaarays {

    public static int countSubarray(int arr[], int n) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                count += hm.get(sum);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int arr[] = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        System.out.println(countSubarray(arr, n));
    }
}