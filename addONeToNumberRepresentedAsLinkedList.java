public class addONeToNumberRepresentedAsLinkedList {
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

    public static int helper(Node temp) {
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if (temp.data < 10) {
            return 0;
        } else {
            temp.data = 0;
            return 1;
        }
    }

    public static Node add() {
        int carry = helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
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
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addONeToNumberRepresentedAsLinkedList list = new addONeToNumberRepresentedAsLinkedList();
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        head = add();
        list.print(head);
    }
}
