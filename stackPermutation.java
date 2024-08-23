import java.util.*;

public class stackPermutation {

    public static Boolean checkPermutation(int arr[], int arr2[]) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
            if (s.peek() == arr2[j]) {
                while (!s.empty() && s.peek() == arr2[j]) {
                    s.pop();
                    j++;
                }
            }
        }

        if (s.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int arr2[] = { 3, 1, 2 };

        System.out.println(checkPermutation(arr, arr2));
    }
}
