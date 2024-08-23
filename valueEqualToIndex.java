import java.util.*;

public class valueEqualToIndex {

    public static void findIndex(int arr[]) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                list.add(arr[i]);
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int arr[] = { 15, 2, 45, 4, 7 };
        findIndex(arr);
    }
}
