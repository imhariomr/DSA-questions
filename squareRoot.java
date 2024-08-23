import java.util.*;

public class squareRoot {

    public static void countSquare(int n) {
        int sqrt = (int) Math.ceil(Math.sqrt(n));

        System.out.println(sqrt - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        countSquare(n);
    }
}
