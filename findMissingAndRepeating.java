import java.util.*;

public class findMissingAndRepeating {

    public static void findMissingAndRepeating(int arr[]) {
        int n = arr.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]] = hash[arr[i]] + 1;
        }

        int missing = -1, repeating = -1;
        for (int i = 0; i <= n; i++) {
            if (hash[i] == 0) {
                missing = i;
            } else if (hash[i] == 2) {
                repeating = i;
            }
        }

        System.out.println("missing: " + missing + " repeating: " + repeating);
    };

    public static void main(String[] args) {
        int[] arr = { 2, 2 };
        findMissingAndRepeating(arr);
    }
}
