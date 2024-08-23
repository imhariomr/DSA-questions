import java.util.*;

public class cutSegment {

    public static void solve(int n, int x, int y, int z) {

        int arr[] = new int[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;

        Arrays.sort(arr);

        int i = 0;
        int count = 0;
        int min = arr[i];

        while (n > 0) {
            if (n > min) {
                n = n - min;
                count++;
            } else {
                min = arr[i + 1];
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int n = 4, x = 2, y = 1, z = 1;
        solve(n, x, y, z);
    }
}
