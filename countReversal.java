import java.util.*;

public class countReversal {

    public static int countReversal(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                s.push(ch);
            } else {
                if (s.empty() || s.peek() == '}') {
                    s.push(ch);
                } else {
                    s.pop();
                }
            }
        }

        int ans = 0, open = 0, close = 0;
        while (!s.empty()) {
            char top = s.pop();
            if (top == '{') {
                open++;
            } else {
                close++;
            }
        }

        ans = (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
        return ans;
    }

    public static void main(String args[]) {
        String str = "}{{}}{{{";
        System.out.println(countReversal(str));
    }

}
