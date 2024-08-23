import java.util.*;

public class negativeSorted {

    public static void DNF(int arr[], int n) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            if (low <= 0) {
                low++;
            } else {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Arrays.sort(arr);

        DNF(arr, n);

        System.out.println("The Sorted Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
