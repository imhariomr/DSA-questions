public class deleteNodeGreaterValueOnRight {
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

    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static Node deleteNodeHavingGreaterValueOnRight(Node head) {
        Node temp = head;
        Node next = null;
        while (temp.next != null) {
            if (temp.data < temp.next.data) {
                next = temp.next;
                temp.next = null;
                temp = next;
            } else {
                temp = temp.next;
            }
        }
        return temp;
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
        deleteNodeGreaterValueOnRight list = new deleteNodeGreaterValueOnRight();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

        list.print(head);
    }
}
