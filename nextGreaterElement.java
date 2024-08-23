import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nextGreaterElement {

    public static void nextGreaterElement(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        s.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() < arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                list.add(-1);
                s.push(arr[i]);
            } else {
                list.add(s.peek());
                s.push(arr[i]);
            }
        }
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        int n = 4;
        int arr[] = { 1, 3, 2, 4 };
        nextGreaterElement(arr, n);
    }
}
