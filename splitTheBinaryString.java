import java.util.*;

public class splitTheBinaryString {

    public static void count(String str) {
        int i = 0;
        int count = -1;
        int count_0 = 0;
        int count_1 = 0;

        while (i < str.length()) {

            if (str.charAt(i) == '0') {
                count_0++;
            } else {
                count_1++;
            }

            if (count_0 == count_1) {
                count++;
                count_0 = 0;
                count_1 = 0;
            }

            i++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        String str = "0000000000";
        count(str);
    }
}
