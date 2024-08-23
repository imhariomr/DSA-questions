import java.util.*;

public class kthMax {

    public static int findMax(int arr[], int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
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

        System.out.println("Enter the index of the element you want to find: ");
        int k = sc.nextInt();

        int maxElement = findMax(arr, k);
        System.out.println(maxElement);
    }
}
