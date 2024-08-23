import java.util.Stack;

public class stackDeleteMiddleElement {

    public static void deleteMiddleHelper(Stack<Integer> s, int count, int pos) {
        if (s.size() == 0) {
            System.out.println("Underflow");
            return;
        }
        if (count == pos) {
            s.pop();
            return;
        }
        int top = s.pop();
        deleteMiddleHelper(s, count + 1, pos);
        s.push(top);
    }

    public static void deleteMiddleElement(Stack<Integer> s) {
        int pos = (int) Math.ceil((s.size() + 1) / 2.0);
        deleteMiddleHelper(s, 1, pos);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        deleteMiddleElement(s);
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
