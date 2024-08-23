import java.util.ArrayList;
import java.util.Collections;

public class medianInBST {
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

    public static int countNodes(Node root, int count[]) {
        if (root == null) {
            return 0;
        }

        countNodes(root.left, count);
        countNodes(root.right, count);
        count[0]++;

        return count[0];
    }

    public static void findMedian(Node root, Node curr[], Node prev[], int k, int c[], int f) {
        if (root == null) {
            return;
        }
        findMedian(root.left, curr, prev, k, c, f);
        if (prev[0] == null) {
            prev[0] = root;
            c[0]++;
        } else if (c[0] == k) {
            c[0]++;
            curr[0] = root;
            f = 1;
            return;
        } else if (f == 0) {
            c[0]++;
            prev[0] = root;
        }
        findMedian(root.right, curr, prev, k, c, f);
    }

    public static void main(String[] args) {
        medianInBST tree = new medianInBST();
        int nodes[] = { 6, 3, 1, -1, -1, 4, -1, -1, 8, 7, -1, -1, 9, -1, -1 };
        Node root = tree.buildTree(nodes);
        int count[] = { 0 };
        int n = countNodes(root, count);
        int k = (n / 2 + 1);
        Node prev[] = { null };
        int c[] = { 1 };
        Node curr[] = { null };
        int f = 0;
        double ans = 0;
        findMedian(root, curr, prev, k, c, f);
        if (n % 2 == 1) {
            ans = (curr[0].data) * 1.0;
        } else {
            ans = ((curr[0].data + prev[0].data) * (1.0)) / (2 * 1.0);
        }

        System.out.println(ans);
    }
}
