import java.util.HashMap;

public class removeDuplicatesInUnsortedLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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
        tail.next = newNode;
        tail = newNode;
    }

    public static void removeDuplicates() {
        Node curr = head;
        HashMap<Integer, Boolean> hm = new HashMap<>();
        Node prev = null;

        while (curr != null) {
            if (hm.containsKey(curr.data)) {
                if (curr.next == null) {
                    prev.next = null;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr = prev.next;
                }
            } else {
                hm.put(curr.data, true);
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void print(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        removeDuplicatesInUnsortedLinkedList list = new removeDuplicatesInUnsortedLinkedList();
        list.addLast(4);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        list.addLast(4);

        list.removeDuplicates();
        list.print(head);
    }
}
