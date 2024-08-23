import java.util.*;

public class circularQueue {

    public static class queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void enque(int data) {
            if (isFull()) {
                System.out.println("Overflow");
                return;
            }

            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static void deque() {
            if (isEmpty()) {
                System.out.println("Underflow");
                return;
            }
            front = (front + 1) % size;
        }

        public static void peek() {
            if (isEmpty()) {
                return;
            }

            System.out.println(arr[front]);
        }
    }

    public static void main(String[] args) {
        queue q = new queue(3);
        q.enque(1);
        q.enque(2);
        q.enque(3);

        q.deque();
        q.peek();
        q.enque(4);
        q.deque();
        q.deque();
        q.peek();
    }
}
