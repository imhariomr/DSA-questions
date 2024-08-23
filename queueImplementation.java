public class queueImplementation {
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
            return ((rear + 1) % size) == front;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static void enque(int data) {
            if (isFull()) {
                System.out.println("overflow");
                return;
            }

            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            System.out.println(rear);
            arr[rear] = data;
        }

        public static void deque() {
            if (isEmpty()) {
                System.out.println("Underflow");
                return;
            }

            front = (front + 1) % size;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        queue q = new queue(5);
        q.enque(0);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        System.out.println(q.peek());
        q.deque();
        System.out.println(q.peek());
    }
}
