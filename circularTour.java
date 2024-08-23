import java.util.*;

public class circularTour {

    public static int startingPoint(int n, int petrol[], int distance[]) {
        int balance = 0;
        int deficient = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];
            if (balance < 0) {
                deficient += balance;
                start = i + 1;
                balance = 0;
                // System.out.println(start);
            }
        }

        if (deficient + balance >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int petrol[] = { 4, 6, 7, 4 };
        int distance[] = { 6, 5, 3, 5 };

        int result = startingPoint(n, petrol, distance);
        System.out.println(result);
    }
}
