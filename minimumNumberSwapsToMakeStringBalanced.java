import java.util.*;

public class minimumNumberSwapsToMakeStringBalanced {

    public static void numberOfSwaps(String str) {

        int n = str.length();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '[') {
                s.push(ch);
            } else {
                if (s.empty() || s.peek() == ']') {
                    s.push(ch);
                } else {
                    s.pop();
                }
            }
        }

        int open = 0, close = 0;
        int ans = 0;

        while (!s.empty()) {
            char top = s.pop();
            if (top == '[') {
                open++;
            } else {
                close++;
            }
        }

        if (open % 2 == 0) {
            ans = open / 2;
        } else {
            ans = open / 2 + 1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str = "][][";
        numberOfSwaps(str);
    }
}
