public class intersectionOfTwoLinkedList {
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

    public static Node intersection(Node l1, Node l2) {
        Node dummyNode = new Node(0);
        Node temp = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.data == l2.data) {
                temp.next = new Node(l1.data);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;

            } else if (l1.data < l2.data) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return (dummyNode.next);
    }

    public static void print(Node head) {
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
        intersectionOfTwoLinkedList list = new intersectionOfTwoLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(40);
        list.addLast(50);

        Node l2 = new Node(15);
        l2.next = new Node(40);

        Node result = intersection(list.head, l2);
        print(result);
    }
}