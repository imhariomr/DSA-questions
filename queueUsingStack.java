import java.util.*;

public class queueUsingStack {

    public static class queue {

        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public static void push(int data) {
            while (!s1.isEmpty()) {
                int top = s1.pop();
                s2.push(top);
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                int top = s2.pop();
                s1.push(top);
            }
        }

        public static void poll() {
            System.out.println("Element deleted" + s1.pop());
        }

        public static boolean isEmpty() {
            return s1.size() == 0;
        }

        public static void peek() {
            System.out.println(s1.peek());
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.push(1);
        q.push(2);
        q.push(3);

        q.peek();
        q.poll();
        q.peek();
    }
}
