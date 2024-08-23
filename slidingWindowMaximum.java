import java.util.*;

public class slidingWindowMaximum {

    public static void findMaximum(int arr[], PriorityQueue<Integer> pq, int k, ArrayList<Integer> list) {

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        list.add(pq.peek());

        for (int i = k; i < arr.length; i++) {
            pq.remove(arr[i - k]);
            pq.add(arr[i]);
            list.add(pq.peek());
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        findMaximum(arr, pq, k, list);
    }
}
