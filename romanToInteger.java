import java.util.*;

public class romanToInteger {
    public static void main(String[] args) {

        String roman = "MMXXIII";
        int n = roman.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            char ch = roman.charAt(i);

            switch (ch) {
                case 'I':
                    ans += 1;
                    break;

                case 'V':
                    ans += 5;
                    break;

                case 'X':
                    ans += 10;
                    break;

                case 'L':
                    ans += 50;
                    break;

                case 'C':
                    ans += 100;
                    break;

                case 'D':
                    ans += 500;
                    break;

                case 'M':
                    ans += 1000;
                    break;

                default:
                    ans += 0;
                    break;
            }
        }

        System.out.println(ans);
    }
}
