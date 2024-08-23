import java.util.ArrayList;
import java.util.PriorityQueue;

public class sortKorderDoubleLinkedList {
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

    public static Node sort(Node head, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(k + 1, (a, b) -> a.data - b.data);
        Node newHead = null;
        Node newcurr = null;

        for (int i = 0; i <= k; i++) {
            pq.add(head);
            head = head.next;
        }

        while (!pq.isEmpty()) {

            Node minHead = pq.poll();

            if (newHead == null) {
                newHead = minHead;
                newHead.prev = newcurr;
                newcurr = newHead;
            } else {
                newcurr.next = minHead;
                minHead.prev = newcurr;
                newcurr = newcurr.next;
            }

            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        newcurr.next = null;
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
        sortKorderDoubleLinkedList list = new sortKorderDoubleLinkedList();
        list.addLast(3);
        list.addLast(6);
        list.addLast(2);
        list.addLast(12);
        list.addLast(56);
        list.addLast(8);

        head = sort(head, 2);

        print(head);
    }
}
