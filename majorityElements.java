import java.util.*;

public class majorityElements {

    public static void majorityElements(int arr[]) {
        int m = arr.length / 2;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> s = hm.keySet();

        for (int i : s) {
            if (hm.get(i) > m) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 3, 3, 2 };
        majorityElements(arr);
    }
}
