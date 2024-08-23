import java.util.*;

public class nextPermutation {

    public static void nextPermutation(int arr[], int n) {

        int idx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(arr, 0, n - 1);
        }

        for (int i = n - 1; i > idx; i--) {

            if (arr[idx] < arr[i]) {
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                break;
            }

        }

        reverse(arr, idx + 1, n - 1);
    }

    public static void reverse(int arr[], int i, int j) {

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int arr[] = { 1, 2, 3, 6, 5, 4 };

        nextPermutation(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
