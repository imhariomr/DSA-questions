import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseLevelOrderTraversal {
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

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            s.push(currNode);
            if (currNode != null) {
                // System.out.println(currNode.data);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            } else {
                // System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
        }

        while (!s.isEmpty()) {
            Node curr = s.pop();
            if (curr != null) {
                System.out.println(curr.data);
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        reverseLevelOrderTraversal tree = new reverseLevelOrderTraversal();
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = tree.buildTree(nodes);
        // preOrder(root);
        levelOrderTraversal(root);
    }
}
