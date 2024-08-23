import java.util.LinkedList;
import java.util.*;

public class treeTopView {
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

    public static void topView(Node root) {
        if (root == null) {
            System.out.println("Enter data");
        }
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (hm.get(temp.hd) == null) {
                hm.put(temp.hd, temp.data);
            }

            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }

        for (int k : hm.values()) {
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        treeTopView tree = new treeTopView();
        int nodes[] = { 10, 20, 40, -1, -1, 60, -1, -1, 30, 90, -1, -1, 100, -1, -1 };
        Node root = tree.buildTree(nodes);
        topView(root);
    }
}
