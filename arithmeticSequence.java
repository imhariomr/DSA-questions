import java.util.*;

public class arithmeticSequence {

    public static boolean check(int a, int b, int c) {
        if (a == b) {
            return true;
        }

        if (c > 0 && b > a && (b - a) % c == 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int A = 1, B = 3, C = 2;

        System.out.println(check(A, B, C));
    }
}
