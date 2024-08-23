public class deleteFromCircularLinkedList {
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
        deleteFromCircularLinkedList list = new deleteFromCircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);

        tail.next = head;

    }
}
