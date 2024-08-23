import java.util.Arrays;

public class aggressiveCows {

    public static boolean canWePlaceCows(int arr[], int dist, int k) {
        int cntcows = 1, lastStall = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastStall >= dist) {
                cntcows++;
                lastStall = arr[i];
            }
            if (cntcows >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int cows = 3;
        int stall[] = { 10, 1, 2, 7, 5 };

        Arrays.sort(stall);

        int low = 1;
        int high = stall[n - 1] - stall[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlaceCows(stall, mid, cows) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
