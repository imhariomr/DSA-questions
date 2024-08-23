import java.util.*;

public class zigzagTraversal {
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

    public static void zigzagTraversal(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Deque<Node> dq = new LinkedList<>();
        boolean leftToRight = true;
        dq.addFirst(root);

        while (!dq.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            int levelSize = dq.size();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    Node temp = dq.pollFirst();
                    list1.add(temp.data);

                    if (temp.left != null) {
                        dq.addLast(temp.left);
                    }

                    if (temp.right != null) {
                        dq.addLast(temp.right);
                    }
                } else {
                    Node temp = dq.pollLast();
                    list1.add(temp.data);

                    if (temp.right != null) {
                        dq.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        dq.addFirst(temp.left);
                    }
                }
            }
            list.add(list1);
            leftToRight = !leftToRight;
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        zigzagTraversal tree = new zigzagTraversal();
        int nodes[] = { 10, 20, 40, -1, -1, 60, -1, -1, 30, 90, -1, -1, 100, -1, -1 };
        Node root = tree.buildTree(nodes);

        zigzagTraversal(root);
    }
}