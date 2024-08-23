import java.util.*;

public class checkRedundantBrakcet {

    public static boolean checkRedundantBrakcet(String str) {

        Stack<Character> st = new Stack<>();
        boolean flag;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch == ')') {
                flag = true;
                while (st.peek() != '(') {

                    if (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/') {
                        flag = false;
                    }
                    st.pop();
                }
                st.pop();
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(a+b)";
        System.out.println(checkRedundantBrakcet(str));
    }
}
