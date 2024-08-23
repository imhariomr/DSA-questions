import java.util.*;

public class minNumberFlips {
    public static void main(String[] args) {
        String str = "0001010111";
        int c1 = 0, c2 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0 && str.charAt(i) == '0')
                c1++;
            if (i % 2 != 0 && str.charAt(i) == '1')
                c1++;

            if (i % 2 == 0 && str.charAt(i) == '1')
                c2++;
            if (i % 2 != 0 && str.charAt(i) == '0')
                c2++;
        }

        System.out.println(Math.min(c1, c2));
    }
}
