import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class treeBottomView {
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

    public static void bottomView(Node root) {
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        root.hd = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            int hd = temp.hd;
            hm.put(hd, temp.data);
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
        treeBottomView tree = new treeBottomView();
        int nodes[] = { 20, 8, 5, -1, -1, 3, 10, -1, -1, 14, -1, -1, 22, 4, -1, -1, 25, -1, -1 };
        Node root = tree.buildTree(nodes);
        bottomView(root);
    }
}
