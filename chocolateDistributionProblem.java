import java.util.*;

public class chocolateDistributionProblem {

    public static int chocolateDistribution(int arr[], int students) {
        Arrays.sort(arr);
        int i = 0;
        int j = students - 1;
        int min = Integer.MAX_VALUE;
        int new_min = 0;

        while (j < arr.length) {
            new_min = arr[j] - arr[i];
            min = Math.min(new_min, min);
            i++;
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 1, 9, 56, 7, 9, 12 };
        int students = 5;
        int ans = chocolateDistribution(arr, students);
        System.out.println(ans);
    }
}
