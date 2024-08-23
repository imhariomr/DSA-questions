import java.util.HashMap;

public class reverseDoublyLinkedList {
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

    public static Node reverseDoublyLinkedList(Node head) {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            head = current;
            current = current.prev;
        }
        return head;
    }

    public void print(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("prev: " + (temp.prev != null ? temp.prev.data : "null"));
            System.out.println("Temp: " + temp.data);
            System.out.println("Next: " + (temp.next != null ? temp.next.data : "null"));
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        reverseDoublyLinkedList list = new reverseDoublyLinkedList();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        head = reverseDoublyLinkedList(head);
        list.print(head);
    }
}
