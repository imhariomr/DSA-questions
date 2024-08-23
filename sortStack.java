import java.util.*;

public class sortStack {

    public static void sortElement(Stack<Integer> s, int top) {
        if (s.empty() || s.peek() < top) {
            s.push(top);
            return;
        }
        int peek = s.pop();
        sortElement(s, top);
        s.push(peek);
    }

    public static void Sort(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }
        int top = s.pop();
        Sort(s);
        sortElement(s, top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(10);
        s.push(12);
        s.push(3);
        Sort(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
