public class identifyCircularLinkedList {
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

    public static boolean isCircular() {
        if (head == null) {
            return true;
        }
        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
            if (temp == null) {
                return false;
            }
        }

        return true;
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (true) {
            System.out.println(temp.data);
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        identifyCircularLinkedList list = new identifyCircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        tail.next = head;
        System.out.println(isCircular());
        list.print(head);
    }
}