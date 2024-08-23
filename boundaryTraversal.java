import java.lang.reflect.Array;
import java.util.ArrayList;

public class boundaryTraversal {
    public static class Node {
        int data;
        Node left;
        Node right;
        int hd;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void leftTraversal(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        System.out.println(root.data);
        if (root.left != null) {
            leftTraversal(root.left);
        } else {
            leftTraversal(root.right);
        }
    }

    public static void bottomTraversal(Node root) {

        if (root == null) {
            return;
        }
        if (root.left == null || root.right == null) {
            System.out.println(root.data);
            return;
        }
        bottomTraversal(root.left);
        bottomTraversal(root.right);
    }

    public static void rightTraversal(Node root) {
        if (root.right == null || (root.right == null && root.left == null)) {
            return;
        }

        if (root.right != null) {
            rightTraversal(root.right);
        } else {
            rightTraversal(root.left);
        }
        System.out.println(root.data);
    }

    public static void boundaryTraversal(Node root) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> boundary = new ArrayList<>();
        boundary.add(root.data);

        leftTraversal(root);
        bottomTraversal(root);
        rightTraversal(root.right);
    }

    public static void main(String[] args) {
        checkBalancedTree tree = new checkBalancedTree();
        int nodes[] = { 1, 2, 4, -1, -1, 5, 8, -1, -1, 9, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node head = buildTree(nodes);
        boundaryTraversal(head);
    }
}
