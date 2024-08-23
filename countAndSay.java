import java.util.*;

public class countAndSay {

    public static void countAndSay(int n) {
        String res = "1";

        if (n <= 1) {
            System.out.println(res);
        }

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < res.length(); j++) {

                int count = 1;
                char c = res.charAt(j);

                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }

                sb.append(count).append(c);
            }

            res = sb.toString();
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        countAndSay(n);
    }
}
