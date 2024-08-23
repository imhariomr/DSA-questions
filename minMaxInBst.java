import java.util.LinkedList;
import java.util.Queue;

public class minMaxInBst {
    public static class Node {
        int data;
        Node left;
        Node right;

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

    public static Node findMin(Node root) {
        if (root.left == null) {
            return root;
        }

        return findMin(root.left);
    }

    public static Node findMax(Node root) {
        if (root.right == null) {
            return root;
        }

        return findMax(root.right);
    }

    public static void main(String[] args) {
        minMaxInBst tree = new minMaxInBst();
        int nodes[] = { 9, -1, 10, -1, 11, -1, -1 };
        Node root = tree.buildTree(nodes);
        System.out.println(findMax(root).data);
        System.out.println(findMin(root).data);
    }
}
