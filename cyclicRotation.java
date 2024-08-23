import java.util.*;

public class cyclicRotation {

    public static void Rotation(int arr[], int n) {

        int lastElement = arr[n - 1];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Rotation(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
