import java.util.*;

public class reverseQueue {

    public static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }

        int top = q.poll();
        reverseQueue(q);
        q.add(top);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        reverseQueue(q);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
