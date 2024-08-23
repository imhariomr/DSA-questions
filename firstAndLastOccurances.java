import java.util.*;

public class firstAndLastOccurances {

    public static void firstAndLastOccurances(int n, int target, int arr[]) {
        int firstOccurance = 0;
        int LastOccurance = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == target && firstOccurance == 0) {
                firstOccurance = i;
                LastOccurance = i;
            } else if (arr[i] == target) {
                LastOccurance = i;
            }
        }

        System.out.println("First Occurance: " + firstOccurance + " and " + "Last Occurance: " + LastOccurance);
    }

    public static void main(String[] args) {
        int n = 9;
        int target = 7;
        int arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };

        firstAndLastOccurances(n, target, arr);
    }
}
