import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class treeHeight {
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

    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        treeHeight tree = new treeHeight();
        int nodes[] = { 2, -1, 1, 3, -1, -1, -1 };
        Node root = tree.buildTree(nodes);

        System.out.println(treeHeight(root));
    }
}
