import java.util.*;

public class validParenthesis {

    public static boolean parenthesisChecker(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')' || ch == '}') {
                s.push(ch);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                if (s.peek() == ')') {
                    s.pop();
                } else {
                    return false;
                }
            }

            if (ch == '{') {
                if (s.peek() == '}') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "({}";
        System.out.println(parenthesisChecker(str));
    }
}
