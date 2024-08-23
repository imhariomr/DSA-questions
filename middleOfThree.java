import java.util.*;

public class middleOfThree {

    public static int find(int a, int b, int c) {
        if (a > b && a < c) {
            return a;
        } else if (b > a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        int A = 162, B = 934, C = 200;

        int ans = find(A, B, C);

        System.out.println(ans);
    }
}
