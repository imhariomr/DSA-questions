import java.util.*;

public class interleave {

    public static void interleave(Queue<Integer> q1, Queue<Integer> q2) {
        int i = 0;
        int n = q1.size() / 2;
        while (i != n) {
            int top = q1.poll();
            q2.add(top);
            i++;
        }

        while (!q2.isEmpty()) {
            int top = q2.poll();
            q1.add(top);
            top = q1.poll();
            q1.add(top);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(11);
        q1.add(12);
        q1.add(13);
        q1.add(14);
        q1.add(15);
        q1.add(16);
        q1.add(17);
        q1.add(18);
        q1.add(19);
        q1.add(20);
        interleave(q1, q2);

        while (!q1.isEmpty()) {
            System.out.println(q1.poll());
        }
    }
}
