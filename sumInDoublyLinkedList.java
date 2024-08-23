import java.util.ArrayList;
import java.util.HashMap;

public class sumInDoublyLinkedList {
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

    public static void Sum(Node head, int x) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node left = head;
        Node right = tail;

        while (left.data <= right.data) {
            int sum = left.data + right.data;
            if (sum == x) {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(left.data);
                list1.add(right.data);
                list.add(list1);
                left = left.next;
                right = right.prev;

            } else if (sum > x) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }
        System.out.println(list);
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
        sumInDoublyLinkedList list = new sumInDoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(8);
        list.addLast(9);

        Sum(head, 7);
    }
}
