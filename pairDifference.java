import java.util.*;

public class pairDifference {

    public static Boolean findpair(int arr[], int N) {
        int flag = -1;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int x = N + arr[i];
            if (hm.containsKey(x) && hm.get(x) >= 1) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 90, 70, 20, 80, 50 };
        int N = 45;

        boolean ans = findpair(arr, N);

        System.out.println(ans);
    }
}
