import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class binaryTreeToBST {
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

    public static Node construct(ArrayList<Integer> list, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        Node root = new Node(list.get(mid));
        root.left = construct(list, s, mid - 1);
        root.right = construct(list, mid + 1, e);

        return root;
    }

    public static void main(String[] args) {
        binaryTreeToBST tree = new binaryTreeToBST();
        int nodes[] = { 1, 2, -1, -1, 3, -1, -1 };
        Node root = tree.buildTree(nodes);
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        Collections.sort(list);
        int s = 0;
        int e = list.size() - 1;
        root = construct(list, s, e);
        ArrayList<Integer> list1 = new ArrayList<>();
        inOrder(root, list1);
        System.out.println(list1);
    }
}
