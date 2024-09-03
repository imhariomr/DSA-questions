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
|
        if(l1==null || l2==null){
            return null;
        }

        Node templ1 = l1;
        Node templ2 = l2;

        while(templ1!=templ2){
            templ1 = templ1==null? l2 : templ1.next;
            templ2 = templ2==null? l1 : templ2.next;
        }
        return templ1;
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
