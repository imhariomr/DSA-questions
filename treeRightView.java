import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class treeRightView {
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

    public static void rightView(Node root, ArrayList<Integer> list, int level) {

        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.data);
        }
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    public static void main(String[] args) {
        treeRightView tree = new treeRightView();
        int nodes[] = { 1, 2, 4, -1, 8, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = tree.buildTree(nodes);
        ArrayList<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        System.out.println(list);
    }
}
