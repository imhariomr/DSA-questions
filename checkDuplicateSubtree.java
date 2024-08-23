import java.util.HashMap;

public class checkDuplicateSubtree {
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
    static int flag = 0;

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

    public static String checkDuplicateSubtree(Node root, HashMap<String, Integer> hm) {
        if (root == null) {
            return "*";
        }

        String left = checkDuplicateSubtree(root.left, hm);
        String right = checkDuplicateSubtree(root.right, hm);

        String s = left + right + String.valueOf(root.data);

        if (!hm.containsKey(s)) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        } else {
            flag = 1;
        }

        return s;
    }

    public static void main(String[] args) {
        checkDuplicateSubtree tree = new checkDuplicateSubtree();
        int nodes[] = { 1, 2, -1, -1, 3, -1, -1 };
        Node root = tree.buildTree(nodes);
        HashMap<String, Integer> hm = new HashMap<>();
        checkDuplicateSubtree(root, hm);
        if (flag == 0) {
            System.out.println("No duplicate");
        } else {
            System.out.println("Contains Duplicates");
        }
    }
}
