import java.util.*;

public class addTwoNumberInLinkedList {
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

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public static Node addTwoNumber(Node l1, Node l2) {
        Node dummyNode = new Node(0);
        Node temp = dummyNode;
        int carry = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            temp.next = new Node(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }
        return reverse(dummyNode.next);
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
        addTwoNumberInLinkedList list = new addTwoNumberInLinkedList();
        list.addLast(0);
        list.addLast(0);
        list.addLast(6);
        list.addLast(3);

        Node l2 = new Node(0);
        l2.next = new Node(7);

        Node result = addTwoNumber(list.head, l2);
        list.print(result);
    }
}
