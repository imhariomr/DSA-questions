public class checkBalancedTree {
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

    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = treeHeight(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static boolean checkBalancedTree(Node root) {
        int reuslt = treeHeight(root);

        if (reuslt == -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        checkBalancedTree tree = new checkBalancedTree();
        int nodes[] = { 1, 10, 5, -1, -1, -1, -1 };
        Node root = tree.buildTree(nodes);
        System.out.println(checkBalancedTree(root));
    }
}
