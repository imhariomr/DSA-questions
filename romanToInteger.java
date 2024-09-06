import java.util.*;

public class romanToInteger {
    public static void main(String[] args) {

        String roman = "MMXXIII";
        int n = roman.length();
        int ans = 0;
        int answer = 0;
        int prevValue = 0;

        for (int i = 0; i < roman.length(); i++) {
            char s = roman.charAt(i);
            int currentValue = 0;

            switch (s) {
                case 'I':
                    currentValue = 1;
                    break;
                case 'V':
                    currentValue = 5;
                    break;
                case 'X':
                    currentValue = 10;
                    break;
                case 'L':
                    currentValue = 50;
                    break;
                case 'C':
                    currentValue = 100;
                    break;
                case 'D':
                    currentValue = 500;
                    break;
                case 'M':
                    currentValue = 1000;
                    break;
            }

            if (prevValue < currentValue) {
                answer += currentValue - 2 * prevValue;
            } else {
                answer += currentValue;
            }
            prevValue = currentValue;

        }

        System.out.println(ans);
    }
}
