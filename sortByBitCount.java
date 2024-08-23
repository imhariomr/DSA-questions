import java.util.*;

public class SortByBitCount {

    static int comp(int a, int b) {
        return Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };

        Integer[] arrWrapper = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrWrapper[i] = arr[i];
        }

        Arrays.sort(arrWrapper, (x, y) -> comp(x, y));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrWrapper[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
