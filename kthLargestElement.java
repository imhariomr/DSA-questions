import java.util.*;

public class kthLargestElement {

    public static void findKthlargest(int arr[], int k, PriorityQueue<Integer> pq) {
        int max = -99999;

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());
    }

    public static void main(String[] args) {
        int arr[] = { 12, 5, 787, 1, 23 };
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        findKthlargest(arr, k, pq);
    }
}
