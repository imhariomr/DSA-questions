import java.util.*;

public class productArrayPuzzle {

    public static void puzzle(int arr[], int n) {

        int[] left = new int[n];
        int[] right = new int[n];

        ArrayList<Integer> list = new ArrayList<>();

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            list.add(left[i] * right[i]);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int n = 2;
        int arr[] = { 12, 0 };

        puzzle(arr, n);
    }
}
