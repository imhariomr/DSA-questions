import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;

public class stackImplementation {

    public static class Stack {

        static ArrayList<Integer> list = new ArrayList<>();

        static int mid = -1;

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (list.size() == 0) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        public static int peek() {
            if (list.size() == 0) {
                return -1;
            }
            int val = list.get(list.size() - 1);

            return val;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}