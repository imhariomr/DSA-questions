import java.util.*;

public class stackUsingQueue {

    public static class queue {

        public static Queue<Integer> q1 = new LinkedList<>();
        public static Queue<Integer> q2 = new LinkedList<>();

        public static void push(int data) {

            while (!q1.isEmpty()) {
                int top = q1.poll();
                q2.add(top);
            }

            q1.add(data);

            while (!q2.isEmpty()) {
                int top = q2.poll();
                q1.add(top);
            }
        }

        public static void peek() {
            System.out.println(q1.peek());
        }

        public static void pop() {
            int top = q1.poll();
            System.out.println("Element has been deleted: " + top);
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.pop();
        q.pop();
    }
}
