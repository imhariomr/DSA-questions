import java.util.PriorityQueue;

public class rotateDoublyLinkedListByK {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = tail;
        tail.next = newNode;
        tail = newNode;
        tail.prev = temp;
    }

    public static Node rotateByN(Node head, int k) {
        Node curr = null;
        Node temp = head;

        int count = 0;
        while (count < k - 1) {
            count++;
            temp = temp.next;
        }

        curr = temp.next;
        curr.prev = null;
        temp.next = null;
        Node newHead = curr;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head.prev = curr;

        return newHead;
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            // System.out.println("prev: " + (temp.prev != null ? temp.prev.data : "null"));
            System.out.println("Temp: " + temp.data);
            // System.out.println("Next: " + (temp.next != null ? temp.next.data : "null"));
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        rotateDoublyLinkedListByK list = new rotateDoublyLinkedListByK();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        head = rotateByN(head, 2);
        print(head);
    }
}
