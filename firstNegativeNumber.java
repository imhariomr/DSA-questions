import java.util.*;

public class firstNegativeNumber {

    public static void findFirstNegative(int arr[], int n, int k) {

        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.addFirst(i);
            }
        }

        if (dq.size() > 0) {
            list.add(arr[dq.pollFirst()]);
        } else {
            list.add(0);
        }

        for (int i = k; i < n; i++) {
            if (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.removeFirst();
            }

            if (arr[i] < 0) {
                dq.addLast(i);
            }

            if (dq.size() > 0) {
                list.add(arr[dq.peekFirst()]);
            } else {
                list.add(0);
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int arr[] = { -8, 2, 3, -6, 10 };
        int n = 5;
        int k = 2;

        findFirstNegative(arr, n, k);
    }
}