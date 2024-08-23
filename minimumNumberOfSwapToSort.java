import java.util.*;

public class minimumNumberOfSwapToSort {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int count(int arr[]) {
        int n = arr.length;
        int temp[] = Arrays.copyOf(arr, n);

        Arrays.sort(temp);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                swaps++;
                int init = arr[i];
                swap(arr, i, hm.get(temp[i]));
                hm.put(init, hm.get(temp[i]));
                hm.put(arr[i], i);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 19, 6, 3, 5 };
        int ans = count(arr);
        System.out.println(ans);
    }
}
