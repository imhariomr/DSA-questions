import java.lang.reflect.Array;
import java.util.*;

public class fourSum {

    public static void fourSum(int arr[], int target) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {

                int low = j + 1;
                int high = n - 1;

                while (low < high) {
                    int sum = arr[i] + arr[j] + arr[low] + arr[high];
                    if (sum == target) {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(arr[i]);
                        l.add(arr[j]);
                        l.add(arr[low]);
                        l.add(arr[high]);
                        list.add(l);

                        while (low < high && arr[low] == arr[low + 1]) {
                            low++;
                        }
                        while (low < high && arr[high] == arr[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (arr[low] + arr[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 3, 4, 5, 7, 8 };
        int target = 23;

        fourSum(arr, target);
    }
}
