import java.util.*;

public class stringRotation {

    public static boolean checkRotation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String str3 = s1 + s1;
        if (!str3.contains(s2)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = new String(sc.next());
        String str2 = new String(sc.next());

        System.out.println(checkRotation(str1, str2));
    }
}
