import java.util.*;

public class rearrangeElements {

    public static void rearraning(int arr[], int n) {

        int i = 0;
        int j = n - 1;

        while (i < j) {
            while (i <= n - 1 && arr[i] > 0) {
                i++;
            }
            while (j >= 0 && arr[j] < 0) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int k = 0;
        while (k < n && i < n) {
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
            i++;
            k = +2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        rearraning(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
