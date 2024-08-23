import java.util.ArrayList;
import java.util.Collections;

public class kthLargetElementInBST {
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

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static int kthLargetElement(ArrayList<Integer> list, int k) {
        for (int i = list.size() - 1; i >= 0; i--) {
            k--;
            if (k == 0) {
                return list.get(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        kthLargetElementInBST tree = new kthLargetElementInBST();
        int nodes[] = { 9, -1, 10, -1, -1 };
        Node root = tree.buildTree(nodes);
        int k = 1;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int result = kthLargetElement(list, k);
        System.out.println(result);
    }
}
