import java.util.PriorityQueue;

public class rotateDoublyLinkedListInGroup {
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

    public static Node rotateInGroup(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        int count = 0;
        while (curr != null && count < k) {
            count++;
            next = curr.next;
            curr.next = prev;
            if (count > k - 1) {
                curr.prev = null;
            } else {
                curr.prev = next;
            }
            prev = curr;
            curr = next;
        }

        if (curr != null) {
            head.next = rotateInGroup(head, k);
            prev.prev = head;
        }
        return prev;
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
        rotateDoublyLinkedListInGroup list = new rotateDoublyLinkedListInGroup();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        head = rotateInGroup(head, 3);
        print(head);
    }
}
