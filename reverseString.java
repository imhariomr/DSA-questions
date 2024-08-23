import java.util.*;

public class reverseString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chr = str.toCharArray();

        int start = 0;
        int end = chr.length - 1;

        while (start <= end) {
            char temp = chr[start];
            chr[start] = chr[end];
            chr[end] = temp;

            start++;
            end--;
        }

        String newstr = new String(chr);

        System.out.println(newstr);
    }
}
