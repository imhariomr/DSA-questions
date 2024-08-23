import java.util.*;

public class factorial {

    public static void factorial(int n) {

        int fact = 1;
        if (n == 0) {
            System.out.println(0);
        }

        if (n == 1) {
            System.out.println(1);
        }

        for (int i = n; i > 0; i--) {
            fact = fact * i;
        }

        System.out.println(fact);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find the factorial: ");
        int n = sc.nextInt();

        factorial(n);
    }
}
